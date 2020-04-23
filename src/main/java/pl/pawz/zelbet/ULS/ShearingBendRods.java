package pl.pawz.zelbet.ULS;

import pl.pawz.zelbet.BasicValues;

public class ShearingBendRods {
    private double dDimension;
    private double bDimension;
    private double fCk;
    private double fCd;
    private double vRdMax;
    private double aSw1;
    private double aSw2;
    private double sMin;
    private double nS1;
    private double nS2;
    private double fiS1;
    private double fiS2;
    private double fYd;
    private double fYk;
    private double sDimension;
    private double vEdRed;
    private double z;
    private double cotTheta;
    private double tanTheta;
    private double vRdC;
    private double vEd;
    private double s2;
    private double cotAlpha;
    private double sinAlpha;


    public ShearingBendRods(double hDimension, double a1, double bDimension, double fCk, double nEd, double aSl, double nS1, double nS2, double fiS1, double fiS2, double fYk, double vEdRed, double vEd, double s2, double cotTheta, double alphaAngleDegree) {
        this.dDimension = BasicValues.dValue(hDimension,a1);
        this.bDimension = bDimension;
        this.fCk = fCk;
        this.fCd = BasicValues.fCdValue(fCk);
        this.nS1= nS1;
        this.nS2= nS2;
        this.fiS2 = fiS2;
        this.fiS1 = fiS1;
        this.fYd = BasicValues.fYdValue(fYk);
        this.fYk = fYk;
        this.vEdRed = vEdRed;
        this.vEd = vEd;
        this.s2 = s2;

        this.z = 0.9 * dDimension;

        this.cotTheta = cotTheta; // TODO change this value  - simplify the code  -> connect both shearing to use the same functions in some cases!
        this.tanTheta = 1/cotTheta;

        double alphaAngleRadian = alphaAngleDegree*(Math.PI/180);

        this.sinAlpha = Math.sin(alphaAngleRadian);
        double cosAlpha = Math.cos(alphaAngleRadian);
        double tanAlpha = sinAlpha/cosAlpha;
        this.cotAlpha = 1/tanAlpha;


        ShearingStirrups shearingBasic = new ShearingStirrups(hDimension, bDimension, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS1, fiS1, cotTheta);
        vRdC = shearingBasic.vRdCValue();
        vRdMax();

    }

    private void vRdMax() {
        int alphaCw = 1;
        double nu1 = 0.6 * (1 - fCk / 250); //from 6.6N EC2

        double deltaV = alphaCw * bDimension * z * nu1 * fCd * cotTheta * cotAlpha / ((1 + Math.pow(cotTheta, 2)) * (2 * cotTheta + cotAlpha));

        vRdMax = (alphaCw * bDimension * z * nu1 * fCd) / (cotTheta + tanTheta) + deltaV;

        aSw1 = nS1 * Math.PI * Math.pow(fiS1 / 2, 2);
        aSw2 = nS2 * Math.PI * Math.pow(fiS2 / 2, 2);
        sMin = 2 * aSw1 * fYd / (bDimension * alphaCw * nu1 * fCd);
    }

    private void vEdRedSmallerThanVRdC() {
        sDimension = Math.max(Math.min(0.75 * dDimension, aSw1 / (0.08 * bDimension) * fYk / Math.sqrt(fCk)), sMin);
    }

    private void vEdRedGreaterThanVRdCAndVEdSmallerThanVRdMax() {
        s2 = Math.min(s2, 0.6 * dDimension * (1 + cotAlpha));

        double vRdS2 = aSw2 / s2 * z * fYd * (cotTheta + cotAlpha) * sinAlpha;

        double vEdS1 = Math.max(vEdRed - vRdS2, 0.5 * vEdRed);


        sDimension = Math.max(Math.min(Math.min(0.75 * dDimension, aSw1 / (0.08 * bDimension) * fYk / Math.sqrt(fCk)), aSw1 / vEdS1 * z * fYd * cotTheta), sMin);
    }

    private void vEdGreaterThanVRdMax() {
        sDimension = 0;
    }

    public double resultShearingStirrups() {


        if (vEdRed <= vRdC) {
            vEdRedSmallerThanVRdC();
        } else if (vEdRed > vRdC && vEd <= vRdMax) {
            vEdRedGreaterThanVRdCAndVEdSmallerThanVRdMax();
        } else {
            vEdGreaterThanVRdMax();
        }

        return sDimension;
    }

    public double getVRdMax(){
        return vRdMax;
    }

    public double getVRdC(){
        return vRdC;
    }
}

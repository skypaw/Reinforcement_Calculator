package pl.pawz.zelbet.ULS;

public class ShearingBendRods {
    private double dDimension;
    private double bDimension;
    private float fCk;
    private double fCd;
    private float nEd;
    private double aC;
    private double aSl;
    private double vRdMax;
    private double aSw1;
    private double aSw2;
    private double sMin;
    private double nS;
    private double fiS1;
    private double fiS2;
    private double fYd;
    private double fYk;
    private double sDimension;
    private double vEdRed;
    private double z;
    private float cotTheta;
    private float tanTheta;
    private double vRdC;
    private float vEd;
    private double s2;
    private float cotAlpha;
    private float sinAlpha;


    public ShearingBendRods(float hDimension, float a1, double dDimension, float bDimension, float fCk, double fCd, float nEd, double aC, double aSl, double nS, double fiS1, double fiS2, double fYd, double fYk, double vEdRed, float vEd, double s2) {
        this.dDimension = dDimension;
        this.bDimension = bDimension;
        this.fCk = fCk;
        this.fCd = fCd;
        this.nEd = nEd;
        this.aC = aC;
        this.aSl = aSl;
        this.nS = nS;
        this.fiS2 = fiS2;
        this.fiS1 = fiS1;
        this.fYd = fYd;
        this.fYk = fYk;
        this.vEdRed = vEdRed;
        this.vEd = vEd;
        this.s2 = s2;

        this.z = 0.9 * dDimension;

        this.cotTheta = 2; // TODO change this value  - simplify the code  -> connect both shearing to use the same functions in some cases!
        this.tanTheta = 0.5f;
        this.sinAlpha = 0.5f;
        this.cotAlpha = 0.5f;


        ShearingStirrups shearingBasic = new ShearingStirrups(hDimension, bDimension, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS1, cotTheta);
        shearingBasic.vRdCValue();

    }

    public void vRdMax() {
        int alphaCw = 1;
        double nu1 = 0.6 * (1 - fCk / 250); //from 6.6N EC2

        double deltaV = alphaCw * bDimension * z * nu1 * fCd * cotTheta * cotAlpha / ((1 + Math.pow(cotTheta, 2)) * (2 * cotTheta + cotAlpha));

        vRdMax = (alphaCw * bDimension * z * nu1 * fCd) / (cotTheta + tanTheta) + deltaV;

        aSw1 = nS * Math.PI * Math.pow(fiS1 / 2, 2);
        aSw2 = nS * Math.PI * Math.pow(fiS2 / 2, 2);
        sMin = 2 * aSw1 * fYd / (bDimension * alphaCw * nu1 * fCd);
    }

    private void vEdRedSmallerThanVRdC() {
        sDimension = Math.min(Math.min(0.75 * dDimension, aSw1 / (0.08 * bDimension) * fYk / Math.sqrt(fCk)), sMin);
    }

    private void vEdRedGreaterThanVRdCAndVEdSmallerThanVRdMax() {
        s2 = Math.max(s2, 0.6 * dDimension * (1 + cotAlpha));

        double vRdS2 = aSw2 / s2 * z * fYd * (cotTheta + cotAlpha) * sinAlpha;
        double vEdS1 = Math.max(vEdRed - vRdS2, 0.5 * vEdRed);


        sDimension = Math.min(Math.min(Math.min(0.75 * dDimension, aSw1 / (0.08 * bDimension) * fYk / Math.sqrt(fCk)), aSw1 / vEdS1 * z * fYd * cotTheta), sMin);
    }

    private void vEdGreaterThanVRdMax() {
        sDimension = 0;
    }

    public double resultShearingStirrups() {
        vRdMax();

        if (vEdRed <= vRdC) {
            vEdRedSmallerThanVRdC();
        } else if (vEdRed > vRdC && vEd <= vRdMax) {
            vEdRedGreaterThanVRdCAndVEdSmallerThanVRdMax();
        } else {
            vEdGreaterThanVRdMax();
        }

        return sDimension;
    }
}

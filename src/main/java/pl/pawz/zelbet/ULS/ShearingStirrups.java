package pl.pawz.zelbet.ULS;

import com.sun.deploy.config.VerboseDefaultConfig;
import pl.pawz.zelbet.BasicValues;

import java.util.Map;

public class ShearingStirrups {
    private double dDimension;
    private double bDimension;
    private double fCk;
    private double fCd;
    private float nEd;
    private double aC;
    private double aSl;
    private double vRdMax;
    private double aSw;
    private double sMin;
    private double nS;
    private double fiS;
    private double fYd;
    private double fYk;
    private double sDimension;
    private double vEdRed;
    private double z;
    private double cotTheta;
    private double tanTheta;
    private double vRdC;
    private double vEd;


    public ShearingStirrups(float hDimension, float bDimension, float a1, double fCk, double fYk, float nEd, double vEd, double vEdRed, double aSl, double nS, double fiS, double cotTheta) {
        this.dDimension = BasicValues.dValue(hDimension, a1);
        this.bDimension = bDimension;
        this.fCk = fCk;
        this.fCd = BasicValues.fCdValue(fCk);
        this.nEd = nEd;
        this.aC = hDimension * bDimension;
        this.aSl = aSl;
        this.nS = nS;
        this.fiS = fiS;
        this.fYd = BasicValues.fYdValue(fYk);
        this.fYk = fYk;
        this.vEdRed = vEdRed;
        this.vEd = vEd;

        this.z = 0.9 * dDimension;

        this.cotTheta = cotTheta;
        this.tanTheta = 1 / cotTheta;

        vRdCValue();
        vRdMax();

    }


    public double vRdCValue() {
        double kValue = Math.min(1 + Math.sqrt(200 / (dDimension * Math.pow(10, 3))), 2);
        double nuMin = 0.035 * Math.pow(kValue, 1.5) * Math.pow(fCk, 0.5);
        double rhoL = Math.min((aSl * Math.pow(10, 4)) / (bDimension * dDimension * Math.pow(10, 4)), 0.02);
        double cRdC = 0.18 / BasicValues.gammaCConcrete();
        double sigmaCp = Math.min(nEd / aC, 0.2 * fCd);

        float k1 = 0.15f;

        double vRdC1 = (cRdC * kValue * Math.pow(100 * rhoL * fCk, 1.0 / 3.0) + k1 * sigmaCp) * bDimension * dDimension;
        double vRdC2 = (nuMin + k1 * sigmaCp) * bDimension * dDimension;
        vRdC = Math.max(vRdC1, vRdC2);
        return vRdC;
    }

    /*
    Max value of durability for shearing
     */


    private void vRdMax() {
        int alphaCw = 1;
        double nu1 = 0.6 * (1 - fCk / 250); //from 6.6N EC2

        vRdMax = (alphaCw * bDimension * z * nu1 * fCd) / (cotTheta + tanTheta);

        aSw = nS * Math.PI * Math.pow(fiS / 2, 2);
        sMin = 2 * aSw * fYd / (bDimension * alphaCw * nu1 * fCd);
    }

    private void vEdRedSmallerThanVRdC() {
        sDimension = Math.max(Math.min(0.75 * dDimension, aSw / (0.08 * bDimension) * fYk / Math.sqrt(fCk)), sMin);
    }

    private void vEdRedGreaterThanVRdCAndVEdSmallerThanVRdMax() {
        sDimension = Math.max(Math.min(Math.min(0.75 * dDimension, aSw / (0.08 * bDimension) * fYk / Math.sqrt(fCk)), aSw / vEdRed * z * fYd * cotTheta), sMin);
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

package pl.pawz.zelbet.ULS;

import com.sun.deploy.config.VerboseDefaultConfig;
import pl.pawz.zelbet.BasicValues;

public class ShearingStirrups {
    private double dDimension;
    private double bDimension;
    private float fCk;
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
    private float cotTheta;
    private float tanTheta;
    private double vRdC;
    private float vEd;


    public ShearingStirrups(double dDimension, float bDimension, float fCk, double fCd, float nEd, double aC, double aSl, double nS, double fiS, double fYd, double fYk, double vEdRed, float vEd) {
        this.dDimension = dDimension;
        this.bDimension = bDimension;
        this.fCk = fCk;
        this.fCd = fCd;
        this.nEd = nEd;
        this.aC = aC;
        this.aSl = aSl;
        this.nS = nS;
        this.fiS = fiS;
        this.fYd = fYd;
        this.fYk = fYk;
        this.vEdRed = vEdRed;
        this.vEd = vEd;

        this.z = 0.9 * dDimension;

        this.cotTheta = 2; // TODO ask
        this.tanTheta = 0.5f;
    }


    void vRdCValue() {
        double kValue = 1 + Math.sqrt(200 / dDimension);
        double nuMin = 0.035 * Math.pow(kValue, 1.5) * Math.pow(fCk, 0.5);
        double rhoL = Math.min(aSl / (bDimension * dDimension), 0.02);
        double cRdC = 0.18 / BasicValues.gammaCConcrete();
        double sigmaCp = Math.min(nEd / aC, 0.2 * fCd);

        float k1 = 0.15f;

        double vRdC1 = (cRdC * kValue * Math.pow(100 * rhoL * fCk, 1.0 / 3.0) + k1 * sigmaCp) * bDimension * dDimension;
        double vRdC2 = (nuMin + k1 * sigmaCp) * bDimension * dDimension;
        vRdC = Math.max(vRdC1, vRdC2);
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
        sDimension = Math.min(Math.min(0.75 * dDimension, aSw / (0.08 * bDimension) * fYk / Math.sqrt(fCk)), sMin);
    }

    private void vEdRedGreaterThanVRdCAndVEdSmallerThanVRdMax() {
        sDimension = Math.min(Math.min(Math.min(0.75 * dDimension, aSw / (0.08 * bDimension) * fYk / Math.sqrt(fCk)), aSw / vEdRed * z * fYd * cotTheta), sMin);
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
}

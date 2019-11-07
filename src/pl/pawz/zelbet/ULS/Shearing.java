package pl.pawz.zelbet.ULS;

import pl.pawz.zelbet.BasicValues;

public class Shearing {
    private double dValue;
    private double bDimension;
    private float fCk;
    private double fCd;
    private float nEd;
    private double aC;
    private double aSl;

    public Shearing(double dValue, float bDimension, float fCk, double fCd, float nEd, double aC, double aSl) {
        this.dValue = dValue;
        this.bDimension = bDimension;
        this.fCk = fCk;
        this.fCd = fCd;
        this.nEd = nEd;
        this.aC = aC;
        this.aSl = aSl;
    }


    private double vRdCValue() {
        double kValue = 1 + Math.sqrt(200 / dValue);
        double nuMin = 0.035 * Math.pow(kValue, 1.5) * Math.pow(fCk, 0.5);
        double rhoL = Math.min(aSl / (bDimension * dValue), 0.02);
        double cRdC = 0.18 / BasicValues.gammaCConcrete();
        double sigmaCp = Math.min(nEd / aC, 0.2 * fCd);  // TODO ask about that line and 'bout Asl

        float k1 = 0.15f;

        double vRdC1 = (cRdC * kValue * Math.pow(100 * rhoL * fCk, 0.333333) + k1 * sigmaCp) * bDimension * dValue; //TODO 0.333 -> to power 1/3
        double vRdC2 = (nuMin + k1 * sigmaCp) * bDimension * dValue;
        return Math.max(vRdC1, vRdC2);
    }

    /*
    Max value of durability for shearing
     */


    private double vRd() {
        int alphaCw = 1;
        double nu1 = 0.6 * (1 - fCk / 250); //from 6.6N EC2
        double z = 0.9 * dValue;

        double cotTheta = 2; // TODO ask
        double tanTheta = 0.5;

        double aSw = 0; //TODO ask
        double s = 0; //TODO ask
        double fYwd = 0; //TODO ask

        double vRdS = aSw / s * z * fYwd * cotTheta;
        double vRdMax = (alphaCw * bDimension * z * nu1 * fCd) / (cotTheta + tanTheta);
        return Math.min(vRdS, vRdMax);
    }
}

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

    private double kValue() {
        return 1 + Math.sqrt(200 / dValue);
    }

    private double nuMinValue() {
        return 0.035 * Math.pow(kValue(), 1.5) * Math.pow(fCk, 0.5);
    }

    private double sigmaCpValue() {
        return Math.min(nEd / aC, 0.2 * fCd);  // TODO ask about that line and 'bout Asl
    }

    private double cRdCValue() {
        return 0.18 / BasicValues.gammaCConcrete();
    }

    private double rhoL() {
        return Math.min(aSl / (bDimension * dValue), 0.02);
    }

    private double vRdCValue() {
        float k1 = 0.15f;

        double vRdC1 = (cRdCValue() * kValue() * Math.pow(100 * rhoL() * fCk, 1 / 3) + k1 * sigmaCpValue()) * bDimension * dValue;
        double vRdC2 = (nuMinValue() + k1 * sigmaCpValue()) * bDimension * dValue;
        return Math.max(vRdC1, vRdC2);
    }
}

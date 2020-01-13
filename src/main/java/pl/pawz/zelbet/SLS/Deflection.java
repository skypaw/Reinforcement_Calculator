package pl.pawz.zelbet.SLS;

import pl.pawz.zelbet.BasicValues;

public class Deflection {
    double mCr;
    double mEd;
    float alphaM;
    double mEk;
    double mEkLt;
    float lEff;
    double eCEff;
    double eCm;
    int eS;


    double sigmaLt;
    double sigma;
    double bIZero;
    double bIIZero;
    double bIInf;
    double bIIInf;
    double epsilonCs;

    public double iI;
    public double iII;
    double sI;
    double sII;


    public Deflection(float lEff, double mEkLt, double mEk, float alphaM, double mEd, float b, float h, float hF, float hFT, float bEff, float bEffT, float a1, float a2, double aS1, double aS2, char longOrShort, double fCk, float rH, char cement, int tZero) {
        this.alphaM = alphaM;
        this.mEd = mEd;
        this.mEk = mEk;
        this.mEkLt = mEkLt;
        this.lEff = lEff;
        this.eS = BasicValues.steelE();

        float fCm = (float)fCk + 8;

        BasicParameters basic = new BasicParameters(eS, b, h, hF, hFT, bEff, bEffT, a1, a2, aS1, aS2, fCk, rH, tZero, cement, longOrShort);
        this.mCr = basic.mCr;
        this.eCEff = basic.eCEff;

        this.iI = basic.iI;
        this.iII = basic.iII;

        this.sI = basic.sI;
        this.sII = basic.sII;

        this.eCm = basic.eCm;

        double h0 = basic.hZero;


        Deformation def = new Deformation(h0,fCm, (float)fCk, rH, cement);
        this.epsilonCs = def.deformationShrink();

        sigmaValue();
        sigmaLtValue();
        bValueLong();
        bValueShort(); //TODO refactor whole SLS

    }

    private void sigmaValue() {
        sigma = 1 - 1 * Math.pow(mCr / mEk, 2);
    }

    private void sigmaLtValue() {
        sigmaLt = 1 - 0.5 * Math.pow(mCr / mEkLt, 2);
    }

    private void bValueShort() {
        bIZero = eCm * iI;
        bIIZero = eCm * iII;
    }

    private void bValueLong() {
        bIInf = eCEff * iI;
        bIIInf = eCEff * iII;
    }


    public double resultsShort() {
        if (mCr > mEd) {
            return alphaM * mEk / bIZero * Math.pow(lEff, 2);
        } else {
            return sigma * alphaM *mEk/ bIIZero * Math.pow(lEff, 2) + (1 - sigma) * alphaM * mEk / bIZero * Math.pow(lEff, 2);
        }
    }

    public double resultsLong() {
        if (mCr > mEd) {
            return alphaM * mEkLt / bIInf * Math.pow(lEff, 2);
        } else {
            return sigmaLt * alphaM * mEkLt / bIIInf * Math.pow(lEff, 2) + (1 - sigmaLt) * alphaM * mEkLt / bIInf * Math.pow(lEff, 2);
        }

    }

    public double resultsLongDeformation() {
        if (mCr > mEd) {
            return alphaM * mEkLt / bIInf * Math.pow(lEff, 2) - 0.125 * (eS * epsilonCs * sI) / bIInf * Math.pow(lEff, 2);
        } else {
            return sigmaLt * (alphaM * mEkLt / bIIInf * Math.pow(lEff, 2) - 0.125 * (eS * epsilonCs * sII) / bIIInf * Math.pow(lEff, 2) + (1 - sigmaLt) * (alphaM * mEkLt / bIInf * Math.pow(lEff, 2) - 0.125 * (eS * epsilonCs * sI) / bIInf * Math.pow(lEff, 2)));
        }


    }
}
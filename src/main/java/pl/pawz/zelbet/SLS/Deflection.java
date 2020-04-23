package pl.pawz.zelbet.SLS;

import pl.pawz.zelbet.BasicValues;

public class Deflection {
    private double mCr;
    private double mEd;
    private double alphaM;
    private double mEk;
    private double mEkLt;
    private double lEff;
    private double eCEff;
    private double eCm;
    private int eS;


    private double sigmaLt;
    private double sigma;
    private double bIZero;
    private double bIIZero;
    private double bIInf;
    private double bIIInf;
    private double epsilonCs;

    public double iI;
    public double iII;
    private double sI;
    private double sII;

    public double fiCrawling;


    public Deflection(double lEff, double mEkLt, double mEk, double alphaM, double mEd, double b, double h, double hF, double hFT, double bEff, double bEffT, double a1, double a2, double aS1, double aS2, char longOrShort, double fCk, double rH, char cement, int tZero) {
        this.alphaM = alphaM;
        this.mEd = mEd;
        this.mEk = mEk;
        this.mEkLt = mEkLt;
        this.lEff = lEff;
        this.eS = BasicValues.steelE();

        double fCm = (double) fCk + 8;

        BasicParameters basic = new BasicParameters(eS, b, h, hF, hFT, bEff, bEffT, a1, a2, aS1, aS2, fCk, rH, tZero, cement, longOrShort);
        this.mCr = basic.mCr;
        this.eCEff = basic.eCEff;
        this.fiCrawling = basic.fiCrawling;

        this.iI = basic.iI;
        this.iII = basic.iII;

        this.sI = basic.sI;
        this.sII = basic.sII;

        this.eCm = basic.eCm;

        double h0 = basic.hZero;

        Deformation def = new Deformation(h0, fCm, (double) fCk, rH, cement);
        this.epsilonCs = def.deformationShrink();

        sigmaValue();
        sigmaLtValue();
        bValueLong();
        bValueShort();
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
            return sigma * alphaM * mEk / bIIZero * Math.pow(lEff, 2) + (1 - sigma) * alphaM * mEk / bIZero * Math.pow(lEff, 2);
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
            return sigmaLt * (alphaM * mEkLt / bIIInf * Math.pow(lEff, 2) - 0.125 * (eS * epsilonCs * sII) / bIIInf * Math.pow(lEff, 2)) + (1 - sigmaLt) * (alphaM * mEkLt / bIInf * Math.pow(lEff, 2) - 0.125 * (eS * epsilonCs * sI) / bIInf * Math.pow(lEff, 2));
        }


    }
}
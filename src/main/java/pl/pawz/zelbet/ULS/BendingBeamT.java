package pl.pawz.zelbet.ULS;

import pl.pawz.zelbet.BasicValues;

public class BendingBeamT {

    private double mEd;
    private double fCd;
    private double etaConcrete;
    private double fYd;
    private double bW;
    private double bEff;
    private double hF;
    private double a2;
    private double d;
    private double[] resultsSeeminglyT;
    private double aZeroLim;
    private double xiLim;


    public BendingBeamT(double mEd, double fCk, double fYk, double bW, double bEff, double h, double hF, double a1, double a2) {
        this.mEd = mEd;
        this.fCd = BasicValues.fCdValue(fCk);
        this.fYd = BasicValues.fYdValue(fYk);
        this.etaConcrete = BasicValues.etaConcreteValue(fCk);

        this.bW = bW;
        this.bEff = bEff;
        this.hF = hF;
        this.a2 = a2;
        this.d = BasicValues.dValue(h, a1);


        BendingBeamRectangle rectangle = new BendingBeamRectangle(mEd, fCk, fYk, h, bEff, a1, a2);
        this.resultsSeeminglyT = rectangle.resultsBendingBeamRectangle();
        this.aZeroLim = rectangle.aZeroLimVar();
        this.xiLim = rectangle.xiLimVar();
    }


    private double mRdHf() {
        return etaConcrete * fCd * bEff * hF * (d - 0.5 * hF);
    }

    private double[] mRdHfGreaterThanMEd() {
        double mRd1 = etaConcrete * fCd * (bEff - bW) * hF * (d - 0.5 * hF);
        double aS11 = (bEff - bW) * hF * etaConcrete * fCd / fYd;
        double A0 = (mEd - mRd1) / (etaConcrete * fCd * bW * Math.pow(d, 2));
        return new double[]{mRd1, aS11, A0};
    }

    private double[] aZeroSmallerThanA0LimT() {
        double zeta = (1 + Math.sqrt(1 - 2 * mRdHfGreaterThanMEd()[2])) / 2;
        double aS12 = (mEd - mRdHfGreaterThanMEd()[0]) / (fYd * zeta * d);
        double aS1 = mRdHfGreaterThanMEd()[1] + aS12;
        return new double[]{aS1, 0};
    }

    private double[] aZeroGreaterThanA0LimT() {
        double mRdLim = aZeroLim * etaConcrete * fCd * bW * Math.pow(d, 2);
        double aS12 = xiLim * bW * d * etaConcrete * fCd / fYd;
        double aS13 = (mEd - mRdHfGreaterThanMEd()[0] - mRdLim) / (fYd * (d - a2));
        double aS1 = mRdHfGreaterThanMEd()[1] + aS12 + aS13;
        return new double[]{aS1, aS13};
    }

    public double[] resultsBendingT() {
        if (mEd <= mRdHf()) {
            return resultsSeeminglyT;
        } else {
            if (mRdHfGreaterThanMEd()[2] <= aZeroLim) {
                return aZeroSmallerThanA0LimT();
            } else {
                return aZeroGreaterThanA0LimT();
            }
        }
    }

}

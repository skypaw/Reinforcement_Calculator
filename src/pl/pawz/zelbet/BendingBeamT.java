package pl.pawz.zelbet;

public class BendingBeamT {

    private float mEd;
    private float fCd;
    private float epsilonCu3;
    private float etaConcrete;
    private float lambdaConcrete;
    private float fYd;
    private int E_S;
    private float bW;
    private float bEff;
    private float hF;
    private float a2;
    private double d;
    private double[] resultsSeeminglyT;
    private double aZeroLim;
    private double xiLim;


    private BendingBeamT(float mEd, float fCd, float epsilonCu3, float lambdaConcrete, float etaConcrete, float fYd, int E_S, float bW, float bEff, float hF, float a2, double d) {
        this.mEd = mEd;
        this.fCd = fCd;
        this.epsilonCu3 = epsilonCu3;
        this.lambdaConcrete = lambdaConcrete;
        this.etaConcrete = etaConcrete;
        this.fYd = fYd;
        this.E_S = E_S;
        this.bW = bW;
        this.bEff = bEff;
        this.hF = hF;
        this.a2 = a2;
        this.d = d;

        BendingBeamRectangle rectangle = new BendingBeamRectangle(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bEff, a2, d);
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

    double[] resultsBendingT() {
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

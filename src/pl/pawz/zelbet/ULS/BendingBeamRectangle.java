package pl.pawz.zelbet.ULS;
import pl.pawz.zelbet.BasicValues;

public class BendingBeamRectangle {

    private float mEd;
    private double fCd;
    private double epsilonCu3;
    private double etaConcrete;
    private double lambdaConcrete;
    private double fYd;
    private int E_S;
    private float b;
    private float a2;
    private double d;


    public BendingBeamRectangle(float mEd, double fCk, double fYk, float h, float b, float a1, float a2) {
        //constructor
        this.mEd = mEd;
        this.fCd = BasicValues.fCdValue(fCk);
        this.fYd = BasicValues.fYdValue(fYk);
        this.b = b;
        this.a2 = a2;

        this.d = BasicValues.dValue(h,a1);
        this.E_S = BasicValues.steelE();
        this.epsilonCu3 = BasicValues.epsilonCu3Value(fCk);
        this.lambdaConcrete = BasicValues.lambdaConcreteValue(fCk);
        this.etaConcrete = BasicValues.etaConcreteValue(fCk);
    }

    double xiLimVar() {
        return lambdaConcrete * epsilonCu3 / (epsilonCu3 + fYd / E_S);
    }

    private double zetaLimVar() {
        return 1 - 0.5 * xiLimVar();
    }

    double aZeroLimVar() {
        return xiLimVar() * zetaLimVar();
    }

    private double aZeroVar() {
        return mEd / (etaConcrete * fCd * b * Math.pow(d, 2));
    }

    private double[] aZeroSmallerThanAZeroLim() {
        double zeta = (1 + Math.sqrt(1 - 2 * aZeroVar()) )/ 2;
        double aS1 = mEd / (fYd * zeta * d);
        double aS2 = 0;
        return new double[]{aS1, aS2};
    }

    private double[] aZeroGreaterThanAZeroLim() {
        double mRdLim = aZeroLimVar() * etaConcrete * fCd * b * Math.pow(d, 2);
        double aS11 = xiLimVar() * b * d * (etaConcrete * fCd / fYd);
        double aS12 = (mEd - mRdLim) / (fYd * (d - a2));
        double aS1 = aS11 + aS12;
        return new double[]{aS1, aS12};
    }

    public double[] resultsBendingBeamRectangle(){
        double aZeroLim = aZeroLimVar();
        double aZero = aZeroVar();

        if (aZero<=aZeroLim){
            return aZeroSmallerThanAZeroLim();
        } else {
            return aZeroGreaterThanAZeroLim();
        }
    }

}

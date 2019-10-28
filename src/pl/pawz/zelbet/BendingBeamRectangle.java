package pl.pawz.zelbet;

public class BendingBeamRectangle {

    private float mEd;
    private float fCd;
    private float E_CU_3;
    private float etaConcrete;
    private float lambdaConcrete;
    private float fYd;
    private int E_S;
    private float b;
    private float a2;
    private double d;


    public BendingBeamRectangle(float mEd, float fCd, float E_CU_3, float lambdaConcrete, float etaConcrete, float fYd, int E_S, float b, float a2, double d) {
        //constructor
        this.mEd = mEd;
        this.fCd = fCd;
        this.E_CU_3 = E_CU_3;
        this.lambdaConcrete = lambdaConcrete;
        this.etaConcrete = etaConcrete;
        this.fYd = fYd;
        this.E_S = E_S;
        this.b = b;
        this.a2 = a2;
        this.d = d;
    }

    private double xiLimVar() {
        return lambdaConcrete * E_CU_3 / (E_CU_3 + fYd / E_S);
    }

    private double zetaLimVar() {
        return 1 - 0.5 * xiLimVar();
    }

    private double aZeroLimVar() {
        return xiLimVar() * zetaLimVar();
    }

    private double aZeroVar() {
        return mEd / (etaConcrete * fCd * b * Math.pow(d, 2));
    }

    private double[] aZeroSmallerThanAZeroLim() {
        double zeta = (1 + Math.sqrt(1 - 2 * aZeroLimVar()) / 2);
        double aS1 = mEd / (fYd * zeta * d);
        double aS2 = 0;
        System.out.println(aS1);
        System.out.println(aS2);
        return new double[]{aS1, aS2};
    }

    private double[] aZeroGreaterThanAZeroLim() {
        double mRdLim = aZeroLimVar() * etaConcrete * fCd * b * Math.pow(d, 2);
        double aS11 = xiLimVar() * b * d * (etaConcrete * fCd / fYd);
        double aS12 = (mEd - mRdLim) / (fYd * (d - a2));
        double aS1 = aS11 + aS12;
        return new double[]{aS1, aS12};
    }

    double[] resultsBendingBeamRectangle(){
        double aZeroLim = aZeroLimVar();
        double aZero = aZeroVar();

        if (aZero<=aZeroLim){
            return aZeroSmallerThanAZeroLim();
        } else {
            return aZeroGreaterThanAZeroLim();
        }
    }

}

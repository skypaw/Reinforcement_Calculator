package pl.pawz.zelbet;

class BasicValuesPillars {
    private float h;
    private float a1;
    private float a2;
    private float E_CU_3;
    private float E_C_3;
    private float fYd;
    private float E_S;

    BasicValuesPillars(float h, float a1, float a2, float E_CU_3, float E_C_3, float fYd, int E_S) {
        //constructor
        this.h =h;
        this.a1 = a1;
        this.a2 = a2;
        this.E_CU_3 = E_CU_3;
        this.E_C_3 = E_C_3;
        this.fYd = fYd;
        this.E_S = E_S;

    }

    private float dDimension() {
        return h - a1;
    }

    private double xLimVar() {
        return (E_CU_3 * dDimension()) / (E_CU_3 + (fYd / E_S));
    }

    private double xMinYdVar() {
        return (E_CU_3 * a2) / (E_CU_3 - (fYd / E_S));
    }

    private double xMinMinusYdVar() {
        return (E_CU_3 * a2) / (E_CU_3 + (fYd / E_S));
    }

    private double epsilonYdVar() {
        return fYd / E_S;
    }

    private double x0Var() {
        return (1 - E_C_3 / E_CU_3) * h;
    }

    private double xYdMaxVar() {
        return (epsilonYdVar() * x0Var() - E_C_3 * a2) / (epsilonYdVar() - E_C_3);
    }

    double[] values(){
        return new double[]{dDimension(), xLimVar(), xMinYdVar(), xMinMinusYdVar(), x0Var(), xYdMaxVar()};
    }
}
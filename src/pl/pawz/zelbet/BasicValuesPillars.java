package pl.pawz.zelbet;

class BasicValuesPillars {
    private float h;
    private float a1;
    private float a2;
    private float E_CU_3;
    private float E_C_3;
    private float fYd;
    private float E_S;

    private BasicValuesPillars(float h, float a1, float a2, float E_CU_3, float E_C_3, float fYd, int E_S) {
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
        float d = h - a1;
        System.out.println("Wysokosc uzyteczna przekroju = " + d);

        return d;
    }

    private double xLimVar() {
        double xLim = (E_CU_3 * dDimension()) / (E_CU_3 + (fYd / E_S));

        System.out.println("xLim = " + xLim);
        return xLim;
    }

    private double xMinYdVar() {
        double xMinYd = (E_CU_3 * a2) / (E_CU_3 - (fYd / E_S));
        System.out.println("xMinYd = " + xMinYd);
        return xMinYd;
    }

    private double xMinMinusYdVar() {
        double xMinMinusYd = (E_CU_3 * a2) / (E_CU_3 + (fYd / E_S));
        System.out.println("xMinMinusYd = " + xMinMinusYd);
        return xMinMinusYd;
    }

    private double epsilonYdVar() {
        double epsilonYd = fYd / E_S;
        System.out.println("epssilonYd = " + epsilonYd);
        return epsilonYd;
    }

    private double x0Var() {
        double x0 = (1 - E_C_3 / E_CU_3) * h;
        System.out.println("x0 = " + x0);
        return x0;

    }

    private double xYdMax() {
        double xYdMax = (epsilonYdVar() * x0Var() - E_C_3 * a2) / (epsilonYdVar() - E_C_3);
        System.out.println("xYdMax = " + xYdMax);
        return xYdMax;
    }
}
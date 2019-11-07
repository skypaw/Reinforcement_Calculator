package pl.pawz.zelbet;

public class BasicValuesPillars {
    private float h;
    private float a1;
    private float a2;
    private double epsilonCu3;
    private double epsilonC3;
    private double fYd;
    private float E_S;
    private float mEd;
    private float nEd;


    public BasicValuesPillars(float h, float a1, float a2, double epsilonCu3, double epsilonC3, double fYd, int E_S, float mEd, float nEd) {
        //constructor
        this.h = h;
        this.a1 = a1;
        this.a2 = a2;
        this.epsilonCu3 = epsilonCu3;
        this.epsilonC3 = epsilonC3;
        this.fYd = fYd;
        this.E_S = E_S;
        this.mEd = mEd;
        this.nEd = nEd;

    }

    public double xLimVar() {
        return (epsilonCu3 * BasicValues.dValue(h,a1)) / (epsilonCu3 + (fYd / E_S));
    }

    public double xMinYdVar() {
        return (epsilonCu3 * a2) / (epsilonCu3 - (fYd / E_S));
    }

    public double xMinMinusYdVar() {
        return (epsilonCu3 * a2) / (epsilonCu3 + (fYd / E_S));
    }

    private double epsilonYdVar() {
        return fYd / E_S;
    }

    public double x0Var() {
        return (1 - epsilonC3 / epsilonCu3) * h;
    }

    public double xYdMaxVar() {
        return (epsilonYdVar() * x0Var() - epsilonC3 * a2) / (epsilonYdVar() - epsilonC3);
    }

    public double[] eccentricityCompression() {
        double e = Math.abs(mEd / nEd);
        double eS1 = e + 0.5 * h - a1;
        double eS2 = e - 0.5 * h + a2;
        return new double[]{eS1, eS2};
    }

    public double[] eccentricityExtension() {
        double e = Math.abs(mEd / nEd);
        double eS1 = e - 0.5 * h + a1;
        double eS2 = e + 0.5 * h - a2;
        return new double[]{eS1, eS2};
    }

    public double[] values() {
        return new double[]{xLimVar(), xMinYdVar(), xMinMinusYdVar(), x0Var(), xYdMaxVar()};
    }
}
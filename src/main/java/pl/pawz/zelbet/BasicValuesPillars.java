package pl.pawz.zelbet;

public class BasicValuesPillars {

    public static double xLimVar(double epsilonCu3, double h, double a1, double fYd, int E_S) {
        return (epsilonCu3 * BasicValues.dValue(h,a1)) / (epsilonCu3 + (fYd / E_S));
    }

    public static double xMinYdVar(double epsilonCu3, double a2, double fYd, int E_S) {
        return (epsilonCu3 * a2) / (epsilonCu3 - (fYd / E_S));
    }

    public static double xMinMinusYdVar(double epsilonCu3, double a2, double fYd, int E_S) {
        return (epsilonCu3 * a2) / (epsilonCu3 + (fYd / E_S));
    }

    private static double epsilonYdVar(double fYd, int E_S) {
        return fYd / E_S;
    }

    public static double x0Var(double epsilonCu3, double epsilonC3, double h) {
        return (1 - epsilonC3 / epsilonCu3) * h;
    }

    public static double xYdMaxVar(double epsilonCu3,double epsilonC3,double fYd, int E_S, double h, double a2) {
        return (epsilonYdVar(fYd, E_S) * x0Var(epsilonCu3,epsilonC3,h) - epsilonC3 * a2) / (epsilonYdVar(fYd, E_S) - epsilonC3);
    }

    public static double[] eccentricityCompression(double mEd, double nEd, double h, double a1, double a2) {
        double e = Math.abs(mEd / nEd);
        double eS1 = e + 0.5 * h - a1;
        double eS2 = e - 0.5 * h + a2;
        return new double[]{eS1, eS2, e};
    }

    public static double[] eccentricityExtension(double mEd, double nEd, double h, double a1, double a2) {
        double e = Math.abs(mEd / nEd);
        double eS1 = e - 0.5 * h + a1;
        double eS2 = e + 0.5 * h - a2;
        return new double[]{eS1, eS2, e};
    }
}
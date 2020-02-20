package pl.pawz.zelbet;

public class BasicValuesPillars {

    public static double xLimVar(double epsilonCu3, float h, float a1, double fYd, int E_S) {
        return (epsilonCu3 * BasicValues.dValue(h,a1)) / (epsilonCu3 + (fYd / E_S));
    }

    public static double xMinYdVar(double epsilonCu3, float a2, double fYd, int E_S) {
        return (epsilonCu3 * a2) / (epsilonCu3 - (fYd / E_S));
    }

    public static double xMinMinusYdVar(double epsilonCu3, float a2, double fYd, int E_S) {
        return (epsilonCu3 * a2) / (epsilonCu3 + (fYd / E_S));
    }

    private static double epsilonYdVar(double fYd, int E_S) {
        return fYd / E_S;
    }

    public static double x0Var(double epsilonCu3, double epsilonC3, float h) {
        return (1 - epsilonC3 / epsilonCu3) * h;
    }

    public static double xYdMaxVar(double epsilonCu3,double epsilonC3,double fYd, int E_S, float h, float a2) {
        return (epsilonYdVar(fYd, E_S) * x0Var(epsilonCu3,epsilonC3,h) - epsilonC3 * a2) / (epsilonYdVar(fYd, E_S) - epsilonC3);
    }

    public static double eccentricityBasic(float mEd, float nEd){
        return Math.abs(mEd / nEd);
    }

    public static double[] eccentricityCompression(double e, float h, float a1, float a2) {
        double eS1 = e + 0.5 * h - a1;
        double eS2 = e - 0.5 * h + a2;
        return new double[]{eS1, eS2};
    }

    public static double[] eccentricityExtension(double e, float h, float a1, float a2) {
        double eS1 = e - 0.5 * h + a1;
        double eS2 = e + 0.5 * h - a2;
        return new double[]{eS1, eS2};
    }
}
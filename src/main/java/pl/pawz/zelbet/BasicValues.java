package pl.pawz.zelbet;

public class BasicValues {
    public static int steelE(){
        return 200000;
    }

    public static float gammaCConcrete() {
        return 1.4f;
    }

    public static double dValue(float h, float a1) {
        return h - a1;
    }

    public static double fCdValue(double fCk) {
        float alphaCc = 1f;
        float gammaC = gammaCConcrete();
        return alphaCc * fCk / gammaC;
    }

    public static double fYdValue(double fYk) {
        float alphaCc = 1f;
        float gammaC = 1.15f;
        return alphaCc * fYk / gammaC;
    }

    public static double lambdaConcreteValue(double fCk) {
        if (fCk > 50) {
            return 0.8 - (fCk - 50) / 400;
        } else {
            return 0.8;
        }
    }

    public static double etaConcreteValue(double fCk) {
        if (fCk > 50) {
            return 1.0 - (fCk - 50) / 200;
        } else {
            return 1.0;
        }
    }

    public static double epsilonCu3Value(double fCk) {
        if (fCk > 50) {
            return (2.6 + 35 * Math.pow(0.01 * (90 - fCk), 4)) * 0.001;
        } else {
            return 3.5 * 0.001;
        }
    }

    public static double epsilonC3Value(double fCk) {
        if (fCk > 50) {
            return (1.75 + 0.01375 * (fCk - 50)) * 0.001;
        } else {
            return 1.75 * 0.001;
        }
    }

}

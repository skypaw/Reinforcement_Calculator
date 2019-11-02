package pl.pawz.zelbet;

class BasicValues {

    static double dValue(float h, float a1){
        return h-a1;
    }

    static double fCdValue(float fCk) {
        float alphaCc = 1f;
        float gammaC = 1.4f;
        return alphaCc * fCk / gammaC;
    }

    static double fYdValue(float fYk) {
        float alphaCc = 1f;
        float gammaC = 1.15f;
        return alphaCc * fYk / gammaC;
    }

    static double lambdaConcreteValue(float fCk) {
        if (fCk > 50) {
            return 0.8 - (fCk - 50) / 400;
        } else {
            return 0.8;
        }
    }

    static double etaConcreteValue(float fCk) {
        if (fCk > 50) {
            return 1.0 - (fCk - 50) / 200;
        } else {
            return 1.0;
        }
    }

    static double epsilonCu3Value(float fCk) {
        if (fCk > 50) {
            return (2.6 + 35 * Math.pow(0.01 * (90 - fCk), 4)) * 0.001;
        } else {
            return 3.5 * 0.001;
        }
    }

    static double epsilonC3Value(float fCk) {
        if (fCk > 50) {
            return (1.75 + 0.01375 * (fCk - 50)) * 0.001;
        } else {
            return 1.75 * 0.001;
        }
    }

}

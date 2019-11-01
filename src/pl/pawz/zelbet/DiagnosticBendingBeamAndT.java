package pl.pawz.zelbet;

class DiagnosticBendingBeamAndT {
    private float fCd;
    private float epsilonCu3;
    private float etaConcrete;
    private float lambdaConcrete;
    private float fYd;
    private int E_S;
    private float bW;
    private float bEff;
    private float h;
    private float hF;
    private float a1;
    private float a2;
    private double d;
    private double aS1;
    private double aS2;
    private double xLim;
    private double xMinYd;
    private double xMinMinusYd;

    DiagnosticBendingBeamAndT(float fCd, float epsilonCu3, float lambdaConcrete, float etaConcrete, float fYd, int E_S, float bW, float bEff, float h, float hF, float a1, float a2, double d, double aS1, double aS2) {
        this.fCd = fCd;
        this.epsilonCu3 = epsilonCu3;
        this.lambdaConcrete = lambdaConcrete;
        this.etaConcrete = etaConcrete;
        this.fYd = fYd;
        this.E_S = E_S;
        this.bW = bW;
        this.bEff = bEff;
        this.h = h;
        this.hF = hF;
        this.a1 = a1;
        this.a2 = a2;
        this.d = d;
        this.aS1 = aS1;
        this.aS2 = aS2;

        BasicValuesPillars limitValues = new BasicValuesPillars(h, a1, a2, epsilonCu3, 0, fYd, E_S, 0, 0);
        this.xLim = limitValues.xLimVar();
        this.xMinYd = limitValues.xMinYdVar();
        this.xMinMinusYd = limitValues.xMinMinusYdVar();
    }

    private double xVar() {
        return 1 / lambdaConcrete * (fYd * (aS1 - aS2)) / (etaConcrete * fCd * bEff);
    }

    private double[] xSmallerThanXMinYd() {
        float sigmaS1 = fYd;
        double aVar = (epsilonCu3 * E_S * aS2 - fYd * aS1) / (etaConcrete * fCd * bEff);
        double bVar = (4 * lambdaConcrete * epsilonCu3 * E_S * aS2) / (etaConcrete * fCd * bEff) * a2;
        double xVar = 1 / lambdaConcrete * ((-aVar + Math.sqrt(Math.pow(aVar, 2) + bVar)) / 2);
        return new double[]{xVar, sigmaS1};
    }

    private double xGreaterThanXMinYd() {
        return fYd; //SigmaS2
    }

    private double xSmallerThanXLim() {
        return fYd; //SigmaS1
    }

    private double[] xGreaterThanXLim() {
        double xVar = xLim;
        double sigmaS1 = (etaConcrete * fCd * bEff * lambdaConcrete * xVar + fYd * aS2) / aS1;
        return new double[]{xVar, sigmaS1};
    }

    private double[] xSmallerThanXMinMinusYd() {
        double xVar = 1 / lambdaConcrete * (fYd * (aS1 + aS2)) / (etaConcrete * fCd * bEff);
        double sigmaS2 = -fYd;
        return new double[]{xVar, sigmaS2};
    }

    private double xGreaterThanXMinMinusYd() {
        return epsilonCu3 * (xSmallerThanXMinYd()[0] - a2) / xSmallerThanXMinYd()[0] * E_S;
    }

    /*
    TBeam
     */

    private double[] xGreaterThanHfByLambdaT() {
        double aC1 = (bEff - bW) * hF;
        double xVar = 1 / lambdaConcrete * ((fYd * (aS1 - aS2)) / (etaConcrete * fCd * bW) - aC1 / bW);
        return new double[]{xVar, aC1};
    }

    private double[] xSmallerThanXMinYdT() {
        double sigmaS1 = fYd;
        double aVar = xGreaterThanHfByLambdaT()[1] / bW + (epsilonCu3 * E_S * aS2 - fYd * aS1) / (etaConcrete * fCd * bW);
        double bVar = (4 * lambdaConcrete * epsilonCu3 * E_S * aS2) / (etaConcrete * fCd * bW) * a2;
        double xVar = 1 / lambdaConcrete * ((-aVar + Math.sqrt(Math.pow(aVar, 2) + bVar)) / 2);
        return new double[]{xVar, sigmaS1};
    }

    private double xGreaterThanXMinYdT() {
        return fYd; //sigmaS2
    }

    private double xSmallerThanXLimT() {
        return fYd; //sigmaS1
    }

    private double[] xGreaterThanXLimT() {
        double xVar = xLim;
        double sigmaS1 = (etaConcrete * fCd * (xGreaterThanHfByLambdaT()[1] + bW * lambdaConcrete * xVar) + fYd * aS2) / aS1;
        return new double[]{xVar, sigmaS1};
    }

    private double[] xSmallerThanXMinMinusYdT() {
        double xVar = 1 / lambdaConcrete * ((fYd * (aS1 + aS2)) / (etaConcrete * fCd * bW) - xGreaterThanHfByLambdaT()[1] / bW);
        return new double[]{xVar, -fYd}; //-fyd = sigmaS2
    }

    private double xGreaterThanXMinMinusYdT() {
        return epsilonCu3 * (xSmallerThanXMinYd()[0] - a2) / xSmallerThanXMinYd()[0] * E_S; //sigmaS2
    }

    double resultDiagnostic() {
        double xVar;
        double sigmaS1;
        double sigmaS2;

        if (xVar() <= hF / lambdaConcrete) {

            if (xVar() < xMinYd) {
                xVar = xSmallerThanXMinYd()[0];
                sigmaS1 = xSmallerThanXMinYd()[1];
                if (xVar < xMinMinusYd) {
                    xVar = xSmallerThanXMinMinusYd()[0];
                    sigmaS2 = xSmallerThanXMinMinusYd()[1];
                } else {
                    sigmaS2 = xGreaterThanXMinMinusYd();
                }
            } else {
                xVar = xVar();
                sigmaS2 = xGreaterThanXMinYd();
                if (xVar <= xLim) {
                    sigmaS1 = xSmallerThanXLim();
                } else {
                    xVar = xGreaterThanXLim()[0];
                    sigmaS1 = xGreaterThanXLim()[1];
                }
            }
            System.out.println(sigmaS1);
            return etaConcrete * fCd * bEff * lambdaConcrete * xVar * (d - 0.5 * lambdaConcrete * xVar) + sigmaS2 * aS2 * (d - a2);
        } else {
            xVar = xGreaterThanHfByLambdaT()[0];
            if (xVar < xMinYd) {
                xVar = xSmallerThanXMinYdT()[0];
                sigmaS1 = xSmallerThanXMinYdT()[1];
                if (xVar < xMinMinusYd) {
                    xVar = xSmallerThanXMinMinusYdT()[0];
                    sigmaS2 = xSmallerThanXMinMinusYdT()[1];
                } else {
                    sigmaS2 = xGreaterThanXMinMinusYdT();
                }

            } else {
                sigmaS2 = xGreaterThanXMinYdT();
                if (xVar <= xLim) {
                    sigmaS1 = xSmallerThanXLimT();
                } else {
                    xVar = xGreaterThanXLimT()[0];
                    sigmaS1 = xGreaterThanXLimT()[1];
                }
            }
            System.out.println(sigmaS1);
            return etaConcrete * fCd * (xGreaterThanHfByLambdaT()[1] * (d - 0.5 * hF) + bW * lambdaConcrete * xVar * (d - 0.5 * lambdaConcrete * xVar)) + sigmaS2 * aS2 * (d - a2);
        }
    }
}

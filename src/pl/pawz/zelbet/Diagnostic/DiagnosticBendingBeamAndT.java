package pl.pawz.zelbet.Diagnostic;

import pl.pawz.zelbet.BasicValues;
import pl.pawz.zelbet.BasicValuesPillars;

public class DiagnosticBendingBeamAndT {
    private double fCd;
    private double epsilonCu3;
    private double etaConcrete;
    private double lambdaConcrete;
    private double fYd;
    private int E_S;
    private float bW;
    private float bEff;
    private float hF;
    private float a2;
    private double d;
    private double aS1;
    private double aS2;
    private double xLim;
    private double xMinYd;
    private double xMinMinusYd;

    public DiagnosticBendingBeamAndT(double fCk,  double fYk, float bW, float bEff, float h, float hF, float a1, float a2, double aS1, double aS2) {
        this.fCd = BasicValues.fCdValue(fCk);
        this.epsilonCu3 = BasicValues.epsilonCu3Value(fCk);
        this.lambdaConcrete = BasicValues.lambdaConcreteValue(fCk);
        this.etaConcrete = BasicValues.etaConcreteValue(fCk);
        this.fYd = BasicValues.fYdValue(fYk);
        this.E_S = BasicValues.steelE();
        this.bW = bW;
        this.bEff = bEff;
        this.hF = hF;
        this.a2 = a2;
        this.d = BasicValues.dValue(h,a1);
        this.aS1 = aS1;
        this.aS2 = aS2;

        this.xLim = BasicValuesPillars.xLimVar(epsilonCu3,h,a1,fYd,E_S);
        this.xMinYd = BasicValuesPillars.xMinYdVar(epsilonCu3,a2,fYd,E_S);
        this.xMinMinusYd = BasicValuesPillars.xMinMinusYdVar(epsilonCu3,a2,fYd,E_S);
    }

    private double xVar() {
        return 1 / lambdaConcrete * (fYd * (aS1 - aS2)) / (etaConcrete * fCd * bEff);
    }

    private double[] xSmallerThanXMinYd() {
        double sigmaS1 = fYd;
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
        double aVar = (fYd*aS2+epsilonCu3*E_S*aS1)/(etaConcrete*fCd*bW);
        double bVar = (4*lambdaConcrete*epsilonCu3*E_S*aS1*d)/(etaConcrete*fCd*bEff);
        double xVar = 1/lambdaConcrete*((-aVar+Math.sqrt(Math.pow(aVar,2)+bVar))/2);
        double sigmaS1 = epsilonCu3*(d-xVar)/xVar*E_S;
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
        double aVar = xGreaterThanHfByLambdaT()[1]/bW+(aS2*fYd+epsilonCu3*E_S*aS1)/(etaConcrete*fCd*bW);
        double bVar = (4*lambdaConcrete*epsilonCu3*E_S*aS1*d)/etaConcrete*fCd*bW;
        double xVar = 1/lambdaConcrete*((-aVar+Math.sqrt(Math.pow(aVar,2)+bVar))/2);
        double sigmaS1 = epsilonCu3*(d-xVar)/xVar*E_S;
        return new double[]{xVar, sigmaS1};
    }

    private double[] xSmallerThanXMinMinusYdT() {
        double xVar = 1 / lambdaConcrete * ((fYd * (aS1 + aS2)) / (etaConcrete * fCd * bW) - xGreaterThanHfByLambdaT()[1] / bW);
        return new double[]{xVar, -fYd}; //-fyd = sigmaS2
    }

    private double xGreaterThanXMinMinusYdT() {
        return epsilonCu3 * (xSmallerThanXMinYd()[0] - a2) / xSmallerThanXMinYd()[0] * E_S; //sigmaS2
    }

    public double resultDiagnostic() {
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

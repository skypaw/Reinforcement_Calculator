package pl.pawz.zelbet.ULS;

import pl.pawz.zelbet.BasicValues;
import pl.pawz.zelbet.BasicValuesPillars;
import pl.pawz.zelbet.PolynomialSolver;

public class ExtensionAsymmetricReinforcement {
    private double nEd;
    private double epsilonCu3;
    private double fCd;
    private double fYd;
    private double etaConcrete;
    private double lambdaConcrete;
    private double dDimension;
    private double bDimension;
    private double a2;
    private int E_S;
    private double xMinusMinYd;
    private double xMinYd;
    private double eS1;
    private double eS2;
    private double sigmaS2;
    private double xVar;
    private double aS2Min;
    private double aS1;
    private double aS2;


    public ExtensionAsymmetricReinforcement(double nEd, double mEd, double fCk, double fYk, double bDimension,
                                            double hDimension, double a1, double a2) {
        this.nEd = nEd;
        this.epsilonCu3 = BasicValues.epsilonCu3Value(fCk);
        this.fCd = BasicValues.fCdValue(fCk);
        this.fYd = BasicValues.fYdValue(fYk);
        this.etaConcrete = BasicValues.etaConcreteValue(fCk);
        this.lambdaConcrete = BasicValues.lambdaConcreteValue(fCk);
        this.dDimension = BasicValues.dValue(hDimension, a1);
        this.bDimension = bDimension;
        this.a2 = a2;
        this.E_S = BasicValues.steelE();
        double xLim = BasicValuesPillars.xLimVar(epsilonCu3, hDimension, a1, fYd, E_S);
        this.xMinusMinYd = BasicValuesPillars.xMinMinusYdVar(epsilonCu3, a2, fYd, E_S);
        this.xMinYd = BasicValuesPillars.xMinYdVar(epsilonCu3, a2, fYd, E_S);


        this.eS1 = BasicValuesPillars.eccentricityExtension(mEd, nEd, hDimension, a1, a2)[0];
        this.eS2 = BasicValuesPillars.eccentricityExtension(mEd, nEd, hDimension, a1, a2)[1];

        xVar = xLim;
        sigmaS2 = Math.min(epsilonCu3 * (xVar - a2) / xVar * E_S, fYd);

        this.aS2Min = Math.max(0.10 * nEd / fYd, (0.002 * bDimension * 100 * hDimension * 100) * Math.pow(10, -4)) / 2;
        aS2 = (nEd * eS1 - etaConcrete * fCd * bDimension * lambdaConcrete * xVar * (dDimension - 0.5 * lambdaConcrete * xVar)) / (sigmaS2 * (dDimension - a2));

    }

    private void aS2GreaterThanAS2Min() {
        aS1 = (sigmaS2 * aS2 + etaConcrete * fCd * bDimension * lambdaConcrete * xVar + nEd) / fYd;
    }

    private void aS2SmallerThanAS2Min() {
        aS2 = aS2Min;
        xVar = 1 / lambdaConcrete * (dDimension - Math.sqrt(Math.pow(dDimension, 2) - (2 * (nEd * eS1 - sigmaS2 * aS2 * (dDimension - a2))) / (etaConcrete * fCd * bDimension)));
    }

    private void xSmallerThanXMinYd() {
        double mS2 = epsilonCu3 * E_S * aS2Min * (dDimension - a2);

        double aVar = -2 * dDimension / lambdaConcrete;
        double bVar = 2 * (nEd * eS1 - mS2) / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);
        double cVar = 2 * a2 * mS2 / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);

        xVar = PolynomialSolver.solver(1, aVar, bVar, cVar, 0);
    }

    private void xGreaterThanXMinYd() {
        sigmaS2 = fYd;
    }

    private void xGreaterThanXMinMinusYd() {
        sigmaS2 = epsilonCu3 * (xVar - a2) / xVar * E_S;
    }

    private void xSmallerThanXMinMinusYd() {
        sigmaS2 = -fYd;
        xVar = 1 / lambdaConcrete * (dDimension - Math.sqrt(Math.pow(dDimension, 2) - (2 * (nEd * eS1 + fYd * aS2 * (dDimension - a2))) / (etaConcrete * fCd * bDimension)));
    }

    private void xGreaterThanZero() {
        aS1 = (sigmaS2 * aS2 + etaConcrete * fCd * bDimension * lambdaConcrete * xVar + nEd) / fYd;
    }

    private void xSmallerThanZero() {
        xVar = 0;
        aS1 = nEd * eS2 / (fYd * (dDimension - a2));
        aS2 = nEd * eS1 / (-fYd * (dDimension - a2));
    }

    public double[] resultsExtensionAsymmetric() {
        if (aS2 <= aS2Min) {
            aS2SmallerThanAS2Min();
            if (xVar <= xMinYd) {
                xSmallerThanXMinYd();
                if (xVar <= xMinusMinYd) {
                    xSmallerThanXMinMinusYd();
                    if (xVar <= 0) {
                        xSmallerThanZero();
                    } else {
                        xGreaterThanZero();
                    }
                } else {
                    xGreaterThanXMinMinusYd();
                    xGreaterThanZero();
                }
            } else {
                xGreaterThanXMinYd();
                xGreaterThanZero();
            }
        } else {
            aS2GreaterThanAS2Min();
        }

        if (aS1<aS2Min){
            aS1 = aS2Min;
        }
        if (aS2<aS2Min){
            aS2 = aS2Min;
        }
        return new double[]{aS1, aS2};
    }

}

package pl.pawz.zelbet.ULS;

import pl.pawz.zelbet.BasicValues;
import pl.pawz.zelbet.BasicValuesPillars;
import pl.pawz.zelbet.PolynomialSolver;

public class CompressionSymmetricReinforcement {

    private float nEd;
    private double epsilonCu3;
    private double epsilonC3;
    private double fCd;
    private double fYd;
    private double etaConcrete;
    private double lambdaConcrete;
    private double dDimension;
    private float bDimension;
    private float hDimension;
    private float a1;
    private float a2;
    private int E_S;
    private double xLim;
    private double xMinusMinYd;
    private double xMinYd;
    private double x0;
    private double xMaxYd;
    private double eS1;
    private double eS2;
    private double xVar;
    private double sigmaS1;
    private double sigmaS2;


    public CompressionSymmetricReinforcement(float nEd, float mEd, double fCk, double fYk, float bDimension,
                                             float hDimension, float a1, float a2) {
        this.nEd = nEd;
        this.epsilonCu3 = BasicValues.epsilonCu3Value(fCk);
        this.epsilonC3 = BasicValues.epsilonC3Value(fCk);
        this.fCd = BasicValues.fCdValue(fCk);
        this.fYd = BasicValues.fYdValue(fYk);
        this.etaConcrete = BasicValues.etaConcreteValue(fCk);
        this.lambdaConcrete = BasicValues.lambdaConcreteValue(fCk);
        this.dDimension = BasicValues.dValue(hDimension, a1);
        this.bDimension = bDimension;
        this.hDimension = hDimension;
        this.a1 = a1;
        this.a2 = a2;
        this.E_S = BasicValues.steelE();
        this.xLim = BasicValuesPillars.xLimVar(epsilonCu3, hDimension, a1, fYd, E_S);
        this.xMinusMinYd = BasicValuesPillars.xMinMinusYdVar(epsilonCu3, a2, fYd, E_S);
        this.xMinYd = BasicValuesPillars.xMinYdVar(epsilonCu3, a2, fYd, E_S);
        this.x0 = BasicValuesPillars.x0Var(epsilonCu3, epsilonC3, hDimension);
        this.xMaxYd = BasicValuesPillars.xYdMaxVar(epsilonCu3, epsilonC3, fYd, E_S, hDimension, a2);


        this.eS1 = BasicValuesPillars.eccentricityCompression(mEd, nEd, hDimension, a1, a2)[0];
        this.eS2 = BasicValuesPillars.eccentricityCompression(mEd, nEd, hDimension, a1, a2)[1];


    }

    private void xVar() {
        xVar = (1 / lambdaConcrete) * (nEd / (etaConcrete * fCd * bDimension));
    }

    private void xSmallerThanXLim() {
        sigmaS1 = fYd;
    }

    private void xSmallerThanXMinYd() {
        double aVar = lambdaConcrete * (fYd - epsilonCu3 * E_S);
        double bVar = -2 * (fYd * dDimension - epsilonCu3 * E_S * a2 * (1 + 0.5 * lambdaConcrete));
        double cVar = 2 * ((nEd * (fYd * eS1 - epsilonCu3 * E_S * eS2)) / (lambdaConcrete * etaConcrete * fCd * bDimension) - epsilonCu3 * E_S * Math.pow(a2, 2));
        double dVar = (2 * nEd * epsilonCu3 * E_S * a2 * eS2) / (lambdaConcrete * etaConcrete * fCd * bDimension);

        xVar = PolynomialSolver.solver(aVar, bVar, cVar, dVar, 0);
    }

    private void xGreaterThanXMinYd() {
        sigmaS2 = fYd;
    }

    private void xSmallerThanXMinusMinYd() {
        sigmaS2 = -fYd;
        xVar = 1 / (2 * lambdaConcrete) * ((dDimension + a2) - Math.sqrt(Math.pow((dDimension + a2), 2) - (4 * nEd * (eS1 + eS2)) / (etaConcrete * fCd * bDimension)));
    }

    private void xGreaterThanXMinusMinYd() {
        sigmaS2 = epsilonCu3 * (xVar - a2) / xVar * E_S;
    }

    private void xGreaterThanXLim() {
        sigmaS2 = fYd;
        double aVar = lambdaConcrete * (fYd + epsilonCu3 * E_S);
        double bVar = -2 * (fYd * a2 + epsilonCu3 * E_S * dDimension * (1 + 0.5 * lambdaConcrete));
        double cVar = 2 * ((nEd * (fYd * eS2 + epsilonCu3 * E_S * eS1)) / (lambdaConcrete * etaConcrete * fCd * bDimension) + epsilonCu3 * E_S * Math.pow(dDimension, 2));
        double dVar = (-2 * nEd) / (lambdaConcrete * etaConcrete * fCd * bDimension) * epsilonCu3 * E_S * dDimension * eS1;

        xVar = PolynomialSolver.solver(aVar, bVar, cVar, dVar, xLim);
    }

    private void xGreaterThanH() {
        double aVar = lambdaConcrete * (fYd + epsilonC3 * E_S);
        double bVar = -2 * (fYd * (a2 + 0.5 * lambdaConcrete * x0) + epsilonC3 * E_S * dDimension * (1 + 0.5 * lambdaConcrete));
        double cVar = 2 * ((nEd * (fYd * eS2 + epsilonC3 * E_S * eS1)) / (lambdaConcrete * etaConcrete * fCd * bDimension) + epsilonC3 * E_S * Math.pow(dDimension, 2) + fYd * a2 * x0);
        double dVar = (-2 * nEd) / (lambdaConcrete * etaConcrete * fCd * bDimension) * (epsilonC3 * E_S * dDimension * eS1 + fYd * x0 * eS2);

        xVar = PolynomialSolver.solver(aVar, bVar, cVar, dVar, hDimension);
    }

    private void xSmallerThanH() {
        sigmaS1 = epsilonCu3 * (dDimension - xVar) / xVar * E_S; //sigmaS1
    }

    private void xGreaterThanHbyLambda() {
        double f1 = nEd * eS1 - etaConcrete * fCd * bDimension * hDimension * (0.5 * hDimension - a1);
        double f2 = nEd * eS2 + etaConcrete * fCd * bDimension * hDimension * (0.5 * hDimension - a2);
        xVar = (epsilonC3 * E_S * dDimension * f1 + fYd * x0 * f2) / (epsilonC3 * E_S * f1 + fYd * f2);
    }

    private void xSmallerThanHbyLambda() {
        sigmaS1 = epsilonC3 * (dDimension - xVar) / (xVar - x0) * E_S;
    }

    private void xBelongsToHbyLambdaAndXYdMax() {
        sigmaS1 = epsilonC3 * (dDimension - xVar) / (xVar - x0) * E_S;
    }

    private void xDoNotBelongsToHbyLambdaAndXYdMax() {
        double f1 = nEd * (eS1 * dDimension + eS2 * a2) + etaConcrete * fCd * bDimension * hDimension * 0.5 * ((a1 - a2) * (dDimension + a2) - Math.pow(dDimension - a2, 2));
        double f2 = nEd * (eS1 + eS2) + etaConcrete * fCd * bDimension * hDimension * (a1 - a2);
        xVar = f1 / f2;
        sigmaS1 = epsilonC3 * (dDimension - xVar) / (xVar - x0) * E_S;
        sigmaS2 = epsilonC3 * (xVar - a2) / (xVar - x0) * E_S;
    }

    private void xGreaterOrEqualHByLambda() {
        xVar = hDimension / lambdaConcrete; //x
    }

    public double[] resultsCompressionSymmetricReinforcement() {
        xVar();

        if (xVar <= xLim) {
            xSmallerThanXLim();
            if (xVar < xMinYd) {
                xSmallerThanXMinYd();
                if (xVar <= xMinusMinYd) {
                    xSmallerThanXMinusMinYd();
                } else {
                    xGreaterThanXMinusMinYd();
                }
            } else {
                xGreaterThanXMinYd();
            }
        } else {
            xGreaterThanXLim();
            if (xVar > hDimension) {
                xGreaterThanH();
                if (xVar > hDimension / lambdaConcrete) {
                    xGreaterThanHbyLambda();
                    if (xVar > hDimension / lambdaConcrete && xVar < xMaxYd) {
                        xBelongsToHbyLambdaAndXYdMax();

                    } else {
                        xDoNotBelongsToHbyLambdaAndXYdMax();
                    }

                } else {
                    xSmallerThanHbyLambda();
                }
                if (xVar > hDimension / lambdaConcrete) {
                    xGreaterOrEqualHByLambda();
                }
            } else {
                xSmallerThanH();
            }
        }


        double aS1 = (nEd * eS2 + etaConcrete * fCd * bDimension * lambdaConcrete * xVar * (0.5 * lambdaConcrete * xVar - a2)) / (sigmaS1 * (dDimension - a2));
        double aS2 = (nEd * eS1 - etaConcrete * fCd * bDimension * lambdaConcrete * xVar * (dDimension - 0.5 * lambdaConcrete * xVar)) / (sigmaS2 * (dDimension - a2));
        return new double[]{aS1, aS2};

    }
}

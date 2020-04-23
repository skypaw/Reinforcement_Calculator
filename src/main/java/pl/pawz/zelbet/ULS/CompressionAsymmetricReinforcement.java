package pl.pawz.zelbet.ULS;

import pl.pawz.zelbet.BasicValues;
import pl.pawz.zelbet.BasicValuesPillars;
import pl.pawz.zelbet.PolynomialSolver;

public class CompressionAsymmetricReinforcement {


    private double nEd;
    private double epsilonCu3;
    private double epsilonC3;
    private double fCd;
    private double fYd;
    private double etaConcrete;
    private double lambdaConcrete;
    private double dDimension;
    private double bDimension;
    private double hDimension;
    private double a1;
    private double a2;
    private int E_S;
    private double xLim;
    private double xMinusMinYd;
    private double xMinYd;
    private double x0;
    private double xMaxYd;
    private double eS1;
    private double eS2;
    private double sigmaS2;
    private double aS1;
    private double aS2;
    private double aS2Min;
    private double aS1Min;
    private double xVar;

    public CompressionAsymmetricReinforcement(double nEd, double mEd, double fCk, double fYk, double bDimension,
                                              double hDimension, double a1, double a2) {
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

        //min reinforcement according to EC 1992;

        this.aS2Min = Math.max(0.10 * nEd / fYd, (0.002 * bDimension * 100 * hDimension * 100) * Math.pow(10, -4)) / 2;
        this.aS1Min = aS2Min;
    }


    private void sigmaS2Var() {
        sigmaS2 = Math.min(epsilonCu3 * (xLim - a2) / xLim * E_S, fYd);
    }

    private void aS2Var() {
        aS2 = (nEd * eS1 - etaConcrete * fCd * bDimension * lambdaConcrete * xLim * (dDimension - 0.5 * lambdaConcrete * xLim)) / (sigmaS2 * (dDimension - a2));
    }

    private void aS2GreaterThanA2Min() {
        aS1 = (sigmaS2 * aS2 + etaConcrete * fCd * bDimension * lambdaConcrete * xLim - nEd) / fYd;
    }

    private void aS1SmallerThan0() {
        aS1 = aS1Min;
        double mS1 = epsilonCu3 * E_S * aS1Min * (dDimension - a2);
        double aVar = -2 * a2 / lambdaConcrete;
        double bVar = 2 * (nEd * eS2 + mS1) / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);
        double cVar = -2 * dDimension * mS1 / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);

        xVar = PolynomialSolver.solver(1, aVar, bVar, cVar, xLim);
    }

    private void xGreaterThanH() {
        double mS2 = epsilonC3 * E_S * aS1Min * (dDimension - a2);
        double aVar = -(x0 + 2 * a2 / lambdaConcrete);
        double bVar = 2 * ((nEd * eS2 + mS2) / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension) + a2 * x0 / lambdaConcrete);
        double cVar = (-2 * (nEd * eS2 * x0 + dDimension * mS2)) / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);

        xVar = PolynomialSolver.solver(1, aVar, bVar, cVar, hDimension);
    }

    private double[] xGreaterThanHByLambda() {
        double f1 = (-nEd * eS2 - etaConcrete * fCd * bDimension * hDimension * (0.5 * hDimension - a2)) * (dDimension - x0);
        double f2 = (nEd * eS1 - etaConcrete * fCd * bDimension * hDimension * (0.5 * hDimension - a1)) * (x0 - a2);

        return new double[]{f1, f2};
    }

    private void f2MinusF1GreaterThan0() {
        double xVarF = (-xGreaterThanHByLambda()[0] * a2 + xGreaterThanHByLambda()[1] * dDimension + Math.sqrt(xGreaterThanHByLambda()[0] * xGreaterThanHByLambda()[1]) * (dDimension - a2)) / (xGreaterThanHByLambda()[1] - xGreaterThanHByLambda()[0]);
        xVar = Math.max(xVarF, xMaxYd);
    }

    private void aS2SmallerThanAS2Min() {
        aS2 = aS2Min;
    }

    private void aS2EqualAS2Min() {
        xVar = 1 / lambdaConcrete * (dDimension - Math.sqrt(Math.pow(dDimension, 2) - (2 * (nEd * eS1 - sigmaS2 * aS2 * (dDimension - a2))) / (etaConcrete * fCd * bDimension)));
    }

    private void xSmallerThanXMinYd() {
        double mS2 = epsilonCu3 * E_S * aS2Min * (dDimension - a2);
        double aVar = -2 * dDimension / lambdaConcrete;
        double bVar = (2 * (nEd * eS1 - mS2)) / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);
        double cVar = (2 * a2 * mS2) / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);

        xVar = PolynomialSolver.solver(1, aVar, bVar, cVar, 0);
    }

    private void xGreaterThanXMinMinusYd() {
        sigmaS2 = epsilonCu3 * (xVar - a2) / xVar * E_S;
    }

    private void xGreaterThanXMinYd() {
        sigmaS2 = fYd;
    }

    private void xSmallerThanXMinMinusYd() {
        sigmaS2 = -fYd;
        xVar = 1 / lambdaConcrete * (dDimension - Math.sqrt(Math.pow(dDimension, 2) - (2 * (nEd * eS1 + fYd * aS2 * (dDimension - a2))) / (etaConcrete * fCd * bDimension)));
    }

    private void f2MinusF1SmallerThan0() {
        xVar = Math.pow(10, 10);
    }

    public double[] resultsCompressionAsymmetricReinforcement() {
        sigmaS2Var();
        aS2Var();

        double aSMinForOneSide = Math.max(0.10 * nEd / fYd, (0.002 * bDimension * 100 * hDimension * 100) * Math.pow(10, -4)) / 2;

        if (aS1 < aSMinForOneSide) {
            aS1 = aSMinForOneSide;
        }
        if (aS2 < aSMinForOneSide) {
            aS2 = aSMinForOneSide;
        }


        if (aS2 <= aS2Min) {
            aS2SmallerThanAS2Min();
            aS2EqualAS2Min();
            if (xVar < xMinYd) {
                xSmallerThanXMinYd();
                if (xVar <= xMinusMinYd) {
                    xSmallerThanXMinMinusYd(); //should sigma change too
                } else {
                    xGreaterThanXMinMinusYd();
                }
            } else {
                xGreaterThanXMinYd();
            }

            aS1 = (sigmaS2 * aS2 + etaConcrete * fCd * bDimension * lambdaConcrete * xVar - nEd) / fYd;

            if (aS1 < aSMinForOneSide) {
                aS1 = aSMinForOneSide;
            }

            return new double[]{aS1, aS2};
        } else {
            aS2GreaterThanA2Min();
            if (aS1 < 0) {
                aS1SmallerThan0();
                if (xVar > hDimension) {
                    xGreaterThanH();
                    if (xVar > hDimension / lambdaConcrete) {
                        double f1 = xGreaterThanHByLambda()[0];
                        double f2 = xGreaterThanHByLambda()[1];
                        double sigmaS1;
                        if (f2 - f1 > 0) {
                            f2MinusF1GreaterThan0();
                            sigmaS1 = Math.min(epsilonC3 * (dDimension - xVar) / (xVar - x0) * E_S, fYd);
                            sigmaS2 = Math.min(epsilonC3 * (xVar - a2) / (xVar - x0) * E_S, fYd);
                            aS1 = (nEd * eS2 + etaConcrete * fCd * bDimension * hDimension * (0.5 * hDimension - a2)) / (sigmaS1 * (dDimension - a2));
                            aS2 = (nEd * eS1 - etaConcrete * fCd * bDimension * hDimension * (0.5 * hDimension - a1)) / (sigmaS2 * (dDimension - a2));

                            if (aS1 < aSMinForOneSide) {
                                aS1 = aSMinForOneSide;
                            }
                            if (aS2 < aSMinForOneSide) {
                                aS2 = aSMinForOneSide;
                            }


                            return new double[]{aS1, aS2};

                        } else {
                            f2MinusF1SmallerThan0();
                            sigmaS1 = Math.max(epsilonC3 * (dDimension - xVar) / (xVar - x0) * E_S, fYd);
                            sigmaS2 = Math.max(epsilonC3 * (xVar - a2) / (xVar - x0) * E_S, fYd);
                            aS1 = (nEd * eS2 + etaConcrete * fCd * bDimension * hDimension * (0.5 * hDimension - a2)) / (sigmaS1 * (dDimension - a2));
                            aS2 = (nEd * eS1 - etaConcrete * fCd * bDimension * hDimension * (0.5 * hDimension - a1)) / (sigmaS2 * (dDimension - a2));

                            if (aS1 < aSMinForOneSide) {
                                aS1 = aSMinForOneSide;
                            }
                            if (aS2 < aSMinForOneSide) {
                                aS2 = aSMinForOneSide;
                            }


                            return new double[]{aS1, aS2};

                        }
                    } else {
                        aS2 = (nEd * eS1 - etaConcrete * fCd * bDimension * lambdaConcrete * xVar * (dDimension - 0.5 * lambdaConcrete * xVar)) / (fYd * (dDimension - a2));


                        if (aS2 < aSMinForOneSide) {
                            aS2 = aSMinForOneSide;
                        }

                        return new double[]{aS1, aS2};
                    }

                } else {
                    aS2 = (nEd * eS1 - etaConcrete * fCd * bDimension * lambdaConcrete * xVar * (dDimension - 0.5 * lambdaConcrete * xVar)) / (fYd * (dDimension - a2));

                    if (aS2 < aSMinForOneSide) {
                        aS2 = aSMinForOneSide;
                    }

                    return new double[]{aS1, aS2};
                }

            } else {
                if (aS1 < aSMinForOneSide) {
                    aS1 = aSMinForOneSide;
                }
                if (aS2 < aSMinForOneSide) {
                    aS2 = aSMinForOneSide;
                }

                return new double[]{aS1, aS2};
            }
        }
    }
}

package pl.pawz.zelbet.ULS;

import pl.pawz.zelbet.BasicValues;
import pl.pawz.zelbet.BasicValuesPillars;
import pl.pawz.zelbet.PolynomialSolverKNG;

public class FourForcesLimit {
    double fYd;
    double aS1;
    double aS2;
    double fCd;
    double bDimension;
    double etaConcrete;
    double lambdaConcrete;
    double xMinMinusYd;
    double hDimension;
    double a1;
    double a2;
    double epsilonCu3;
    double xLim;
    double x0;
    double xMinYd;
    double xMaxYd;
    double epsilonC3;
    int eS;

    public FourForcesLimit(double fYk, double aS1, double aS2, double bDimension, float hDimension, double fCk, float a1, float a2) {

        this.aS1 = aS1;
        this.aS2 = aS2;
        this.fYd = BasicValues.fYdValue(fYk);
        this.bDimension = bDimension;
        this.fCd = BasicValues.fCdValue(fCk);

        this.a1 = a1;
        this.a2 = a2;
        this.hDimension = hDimension;

        this.eS = BasicValues.steelE();
        this.epsilonCu3 = BasicValues.epsilonCu3Value(fCk);
        this.epsilonC3 = BasicValues.epsilonC3Value(fCk);

        this.etaConcrete = BasicValues.etaConcreteValue(fCk);
        this.lambdaConcrete = BasicValues.lambdaConcreteValue(fCk);

        this.xLim = BasicValuesPillars.xLimVar(epsilonCu3, hDimension, a1, fYd, eS);
        this.xMinYd = BasicValuesPillars.xMinYdVar(epsilonCu3, a2, fYd, eS);
        this.x0 = BasicValuesPillars.x0Var(epsilonCu3, epsilonC3, hDimension);
        this.xMaxYd = BasicValuesPillars.xYdMaxVar(epsilonCu3, epsilonC3, fYd, eS, hDimension, a2);
        this.xMinMinusYd = BasicValuesPillars.xMinMinusYdVar(epsilonCu3, a2, fYd, eS);

    }

    public double[] firstCase() {
        double sigmaS1 = fYd;
        double sigmaS2 = -fYd;

        //limit values of N in this case

        double n0 = -fYd * (aS1 + aS2);
        double n1 = -fYd * (aS1 + aS2) + etaConcrete * fCd * bDimension * lambdaConcrete * xMinMinusYd;

        double x0 = (n0 + fYd * (aS1 + aS2)) / (etaConcrete * fCd * bDimension * lambdaConcrete);
        double x1 = (n1 + fYd * (aS1 + aS2)) / (etaConcrete * fCd * bDimension * lambdaConcrete);

        double res1 = momentFrom0To1(x0);
        double res2 = momentFrom0To1(x1);

        return new double[]{res1, res2, n0, n1};
    }

    private double momentFrom0To1(double x) {
        return fYd * aS1 * (0.5 * hDimension - a1) - fYd * aS2 * (0.5 * hDimension - a2) + etaConcrete * fCd *
                bDimension * lambdaConcrete * x * 0.5 * (hDimension - lambdaConcrete * x);
    }

    public double[] secondCase() {
        double sigmaS1 = fYd;
        double sigmaS2First = epsilonCu3 * (xMinMinusYd - a2) / xMinMinusYd;
        double sigmaS2Second = epsilonCu3 * (xMinYd - a2) / xMinYd;

        double n1 = -fYd * (aS1 + aS2) + etaConcrete * fCd * bDimension * lambdaConcrete * xMinMinusYd;
        double n2 = fYd * (aS2 - aS1) + etaConcrete * fCd * bDimension * lambdaConcrete * xMinYd;

        double x1 = PolynomialSolverKNG.solverPhaseII(n1, fYd, aS1, epsilonCu3, eS, aS2, etaConcrete, fCd, bDimension, lambdaConcrete, a2);
        double x2 = PolynomialSolverKNG.solverPhaseII(n2, fYd, aS1, epsilonCu3, eS, aS2, etaConcrete, fCd, bDimension, lambdaConcrete, a2);


        double res1 = fYd * aS1 * (0.5 * hDimension - a1) + sigmaS2First * aS2 * (0.5 * hDimension - a2) + etaConcrete * fCd * bDimension * lambdaConcrete * x1 * 0.5 * (hDimension - lambdaConcrete * x1);
        double res2 = fYd * aS1 * (0.5 * hDimension - a1) + sigmaS2Second * aS2 * (0.5 * hDimension - a2) + etaConcrete * fCd * bDimension * lambdaConcrete * x2 * 0.5 * (hDimension - lambdaConcrete * x2);

        return new double[]{res1, res2, n1, n2};
    }

}

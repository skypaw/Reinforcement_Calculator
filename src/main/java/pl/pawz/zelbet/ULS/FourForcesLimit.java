package pl.pawz.zelbet.ULS;

import pl.pawz.zelbet.BasicValues;
import pl.pawz.zelbet.BasicValuesPillars;
import pl.pawz.zelbet.PolynomialSolverKNG;

public class FourForcesLimit {
    private double fYd;
    private double aS1;
    private double aS2;
    private double fCd;
    private double bDimension;
    private double etaConcrete;
    private double lambdaConcrete;
    private double xMinMinusYd;
    private double hDimension;
    private double a1;
    private double a2;
    private double epsilonCu3;
    private double xLim;
    private double x0;
    private double xMinYd;
    private double xMaxYd;
    private double epsilonC3;
    private int eS;
    private double dDimension;

    public FourForcesLimit(double fYk, double aS1, double aS2, double bDimension, float hDimension, double fCk, float a1, float a2) {

        this.aS1 = aS1;
        this.aS2 = aS2;
        this.fYd = BasicValues.fYdValue(fYk);
        this.bDimension = bDimension;
        this.fCd = BasicValues.fCdValue(fCk);

        this.a1 = a1;
        this.a2 = a2;
        this.hDimension = hDimension;
        this.dDimension = BasicValues.dValue(hDimension, a1);

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


    private double[] firstCase(double x) {
        double sigmaS1 = fYd;
        double sigmaS2 = -fYd;

        double n = -fYd * aS1 - fYd * aS2 + etaConcrete * fCd * bDimension * lambdaConcrete * x;

        double m = sigmaS1 * aS1 * (0.5 * hDimension - a1) + sigmaS2 * aS2 * (0.5 * hDimension - a2) + etaConcrete * fCd *
                bDimension * lambdaConcrete * x * 0.5 * (hDimension - lambdaConcrete * x);

        double nReturn = n;

        n = n + 0.1;
        x = (n + fYd * (aS1 + aS2)) / (etaConcrete * fCd * bDimension * lambdaConcrete);

        return new double[]{nReturn, m, x};
    }


    public double[] secondCase(double x, double interval) {
        double sigmaS1 = fYd;
        double sigmaS2 = Math.max(Math.min(epsilonCu3 * (x - a2) / x * eS, fYd), -fYd);

        double n = -fYd * aS1 + epsilonCu3 * (x - a2) / x * eS * aS2 + etaConcrete * fCd * bDimension * lambdaConcrete * x;

        double m = sigmaS1 * aS1 * (0.5 * hDimension - a1) + sigmaS2 * aS2 * (0.5 * hDimension - a2) + etaConcrete * fCd * bDimension * lambdaConcrete * x * 0.5 * (hDimension - lambdaConcrete * x);

        double nReturn = n;

        n = n + interval;
        x = PolynomialSolverKNG.solverPhaseII(n, fYd, aS1, epsilonCu3, eS, aS2, etaConcrete, fCd, bDimension, lambdaConcrete, a2);

        return new double[]{nReturn, m, x};
    }

    private double[] thirdCase(double x) {
        double sigmaS1 = fYd;
        double sigmaS2 = fYd;

        double n = fYd * (aS2 - aS1) + etaConcrete * fCd * bDimension * lambdaConcrete * x;

        double m = sigmaS1 * aS1 * (0.5 * hDimension - a1) + sigmaS2 * aS2 * (0.5 * hDimension - a2) + etaConcrete * fCd * bDimension * lambdaConcrete * x * 0.5 * (hDimension - lambdaConcrete * x);

        double nReturn = n;

        n = n + 0.1;
        x = (n + fYd * (aS1 - aS2)) / (etaConcrete * fCd * bDimension * lambdaConcrete);


        return new double[]{nReturn, m, x};
    }

    public double[] fourthCase(double x, double interval) {
        double sigmaS1 = Math.max(Math.min(fYd, epsilonCu3 * (dDimension - x) / x * eS), -fYd);
        double sigmaS2 = fYd;

        double n = -epsilonCu3 * (dDimension - x) / x * eS * aS1 + fYd * aS2 + etaConcrete * fCd * bDimension * lambdaConcrete * x;
        double m = sigmaS1 * aS1 * (0.5 * hDimension - a1) + sigmaS2 * aS2 * (0.5 * hDimension - a2) + etaConcrete * fCd * bDimension * lambdaConcrete * x * 0.5 * (hDimension - lambdaConcrete * x);

        double nReturn = n;

        n = n + interval;
        x = PolynomialSolverKNG.solverPhaseIV(n, fYd, aS1, epsilonCu3, eS, aS2, etaConcrete, fCd, bDimension, lambdaConcrete, dDimension, xLim);

        return new double[]{nReturn, m, x};
    }

    public double[] fifthCase(double x, double interval) {
        double sigmaS1 = Math.max(epsilonC3 * (dDimension - x) / (x - x0) * eS, -fYd);
        double sigmaS2 = fYd;

        double n = -epsilonC3 * (dDimension - x) / (x - x0) * eS * aS1 + fYd * aS2 + etaConcrete * fCd * bDimension * lambdaConcrete * x;

        double m = sigmaS1 * aS1 * (0.5 * hDimension - a1) + sigmaS2 * aS2 * (0.5 * hDimension - a2) + etaConcrete * fCd * bDimension * lambdaConcrete * x * 0.5 * (hDimension - lambdaConcrete * x);

        double nReturn = n;

        n = n + interval;
        x = PolynomialSolverKNG.solverPhaseV(n, fYd, aS1, epsilonC3, eS, aS2, etaConcrete, fCd, bDimension, lambdaConcrete, dDimension, x0);

        return new double[]{nReturn, m, x};
    }

    private double[] sixthCase(double x) {
        double sigmaS1 = Math.max(epsilonC3 * (dDimension - x) / (x - x0) * eS, -fYd);
        double sigmaS2 = fYd;

        double n = -epsilonC3 * (dDimension - x) / (x - x0) * eS * aS1 + fYd * aS2 + etaConcrete * fCd * bDimension * hDimension;

        double m = sigmaS1 * aS1 * (0.5 * hDimension - a1) + sigmaS2 * aS2 * (0.5 * hDimension - a2);

        return new double[]{n, m, x};
    }

    private double[] seventhCase(double x) {
        double sigmaS1 = Math.max(epsilonC3 * (dDimension - x) / (x - x0) * eS, -fYd);
        double sigmaS2 = Math.min(epsilonC3 * (x - a2) / (x - x0) * eS, fYd);

        double n = -epsilonC3 * (dDimension - x) / (x - x0) * eS * aS1 + epsilonC3 * (x - a2) / (x - x0) * eS * aS2 + etaConcrete * fCd * bDimension * hDimension;

        double m = sigmaS1 * aS1 * (0.5 * hDimension - a1) + sigmaS2 * aS2 * (0.5 * hDimension - a2);

        return new double[]{n, m, x};
    }

    // Limit Values for graph

    public double[] limitFirst() {
        double[] results = firstCase(0);
        double n = results[0];
        double m = results[1];

        return new double[]{n, m};
    }

    public double[] limitSecond() {
        double[] results = firstCase(xMinMinusYd);
        double n = results[0];
        double m = results[1];

        return new double[]{n, m};
    }

    public double[] limitThird() {
        double[] results = secondCase(xMinYd, 0.1);
        double n = results[0];
        double m = results[1];

        return new double[]{n, m};
    }

    public double[] limitFourth() {
        double[] results = thirdCase(xLim);
        double n = results[0];
        double m = results[1];

        return new double[]{n, m};
    }

    public double[] limitFifth() {
        double[] results = fourthCase(hDimension, 0.1);
        double n = results[0];
        double m = results[1];

        return new double[]{n, m};
    }

    public double[] limitSixth() {
        double[] results = fifthCase(hDimension / lambdaConcrete, 0.1);
        double n = results[0];
        double m = results[1];

        return new double[]{n, m};
    }

    public double[] limitSeventh() {
        double[] results = sixthCase(xMaxYd);
        double n = results[0];
        double m = results[1];

        return new double[]{n, m};
    }

    public double[] limitEighth() {
        double[] results = seventhCase(Integer.MAX_VALUE);
        double n = results[0];
        double m = results[1];

        return new double[]{n, m};
    }


}

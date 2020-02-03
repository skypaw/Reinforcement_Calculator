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
    double dDimension;

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
        double sigmaS2First = epsilonCu3 * (xMinMinusYd - a2) / xMinMinusYd * eS;
        double sigmaS2Second = epsilonCu3 * (xMinYd - a2) / xMinYd * eS;

        double n1 = -fYd * (aS1 + aS2) + etaConcrete * fCd * bDimension * lambdaConcrete * xMinMinusYd;
        double n2 = fYd * (aS2 - aS1) + etaConcrete * fCd * bDimension * lambdaConcrete * xMinYd;

        double x1 = PolynomialSolverKNG.solverPhaseII(n1, fYd, aS1, epsilonCu3, eS, aS2, etaConcrete, fCd, bDimension, lambdaConcrete, a2);
        double x2 = PolynomialSolverKNG.solverPhaseII(n2, fYd, aS1, epsilonCu3, eS, aS2, etaConcrete, fCd, bDimension, lambdaConcrete, a2);


        double res1 = fYd * aS1 * (0.5 * hDimension - a1) + sigmaS2First * aS2 * (0.5 * hDimension - a2) + etaConcrete * fCd * bDimension * lambdaConcrete * x1 * 0.5 * (hDimension - lambdaConcrete * x1);
        double res2 = fYd * aS1 * (0.5 * hDimension - a1) + sigmaS2Second * aS2 * (0.5 * hDimension - a2) + etaConcrete * fCd * bDimension * lambdaConcrete * x2 * 0.5 * (hDimension - lambdaConcrete * x2);

        return new double[]{res1, res2, n1, n2};
    }

    public double[] thirdCase() {
        double sigmaS1 = fYd;
        double sigmaS2 = fYd;

        double n2 = fYd * (aS2 - aS1) + etaConcrete * fCd * bDimension * lambdaConcrete * xMinYd;
        double n3 = fYd * (aS2 - aS1) + etaConcrete * fCd * bDimension * lambdaConcrete * xLim;

        double x2 = (n2 + fYd * (aS1 - aS2)) / (etaConcrete * fCd * bDimension * lambdaConcrete);
        double x3 = (n3 + fYd * (aS1 - aS2)) / (etaConcrete * fCd * bDimension * lambdaConcrete);

        double res2 = fYd * aS1 * (0.5 * hDimension - a1) + fYd * aS2 * (0.5 * hDimension - a2) + etaConcrete * fCd * bDimension * lambdaConcrete * x2 * 0.5 * (hDimension - lambdaConcrete * x2);
        double res3 = fYd * aS1 * (0.5 * hDimension - a1) + fYd * aS2 * (0.5 * hDimension - a2) + etaConcrete * fCd * bDimension * lambdaConcrete * x3 * 0.5 * (hDimension - lambdaConcrete * x3);

        return new double[]{res2, res3, n2, n3};
    }

    public double[] fourthCase() {
        double sigmaS1One = Math.min(fYd, epsilonCu3 * (dDimension - xLim) / xLim * eS);
        double sigmaS1Two = Math.min(fYd, epsilonCu3 * (dDimension - hDimension) / hDimension * eS);
        double sigmaS2 = fYd;

        double n3 = fYd * (aS2 - aS1) + etaConcrete * fCd * bDimension * lambdaConcrete * xLim;
        double n4 = -epsilonCu3 * (dDimension - hDimension) / hDimension * eS * aS1 + fYd * aS2 + etaConcrete * fCd * bDimension * lambdaConcrete * hDimension;

        double x3 = PolynomialSolverKNG.solverPhaseIV(n3, fYd, aS1, epsilonCu3, eS, aS2, etaConcrete, fCd, bDimension, lambdaConcrete, dDimension);
        double x4 = PolynomialSolverKNG.solverPhaseIV(n4, fYd, aS1, epsilonCu3, eS, aS2, etaConcrete, fCd, bDimension, lambdaConcrete, dDimension);

        double res3 = sigmaS1One * aS1 * (0.5 * hDimension - a1) + fYd * aS2 * (0.5 * hDimension - a2) + etaConcrete * fCd * bDimension * lambdaConcrete * x3 * 0.5 * (hDimension - lambdaConcrete * x3);
        double res4 = sigmaS1Two * aS1 * (0.5 * hDimension - a1) + fYd * aS2 * (0.5 * hDimension - a2) + etaConcrete * fCd * bDimension * lambdaConcrete * x4 * 0.5 * (hDimension - lambdaConcrete * x4);


        return new double[]{res3, res4, n3, n4};
    }

    public double[] fifthCase() {
        double sigmaS1One = Math.max(epsilonC3 * (dDimension - hDimension) / (hDimension - x0) * eS, -fYd);
        double sigmaS1Two = Math.max(epsilonC3 * (dDimension - (hDimension / lambdaConcrete)) / ((hDimension / lambdaConcrete) - x0) * eS, -fYd);

        double sigmaS2 = fYd;

        double n4 = -epsilonCu3 * (dDimension - hDimension) / hDimension * eS * aS1 + fYd * aS2 + etaConcrete * fCd * bDimension * lambdaConcrete * hDimension;
        double n5 = -epsilonCu3 * (dDimension - hDimension / lambdaConcrete) / (hDimension / lambdaConcrete - x0) * eS * aS1 + fYd * aS2 + etaConcrete * fCd * bDimension * lambdaConcrete * hDimension;

        double x4 = PolynomialSolverKNG.solverPhaseV(n4, fYd, aS1, epsilonC3, eS, aS2, etaConcrete, fCd, bDimension, lambdaConcrete, dDimension, x0);
        double x5 = PolynomialSolverKNG.solverPhaseV(n5, fYd, aS1, epsilonC3, eS, aS2, etaConcrete, fCd, bDimension, lambdaConcrete, dDimension, x0);

        double res4 = sigmaS1One * aS1 * (0.5 * hDimension - a1) + fYd * aS2 * (0.5 * hDimension - a2) + etaConcrete * fCd * bDimension * lambdaConcrete * x4 * 0.5 * (hDimension - lambdaConcrete * x4);
        double res5 = sigmaS1Two * aS1 * (0.5 * hDimension - a1) + fYd * aS2 * (0.5 * hDimension - a2) + etaConcrete * fCd * bDimension * lambdaConcrete * x5 * 0.5 * (hDimension - lambdaConcrete * x5);

        return new double[]{res4, res5, n4, n5};
    }

    public double[] sixthCase() {
        double sigmaS1One = Math.max(epsilonC3 * (dDimension - hDimension / lambdaConcrete) / (hDimension / lambdaConcrete - x0) * eS, -fYd);
        double sigmaS1Two = Math.max(epsilonC3 * (dDimension - xMaxYd) / (xMaxYd - x0) * eS, -fYd);
        double sigmaS2 = fYd;

        double n5 = -epsilonC3 * (dDimension - hDimension / lambdaConcrete) / (hDimension / lambdaConcrete - x0) * eS * aS1 + fYd * aS2 + etaConcrete * fCd * bDimension * hDimension;
        double n6 = -epsilonC3 * (dDimension - xMaxYd) / (xMaxYd - x0) * eS * aS1 + fYd * aS2 + etaConcrete * fCd * bDimension * hDimension;

        double x5 = (epsilonC3 * eS * aS1 * dDimension + x0 * (-n5 + fYd * aS2 + etaConcrete * fCd * bDimension * hDimension)) / (epsilonC3 * eS * aS1 - n5 + fYd * aS2 + etaConcrete * fCd * bDimension * hDimension);
        double x6 = (epsilonC3 * eS * aS1 * dDimension + x0 * (-n6 + fYd * aS2 + etaConcrete * fCd * bDimension * hDimension)) / (epsilonC3 * eS * aS1 - n6 + fYd * aS2 + etaConcrete * fCd * bDimension * hDimension);

        double res5 = sigmaS1One * aS1 * (0.5 * hDimension - a1) + fYd * aS2 * (0.5 * hDimension - a2);
        double res6 = sigmaS1Two * aS1 * (0.5 * hDimension - a1) + fYd * aS2 * (0.5 * hDimension - a2);

        return new double[]{res5, res6, n5, n6};
    }

    public double[] seventhCase() {
        double sigmaS1One = Math.max(epsilonC3 * (dDimension - xMaxYd) / (xMaxYd - x0) * eS, -fYd);
        double sigmaS1Two = Math.max(epsilonC3 * (dDimension - Double.MAX_VALUE) / (Double.MAX_VALUE - x0) * eS, -fYd);

        double sigmaS2One = Math.min(epsilonC3 * (xMaxYd - a2) / (xMaxYd - x0) * eS, fYd);
        double sigmaS2Two = Math.min(epsilonC3 * (Double.MAX_VALUE - a2) / (Double.MAX_VALUE - x0) * eS, fYd);

        double n6 = -epsilonC3 * (dDimension - xMaxYd) / (xMaxYd - x0) * eS * aS1 + fYd * aS2 + etaConcrete * fCd * bDimension * hDimension;
        double n7 = epsilonC3 * eS * (aS1 + aS2) + etaConcrete * fCd * bDimension * hDimension;

        double res6 = sigmaS1One * aS1 * (0.5 * hDimension - a1) + sigmaS2One * aS2 * (0.5 * hDimension - a2);
        double res7 = sigmaS1Two * aS1 * (0.5 * hDimension - a1) + sigmaS2Two * aS2 * (0.5 * hDimension - a2);

        return new double[]{res6, res7, n6, n7};
    }
}

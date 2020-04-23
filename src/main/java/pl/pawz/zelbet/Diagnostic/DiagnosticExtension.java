package pl.pawz.zelbet.Diagnostic;

import pl.pawz.zelbet.BasicValues;
import pl.pawz.zelbet.BasicValuesPillars;
import pl.pawz.zelbet.PolynomialSolver;

public class DiagnosticExtension {
    private double nEd;
    private double epsilonCu3;
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
    private double xMinusMinYd;
    private double xMinYd;
    private double eS1;
    private double eS2;
    private double sigmaS1;
    private double sigmaS2;
    private double xVar;
    private double aS1;
    private double aS2;


    public DiagnosticExtension(double nEd, double mEd, double fCk, double fYk, double bDimension,
                               double hDimension, double a1, double a2, double aS1, double aS2) {
        this.nEd = nEd;
        this.fCd = BasicValues.fCdValue(fCk);
        this.epsilonCu3 = BasicValues.epsilonCu3Value(fCk);
        this.lambdaConcrete = BasicValues.lambdaConcreteValue(fCk);
        this.etaConcrete = BasicValues.etaConcreteValue(fCk);
        this.fYd = BasicValues.fYdValue(fYk);
        this.E_S = BasicValues.steelE();
        this.dDimension = BasicValues.dValue(hDimension, a1);
        this.bDimension = bDimension;
        this.hDimension = hDimension;
        this.a1 = a1;
        this.a2 = a2;

        this.xMinusMinYd = BasicValuesPillars.xMinMinusYdVar(epsilonCu3, a2, fYd, E_S);
        this.xMinYd = BasicValuesPillars.xMinYdVar(epsilonCu3, a2, fYd, E_S);

        this.aS1 = aS1;
        this.aS2 = aS2;

        double eMin = (aS1 * (0.5 * hDimension - a1) - aS2 * (0.5 * hDimension - a2)) / (aS1 + aS2);
        double e = BasicValuesPillars.eccentricityExtension(mEd, nEd, hDimension, a1, a2)[2];

        if (e < eMin) {
            this.aS1 = aS2;
            this.aS2 = aS1;
        }


        this.eS1 = BasicValuesPillars.eccentricityExtension(mEd, nEd, hDimension, a1, a2)[0];
        this.eS2 = BasicValuesPillars.eccentricityExtension(mEd, nEd, hDimension, a1, a2)[1];

        xVar = 1 / lambdaConcrete * ((eS2 + a2) - Math.sqrt(Math.pow(eS2 + a2, 2) - (2 * fYd * (aS1 * eS1 - aS2 * eS2)) / (etaConcrete * fCd * bDimension)));
    }

    private void xSmallerThanXMinYd() {
        double aVar = -2 * (eS2 + a2) / lambdaConcrete;
        double bVar = 2 * (aS1 * fYd * eS1 - aS2 * epsilonCu3 * E_S * eS2) / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);
        double cVar = 2 * aS2 * epsilonCu3 * E_S * eS2 * a2 / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);

        xVar = PolynomialSolver.solver(1, aVar, bVar, cVar, 0); //todo To check changed value form xLim
    }

    private void xSmallerThanXMinMinusYd() {
        xVar = 1 / lambdaConcrete * ((eS2 + a2) - Math.sqrt(Math.pow(eS2 + a2, 2) - (2 * fYd * (aS1 * eS1 + aS2 * eS2)) / (etaConcrete * fCd * bDimension)));
    }

    private void xGreaterThanZero() {
        sigmaS1 = Math.min(epsilonCu3 * (dDimension - xVar) / xVar * E_S, fYd);

        sigmaS2 = epsilonCu3 * (xVar - a2) / xVar * E_S;
        if (sigmaS2 > fYd) {
            sigmaS2 = fYd;
        }
        if (sigmaS2 < -fYd) {
            sigmaS2 = -fYd;
        }
    }

    private void xSmallerThanZero() {
        xVar = 0;
        sigmaS1 = fYd;
        sigmaS2 = -fYd;
    }

    public double[] resultsDiagnosticExtension() {

        if (xVar <= xMinYd) {
            xSmallerThanXMinYd();
            if (xVar < xMinusMinYd) {
                xSmallerThanXMinMinusYd();
            }
        }
        if (xVar > 0) {
            xGreaterThanZero();
        } else {
            xSmallerThanZero();
        }


        double nRd = -etaConcrete * fCd * bDimension * lambdaConcrete * xVar + sigmaS1 * aS1 - sigmaS2 * aS2;
        double mRd = etaConcrete * fCd * bDimension * lambdaConcrete * xVar * (dDimension - 0.5 * lambdaConcrete * xVar) + sigmaS2 * aS2 * (dDimension - a2) + nEd * (0.5 * hDimension - a1);

        return new double[]{nRd, mRd};
    }
}

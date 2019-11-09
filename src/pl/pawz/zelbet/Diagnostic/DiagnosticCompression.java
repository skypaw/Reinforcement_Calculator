package pl.pawz.zelbet.Diagnostic;

import pl.pawz.zelbet.BasicValuesPillars;
import pl.pawz.zelbet.PolynomialSolver;

public class DiagnosticCompression {
    private float nEd;
    private float mEd;
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
    private double aS1;
    private double aS2;
    private double e;
    private double x;
    private double sigmaS1;
    private double sigmaS2;


    public DiagnosticCompression(float nEd, float mEd, double epsilonCu3, double epsilonC3, double fCd, double fYd,
                                 double etaConcrete, double lambdaConcrete, double dDimension, float bDimension,
                                 float hDimension, float a1, float a2, int E_S, double xLim, double xMinusMinYd,
                                 double xMinYd, double x0, double xMaxYd, double aS1, double aS2) {
        this.nEd = nEd;
        this.mEd = mEd;
        this.epsilonCu3 = epsilonCu3;
        this.epsilonC3 = epsilonC3;
        this.fCd = fCd;
        this.fYd = fYd;
        this.etaConcrete = etaConcrete;
        this.lambdaConcrete = lambdaConcrete;
        this.dDimension = dDimension;
        this.bDimension = bDimension;
        this.hDimension = hDimension;
        this.a1 = a1;
        this.a2 = a2;
        this.E_S = E_S;
        this.xLim = xLim;
        this.xMinusMinYd = xMinusMinYd;
        this.xMinYd = xMinYd;
        this.x0 = x0;
        this.xMaxYd = xMaxYd;
        this.aS1 = aS1;
        this.aS2 = aS2;


        BasicValuesPillars eccentricity = new BasicValuesPillars(hDimension, a1, a2, epsilonCu3, epsilonC3, fYd, E_S, mEd, nEd);


        double eMin = (epsilonC3 * E_S * (aS2 * (0.5 * hDimension - a2) - aS1 * (0.5 * hDimension - a1))) / (etaConcrete * fCd * bDimension * hDimension + epsilonC3 * E_S * (aS1 + aS2));
        e = eccentricity.eccentricityCompression()[2];

        if (e < eMin) {
            double aS1Prim = aS2;
            double aS2Prim = aS1;
            this.aS1 = aS1Prim;
            this.aS2 = aS2Prim;
        }


        eS1 = eccentricity.eccentricityCompression()[0];
        eS2 = eccentricity.eccentricityCompression()[1];


    }

    private void xVar() {
        x = 1 / lambdaConcrete * (-(eS2 - a2) + Math.sqrt(Math.pow(eS2 - a2, 2) + (2 * fYd * (aS1 * eS1 - aS2 * eS2)) / (etaConcrete * fCd * bDimension)));
    }

    private void xGreaterThanXLim() {
        double aVar = 2 * (eS2 - a2) / lambdaConcrete;
        double bVar = 2 * (fYd * aS2 * eS2 + epsilonCu3 * E_S * aS1 * eS1) / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);
        double cVar = -2 * epsilonCu3 * E_S * aS1 * eS1 * dDimension / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);

        x = PolynomialSolver.solver(1, aVar, bVar, cVar, xLim);
    }

    private void xGreaterThanH() {
        double aVar = -x0 + 2 * (eS2 - a2) / lambdaConcrete;
        double bVar = 2 * ((fYd * aS2 * eS2 + epsilonC3 * E_S * aS1 * eS1) / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension) - (eS2 - a2) / lambdaConcrete * x0);
        double cVar = -2 * (fYd * aS2 * eS2 * x0 + epsilonC3 * E_S * aS1 * eS1 * dDimension) / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);

        x = PolynomialSolver.solver(1, aVar, bVar, cVar, hDimension);
    }

    private void xGreaterThanHByLambda() {
        x = (etaConcrete * fCd * bDimension * hDimension * e * x0 + epsilonC3 * E_S * (aS1 * eS1 * dDimension + aS2 * eS2 * a2)) / (etaConcrete * fCd * bDimension * hDimension * e + epsilonC3 * E_S * (aS1 * eS1 + aS2 * eS2));
    }

    private void xSmallerThanXMaxYd() {
        x = ((etaConcrete * fCd * bDimension * hDimension * e + fYd * eS2 * aS2) * x0 + epsilonC3 * E_S * aS1 * eS1 * dDimension) / (etaConcrete * fCd * bDimension * hDimension * e + fYd * aS2 * eS2 + epsilonC3 * E_S * aS1 * eS1);
    }

    private void xSmallerThanXMinYd() {
        double aVar = 2 * (eS2 - a2) / lambdaConcrete;
        double bVar = -2 * (fYd * aS1 * eS1 - epsilonCu3 * E_S * aS2 * eS2) / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);
        double cVar = -2 * epsilonCu3 * E_S * aS2 * eS2 * a2 / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);

        x = PolynomialSolver.solver(1, aVar, bVar, cVar, hDimension);
    }

    private void xSmallerThanXMinMinusYd() {
        x = 1 / lambdaConcrete * (-(eS2 - a2) + Math.sqrt(Math.pow(eS2 - a2, 2) + (2 * fYd * (aS1 * eS1 + aS2 * eS2)) / (etaConcrete * fCd * bDimension)));
    }

    private void sigmaSmallEccentricity() {
        sigmaS1 = Math.max(epsilonC3 * (dDimension - x) / (x - x0) * E_S, -fYd);
        sigmaS2 = Math.min(epsilonC3 * (x - a2) / (x - x0) * E_S, fYd);
    }

    private void sigmaGreatEccentricity() {
        sigmaS1 = Math.min(epsilonCu3 * (dDimension - x) / x * E_S, fYd);
        sigmaS2 = epsilonCu3 * (x - a2) / x * E_S;
        if (sigmaS2 > fYd) {
            sigmaS2 = fYd;
        }
        if (sigmaS2 < -fYd) {
            sigmaS2 = -fYd;
        }
    }

    public double[] resultsDiagnosticCompression() {

        xVar();

        if (x <= xLim) {
            if (x < xMinYd) {
                xSmallerThanXMinYd();
                if (x <= xMinusMinYd) {
                    xSmallerThanXMinMinusYd();
                }
            }
            sigmaGreatEccentricity();
        } else {
            xGreaterThanXLim();
            if (x > hDimension) {
                xGreaterThanH();
                if (x > hDimension / lambdaConcrete) {
                    xGreaterThanHByLambda();
                    if (x <= xMaxYd) {
                        xSmallerThanXMaxYd();
                    }
                } else {
                    sigmaSmallEccentricity();
                }
            }
            sigmaSmallEccentricity();

            if (x > hDimension / lambdaConcrete) {
                x = hDimension / lambdaConcrete;
            }
        }


        double nRd = etaConcrete * fCd * bDimension * lambdaConcrete * x - sigmaS1 * aS1 + sigmaS2 * aS2;
        double mRd = etaConcrete * fCd * bDimension * lambdaConcrete * x * (dDimension - 0.5 * lambdaConcrete * x) + sigmaS2 * aS2 * (dDimension - a2) - nEd * (0.5 * hDimension - a1);

        return new double[]{nRd, mRd};
    }

}

package pl.pawz.zelbet.Diagnostic;

import pl.pawz.zelbet.BasicValues;
import pl.pawz.zelbet.BasicValuesPillars;
import pl.pawz.zelbet.PolynomialSolver;

public class DiagnosticCompression {
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
    private double aS1;
    private double aS2;
    private double e;
    private double x;
    private double sigmaS1;
    private double sigmaS2;


    public DiagnosticCompression(float nEd, float mEd, double fCk, double fYk,
                                 float bDimension, float hDimension, float a1, float a2, double aS1, double aS2) {
        this.nEd = nEd;
        this.fCd = BasicValues.fCdValue(fCk);
        this.epsilonCu3 = BasicValues.epsilonCu3Value(fCk);
        this.epsilonC3 = BasicValues.epsilonC3Value(fCk);
        this.lambdaConcrete = BasicValues.lambdaConcreteValue(fCk);
        this.etaConcrete = BasicValues.etaConcreteValue(fCk);
        this.fYd = BasicValues.fYdValue(fYk);
        this.E_S = BasicValues.steelE();
        this.dDimension = BasicValues.dValue(hDimension, a1);
        this.bDimension = bDimension;
        this.hDimension = hDimension;
        this.a1 = a1;
        this.a2 = a2;

        this.xLim = BasicValuesPillars.xLimVar(epsilonCu3, hDimension, a1, fYd, E_S);
        this.xMinusMinYd = BasicValuesPillars.xMinMinusYdVar(epsilonCu3, a2, fYd, E_S);
        this.xMinYd = BasicValuesPillars.xMinYdVar(epsilonCu3, a2, fYd, E_S);
        this.x0 = BasicValuesPillars.x0Var(epsilonCu3, epsilonC3, hDimension);
        this.xMaxYd = BasicValuesPillars.xYdMaxVar(epsilonCu3, epsilonC3, fYd, E_S, hDimension, a2);
        this.aS1 = aS1;
        this.aS2 = aS2;

        this.e = BasicValuesPillars.eccentricityBasic(mEd, nEd);



    }

    private void minEccentricity(){
        double eMin = (epsilonC3 * E_S * (aS2 * (0.5 * hDimension - a2) - aS1 * (0.5 * hDimension - a1))) / (etaConcrete * fCd * bDimension * hDimension + epsilonC3 * E_S * (aS1 + aS2));

        if (e < eMin) {
            this.aS1 = aS2; //todo to check this
            this.aS2 = aS1;
        }
    }

    private void eccentricity() {
        eS1 = BasicValuesPillars.eccentricityCompression(e, hDimension, a1, a2)[0];
        eS2 = BasicValuesPillars.eccentricityCompression(e, hDimension, a1, a2)[1];
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

        x = PolynomialSolver.solver(1, aVar, bVar, cVar, 0);
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

        if (sigmaS2 >= fYd) {
            sigmaS2 = fYd;
        }
        if (sigmaS2 <= -fYd) {
            sigmaS2 = -fYd;
        }
    }

    public double[] resultsDiagnosticCompression() {
        eccentricity();
        minEccentricity();
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
                sigmaSmallEccentricity();
            } else {
                sigmaGreatEccentricity();
            }


            if (x > hDimension / lambdaConcrete) {
                x = hDimension / lambdaConcrete;
            }
        }

        double nRd = etaConcrete * fCd * bDimension * lambdaConcrete * x - sigmaS1 * aS1 + sigmaS2 * aS2;
        double mRd = etaConcrete * fCd * bDimension * lambdaConcrete * x * (dDimension - 0.5 * lambdaConcrete * x) + sigmaS2 * aS2 * (dDimension - a2) - nEd * (0.5 * hDimension - a1);

        if (mRd < 0) mRd = 0;

        return new double[]{nRd, mRd};
    }

    public void setE(double e) {
        this.e = e;
    }

    public void setAS1(double aS1){
        this.aS1 = aS1;
    }

    public void setAS2(double aS2){
        this.aS2 = aS2;
    }
}

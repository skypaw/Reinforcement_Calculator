package pl.pawz.zelbet.ULS;

import pl.pawz.zelbet.BasicValues;
import pl.pawz.zelbet.BasicValuesPillars;
import pl.pawz.zelbet.PolynomialSolver;

public class ExtensionSymmetricReinforcement {
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
    private double eS1;
    private double eS2;
    private double sigmaS1;
    private double sigmaS2;
    private double xVar;
    private double hDimension;

    public ExtensionSymmetricReinforcement(double nEd, double mEd, double fCk, double fYk, double bDimension,
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
        this.xMinusMinYd = BasicValuesPillars.xMinMinusYdVar(epsilonCu3,a2,fYd,E_S);
        this.sigmaS1 = fYd;
        this.hDimension = hDimension;

        this.eS1 = BasicValuesPillars.eccentricityExtension(mEd,nEd,hDimension,a1,a2)[0];
        this.eS2 = BasicValuesPillars.eccentricityExtension(mEd,nEd,hDimension,a1,a2)[1];


    }

    private void xStart() {
        double aVar = lambdaConcrete * (fYd - epsilonCu3 * E_S);
        double bVar = -2 * (fYd * dDimension - epsilonCu3 * E_S * a2 * (1 + 0.5 * lambdaConcrete));
        double cVar = 2 * ((nEd * (fYd * eS1 - epsilonCu3 * E_S * eS2)) / (lambdaConcrete * etaConcrete * fCd * bDimension) - epsilonCu3 * E_S * Math.pow(a2, 2));
        double dVar = 2 * nEd * epsilonCu3 * E_S * a2 * eS2 / (lambdaConcrete * etaConcrete * fCd * bDimension);

        xVar = PolynomialSolver.solver(aVar, bVar, cVar, dVar, 0);
    }

    private void xSmallerThanXMinMinusYd() {
        sigmaS2 = -fYd;
        xVar = 1 / (2 * lambdaConcrete) * ((dDimension + a2) - Math.sqrt(Math.pow(dDimension + a2, 2) - (4 * nEd * (eS1 + eS2)) / (etaConcrete * fCd * bDimension)));
    }

    private void xGreaterThanXMinMinusYd() {
        sigmaS2 = epsilonCu3 * (xVar - a2) / xVar * E_S;
    }

    private void xSmallerThan0() {
        xVar = 0;
    }

    public double[] resultsExtensionSymmetric() {

        xStart();
        if (xVar <= xMinusMinYd) {
            xSmallerThanXMinMinusYd();
            if (xVar <= 0) {
                xSmallerThan0();
            }
        } else {
            xGreaterThanXMinMinusYd();
        }

        double aS1 = (nEd * eS2 + etaConcrete * fCd * bDimension * lambdaConcrete * xVar * (0.5 * lambdaConcrete * xVar - a2)) / (sigmaS1 * (dDimension - a2));
        double aS2 = (nEd * eS1 - etaConcrete * fCd * bDimension * lambdaConcrete * xVar * (dDimension - 0.5 * lambdaConcrete * xVar)) / (sigmaS2 * (dDimension - a2));

        double aSMinForOneSide = Math.max(0.10 * nEd / fYd, (0.002 * bDimension * 100 * hDimension * 100) * Math.pow(10, -4)) / 2;

        if (aS1<aSMinForOneSide){
            aS1 = aSMinForOneSide;
        }
        if (aS2<aSMinForOneSide){
            aS2 = aSMinForOneSide;
        }


        return new double[]{aS1, aS2};
    }

}

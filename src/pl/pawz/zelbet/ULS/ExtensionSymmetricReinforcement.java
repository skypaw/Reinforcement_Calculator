package pl.pawz.zelbet.ULS;

import pl.pawz.zelbet.BasicValuesPillars;
import pl.pawz.zelbet.PolynomialSolver;

public class ExtensionSymmetricReinforcement {
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
    private double xMinusMinYd;

    private double eS1;
    private double eS2;
    private double sigmaS1;
    private double sigmaS2;
    private double xVar;


    public ExtensionSymmetricReinforcement(float nEd, float mEd, double epsilonCu3, double epsilonC3, double fCd, double fYd,
                                           double etaConcrete, double lambdaConcrete, double dDimension, float bDimension,
                                           float hDimension, float a1, float a2, int E_S, double xMinusMinYd) {
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
        this.xMinusMinYd = xMinusMinYd;
        this.sigmaS1 = fYd;
        this.sigmaS2 = fYd;


        BasicValuesPillars eccentricity = new BasicValuesPillars(hDimension, a1, a2, epsilonCu3, epsilonC3, fYd, E_S, mEd, nEd);

        this.eS1 = eccentricity.eccentricityExtension()[0];
        this.eS2 = eccentricity.eccentricityExtension()[1];


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
        xVar = 1 / (2 * lambdaConcrete) * ((dDimension - a2) - Math.sqrt(Math.pow(dDimension + a2, 2) - (4 * nEd * (eS1 + eS2)) / (etaConcrete * fCd * bDimension)));
    }

    private void xGreaterThanXMinMinusYd() {
        sigmaS2 = epsilonCu3 * (xVar - a2) / xVar * E_S;
    }

    private void xSmallerThan0() {
        xVar = 0;
    }

    public double[] resultsExtensionSymmetric() {

        xStart();
        if (xVar<=xMinusMinYd){
            xSmallerThanXMinMinusYd();
            if (xVar<=0){
                xSmallerThan0();
            }
        }else{
            xGreaterThanXMinMinusYd();
        }

        double aS1 = (nEd * eS2 + etaConcrete * fCd * bDimension * lambdaConcrete * xVar * (0.5 * lambdaConcrete * xVar - a2)) / (sigmaS1 * (dDimension - a2));
        double aS2 = (nEd * eS1 - etaConcrete * fCd * bDimension * lambdaConcrete * xVar * (dDimension - 0.5 * lambdaConcrete * xVar)) / (sigmaS2 * (dDimension - a2));

        return new double[]{aS1,aS2};
    }

}

package pl.pawz.zelbet.ULS;

import pl.pawz.zelbet.BasicValuesPillars;
import pl.pawz.zelbet.PolynomialSolver;

public class ExtensionAsymmetricReinforcement {
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
    private double xMinYd;
    private double xLim;
    private double eS1;
    private double eS2;
    private double sigmaS1;
    private double sigmaS2;
    private double xVar;
    private double aS2Min;
    private double aS1;
    private double aS2;


    public ExtensionAsymmetricReinforcement(float nEd, float mEd, double epsilonCu3, double epsilonC3, double fCd, double fYd,
                                            double etaConcrete, double lambdaConcrete, double dDimension, float bDimension,
                                            float hDimension, float a1, float a2, int E_S, double xMinusMinYd, double xLim, double xMinYd) {
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
        this.xLim = xLim;
        this.xMinYd = xMinYd;


        BasicValuesPillars eccentricity = new BasicValuesPillars(hDimension, a1, a2, epsilonCu3, epsilonC3, fYd, E_S, mEd, nEd);

        this.eS1 = eccentricity.eccentricityExtension()[0];
        this.eS2 = eccentricity.eccentricityExtension()[1];

        xVar = xLim;
        sigmaS2 = Math.min(epsilonCu3 * (xVar - a2) / xVar * E_S, fYd);

        this.aS2Min = Math.max(0.10 * nEd / fYd, (0.002 * bDimension * 100 * hDimension * 100) * Math.pow(10, -4)) / 2;
        aS2 = (nEd * eS1 - etaConcrete * fCd * bDimension * lambdaConcrete * xVar * (dDimension - 0.5 * lambdaConcrete * xVar)) / (sigmaS2 * (dDimension - a2));

    }

    private void aS2GreaterThanAS2Min() {
        aS1 = (sigmaS2 * aS2 + etaConcrete * fCd * bDimension * lambdaConcrete * xVar + nEd) / fYd;
    }

    private void aS2SmallerThanAS2Min() {
        aS2 = aS2Min;
        xVar = 1 / lambdaConcrete * (dDimension - Math.sqrt(Math.pow(dDimension, 2) - (2 * (nEd * eS1 - sigmaS2 * aS2 * (dDimension - a2))) / (etaConcrete * fCd * bDimension)));
    }

    private void xSmallerThanXMinYd() {
        double mS2 = epsilonCu3 * E_S * aS2Min * (dDimension - a2);

        double aVar = -2 * dDimension / lambdaConcrete;
        double bVar = 2 * (nEd * eS1 - mS2) / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);
        double cVar = 2 * a2 * mS2 / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);

        xVar = PolynomialSolver.solver(1, aVar, bVar, cVar, 0);
    }

    private void xGreaterThanXMinYd() {
        sigmaS2 = fYd;
    }

    private void xGreaterThanXMinMinusYd() {
        sigmaS2 = epsilonCu3 * (xVar - a2) / xVar * E_S;
    }

    private void xSmallerThanXMinMinusYd() {
        sigmaS2 = -fYd;
        xVar = 1 / lambdaConcrete * (dDimension - Math.sqrt(Math.pow(dDimension, 2) - (2 * (nEd * eS1 + fYd * aS2 * (dDimension - a2))) / (etaConcrete * fCd * bDimension)));
    }

    private void xGreaterThanZero() {
        aS1 = (sigmaS2 * aS2 + etaConcrete * fCd * bDimension * lambdaConcrete * xVar + nEd) / fYd;
    }

    private void xSmallerThanZero() {
        xVar = 0;
        aS1 = nEd * eS2 / (fYd * (dDimension - a2));
        aS2 = nEd * eS1 / (-fYd * (dDimension - a2));
    }

    public double[] resultsExtensionAsymmetric() {
        if (aS2 <= aS2Min) {
            aS2SmallerThanAS2Min();
            if (xVar <= xMinYd) {
                xSmallerThanXMinYd();
                if (xVar <= xMinusMinYd) {
                    xSmallerThanXMinMinusYd();
                    if (xVar <= 0) {
                        xSmallerThanZero();
                    } else {
                        xGreaterThanZero();
                    }
                } else {
                    xGreaterThanXMinMinusYd();
                    xGreaterThanZero();
                }
            } else {
                xGreaterThanXMinYd();
                xGreaterThanZero();
            }
        } else {
            aS2GreaterThanAS2Min();
        }

        return new double[]{aS1, aS2};
    }


}

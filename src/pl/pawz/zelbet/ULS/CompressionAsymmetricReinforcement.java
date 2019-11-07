package pl.pawz.zelbet.ULS;

import pl.pawz.zelbet.BasicValuesPillars;

public class CompressionAsymmetricReinforcement {


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
    private double sigmaS1;
    private double sigmaS2;
    private double aS1;
    private double aS2;
    private double aS2Min;

    public CompressionAsymmetricReinforcement(float nEd, float mEd, double epsilonCu3, double epsilonC3, double fCd, double fYd,
                                              double etaConcrete, double lambdaConcrete, double dDimension, float bDimension,
                                              float hDimension, float a1, float a2, int E_S, double xLim, double xMinusMinYd,
                                              double xMinYd, double x0, double xMaxYd) {
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


        BasicValuesPillars eccentricity = new BasicValuesPillars(hDimension, a1, a2, epsilonCu3, epsilonC3, fYd, E_S, mEd, nEd);

        this.eS1 = eccentricity.eccentricityExtension()[0];
        this.eS2 = eccentricity.eccentricityExtension()[1];

        //min reinforcement according to EC 1992;

        this.aS2Min = Math.max(0.10 * nEd / fYd, (0.002 * bDimension * 100 * hDimension * 100) * Math.pow(10, -4)) / 2;

    }


    private double sigmaS2Var() {
        double sigmaS2 = epsilonCu3 * (xLim - a2) / xLim * E_S;
        return Math.min(sigmaS2, fYd);
    }

    private void aS2Var() {
        this.aS2 = (nEd * eS1 - etaConcrete * fCd * bDimension * lambdaConcrete * xLim * (dDimension - 0.5 * lambdaConcrete * xLim)) / (sigmaS2Var() * (dDimension - a2));
    }

    private void aS2GreaterThanA2Min() {
        this.aS1 = (sigmaS2 * aS2 + etaConcrete * fCd * bDimension * lambdaConcrete * xLim - nEd) / fYd;
    }

    public double[] resultsCompressionAsymmetricReinforcement() {
        sigmaS2 = sigmaS2Var();
        aS2Var();
        if (aS2 <= aS2Min) {
            return new double[]{0,0};
        } else {
            aS2GreaterThanA2Min();
            return new double[]{aS1, aS2};
        }
    }
}

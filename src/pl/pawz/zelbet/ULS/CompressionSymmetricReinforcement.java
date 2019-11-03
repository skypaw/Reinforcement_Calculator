package pl.pawz.zelbet.ULS;

public class CompressionSymmetricReinforcement {

    private float nEd;
    private float mEd;
    private double eCu3;
    private double eC3;
    private float fCd;
    private float fYd;
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


    private CompressionSymmetricReinforcement(float nEd, float mEd, double eCu3, double eC3, float fCd, float fYd,
                                              double etaConcrete, double lambdaConcrete, double dDimension, float bDimension,
                                              float hDimension, float a1, float a2, int E_S, double xLim, double xMinusMinYd,
                                              double xMinYd, double x0, double xMaxYd, double eS1, double eS2) {
        this.nEd = nEd;
        this.mEd = mEd;
        this.eCu3 = eCu3;
        this.eC3 = eC3;
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
        this.eS1 = eS1;
        this.eS2 = eS2;

    }

    private double xVar() {
        return (1 / lambdaConcrete) * (nEd / (etaConcrete * fCd * bDimension));
    }

    private double xSmallerThanXLim() {
        return fYd; //sigmaS1
    }

    private double xSmallerThanXMinYd() {
        double aVar = lambdaConcrete * (fYd - eCu3 * E_S);
        double bVar = -2 * (fYd * dDimension - eCu3 * E_S * a2 * (1 + 0.5 * lambdaConcrete));
        double cVar = 2 * ((nEd * (fYd * eS1 - eCu3 * E_S * eS2)) / (lambdaConcrete * etaConcrete * fCd * bDimension) - eCu3 * E_S * Math.pow(a2, 2));
        double dVar = (2 * nEd * eCu3 * E_S * a2 * eS2) / (lambdaConcrete * etaConcrete * fCd * bDimension);
        // double[] xArray = {}; TODO Solve the equation - polynomial x^3
        return 1;
    }

    private double[] xGreaterThanXMinYd() {
        double x = xVar();
        return new double[]{x, fYd};
    }

    private double[] xSmallerThanXMinusMinYd() {
        float sigmaS2 = -fYd;
        double x = 1 / (2 * lambdaConcrete) * ((dDimension + a2) - Math.sqrt(Math.pow(dDimension + a2, 2) - (4 * nEd * (eS1 + eS2)) / (etaConcrete * fCd * bDimension)));
        return new double[]{x, sigmaS2};
    }

    private double[] xGreaterThanXMinusMinYd() {
        double x = xSmallerThanXLim();
        double sigmaS2 = eCu3 * (x - a2) / x * E_S;
        return new double[]{x, sigmaS2};
    }

    double[] resultsCompressionSymmetricReinforcement(double x, double sigmaS1, double sigmaS2) {
        double aS1 = (nEd * eS2 + etaConcrete * fCd * bDimension * lambdaConcrete * x * (0.5 * lambdaConcrete * x - a2)) / (sigmaS1 * (dDimension - a2));
        double aS2 = (nEd * eS1 - etaConcrete * fCd * bDimension * lambdaConcrete * x * (dDimension - 0.5 * lambdaConcrete * x)) / (sigmaS2 * (dDimension - a2));
        return new double[]{aS1, aS2};
    }

}

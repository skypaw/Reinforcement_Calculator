package pl.pawz.zelbet;

public class DiagnosticBendingBeamAndT {
    private float mEd;
    private float fCd;
    private float E_CU_3;
    private float etaConcrete;
    private float lambdaConcrete;
    private float fYd;
    private int E_S;
    private float bW;
    private float bEff;
    private float h;
    private float hF;
    private float a1;
    private float a2;
    private double d;
    private double aS1;
    private double aS2;

    private DiagnosticBendingBeamAndT(float mEd, float fCd, float E_CU_3, float lambdaConcrete, float etaConcrete, float fYd, int E_S, float bW, float bEff, float h, float hF, float a1, float a2, double d, double aS1, double aS2) {
        this.mEd = mEd;
        this.fCd = fCd;
        this.E_CU_3 = E_CU_3; //TODO change this to variable epsilonCu3 - for concrete c50< this is a variable
        this.lambdaConcrete = lambdaConcrete;
        this.etaConcrete = etaConcrete;
        this.fYd = fYd;
        this.E_S = E_S;
        this.bW = bW;
        this.bEff = bEff;
        this.h = h;
        this.hF = hF;
        this.a1 = a1;
        this.a2 = a2;
        this.d = d;
        this.aS1 = aS1;
        this.aS2 = aS2;
    }

    private BasicValuesPillars limitValues = new BasicValuesPillars(h, a1, a2, E_CU_3, 0, fYd, E_S, 0, 0);
    private double xLim = limitValues.xLimVar();
    private double xMinYd = limitValues.xMinYdVar();
    private double xMinMinusYd = limitValues.xMinMinusYdVar();

    private double xVar() {
        return 1 / lambdaConcrete * (fYd * (aS1 - aS2)) / (etaConcrete * fCd * bEff);
    }

    private double[] xSmallerThanXMinYd() {
        float sigmaS1 = fYd;
        double aVar = (E_CU_3 * E_S * aS2 - fYd * aS1) / (etaConcrete * fCd * bEff);
        double bVar = (4 * lambdaConcrete * E_CU_3 * E_S * aS2) / (etaConcrete * fCd * bEff) * a2;
        double xVar = 1 / lambdaConcrete * ((-aVar + Math.sqrt(Math.pow(aVar, 2) + bVar)) / 2);
        return new double[]{xVar, sigmaS1};
    }

    private double xGreaterThanXMinYd() {
        return fYd; //SigmaS2
    }

    private double xSmallerThanXLim() {
        return fYd; //SigmaS1
    }

    private double[] xGreaterThanXLim() {
        double xVar = xLim;
        double sigmaS1 = (etaConcrete * fCd * bEff * lambdaConcrete * xVar + fYd * aS2) / aS1;
        return new double[]{xVar, sigmaS1};
    }

    private double[] xSmallerThanXMinMinusYd() {
        double xVar = 1 / lambdaConcrete * (fYd * (aS1 + aS2)) / (etaConcrete * fCd * bEff);
        double sigmaS2 = -fYd;
        return new double[]{xVar, sigmaS2};
    }

    private double xGreaterThanXMinMinusYd() {
        return E_CU_3 * (xSmallerThanXMinYd()[0] - a2) / xSmallerThanXMinYd()[0] * E_S;
    }


}

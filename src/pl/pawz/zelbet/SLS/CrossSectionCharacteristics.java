package pl.pawz.zelbet.SLS;

import pl.pawz.zelbet.BasicValues;

public class CrossSectionCharacteristics {
    private float b;
    private float bEff;
    private float bEffT;
    private float h;
    private float hF;
    private float hFT;
    private float a1;
    private float a2;
    private double aS1;
    private double aS2;
    private double alphaEOrEEff;
    private double d;

    public CrossSectionCharacteristics(float b, float bEff, float bEffT, float h, float hF, float hFT, float a1, float a2, double aS1, double aS2, double alphaEOrEEff) {
        this.b = b;
        this.bEff = bEff;
        this.bEffT = bEffT;
        this.h = h;
        this.hF = hF;
        this.hFT = hFT;
        this.a1 = a1;
        this.a2 = a2;
        this.aS1 = aS1;
        this.aS2 = aS2;
        this.alphaEOrEEff = alphaEOrEEff;
        this.d = BasicValues.dValue(h, a1);
    }

    private double[] concreteCrossSection() {
        double aC = (bEff - b) * hF + (bEffT - b) * hFT + b * h;
        double sCC = (bEff - b) * Math.pow(hF, 2) / 2 + (bEffT - b) * hFT * (h - hFT / 2) + b * Math.pow(h, 2);
        double xC = sCC / aC;
        double iC = b * Math.pow(h, 3) / 12 + b * h * Math.pow(h / 2 - xC, 2) + (bEff - b) * Math.pow(hF, 3) / 12 + (bEff - b)
                * hF * Math.pow(xC - hF / 2, 2) + (bEffT - b) * Math.pow(hFT, 3) / 12 + (bEffT - b) * hFT * Math.pow(h - xC - hFT / 2, 2);

        return new double[]{aC, sCC, xC, iC};
    }

    private double[] phaseI() {
        double aI = (bEff - b) * hF + (bEffT - b) * hFT * +b * h + alphaEOrEEff * aS2 + alphaEOrEEff * aS1;
        double sCI = (bEff - b) * Math.pow(hF, 2) / 2 + (bEffT - b) * hFT * (h - hFT / 2) + b * Math.pow(h, 2) / 2 + alphaEOrEEff * aS2 * a2 + alphaEOrEEff * aS1 * d;
        double xI = sCI / aI;
        double sI = aS1 * (d - xI) - aS2 * (xI - a2);
        double iI = b * Math.pow(h, 3) / 12 + b * h * Math.pow(h / 2 - xI, 2) + (bEff - b) * Math.pow(hF, 3) / 12 + (bEff - b) * hF * Math.pow(xI - hF / 2, 2) + (bEffT - b) * Math.pow(hFT, 3) / 12 + (bEffT - b) * hFT * Math.pow(h - xI - hFT / 2, 2);
        double iI2 = iI + alphaEOrEEff * aS2 * Math.pow(xI - a2, 2) + alphaEOrEEff * aS1 * Math.pow(h - xI - a1, 2);

        return new double[]{aI, sCI, xI, sI, iI, iI2};
    }

    private double[] phaseII1() {
        return new double[]{};
    }


}

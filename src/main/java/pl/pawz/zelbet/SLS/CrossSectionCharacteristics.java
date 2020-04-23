package pl.pawz.zelbet.SLS;

import pl.pawz.zelbet.BasicValues;
import pl.pawz.zelbet.PolynomialSolverSGU;

public class CrossSectionCharacteristics {
    private double b;
    private double bEff;
    private double bEffT;
    private double h;
    private double hF;
    private double hFT;
    private double a1;
    private double a2;
    private double aS1;
    private double aS2;
    private double alphaEOrEEff;
    private double d;

    public CrossSectionCharacteristics(double b, double bEff, double bEffT, double h, double hF, double hFT, double a1, double a2, double aS1, double aS2, double alphaEOrEEff) {
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

    double[] concreteCrossSection() {
        double aC = (bEff - b) * hF + (bEffT - b) * hFT + b * h;
        double sCC = (bEff - b) * Math.pow(hF, 2) / 2 + (bEffT - b) * hFT * (h - hFT / 2) + b * Math.pow(h, 2)/2;
        double xC = sCC / aC;
        double iC = b * Math.pow(h, 3) / 12 + b * h * Math.pow(h / 2 - xC, 2) + (bEff - b) * Math.pow(hF, 3) / 12 + (bEff - b)
                * hF * Math.pow(xC - hF / 2, 2) + (bEffT - b) * Math.pow(hFT, 3) / 12 + (bEffT - b) * hFT * Math.pow(h - xC - hFT / 2, 2);

        return new double[]{aC, sCC, xC, iC};
    }

    double[] phaseI() {
        double aI = (bEff - b) * hF + (bEffT - b) * hFT + b * h + alphaEOrEEff * aS2 + alphaEOrEEff * aS1;
        double sCI = (bEff - b) * Math.pow(hF, 2) / 2 + (bEffT - b) * hFT * (h - hFT / 2) + b * Math.pow(h, 2) / 2 + alphaEOrEEff * aS2 * a2 + alphaEOrEEff * aS1 * d;
        double xI = sCI / aI;
        double sI = aS1 * (d - xI) - aS2 * (xI - a2);
        double iI = b * Math.pow(h, 3) / 12 + b * h * Math.pow(h / 2 - xI, 2) + (bEff - b) * Math.pow(hF, 3) / 12 + (bEff - b) * hF * Math.pow(xI - hF / 2, 2) + (bEffT - b) * Math.pow(hFT, 3) / 12 + (bEffT - b) * hFT * Math.pow(h - xI - hFT / 2, 2);
        double iI2 = iI + alphaEOrEEff * aS2 * Math.pow(xI - a2, 2) + alphaEOrEEff * aS1 * Math.pow(h - xI - a1, 2);

        return new double[]{aI, sCI, xI, sI, iI2};
    }

    private double[] phaseII1() {

        double xII = PolynomialSolverSGU.solverPhaseII1(bEff, a2, aS1, aS2, alphaEOrEEff, d);
        double sII = aS1 * (d - xII) - aS2 * (xII - a2);
        double iII = (bEff * Math.pow(xII, 3)) / 12 + bEff * xII * Math.pow(xII / 2, 2) + alphaEOrEEff * aS2 * Math.pow(xII - a2, 2) + alphaEOrEEff * aS1 * Math.pow(h - xII - a1, 2);

        return new double[]{xII, sII, iII};
    }

    private double[] phaseII2() {

        double xII = PolynomialSolverSGU.solverPhaseII2(b, bEff, hF, a2, aS1, aS2, alphaEOrEEff, d);
        double sII = aS1 * (d - xII) - aS2 * (xII - a2);
        double iII = b * Math.pow(xII, 3) / 12 + b * xII * Math.pow(xII / 2, 2) + (bEff - b) * Math.pow(hF, 3) / 12 + (bEff - b) * hF * Math.pow(xII - hF / 2, 2) + alphaEOrEEff * aS2 * Math.pow(xII - a2, 2) + alphaEOrEEff * aS1 * Math.pow(h - xII - a1, 2);

        return new double[]{xII, sII, iII};
    }

    private double[] phaseII3() {
        double xII = PolynomialSolverSGU.solverPhaseII3(b, bEff, bEffT, h, hF, hFT, a2, aS1, aS2, alphaEOrEEff, d);
        double sII = aS1 * (d - xII) - aS2 * (xII - a2);
        double iII1 = b * Math.pow(xII, 3) / 12 + b * xII * Math.pow(xII / 2, 2) + (bEff - b) * Math.pow(hF, 3) / 12 + (bEff - b) * hF * Math.pow(xII - hF / 2, 2) + (bEffT - b) * Math.pow(xII - h + hFT, 3) / 12;
        double iII2 = iII1 + (bEffT - b) * (xII - h + hFT) * Math.pow((xII - h + hFT) / 2, 2) + alphaEOrEEff * aS2 * Math.pow(xII - a2, 2) + alphaEOrEEff * aS1 * Math.pow(h - xII - a1, 2);

        return new double[]{xII, sII, iII2};
    }

    public double[] phaseII() {
        if (phaseII1()[0] <= hF) {
            return phaseII1();
        } else if (phaseII2()[0] < (h - hFT) && phaseII2()[0] >= hF) {
            return phaseII2();
        } else {
            return phaseII3();
        }
    }
}

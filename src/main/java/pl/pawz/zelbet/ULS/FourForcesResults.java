package pl.pawz.zelbet.ULS;


import pl.pawz.zelbet.BasicValuesPillars;
import pl.pawz.zelbet.Diagnostic.DiagnosticCompression;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

public class FourForcesResults {
    private double h;
    private double b;
    private double a1;
    private double a2;
    private double mEd1;
    private double mEd2;
    private double mEd3;
    private double mEd4;

    private double nEd1;
    private double nEd2;
    private double nEd3;
    private double nEd4;

    private double fCk;
    private double fYk;

    public FourForcesResults(double b, double h, double a1, double a2, double nEd1, double mEd1, double nEd2, double mEd2, double nEd3, double mEd3, double nEd4, double mEd4, double fCk, double fYk) {
        this.h = h;
        this.b = b;
        this.a1 = a1;
        this.a2 = a2;

        this.fCk = fCk;
        this.fYk = fYk;

        this.mEd1 = mEd1;
        this.mEd2 = mEd2;
        this.mEd3 = mEd3;
        this.mEd4 = mEd4;

        this.nEd1 = nEd1;
        this.nEd2 = nEd2;
        this.nEd3 = nEd3;
        this.nEd4 = nEd4;

    }

    private double eccentricity(double nEdEccentricity, double mEdEccentricity) {
        if (nEdEccentricity >= 0) {
            return BasicValuesPillars.eccentricityCompression(mEdEccentricity, nEdEccentricity, h, a1, a2)[2];
        } else {
            return BasicValuesPillars.eccentricityExtension(mEdEccentricity, nEdEccentricity, h, a1, a2)[2];
        }
    }

    private char maxEccentricity() {
        double eccentricityFirstBeam = eccentricity(nEd1, mEd1);
        double eccentricitySecondBeam = eccentricity(nEd2, mEd2);
        double eccentricityThirdBeam = eccentricity(nEd3, mEd3);
        double eccentricityFourthBeam = eccentricity(nEd4, mEd4);

        double maxValue = Math.max(Math.max(eccentricityFirstBeam, eccentricitySecondBeam), Math.max(eccentricityThirdBeam, eccentricityFourthBeam));

        if (maxValue == eccentricityFirstBeam) {
            return '1';
        }
        if (maxValue == eccentricitySecondBeam) {
            return '2';
        }
        if (maxValue == eccentricityThirdBeam) {
            return '3';
        }
        if (maxValue == eccentricityFourthBeam) {
            return '4';
        }

        return 0;
    }

    private double[] calculations() {
        char max = maxEccentricity();
        double[] calculationsResults = {0, 0};

        if (max == '1') {
            CompressionAsymmetricReinforcement results = new CompressionAsymmetricReinforcement(nEd1, mEd1, fCk, fYk, b, h, a1, a2);
            calculationsResults = results.resultsCompressionAsymmetricReinforcement();
        }
        if (max == '2') {
            CompressionAsymmetricReinforcement results = new CompressionAsymmetricReinforcement(nEd2, mEd2, fCk, fYk, b, h, a1, a2);
            calculationsResults = results.resultsCompressionAsymmetricReinforcement();
        }
        if (max == '3') {
            CompressionAsymmetricReinforcement results = new CompressionAsymmetricReinforcement(nEd3, mEd3, fCk, fYk, b, h, a1, a2);
            calculationsResults = results.resultsCompressionAsymmetricReinforcement();
        }
        if (max == '4') {
            CompressionAsymmetricReinforcement results = new CompressionAsymmetricReinforcement(nEd4, mEd4, fCk, fYk, b, h, a1, a2);
            calculationsResults = results.resultsCompressionAsymmetricReinforcement();
        }

        return calculationsResults;
    }

    public double[] diagnostic() {
        double[] reinforcementResults = calculations();

        double aS1 = reinforcementResults[0];
        double aS2 = reinforcementResults[1];

        double[] results1 = {0, 0};
        double[] results2 = {0, 0};
        double[] results3 = {0, 0};
        double[] results4 = {0, 0};

        while ((results1[0] <= nEd1 && results1[1] <= mEd1) || (results2[0] <= nEd2 && results2[1] <= mEd2) || (results3[0] <= nEd3 && results3[1] <= mEd3) || (results4[0] <= nEd4 || results4[1] <= mEd4)) {
            DiagnosticCompression resultsFirstBeam = new DiagnosticCompression(nEd1, mEd1, fCk, fYk, b, h, a1, a2, aS1, aS2);
            results1 = resultsFirstBeam.resultsDiagnosticCompression();
            DiagnosticCompression resultsSecondBeam = new DiagnosticCompression(nEd2, mEd2, fCk, fYk, b, h, a1, a2, aS1, aS2);
            results2 = resultsSecondBeam.resultsDiagnosticCompression();
            DiagnosticCompression resultsThirdBeam = new DiagnosticCompression(nEd3, mEd3, fCk, fYk, b, h, a1, a2, aS1, aS2);
            results3 = resultsThirdBeam.resultsDiagnosticCompression();
            DiagnosticCompression resultsFourthBeam = new DiagnosticCompression(nEd4, mEd4, fCk, fYk, b, h, a1, a2, aS1, aS2);
            results4 = resultsFourthBeam.resultsDiagnosticCompression();

            aS1 = aS1 + 0.0001;
            aS2 = aS2 + 0.0001;
            System.out.println(aS1);
        }
        return new double[]{aS1, aS2};
    }


}

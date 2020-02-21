package pl.pawz.zelbet.ULS;


import pl.pawz.zelbet.BasicValuesPillars;
import pl.pawz.zelbet.Diagnostic.DiagnosticCompression;


public class FourForcesResults {
    private float h;
    private float b;
    private float a1;
    private float a2;
    private float mEd1;
    private float mEd2;
    private float mEd3;
    private float mEd4;

    private float nEd1;
    private float nEd2;
    private float nEd3;
    private float nEd4;

    private float fCk;
    private float fYk;

    public FourForcesResults(float b, float h, float a1, float a2, float nEd1, float mEd1, float nEd2, float mEd2, float nEd3, float mEd3, float nEd4, float mEd4, float fCk, float fYk) {
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

    private double eccentricity(float nEdEccentricity, float mEdEccentricity) {
        double e = BasicValuesPillars.eccentricityBasic(mEdEccentricity, nEdEccentricity);
        return e;
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

    public double[] diagnostic() {
        char max = maxEccentricity();
        double[] calculationsResults = {0, 0};
        double e = 0;


        double[] results1 = {0, 0};
        double[] results2 = {0, 0};
        double[] results3 = {0, 0};
        double[] results4 = {0, 0};

        double aS1 = 0;
        double aS2 = 0;

        CompressionAsymmetricReinforcement resultsOne = new CompressionAsymmetricReinforcement(nEd1, mEd1, fCk, fYk, b, h, a1, a2);
        CompressionAsymmetricReinforcement resultsTwo = new CompressionAsymmetricReinforcement(nEd2, mEd2, fCk, fYk, b, h, a1, a2);
        CompressionAsymmetricReinforcement resultsThree = new CompressionAsymmetricReinforcement(nEd3, mEd3, fCk, fYk, b, h, a1, a2);
        CompressionAsymmetricReinforcement resultsFour = new CompressionAsymmetricReinforcement(nEd4, mEd4, fCk, fYk, b, h, a1, a2);

        DiagnosticCompression resultsFirstBeam = new DiagnosticCompression(nEd1, mEd1, fCk, fYk, b, h, a1, a2, aS1, aS2);
        DiagnosticCompression resultsSecondBeam = new DiagnosticCompression(nEd2, mEd2, fCk, fYk, b, h, a1, a2, aS1, aS2);
        DiagnosticCompression resultsThirdBeam = new DiagnosticCompression(nEd3, mEd3, fCk, fYk, b, h, a1, a2, aS1, aS2);
        DiagnosticCompression resultsFourthBeam = new DiagnosticCompression(nEd4, mEd4, fCk, fYk, b, h, a1, a2, aS1, aS2);

        while ((results1[0] <= nEd1 && results1[1] <= mEd1) || (results2[0] <= nEd2 && results2[1] <= mEd2) || (results3[0] <= nEd3 && results3[1] <= mEd3) || (results4[0] <= nEd4 || results4[1] <= mEd4)) {

            if (max == '1') {

                calculationsResults = resultsOne.resultsCompressionAsymmetricReinforcement();
                e = resultsOne.getE();
            }
            if (max == '2') {

                calculationsResults = resultsTwo.resultsCompressionAsymmetricReinforcement();
                e = resultsTwo.getE();
            }
            if (max == '3') {

                calculationsResults = resultsThree.resultsCompressionAsymmetricReinforcement();
                e = resultsThree.getE();
            }
            if (max == '4') {

                calculationsResults = resultsFour.resultsCompressionAsymmetricReinforcement();
                e = resultsFour.getE();
            }


            aS1 = calculationsResults[1];
            aS2 = calculationsResults[0];

            resultsFirstBeam.setAS1(aS1);
            resultsFirstBeam.setAS2(aS2);


            resultsSecondBeam.setAS1(aS1);
            resultsSecondBeam.setAS2(aS2);

            resultsThirdBeam.setAS1(aS1);
            resultsThirdBeam.setAS2(aS2);

            resultsFourthBeam.setAS1(aS1);
            resultsFourthBeam.setAS2(aS2);


            results1 = resultsFirstBeam.resultsDiagnosticCompression();
            results2 = resultsSecondBeam.resultsDiagnosticCompression();
            results3 = resultsThirdBeam.resultsDiagnosticCompression();
            results4 = resultsFourthBeam.resultsDiagnosticCompression();


            e = e + e / 100;
            System.out.println(e);

            if (results2[0] > 6 && results2[1]>0.5f) {
                System.out.println("dlaczego xd");
            }

            resultsOne.setE(e);
            resultsTwo.setE(e);
            resultsThree.setE(e);
            resultsFour.setE(e);

            System.out.println(aS1);
            System.out.println(aS2);

        }
        return new double[]{aS1, aS2};
    }


}

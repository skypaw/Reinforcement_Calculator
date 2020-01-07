package pl.pawz.zelbet;

import pl.pawz.zelbet.Diagnostic.DiagnosticCompression;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        float fCk = 30f;
        float fYk = 500f;


        float b = 0.3f;
        float a1 = 0.05f;
        float a2 = 0.05f;
        float h = 0.6f;

        float a1Beam = 0.051f;
        float fCkBeam = 30f;
        float hBeam = 0.4f;
        float bW = 0.25f;
        float bEff = 1.6f;
        float hF = 0.10f;



        float vEd = 0.3984f;
        double vEdRed = 0.332f;
        double aS2 = 0.0006032;
        double aS1 = 0.0004021;
        double nS1 = 2;
        double nS2 = 2;
        double fiS1 = 0.006;
        double fiS2 = 0.012;
        float cotTheta = 2;

        float mEd = 0.012f;
        float nEd = 0.034f;

        float mEdBeam = 0.10439f;

        DiagnosticCompression test = new DiagnosticCompression(nEd,mEd,fCk,fYk,b,h,a1,a2,aS1, aS2);
        double[] res = test.resultsDiagnosticCompression();
        System.out.println(Arrays.toString(res));

    }

}

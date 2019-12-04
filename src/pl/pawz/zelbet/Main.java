package pl.pawz.zelbet;

import pl.pawz.zelbet.Diagnostic.DiagnosticExtension;
import pl.pawz.zelbet.ULS.BendingBeamT;
import pl.pawz.zelbet.ULS.ShearingBendRods;
import pl.pawz.zelbet.ULS.ShearingStirrups;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        float fCk = 30f;
        float fYk = 500f;

        float b = 0.3f;
        float a1 = 0.05f;
        float a2 = 0.05f;

        float h = 0.6f;
        float bW = 0.2f;
        float bEff = 0.8f;
        float hF = 0.15f;



        float vEd = 0.3984f;
        double vEdRed = 0.332f;
        double aSl = 0.001;
        double nS1 = 2;
        double nS2 = 2;
        double fiS1 = 0.006;
        double fiS2 = 0.012;
        float cotTheta = 2;


        float nEd = 0.5f;
        float mEd = 0.0001f;

        double aS1 = 5.750034 * Math.pow(10, -4);
        double aS2 = aS1;

        DiagnosticExtension res = new DiagnosticExtension(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticExtension()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticExtension()[1];
        System.out.println(result2);

    }

}

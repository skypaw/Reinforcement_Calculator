package pl.pawz.zelbet;

import pl.pawz.zelbet.Diagnostic.DiagnosticExtension;
import pl.pawz.zelbet.ULS.BendingBeamT;
import pl.pawz.zelbet.ULS.CompressionSymmetricReinforcement;
import pl.pawz.zelbet.ULS.ShearingBendRods;
import pl.pawz.zelbet.ULS.ShearingStirrups;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        float fCk = 25f;
        float fYk = 500f;

        float b = 0.4f;
        float a1 = 0.053f;
        float a2 = 0.053f;

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

        float nEd = 0.2114f;
        float mEd = 0.29114f;

    }

}

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

        float a1Beam = 0.051f;
        float fCkBeam = 30f;
        float hBeam = 0.4f;
        float bW = 0.25f;
        float bEff = 1.6f;
        float hF = 0.10f;



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

        float mEdBeam = 0.10439f;

        BendingBeamT resultsBending = new BendingBeamT(mEdBeam,fCkBeam,fYk,bW,bEff,hBeam,hF,a1Beam,a2);
        System.out.println(Arrays.toString(resultsBending.resultsBendingT()));

        CompressionSymmetricReinforcement results = new CompressionSymmetricReinforcement(nEd,mEd,fCk,fYk,b,h,a1,a2);
        System.out.println(Arrays.toString(results.resultsCompressionSymmetricReinforcement()));

        System.out.println( 32.3432423);

    }

}

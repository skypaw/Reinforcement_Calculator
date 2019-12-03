package pl.pawz.zelbet;

import pl.pawz.zelbet.ULS.BendingBeamT;
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

        float mEd = 0.50f;

        float nEd = 0;
        float vEd = 0.0624f;
        double vEdRed = 0.052f;
        double aSl = 0;
        double nS = 2;
        double fiS1 = 0.006;
        float cotTheta = 2;


        ShearingStirrups shearingBasic = new ShearingStirrups(h, b,a1,fCk,fYk,nEd,vEd,vEdRed,aSl,nS,fiS1,cotTheta);
        double res = shearingBasic.resultShearingStirrups();
        System.out.println(res);

    }

}

package pl.pawz.zelbet;

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

        float mEd = 0.50f;

        float nEd = 0.9f;

        float vEd = 0.258f;
        double vEdRed = 0.215f;
        double aSl = 0;
        double nS1 = 2;
        double nS2 = 0;
        double fiS1 = 0.006;
        double fiS2 = 0.012;
        float cotTheta = 2;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

    }

}

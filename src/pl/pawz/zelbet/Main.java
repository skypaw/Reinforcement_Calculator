package pl.pawz.zelbet;

import pl.pawz.zelbet.ULS.BendingBeamT;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        float fCk = 20f;
        float fYk = 500f;

        float b = 0.2f;
        float a1 = 0.05f;
        float a2 = 0.05f;

        float h = 0.3f;
        float bW = 0.2f;
        float bEff = 0.8f;
        float hF = 0.15f;

        float mEd = 0.50f;

        BendingBeamT res = new BendingBeamT(mEd,fCk,fYk,bW,bEff,h,hF,a1,a2);
        System.out.println(Arrays.toString(res.resultsBendingT()));


    }

}

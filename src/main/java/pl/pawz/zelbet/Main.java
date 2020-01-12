package pl.pawz.zelbet;

import pl.pawz.zelbet.Diagnostic.DiagnosticCompression;
import pl.pawz.zelbet.SLS.Deflection;
import pl.pawz.zelbet.SLS.Scratch;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        float fCk = 30f;
        double fYk = 500;
        float hDimension = 0.6f;
        float bDimension = 0.3f;
        float a1 = 0.05f;
        float a2 = 0.05f;

        float fi = 0.016f;
        float alphaM = 0.104f;
        float lEff = 6f;

        int eS = 200000;
        int rH = 50;

        float cNom = 0.030f;
        float fiSt = 0.008f;


        float mEd = 0.25f;
        float mEk = 0.20f;
        float mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 0;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, eS, bDimension, hDimension, 0, 0, bDimension, bDimension, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bDimension, bDimension, hDimension, 0, 0, a1, a2, as1, as2, mEk, mEkLt, 'N', eS, 'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("wk = " + result2 + " m");

    }

}

package pl.pawz.zelbet.tests.SLS;

import org.junit.Test;
import pl.pawz.zelbet.SLS.Deflection;
import pl.pawz.zelbet.SLS.Scratch;


import static org.junit.Assert.assertEquals;

public class TestSgu1 {

    private float fCk = 30f;
    private double fYk = 500;
    private float hDimension = 0.6f;
    private float bDimension = 0.3f;
    private float a1 = 0.05f;
    private float a2 = 0.05f;

    private float fi = 0.016f;
    private float alphaM = 0.104f;
    private float lEff = 6f;

    private int eS = 200000;
    private int rH = 50;

    private float cNom = 0.030f;
    private float fiSt = 0.008f;

    private static final double DELTA = 1e-6;

    @Test
    public void testSixZero() {

        float mEd = 0.25f;
        float mEk = 0.2f;
        float mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 0;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, eS, bDimension, hDimension, 0, 0, bDimension, bDimension, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bDimension, bDimension, hDimension, 0, 0, a1, a2, as1, as2, mEk, mEkLt, 'N', eS, 'L');
        double result2 = res2.wK();

        assertEquals(20.21, result1, DELTA);
        assertEquals(0.2743, result2, DELTA);

    }

}

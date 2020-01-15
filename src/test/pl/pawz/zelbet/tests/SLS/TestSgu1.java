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

    private static final double DELTA = 1.5e-4;
    private static final double DELTA1 = 1.5e-5;

    @Test
    public void testSixZeroLongOne() {

        float mEd = 0.25f;
        float mEk = 0.2f;
        float mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 0;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, 0, 0, bDimension, bDimension, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bDimension, bDimension, hDimension, 0, 0, a1, a2, as1, as2, mEk, mEkLt, 'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " cm");
        System.out.println("fc+m = " + result1a + " cm");
        System.out.println("wk = " + result2 + " mm");

        assertEquals(20.21 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.2743 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixZeroLongTwo() {

        float mEd = 0.25f;
        float mEk = 0.25f;
        float mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 0;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, 0, 0, bDimension, bDimension, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bDimension, bDimension, hDimension, 0, 0, a1, a2, as1, as2, mEk, mEkLt, 'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " cm");
        System.out.println("fc+m = " + result1a + " cm");
        System.out.println("wk = " + result2 + " mm");

        assertEquals(20.21 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.2743 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixSixLongOne() {

        float mEd = 0.25f;
        float mEk = 0.20f;
        float mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 6;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, 0, 0, bDimension, bDimension, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bDimension, bDimension, hDimension, 0, 0, a1, a2, as1, as2, mEk, mEkLt, 'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " cm");
        System.out.println("fc+m = " + result1a + " cm");
        System.out.println("wk = " + result2 + " mm");

        assertEquals(17.27 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.2868 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixSixLongTwo() {

        float mEd = 0.25f;
        float mEk = 0.25f;
        float mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 6;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, 0, 0, bDimension, bDimension, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bDimension, bDimension, hDimension, 0, 0, a1, a2, as1, as2, mEk, mEkLt, 'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " cm");
        System.out.println("fc+m = " + result1a + " cm");
        System.out.println("wk = " + result2 + " mm");

        assertEquals(17.27 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.2868 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixThreeLongOne() {

        float mEd = 0.25f;
        float mEk = 0.20f;
        float mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 3;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, 0, 0, bDimension, bDimension, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bDimension, bDimension, hDimension, 0, 0, a1, a2, as1, as2, mEk, mEkLt, 'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " cm");
        System.out.println("fc+m = " + result1a + " cm");
        System.out.println("wk = " + result2 + " mm");

        assertEquals(18.45 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.2916 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixThreeLongTwo() {

        float mEd = 0.25f;
        float mEk = 0.25f;
        float mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 3;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, 0, 0, bDimension, bDimension, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bDimension, bDimension, hDimension, 0, 0, a1, a2, as1, as2, mEk, mEkLt, 'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " cm");
        System.out.println("fc+m = " + result1a + " cm");
        System.out.println("wk = " + result2 + " mm");

        assertEquals(18.45 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.2916 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testThreeSixLongOne() {

        float mEd = 0.25f;
        float mEk = 0.20f;
        float mEkLt = 0.2f;

        int rods1 = 3;
        int rods2 = 6;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, 0, 0, bDimension, bDimension, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 3, fCk, rH, 28, 'N', bDimension, bDimension, bDimension, hDimension, 0, 0, a1, a2, as1, as2, mEk, mEkLt, 'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " cm");
        System.out.println("fc+m = " + result1a + " cm");
        System.out.println("wk = " + result2 + " mm");

        assertEquals(29.40 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.8225 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testThreeSixLongTwo() {

        float mEd = 0.25f;
        float mEk = 0.25f;
        float mEkLt = 0.2f;

        int rods1 = 3;
        int rods2 = 6;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, 0, 0, bDimension, bDimension, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 3, fCk, rH, 28, 'N', bDimension, bDimension, bDimension, hDimension, 0, 0, a1, a2, as1, as2, mEk, mEkLt, 'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " cm");
        System.out.println("fc+m = " + result1a + " cm");
        System.out.println("wk = " + result2 + " mm");

        assertEquals(29.40 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.8225 * Math.pow(10, -3), result2, DELTA1);

    }

    // short time load

    @Test
    public void testSixZeroShortOne() {

        float mEd = 0.25f;
        float mEk = 0.20f;
        float mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 0;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, 0, 0, bDimension, bDimension, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bDimension, bDimension, hDimension, 0, 0, a1, a2, as1, as2, mEk, mEkLt, 'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " cm");
        System.out.println("wk = " + result2 + " mm");

        assertEquals(14.42 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.2743 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixZeroShortTwo() {

        float mEd = 0.25f;
        float mEk = 0.25f;
        float mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 0;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, 0, 0, bDimension, bDimension, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bDimension, bDimension, hDimension, 0, 0, a1, a2, as1, as2, mEk, mEkLt, 'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " cm");

        System.out.println("wk = " + result2 + " mm");

        assertEquals(18.37 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.36 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixSixShortOne() {

        float mEd = 0.25f;
        float mEk = 0.20f;
        float mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 6;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, 0, 0, bDimension, bDimension, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bDimension, bDimension, hDimension, 0, 0, a1, a2, as1, as2, mEk, mEkLt, 'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " cm");
        System.out.println("wk = " + result2 + " mm");

        assertEquals(13.9 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.2723 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixSixShortTwo() {

        float mEd = 0.25f;
        float mEk = 0.25f;
        float mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 6;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, 0, 0, bDimension, bDimension, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bDimension, bDimension, hDimension, 0, 0, a1, a2, as1, as2, mEk, mEkLt, 'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");

        System.out.println("wk = " + result2 + " m");

        assertEquals(17.71 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.3572 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixThreeShortOne() {

        float mEd = 0.25f;
        float mEk = 0.20f;
        float mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 3;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, 0, 0, bDimension, bDimension, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bDimension, bDimension, hDimension, 0, 0, a1, a2, as1, as2, mEk, mEkLt, 'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");

        System.out.println("wk = " + result2 + " m");

        assertEquals(14.14 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.2731 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixThreeShortTwo() {

        float mEd = 0.25f;
        float mEk = 0.25f;
        float mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 3;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, 0, 0, bDimension, bDimension, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bDimension, bDimension, hDimension, 0, 0, a1, a2, as1, as2, mEk, mEkLt, 'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");

        System.out.println("wk = " + result2 + " m");

        assertEquals(18.01 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.3582 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testThreeSixShortOne() {

        float mEd = 0.25f;
        float mEk = 0.2f;
        float mEkLt = 0.2f;

        int rods1 = 3;
        int rods2 = 6;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, 0, 0, bDimension, bDimension, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bDimension, bDimension, hDimension, 0, 0, a1, a2, as1, as2, mEk, mEkLt, 'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");

        System.out.println("wk = " + result2 + " m");

        assertEquals(25.00 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.7658 * Math.pow(10, -3), result2, DELTA1);

    }


    @Test
    public void testThreeSixShortTwo() {

        float mEd = 0.25f;
        float mEk = 0.25f;
        float mEkLt = 0.2f;

        int rods1 = 3;
        int rods2 = 6;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, 0, 0, bDimension, bDimension, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bDimension, bDimension, hDimension, 0, 0, a1, a2, as1, as2, mEk, mEkLt, 'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");

        System.out.println("wk = " + result2 + " m");

        assertEquals(31.95 * Math.pow(10, -3), result1, DELTA);
        assertEquals(1.0006 * Math.pow(10, -3), result2, DELTA1);

    }
}

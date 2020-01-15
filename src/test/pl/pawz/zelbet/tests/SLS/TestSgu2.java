package pl.pawz.zelbet.tests.SLS;

import org.junit.Test;
import pl.pawz.zelbet.SLS.Deflection;
import pl.pawz.zelbet.SLS.Scratch;


import static org.junit.Assert.assertEquals;

public class TestSgu2 {

    private float fCk = 30f;
    private double fYk = 500;

    private float hDimension = 0.6f;
    private float bDimension = 0.3f;
    private float hf = 0.1f;
    private float bEff = 0.7f;
    private float hft = 0.15f;
    private float bEfft = 0.50f;

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


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt,  'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("fc+m = " + result1a + " m");
        System.out.println("wk = " + result2 + " m");

        assertEquals(15.56 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.3260 * Math.pow(10, -3), result2, DELTA1);

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


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd,  bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt,  'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("fc+m = " + result1a + " m");
        System.out.println("wk = " + result2 + " m");

        assertEquals(15.56 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.3260 * Math.pow(10, -3), result2, DELTA1);

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


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt,  'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("fc+m = " + result1a + " m");
        System.out.println("wk = " + result2 + " m");

        assertEquals(14.55 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.3230 * Math.pow(10, -3), result2, DELTA1);

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


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd,  bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt, 'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("fc+m = " + result1a + " m");
        System.out.println("wk = " + result2 + " m");

        assertEquals(14.55 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.3230 * Math.pow(10, -3), result2, DELTA1);


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


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd,  bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt,  'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("fc+m = " + result1a + " m");
        System.out.println("wk = " + result2 + " m");

        assertEquals(14.99 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.3241 * Math.pow(10, -3), result2, DELTA1);

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


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd,  bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt,  'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("fc+m = " + result1a + " m");
        System.out.println("wk = " + result2 + " m");

        assertEquals(14.99 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.3241 * Math.pow(10, -3), result2, DELTA1);

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


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd,  bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt,  'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("fc+m = " + result1a + " m");
        System.out.println("wk = " + result2 + " m");

        assertEquals(25.50 * Math.pow(10, -3), result1, DELTA);
        assertEquals(1.0214 * Math.pow(10, -3), result2, DELTA1);

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


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt,  'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("fc+m = " + result1a + " m");
        System.out.println("wk = " + result2 + " m");

        assertEquals(25.50 * Math.pow(10, -3), result1, DELTA);
        assertEquals(1.0214 * Math.pow(10, -3), result2, DELTA1);

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


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt,  'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("wk = " + result2 + " m");


        assertEquals(11.19 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.2891 * Math.pow(10, -3), result2, DELTA1);

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


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd,  bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt, 'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("wk = " + result2 + " m");


        assertEquals(14.94 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.3946 * Math.pow(10, -3), result2, DELTA1);

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


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd,  bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt,  'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("wk = " + result2 + " m");


        assertEquals(11.07 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.2894 * Math.pow(10, -3), result2, DELTA1);

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


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd,  bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt,  'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("wk = " + result2 + " m");


        assertEquals(14.79 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.3949 * Math.pow(10, -3), result2, DELTA1);

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


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd,  bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt,  'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("wk = " + result2 + " m");


        assertEquals(11.13 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.2892 * Math.pow(10, -3), result2, DELTA1);

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


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd,  bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt,  'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("wk = " + result2 + " m");


        assertEquals(14.86 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.3948 * Math.pow(10, -3), result2, DELTA1);

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


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt,  'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("wk = " + result2 + " m");


        assertEquals(20.31 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.8905 * Math.pow(10, -3), result2, DELTA1);

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


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd,  bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt,  'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("wk = " + result2 + " m");


        assertEquals(27.31 * Math.pow(10, -3), result1, DELTA);
        assertEquals(1.2097 * Math.pow(10, -3), result2, DELTA1);

    }
}


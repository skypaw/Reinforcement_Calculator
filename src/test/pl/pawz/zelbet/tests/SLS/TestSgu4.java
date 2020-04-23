package test.pl.pawz.zelbet.tests.SLS;

import org.junit.Test;
import pl.pawz.zelbet.SLS.Deflection;
import pl.pawz.zelbet.SLS.Scratch;


import static org.junit.Assert.assertEquals;

public class TestSgu4 {

    private double fCk = 30f;
    private double fYk = 500;

    private double hDimension = 0.6f;
    private double bDimension = 0.3f;
    private double hf = 0.0f;
    private double bEff = 0.00f; // maybe 0.3, not sure
    private double hft = 0.15f;
    private double bEfft = 0.5f;

    private double a1 = 0.05f;
    private double a2 = 0.05f;

    private double fi = 0.016f;
    private double alphaM = 0.104f;
    private double lEff = 6f;

    private int eS = 200000;
    private int rH = 50;

    private double cNom = 0.030f;
    private double fiSt = 0.008f;

    private static final double DELTA = 1.5e-4;
    private static final double DELTA1 = 1.5e-5;

    @Test
    public void testSixZeroLongOne() {

        double mEd = 0.25f;
        double mEk = 0.2f;
        double mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 0;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt, 'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("fc+m = " + result1a + " m");
        System.out.println("wk = " + result2 + " m");

        assertEquals(19.84 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.349 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixZeroLongTwo() {

        double mEd = 0.25f;
        double mEk = 0.25f;
        double mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 0;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt, 'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("fc+m = " + result1a + " m");
        System.out.println("wk = " + result2 + " m");

        assertEquals(20.1 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.349 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixSixLongOne() {

        double mEd = 0.25f;
        double mEk = 0.20f;
        double mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 6;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt, 'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("fc+m = " + result1a + " m");
        System.out.println("wk = " + result2 + " m");

        assertEquals(16.94 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.3332 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixSixLongTwo() {

        double mEd = 0.25f;
        double mEk = 0.25f;
        double mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 6;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt, 'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("fc+m = " + result1a + " m");
        System.out.println("wk = " + result2 + " m");

        assertEquals(17.17 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.3332 * Math.pow(10, -3), result2, DELTA1);


    }

    @Test
    public void testSixThreeLongOne() {

        double mEd = 0.25f;
        double mEk = 0.20f;
        double mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 3;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt, 'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("fc+m = " + result1a + " m");
        System.out.println("wk = " + result2 + " m");

        assertEquals(18.10 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.2798 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixThreeLongTwo() {

        double mEd = 0.25f;
        double mEk = 0.25f;
        double mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 3;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, 6, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt, 'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("fc+m = " + result1a + " m");
        System.out.println("wk = " + result2 + " m");

        assertEquals(18.34 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.3394 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testThreeSixLongOne() {

        double mEd = 0.25f;
        double mEk = 0.20f;
        double mEkLt = 0.2f;

        int rods1 = 3;
        int rods2 = 6;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt, 'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("fc+m = " + result1a + " m");
        System.out.println("wk = " + result2 + " m");

        assertEquals(28.68 * Math.pow(10, -3), result1, DELTA);
        assertEquals(1.0435 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testThreeSixLongTwo() {

        double mEd = 0.25f;
        double mEk = 0.25f;
        double mEkLt = 0.2f;

        int rods1 = 3;
        int rods2 = 6;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'L', fCk, rH, 'N', 28);
        double result1 = res1.resultsLong();
        double result1a = res1.resultsLongDeformation();

        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt, 'L');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("fc+m = " + result1a + " m");
        System.out.println("wk = " + result2 + " m");

        assertEquals(29.20 * Math.pow(10, -3), result1, DELTA);
        assertEquals(1.0435 * Math.pow(10, -3), result2, DELTA1);

    }

    // short time load

    @Test
    public void testSixZeroShortOne() {

        double mEd = 0.25f;
        double mEk = 0.20f;
        double mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 0;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt, 'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("wk = " + result2 + " m");


        assertEquals(13.61 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.3015 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixZeroShortTwo() {

        double mEd = 0.25f;
        double mEk = 0.25f;
        double mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 0;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt, 'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("wk = " + result2 + " m");


        assertEquals(17.73 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.4102 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixSixShortOne() {

        double mEd = 0.25f;
        double mEk = 0.20f;
        double mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 6;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt, 'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("wk = " + result2 + " m");


        assertEquals(13.11 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.2990 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixSixShortTwo() {

        double mEd = 0.25f;
        double mEk = 0.25f;
        double mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 6;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt, 'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("wk = " + result2 + " m");


        assertEquals(17.09 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.4070 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixThreeShortOne() {

        double mEd = 0.25f;
        double mEk = 0.20f;
        double mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 3;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt, 'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("wk = " + result2 + " m");


        assertEquals(13.34 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.300 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testSixThreeShortTwo() {

        double mEd = 0.25f;
        double mEk = 0.25f;
        double mEkLt = 0.2f;

        int rods1 = 6;
        int rods2 = 3;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt, 'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("wk = " + result2 + " m");


        assertEquals(17.38 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.4083 * Math.pow(10, -3), result2, DELTA1);

    }

    @Test
    public void testThreeSixShortOne() {

        double mEd = 0.25f;
        double mEk = 0.2f;
        double mEkLt = 0.2f;

        int rods1 = 3;
        int rods2 = 6;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt, 'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("wk = " + result2 + " m");


        assertEquals(23.45 * Math.pow(10, -3), result1, DELTA);
        assertEquals(0.9162 * Math.pow(10, -3), result2, DELTA1);

    }


    @Test
    public void testThreeSixShortTwo() {

        double mEd = 0.25f;
        double mEk = 0.25f;
        double mEkLt = 0.2f;

        int rods1 = 3;
        int rods2 = 6;


        double as1 = Math.pow(fi * 0.5, 2) * Math.PI * rods1;
        double as2 = Math.pow(fi * 0.5, 2) * Math.PI * rods2;
        System.out.println(as1);


        Deflection res1 = new Deflection(lEff, mEkLt, mEk, alphaM, mEd, bDimension, hDimension, hf, hft, bEff, bEfft, a1, a2, as1, as2, 'S', fCk, rH, 'N', 28);
        double result1 = res1.resultsShort();


        Scratch res2 = new Scratch(cNom, fiSt, fi, rods1, fCk, rH, 28, 'N', bDimension, bEff, bEfft, hDimension, hf, hft, a1, a2, as1, as2, mEk, mEkLt, 'S');
        double result2 = res2.wK();

        System.out.println(res1.iI);
        System.out.println(res1.iII);

        System.out.println("fc = " + result1 + " m");
        System.out.println("wk = " + result2 + " m");


        assertEquals(30.72 * Math.pow(10, -3), result1, DELTA);
        assertEquals(1.2418 * Math.pow(10, -3), result2, DELTA1);

    }
}


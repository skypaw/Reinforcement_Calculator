package test.pl.pawz.zelbet.tests.ULS;

import org.junit.Test;
import pl.pawz.zelbet.ULS.BendingBeamT;

import static org.junit.Assert.assertEquals;

public class BendingBeamTTest {


    private double fCk = 25;

    private double fYk = 500;

    private double bEff = 0.9f;
    private double bW = 0.30f;
    private double a1 = 0.05f;
    private double a2 = 0.05f;
    private double h = 0.6f;
    private double hF = 0.12f;


    private static final double DELTA = 1e-6;

    @Test
    public void test50() {

        double mEd = 0.05f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(2.10177 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test100() {

        double mEd = 0.1f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(4.22574 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test200() {

        double mEd = 0.2f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(8.54313 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test300() {

        double mEd = 0.3f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(12.95843 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test400() {

        double mEd = 0.4f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(17.47861 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test500() {

        double mEd = 0.5f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(22.11151 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test600() {

        double mEd = 0.6f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(26.866 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test700() {

        double mEd = 0.7f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(31.75227 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test800() {

        double mEd = 0.8f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(36.78181 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test900() {

        double mEd = 0.9f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(41.96808 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test945() {

        double mEd = 0.945f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(44.35710 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test950() {

        double mEd = 0.950f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(44.62522 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1000() {

        double mEd = 1.0f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(47.38551 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1100() {

        double mEd = 1.1f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(53.42352 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1200() {

        double mEd = 1.2f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(60.43658 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1300() {

        double mEd = 1.3f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(66.12402 * Math.pow(10, -4), result1, DELTA);
        assertEquals(3.11006 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1400() {

        double mEd = 1.4f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(70.72401 * Math.pow(10, -4), result1, DELTA);
        assertEquals(7.71006 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1500() {

        double mEd = 1.5f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(75.32401 * Math.pow(10, -4), result1, DELTA);
        assertEquals(12.31005 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1600() {

        double mEd = 1.6f;

        BendingBeamT res = new BendingBeamT(mEd, fCk, fYk, bW, bEff, h, hF, a1, a2);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(79.92400 * Math.pow(10, -4), result1, DELTA);
        assertEquals(16.91005 * Math.pow(10, -4), result2, DELTA);
    }
}

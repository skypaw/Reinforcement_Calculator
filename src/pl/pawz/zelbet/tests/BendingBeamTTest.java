package pl.pawz.zelbet.tests;

import org.junit.Test;
import pl.pawz.zelbet.ULS.BendingBeamT;

import static org.junit.Assert.assertEquals;

public class BendingBeamTTest {


    private float fCd = 17.857f;
    private double epsilonCu3 = 0.0035;
    private double lambdaConcrete = 0.8;
    private double etaConcrete = 1;
    private double fYd = 434.7826;
    private int E_S = 200000;
    private float bEff = 0.9f;
    private float bW = 0.30f;
    private float a2 = 0.05f;
    private double dDimension = 0.55;
    private float hF = 0.12f;


    private static final double DELTA = 1e-6;

    @Test
    public void test50() {

        float mEd = 0.05f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(2.10177 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test100() {

        float mEd = 0.1f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(4.22574 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test200() {

        float mEd = 0.2f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(8.54313 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test300() {

        float mEd = 0.3f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(12.95843 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test400() {

        float mEd = 0.4f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(17.47861 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test500() {

        float mEd = 0.5f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(22.11151 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test600() {

        float mEd = 0.6f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(26.866 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test700() {

        float mEd = 0.7f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(31.75227 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test800() {

        float mEd = 0.8f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(36.78181 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test900() {

        float mEd = 0.9f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(41.96808 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test945() {

        float mEd = 0.945f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(44.35710 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test950() {

        float mEd = 0.950f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(44.62522 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1000() {

        float mEd = 1.0f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(47.38551 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1100() {

        float mEd = 1.1f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(53.42352 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1200() {

        float mEd = 1.2f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(60.43658 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1300() {

        float mEd = 1.3f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(66.12402 * Math.pow(10, -4), result1, DELTA);
        assertEquals(3.11006 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1400() {

        float mEd = 1.4f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(70.72401 * Math.pow(10, -4), result1, DELTA);
        assertEquals(7.71006 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1500() {

        float mEd = 1.5f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(75.32401 * Math.pow(10, -4), result1, DELTA);
        assertEquals(12.31005 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1600() {

        float mEd = 1.6f;

        BendingBeamT res = new BendingBeamT(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bW, bEff, hF, a2, dDimension);
        double result1 = res.resultsBendingT()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingT()[1];
        System.out.println(result2);

        assertEquals(79.92400 * Math.pow(10, -4), result1, DELTA);
        assertEquals(16.91005 * Math.pow(10, -4), result2, DELTA);
    }
}

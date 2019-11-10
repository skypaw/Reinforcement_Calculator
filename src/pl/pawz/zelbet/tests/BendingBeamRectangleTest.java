package pl.pawz.zelbet.tests;

import org.junit.Test;
import pl.pawz.zelbet.ULS.BendingBeamRectangle;

import static org.junit.Assert.assertEquals;

public class BendingBeamRectangleTest {

    private float fCd = 17.857f;
    private double epsilonCu3 = 0.0035;
    private double lambdaConcrete = 0.8;
    private double etaConcrete = 1;
    private double fYd = 434.7826;
    private int E_S = 200000;
    private float bDimension = 0.30f;
    private float a2 = 0.05f;
    private double dDimension = 0.55f;


    private static final double DELTA = 1e-6;

    @Test
    public void test50() {

        float mEd = 0.05f;

        BendingBeamRectangle res = new BendingBeamRectangle(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bDimension, a2, dDimension);
        double result1 = res.resultsBendingBeamRectangle()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingBeamRectangle()[1];
        System.out.println(result2);

        assertEquals(2.1242 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test100() {

        float mEd = 0.1f;

        BendingBeamRectangle res = new BendingBeamRectangle(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bDimension, a2, dDimension);
        double result1 = res.resultsBendingBeamRectangle()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingBeamRectangle()[1];
        System.out.println(result2);

        assertEquals(4.31948 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }


    @Test
    public void test200() {

        float mEd = 0.2f;

        BendingBeamRectangle res = new BendingBeamRectangle(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bDimension, a2, dDimension);
        double result1 = res.resultsBendingBeamRectangle()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingBeamRectangle()[1];
        System.out.println(result2);

        assertEquals(8.95535 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test305() {

        float mEd = 0.305f;

        BendingBeamRectangle res = new BendingBeamRectangle(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bDimension, a2, dDimension);
        double result1 = res.resultsBendingBeamRectangle()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingBeamRectangle()[1];
        System.out.println(result2);

        assertEquals(14.2535 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test455() {

        float mEd = 0.455f;

        BendingBeamRectangle res = new BendingBeamRectangle(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bDimension, a2, dDimension);
        double result1 = res.resultsBendingBeamRectangle()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingBeamRectangle()[1];
        System.out.println(result2);

        assertEquals(22.8946 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test600() {

        float mEd = 0.6f;

        BendingBeamRectangle res = new BendingBeamRectangle(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bDimension, a2, dDimension);
        double result1 = res.resultsBendingBeamRectangle()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingBeamRectangle()[1];
        System.out.println(result2);

        assertEquals(33.2458 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test735() {

        float mEd = 0.735f;

        BendingBeamRectangle res = new BendingBeamRectangle(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bDimension, a2, dDimension);
        double result1 = res.resultsBendingBeamRectangle()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingBeamRectangle()[1];
        System.out.println(result2);

        assertEquals(39.5426 * Math.pow(10, -4), result1, DELTA);
        assertEquals(6.1 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test890() {

        float mEd = 0.890f;

        BendingBeamRectangle res = new BendingBeamRectangle(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bDimension, a2, dDimension);
        double result1 = res.resultsBendingBeamRectangle()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingBeamRectangle()[1];
        System.out.println(result2);

        assertEquals(46.67261 * Math.pow(10, -4), result1, DELTA);
        assertEquals(13.23 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test955() {

        float mEd = 0.955f;

        BendingBeamRectangle res = new BendingBeamRectangle(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, bDimension, a2, dDimension);
        double result1 = res.resultsBendingBeamRectangle()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingBeamRectangle()[1];
        System.out.println(result2);

        assertEquals(49.6626 * Math.pow(10, -4), result1, DELTA);
        assertEquals(16.22 * Math.pow(10, -4), result2, DELTA);
    }
}

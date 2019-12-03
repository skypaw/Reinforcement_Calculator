package pl.pawz.zelbet.Tests;

import org.junit.Test;
import pl.pawz.zelbet.ULS.BendingBeamRectangle;

import static org.junit.Assert.assertEquals;

public class BendingBeamRectangleTest {

    private double fCk = 25f;
    private double fYk = 500;
    private float hDimension = 0.6f;
    private float bDimension = 0.3f;
    private float a1 = 0.05f;
    private float a2 = 0.05f;


    private static final double DELTA = 1e-6;

    @Test
    public void test50() {

        float mEd = 0.05f;

        BendingBeamRectangle res = new BendingBeamRectangle(mEd, fCk, fYk, hDimension, bDimension, a1, a2);
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

        BendingBeamRectangle res = new BendingBeamRectangle(mEd, fCk, fYk, hDimension, bDimension, a1, a2);
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

        BendingBeamRectangle res = new BendingBeamRectangle(mEd, fCk, fYk, hDimension, bDimension, a1, a2);
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

        BendingBeamRectangle res = new BendingBeamRectangle(mEd, fCk, fYk, hDimension, bDimension, a1, a2);
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

        BendingBeamRectangle res = new BendingBeamRectangle(mEd, fCk, fYk, hDimension, bDimension, a1, a2);
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

        BendingBeamRectangle res = new BendingBeamRectangle(mEd, fCk, fYk, hDimension, bDimension, a1, a2);
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

        BendingBeamRectangle res = new BendingBeamRectangle(mEd, fCk, fYk, hDimension, bDimension, a1, a2);
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

        BendingBeamRectangle res = new BendingBeamRectangle(mEd, fCk, fYk, hDimension, bDimension, a1, a2);
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

        BendingBeamRectangle res = new BendingBeamRectangle(mEd, fCk, fYk, hDimension, bDimension, a1, a2);
        double result1 = res.resultsBendingBeamRectangle()[0];
        System.out.println(result1);
        double result2 = res.resultsBendingBeamRectangle()[1];
        System.out.println(result2);

        assertEquals(49.6626 * Math.pow(10, -4), result1, DELTA);
        assertEquals(16.22 * Math.pow(10, -4), result2, DELTA);
    }
}

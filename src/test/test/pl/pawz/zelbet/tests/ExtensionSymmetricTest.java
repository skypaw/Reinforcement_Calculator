package pl.pawz.zelbet.tests;

import org.junit.Test;
import pl.pawz.zelbet.ULS.ExtensionSymmetricReinforcement;

import static org.junit.Assert.assertEquals;

public class ExtensionSymmetricTest {

    private float nEd;
    private float mEd;
    private double aS1;
    private double aS2;
    private float h = 0.6f;
    private float b = 0.3f;
    private float a1 = 0.05f;
    private float a2 = 0.05f;
    private double fCk = 30;
    private double fYk = 500;


    private static final double DELTA = 1e-6;

    @Test
    public void test500and0() {
        nEd = 0.500f;
        mEd = 0;

        ExtensionSymmetricReinforcement res = new ExtensionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsExtensionSymmetric()[0];
        System.out.println(result1);
        double result2 = res.resultsExtensionSymmetric()[1];

        aS1 = 5.750034;
        aS2 = aS1;

        assertEquals(aS1 * Math.pow(10, -4), result1, DELTA);
        assertEquals(aS2 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test500and10() {
        nEd = 0.500f;
        mEd = 0.01f;


        ExtensionSymmetricReinforcement res = new ExtensionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsExtensionSymmetric()[0];
        System.out.println(result1);
        double result2 = res.resultsExtensionSymmetric()[1];

        aS1 = 6.136741;
        aS2 = aS1;

        assertEquals(aS1 * Math.pow(10, -4), result1, DELTA);
        assertEquals(aS2 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test500and75() {
        nEd = 0.500f;
        mEd = 0.075f;


        ExtensionSymmetricReinforcement res = new ExtensionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsExtensionSymmetric()[0];
        System.out.println(result1);
        double result2 = res.resultsExtensionSymmetric()[1];

        aS1 = 8.906260;
        aS2 = aS1;

        assertEquals(aS1 * Math.pow(10, -4), result1, DELTA);
        assertEquals(aS2 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test500and100() {
        nEd = 0.500f;
        mEd = 0.1f;


        ExtensionSymmetricReinforcement res = new ExtensionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsExtensionSymmetric()[0];
        System.out.println(result1);
        double result2 = res.resultsExtensionSymmetric()[1];

        aS1 = 10.04298;
        aS2 = aS1;

        assertEquals(aS1 * Math.pow(10, -4), result1, DELTA);
        assertEquals(aS2 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test50and200() {
        nEd = 0.05f;
        mEd = 0.2f;


        ExtensionSymmetricReinforcement res = new ExtensionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsExtensionSymmetric()[0];
        System.out.println(result1);
        double result2 = res.resultsExtensionSymmetric()[1];

        aS1 = 9.409347;
        aS2 = aS1;

        assertEquals(aS1 * Math.pow(10, -4), result1, DELTA);
        assertEquals(aS2 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test50and650() {
        nEd = 0.05f;
        mEd = 0.65f;


        ExtensionSymmetricReinforcement res = new ExtensionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsExtensionSymmetric()[0];
        System.out.println(result1);
        double result2 = res.resultsExtensionSymmetric()[1];

        aS1 = 30.14430;
        aS2 = aS1;

        assertEquals(aS1 * Math.pow(10, -4), result1, DELTA);
        assertEquals(aS2 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test50and1000() {
        nEd = 0.05f;
        mEd = 1.0f;


        ExtensionSymmetricReinforcement res = new ExtensionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsExtensionSymmetric()[0];
        System.out.println(result1);
        double result2 = res.resultsExtensionSymmetric()[1];

        aS1 = 46.29033;
        aS2 = aS1;

        assertEquals(aS1 * Math.pow(10, -4), result1, DELTA);
        assertEquals(aS2 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5and1500() {
        nEd = 0.005f;
        mEd = 1.5f;


        ExtensionSymmetricReinforcement res = new ExtensionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsExtensionSymmetric()[0];
        System.out.println(result1);
        double result2 = res.resultsExtensionSymmetric()[1];

        aS1 = 68.83768;
        aS2 = aS1;

        assertEquals(aS1 * Math.pow(10, -4), result1, DELTA);
        assertEquals(aS2 * Math.pow(10, -4), result2, DELTA);
    }


}

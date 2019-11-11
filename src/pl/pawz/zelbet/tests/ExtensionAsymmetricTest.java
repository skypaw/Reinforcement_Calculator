package pl.pawz.zelbet.tests;

import org.junit.Test;
import pl.pawz.zelbet.ULS.ExtensionAsymmetricReinforcement;

import static org.junit.Assert.assertEquals;

public class ExtensionAsymmetricTest {

    private float nEd;
    private float mEd;
    private double aS1;
    private double aS2;

    private static final double DELTA = 1e-6;

    @Test
    public void test500and0() {
        nEd = 0.500f;
        mEd = 0;


        ExtensionAsymmetricReinforcement res = new ExtensionAsymmetricReinforcement(nEd, mEd, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.030843, 0.339273, 0.131966);
        double result1 = res.resultsExtensionAsymmetric()[0];
        System.out.println(result1);
        double result2 = res.resultsExtensionAsymmetric()[1];

        aS1 = 5.750034;
        aS2 = 5.750034;

        assertEquals(aS1 * Math.pow(10, -4), result1, DELTA);
        assertEquals(aS2 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test500and10() {
        nEd = 0.500f;
        mEd = 0.01f;


        ExtensionAsymmetricReinforcement res = new ExtensionAsymmetricReinforcement(nEd, mEd, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.030843, 0.339273, 0.131966);
        double result1 = res.resultsExtensionAsymmetric()[0];
        System.out.println(result1);
        double result2 = res.resultsExtensionAsymmetric()[1];

        aS1 = 6.210037;
        aS2 = 5.290032;

        assertEquals(aS1 * Math.pow(10, -4), result1, DELTA);
        assertEquals(aS2 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test500and75() {
        nEd = 0.500f;
        mEd = 0.075f;


        ExtensionAsymmetricReinforcement res = new ExtensionAsymmetricReinforcement(nEd, mEd, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.030843, 0.339273, 0.131966);
        double result1 = res.resultsExtensionAsymmetric()[0];
        System.out.println(result1);
        double result2 = res.resultsExtensionAsymmetric()[1];

        aS1 = 9.200055;
        aS2 = 2.300014;

        assertEquals(aS1 * Math.pow(10, -4), result1, DELTA);
        assertEquals(aS2 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test500and100() {
        nEd = 0.500f;
        mEd = 0.1f;


        ExtensionAsymmetricReinforcement res = new ExtensionAsymmetricReinforcement(nEd, mEd, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.030843, 0.339273, 0.131966);
        double result1 = res.resultsExtensionAsymmetric()[0];
        System.out.println(result1);
        double result2 = res.resultsExtensionAsymmetric()[1];

        aS1 = 10.29313;
        aS2 = 1.800000;

        assertEquals(aS1 * Math.pow(10, -4), result1, DELTA);
        assertEquals(aS2 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test50and200() {
        nEd = 0.05f;
        mEd = 0.2f;


        ExtensionAsymmetricReinforcement res = new ExtensionAsymmetricReinforcement(nEd, mEd, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.030843, 0.339273, 0.131966);
        double result1 = res.resultsExtensionAsymmetric()[0];
        System.out.println(result1);
        double result2 = res.resultsExtensionAsymmetric()[1];

        aS1 = 9.407365;
        aS2 = 1.800000;

        assertEquals(aS1 * Math.pow(10, -4), result1, DELTA);
        assertEquals(aS2 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test50and650() {
        nEd = 0.05f;
        mEd = 0.65f;


        ExtensionAsymmetricReinforcement res = new ExtensionAsymmetricReinforcement(nEd, mEd, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.030843, 0.339273, 0.131966);
        double result1 = res.resultsExtensionAsymmetric()[0];
        System.out.println(result1);
        double result2 = res.resultsExtensionAsymmetric()[1];

        aS1 = 33.83880;
        aS2 = 1.800000;

        assertEquals(aS1 * Math.pow(10, -4), result1, DELTA);
        assertEquals(aS2 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test50and1000() {
        nEd = 0.05f;
        mEd = 1.0f;


        ExtensionAsymmetricReinforcement res = new ExtensionAsymmetricReinforcement(nEd, mEd, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.030843, 0.339273, 0.131966);
        double result1 = res.resultsExtensionAsymmetric()[0];
        System.out.println(result1);
        double result2 = res.resultsExtensionAsymmetric()[1];

        aS1 = 53.45499;
        aS2 = 12.17093;

        assertEquals(aS1 * Math.pow(10, -4), result1, DELTA);
        assertEquals(aS2 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5and1500() {
        nEd = 0.005f;
        mEd = 1.5f;


        ExtensionAsymmetricReinforcement res = new ExtensionAsymmetricReinforcement(nEd, mEd, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.030843, 0.339273, 0.131966);
        double result1 = res.resultsExtensionAsymmetric()[0];
        System.out.println(result1);
        double result2 = res.resultsExtensionAsymmetric()[1];

        aS1 = 75.937610;
        aS2 = 35.68857;

        assertEquals(aS1 * Math.pow(10, -4), result1, DELTA);
        assertEquals(aS2 * Math.pow(10, -4), result2, DELTA);
    }


}

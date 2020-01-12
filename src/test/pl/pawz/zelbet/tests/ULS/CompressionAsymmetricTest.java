package pl.pawz.zelbet.tests.ULS;

import org.junit.Test;
import pl.pawz.zelbet.ULS.CompressionAsymmetricReinforcement;

import static org.junit.Assert.assertEquals;


public class CompressionAsymmetricTest {
    double fCk = 30;
    double fYk = 500;
    float h = 0.6f;
    float b = 0.3f;
    float a1 = 0.05f;
    float a2 = 0.05f;

    private static final double DELTA = 1e-6;

    @Test
    public void test5and10() {
        float mEd = 0.01f;
        float nEd = 0.005f;

        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];
        System.out.println(result2);

        assertEquals(0.219840 * Math.pow(10, -4), result1, DELTA);
        assertEquals(1.8 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test100and100() {
        float mEd = 0.1f;
        float nEd = 0.1f;

        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];
        System.out.println(result2);

        assertEquals(3.102643 * Math.pow(10, -4), result1, DELTA);
        assertEquals(1.8 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1000and500() {
        float mEd = 0.5f;
        float nEd = 1f;

        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];
        System.out.println(result2);

        assertEquals(17.95217 * Math.pow(10, -4), result1, DELTA);
        assertEquals(1.8 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1000and750() {
        float mEd = 0.75f;
        float nEd = 1f;

        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];
        System.out.println(result2);

        assertEquals(29.87916 * Math.pow(10, -4), result1, DELTA);
        assertEquals(12.74813 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test3500and500() {
        float mEd = 0.5f;
        float nEd = 3.5f;

        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];
        System.out.println(result2);

        assertEquals(4.025000 * Math.pow(10, -4), result1, DELTA);
        assertEquals(21.79357 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test3500and350() {
        float mEd = 0.350f;
        float nEd = 3.5f;

        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];
        System.out.println(result2);

        assertEquals(4.025 * Math.pow(10, -4), result1, DELTA);
        assertEquals(12.94635 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and300() {
        float mEd = 0.3f;
        float nEd = 5f;

        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];
        System.out.println(result2);

        assertEquals(5.75 * Math.pow(10, -4), result1, DELTA);
        assertEquals(26.7423 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and250() {
        float mEd = 0.25f;
        float nEd = 5f;

        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];
        System.out.println(result2);

        assertEquals(5.75 * Math.pow(10, -4), result1, DELTA);
        assertEquals(24.60759 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and225() {
        float mEd = 0.225f;
        float nEd = 5f;

        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];
        System.out.println(result2);

        assertEquals(4.578443 * Math.pow(10, -4), result1, DELTA);
        assertEquals(23.49285 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and100() {
        float mEd = 0.1f;
        float nEd = 5f;

        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];
        System.out.println(result2);

        assertEquals(12.95305 * Math.pow(10, -4), result1, DELTA);
        assertEquals(18.66734 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and25() {
        float mEd = 0.025f;
        float nEd = 5f;

        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];
        System.out.println(result2);

        assertEquals(15.58093 * Math.pow(10, -4), result1, DELTA);
        assertEquals(17.00950 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and0() {
        float mEd = 0.001f;
        float nEd = 5f;

        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];
        System.out.println(result2);

        assertEquals(16.32650 * Math.pow(10, -4), result1, DELTA);
        assertEquals(16.32655 * Math.pow(10, -4), result2, DELTA);
    }


}

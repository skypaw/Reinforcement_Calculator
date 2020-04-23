package test.pl.pawz.zelbet.tests.ULS;

import org.junit.Test;
import pl.pawz.zelbet.ULS.CompressionAsymmetricReinforcement;

import static org.junit.Assert.assertEquals;


public class CompressionAsymmetricTest {
    double fCk = 30;
    double fYk = 500;
    double h = 0.6f;
    double b = 0.3f;
    double a1 = 0.05f;
    double a2 = 0.05f;

    private static final double DELTA = 1e-6;

    @Test
    public void test5and10() {
        double mEd = 0.01f;
        double nEd = 0.005f;

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
        double mEd = 0.1f;
        double nEd = 0.1f;

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
        double mEd = 0.5f;
        double nEd = 1f;

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
        double mEd = 0.75f;
        double nEd = 1f;

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
        double mEd = 0.5f;
        double nEd = 3.5f;

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
        double mEd = 0.350f;
        double nEd = 3.5f;

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
        double mEd = 0.3f;
        double nEd = 5f;

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
        double mEd = 0.25f;
        double nEd = 5f;

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
        double mEd = 0.225f;
        double nEd = 5f;

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
        double mEd = 0.1f;
        double nEd = 5f;

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
        double mEd = 0.025f;
        double nEd = 5f;

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
        double mEd = 0.001f;
        double nEd = 5f;

        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];
        System.out.println(result2);

        assertEquals(16.32650 * Math.pow(10, -4), result1, DELTA);
        assertEquals(16.32655 * Math.pow(10, -4), result2, DELTA);
    }


}

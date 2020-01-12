package pl.pawz.zelbet.tests.ULS;

import org.junit.Test;
import pl.pawz.zelbet.ULS.CompressionSymmetricReinforcement;

import static org.junit.Assert.assertEquals;


public class CompressionSymmetricTest {

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

        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(0.329204 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0.329204 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test100and100() {
        float mEd = 0.1f;
        float nEd = 0.1f;

        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(3.10107 * Math.pow(10, -4), result1, DELTA);
        assertEquals(3.10107 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1000and500() {
        float mEd = 0.5f;
        float nEd = 1f;

        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(12.77754 * Math.pow(10, -4), result1, DELTA);
        assertEquals(12.77754 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1000and750() {
        float mEd = 0.75f;
        float nEd = 1f;

        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(24.27754 * Math.pow(10, -4), result1, DELTA);
        assertEquals(24.27754 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test3500and500() {
        float mEd = 0.5f;
        float nEd = 3.5f;

        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(21.21958 * Math.pow(10, -4), result1, DELTA);
        assertEquals(21.21958 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test3500and350() {
        float mEd = 0.35f;
        float nEd = 3.5f;

        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(13.02856 * Math.pow(10, -4), result1, DELTA);
        assertEquals(13.02856 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and300() {
        float mEd = 0.3f;
        float nEd = 5f;

        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(26.57117 * Math.pow(10, -4), result1, DELTA);
        assertEquals(26.57117 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and250() {
        float mEd = 0.25f;
        float nEd = 5f;

        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(24.29538 * Math.pow(10, -4), result1, DELTA);
        assertEquals(24.29538 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and225() {
        float mEd = 0.225f;
        float nEd = 5f;

        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(23.18530 * Math.pow(10, -4), result1, DELTA);
        assertEquals(23.18530 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and100() {
        float mEd = 0.1f;
        float nEd = 5f;

        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(17.73990 * Math.pow(10, -4), result1, DELTA);
        assertEquals(17.73990 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and25() {
        float mEd = 0.025f;
        float nEd = 5f;

        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(16.32285 * Math.pow(10, -4), result1, DELTA);
        assertEquals(16.32285 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and0() {
        float mEd = 0.001f;
        float nEd = 5f;

        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(nEd, mEd, fCk, fYk, b, h, a1, a2);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(16.32285 * Math.pow(10, -4), result1, DELTA);
        assertEquals(16.32285 * Math.pow(10, -4), result2, DELTA);
    }


}

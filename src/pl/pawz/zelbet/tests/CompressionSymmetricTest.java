package pl.pawz.zelbet.tests;

import org.junit.Test;
import pl.pawz.zelbet.ULS.CompressionSymmetricReinforcement;

import static org.junit.Assert.assertEquals;


public class CompressionSymmetricTest {

    private static final double DELTA = 1e-7;

    @Test
    public void test5and10() {
        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(0.005f, 0.01f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(0.329204 * Math.pow(10, -4), result1, DELTA);
        assertEquals(0.329204 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test100and100() {
        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(0.1f, 0.1f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(3.10107 * Math.pow(10, -4), result1, DELTA);
        assertEquals(3.10107 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1000and500() {
        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(1f, 0.5f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(12.77754 * Math.pow(10, -4), result1, DELTA);
        assertEquals(12.77754 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1000and750() {
        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(1f, 0.75f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(24.27754 * Math.pow(10, -4), result1, DELTA);
        assertEquals(24.27754 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test3500and500() {
        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(3.5f, 0.5f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(21.21958 * Math.pow(10, -4), result1, DELTA);
        assertEquals(21.21958 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test3500and350() {
        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(3.5f, 0.35f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(13.02856 * Math.pow(10, -4), result1, DELTA);
        assertEquals(13.02856 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and300() {
        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(5f, 0.3f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(26.57117 * Math.pow(10, -4), result1, DELTA);
        assertEquals(26.57117 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and250() {
        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(5f, 0.25f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(24.29538 * Math.pow(10, -4), result1, DELTA);
        assertEquals(24.29538 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and225() {
        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(5f, 0.225f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(23.18530 * Math.pow(10, -4), result1, DELTA);
        assertEquals(23.18530 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and100() {
        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(5f, 0.1f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(17.73990 * Math.pow(10, -4), result1, DELTA);
        assertEquals(17.73990 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and25() {
        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(5f, 0.025f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(16.32285 * Math.pow(10, -4), result1, DELTA);
        assertEquals(16.32285 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and0() {
        CompressionSymmetricReinforcement res = new CompressionSymmetricReinforcement(5f, 0.001f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionSymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionSymmetricReinforcement()[1];

        assertEquals(16.32285 * Math.pow(10, -4), result1, DELTA);
        assertEquals(16.32285 * Math.pow(10, -4), result2, DELTA);
    }


}

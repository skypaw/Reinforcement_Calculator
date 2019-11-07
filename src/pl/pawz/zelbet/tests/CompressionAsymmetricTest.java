package pl.pawz.zelbet.tests;

import org.junit.Test;
import pl.pawz.zelbet.ULS.CompressionAsymmetricReinforcement;

import static org.junit.Assert.assertEquals;


public class CompressionAsymmetricTest {

    private static final double DELTA = 1e-7;

    @Test
    public void test5and10() {
        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(0.005f, 0.01f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];

        assertEquals(0.219840 * Math.pow(10, -4), result1, DELTA);
        assertEquals(1.8 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test100and100() {
        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(0.1f, 0.1f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];

        assertEquals(3.102643 * Math.pow(10, -4), result1, DELTA);
        assertEquals(1.8* Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1000and500() {
        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(1f, 0.5f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];

        assertEquals(17.95217 * Math.pow(10, -4), result1, DELTA);
        assertEquals(1.8 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test1000and750() {
        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(1f, 0.75f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];

        assertEquals(29.87916* Math.pow(10, -4), result1, DELTA);
        assertEquals(12.74813 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test3500and500() {
        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(3.5f, 0.5f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];

        assertEquals(4.025000 * Math.pow(10, -4), result1, DELTA);
        assertEquals(21.79357 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test3500and350() {
        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(3.5f, 0.35f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];

        assertEquals(4.025 * Math.pow(10, -4), result1, DELTA);
        assertEquals(12.94635 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and300() {
        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(5f, 0.3f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];

        assertEquals(5.75 * Math.pow(10, -4), result1, DELTA);
        assertEquals(26.7423 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and250() {
        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(5f, 0.25f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];

        assertEquals(5.75 * Math.pow(10, -4), result1, DELTA);
        assertEquals(24.60759 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and225() {
        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(5f, 0.225f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];

        assertEquals(4.578443 * Math.pow(10, -4), result1, DELTA);
        assertEquals(23.49285 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and100() {
        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(5f, 0.1f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];

        assertEquals(12.95305 * Math.pow(10, -4), result1, DELTA);
        assertEquals(18.66734 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and25() {
        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(5f, 0.025f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];

        assertEquals(15.58093 * Math.pow(10, -4), result1, DELTA);
        assertEquals(17.00950 * Math.pow(10, -4), result2, DELTA);
    }

    @Test
    public void test5000and0() {
        CompressionAsymmetricReinforcement res = new CompressionAsymmetricReinforcement(5f, 0.001f, 0.0035, 0.00175, 21.43, 434.78, 1, 0.8, 0.55, 0.3f, 0.6f, 0.05f, 0.05f, 200000, 0.339273, 0.030843, 0.131996, 0.3, 1.332083);
        double result1 = res.resultsCompressionAsymmetricReinforcement()[0];
        System.out.println(result1);
        double result2 = res.resultsCompressionAsymmetricReinforcement()[1];

        assertEquals(16.32650 * Math.pow(10, -4), result1, DELTA);
        assertEquals(16.32655 * Math.pow(10, -4), result2, DELTA);
    }


}

package test.pl.pawz.zelbet.tests.Shearing;

import org.junit.Test;
import pl.pawz.zelbet.ULS.ShearingStirrups;

import static org.junit.Assert.assertEquals;

public class ShearingP2 {


    private double fCk = 30;
    private double fYk = 500;
    private double b = 0.30f;
    private double a1 = 0.05f;
    private double a2 = 0.05f;
    private double h = 0.6f;

    private double cotTheta = 2f;
    private double aSl = 0.001f;
    private double nS = 2;
    private double fiS = 6 * Math.pow(10, -3);


    double nEd = 0.00f;


    private static final double DELTA = 1e-3;

    @Test
    public void value() {

        double vEd = 0.0624f;
        double vEdRed = 0.052f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double valueVRdC = res.getVRdC();
        System.out.println(valueVRdC);
        double valueVRdMax = res.getVRdMax();
        System.out.println(valueVRdMax);

        assertEquals(0.089423, valueVRdC, 1e-5);
        assertEquals(0.672069, valueVRdMax, 1e-5);

    }

    @Test
    public void test92() {

        double vEd = 0.0924f;
        double vEdRed = 0.077f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);


    }

    @Test
    public void test134() {

        double vEd = 0.1344f;
        double vEdRed = 0.112f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test147() {

        double vEd = 0.1476f;
        double vEdRed = 0.123f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.198, result1, DELTA);
    }

    @Test
    public void test200() {

        double vEd = 0.2004f;
        double vEdRed = 0.167f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.146, result1, DELTA);
    }

    @Test
    public void test253() {

        double vEd = 0.2532f;
        double vEdRed = 0.211f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.115, result1, DELTA);
    }

    @Test
    public void test306() {

        double vEd = 0.306f;
        double vEdRed = 0.255f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.095, result1, DELTA);
    }

    @Test
    public void test358() {

        double vEd = 0.3588f;
        double vEdRed = 0.299f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.081, result1, DELTA);
    }

    @Test
    public void test398() {

        double vEd = 0.3984f;
        double vEdRed = 0.332f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.073, result1, DELTA);
    }

    @Test
    public void test451() {

        double vEd = 0.4512f;
        double vEdRed = 0.376f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.065, result1, DELTA);
    }

    @Test
    public void test504() {

        double vEd = 0.504f;
        double vEdRed = 0.420f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.058, result1, DELTA);
    }

    @Test
    public void test556() {

        double vEd = 0.5568f;
        double vEdRed = 0.464f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.052, result1, DELTA);
    }

    @Test
    public void test609() {

        double vEd = 0.6097f;
        double vEdRed = 0.508f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.048, result1, DELTA);
    }

    @Test
    public void test662() {

        double vEd = 0.6624f;
        double vEdRed = 0.552f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.044, result1, DELTA);
    }
}

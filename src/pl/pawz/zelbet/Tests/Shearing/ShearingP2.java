package pl.pawz.zelbet.Tests.Shearing;

import org.junit.Test;
import pl.pawz.zelbet.ULS.ShearingStirrups;

import static org.junit.Assert.assertEquals;

public class ShearingP2 {


    private float fCk = 30;
    private double fYk = 500;
    private float b = 0.30f;
    private float a1 = 0.05f;
    private float a2 = 0.05f;
    private float h = 0.6f;

    private float cotTheta = 2f;
    private float aSl = 0.001f;
    private float nS = 2;
    private double fiS = 6 * Math.pow(10, -3);


    float nEd = 0.00f;


    private static final double DELTA = 1e-3;

    @Test
    public void value() {

        float vEd = 0.0624f;
        float vEdRed = 0.052f;


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

        float vEd = 0.0924f;
        float vEdRed = 0.077f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);


    }

    @Test
    public void test134() {

        float vEd = 0.1344f;
        float vEdRed = 0.112f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test147() {

        float vEd = 0.1476f;
        float vEdRed = 0.123f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.198, result1, DELTA);
    }

    @Test
    public void test200() {

        float vEd = 0.2004f;
        float vEdRed = 0.167f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.146, result1, DELTA);
    }

    @Test
    public void test253() {

        float vEd = 0.2532f;
        float vEdRed = 0.211f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.115, result1, DELTA);
    }

    @Test
    public void test306() {

        float vEd = 0.306f;
        float vEdRed = 0.255f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.095, result1, DELTA);
    }

    @Test
    public void test358() {

        float vEd = 0.3588f;
        float vEdRed = 0.299f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.081, result1, DELTA);
    }

    @Test
    public void test398() {

        float vEd = 0.3984f;
        float vEdRed = 0.332f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.073, result1, DELTA);
    }

    @Test
    public void test451() {

        float vEd = 0.4512f;
        float vEdRed = 0.376f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.065, result1, DELTA);
    }

    @Test
    public void test504() {

        float vEd = 0.504f;
        float vEdRed = 0.420f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.058, result1, DELTA);
    }

    @Test
    public void test556() {

        float vEd = 0.5568f;
        float vEdRed = 0.464f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.052, result1, DELTA);
    }

    @Test
    public void test609() {

        float vEd = 0.6097f;
        float vEdRed = 0.508f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.048, result1, DELTA);
    }

    @Test
    public void test662() {

        float vEd = 0.6624f;
        float vEdRed = 0.552f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.044, result1, DELTA);
    }
}

package pl.pawz.zelbet.Tests.Shearing;

import org.junit.Test;
import pl.pawz.zelbet.ULS.ShearingStirrups;

import static org.junit.Assert.assertEquals;

public class ShearingP5 {


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


    float nEd = 0.9f;


    private static final double DELTA = 1e-3;


    @Test
    public void value() {

        float vEd = 0.0624f;
        float vEdRed = 0.052f;


        ShearingStirrups res = new ShearingStirrups(h,b,a1,fCk,fYk,nEd,vEd,vEdRed,aSl,nS,fiS,cotTheta);
        double valueVRdC = res.getVRdC();
        System.out.println(valueVRdC);
        double valueVRdMax = res.getVRdMax();
        System.out.println(valueVRdMax);

        assertEquals(0.195494 ,valueVRdC, 1e-5);
        assertEquals(0.672069 ,valueVRdMax, 1e-5);

    }

    @Test
    public void test147() {

        float vEd = 0.147072f;
        float vEdRed = 0.12256f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test148() {

        float vEd = 0.148f;
        float vEdRed = 0.123333f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test232() {

        float vEd = 0.232247f;
        float vEdRed = 0.193539f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test234() {

        float vEd = 0.234593f;
        float vEdRed = 0.195494f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test236() {

        float vEd = 0.236939f;
        float vEdRed = 0.197449f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.123, result1, DELTA);
    }

    @Test
    public void test246() {

        float vEd = 0.246f;
        float vEdRed = 0.205f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.119, result1, DELTA);
    }

    @Test
    public void test255() {

        float vEd = 0.2556f;
        float vEdRed = 0.213f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.114, result1, DELTA);
    }

    @Test
    public void test303() {

        float vEd = 0.3036f;
        float vEdRed = 0.253f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.096, result1, DELTA);
    }

    @Test
    public void test351() {

        float vEd = 0.3516f;
        float vEdRed = 0.293f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.083, result1, DELTA);
    }

    @Test
    public void test398() {

        float vEd = 0.399f;
        float vEdRed = 0.333f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.073, result1, DELTA);
    }

    @Test
    public void test447() {

        float vEd = 0.4476f;
        float vEdRed = 0.373f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.065, result1, DELTA);
    }

    @Test
    public void test507() {

        float vEd = 0.5076f;
        float vEdRed = 0.423f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.058, result1, DELTA);
    }

    @Test
    public void test556() {

        float vEd = 0.5556f;
        float vEdRed = 0.463f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.053, result1, DELTA);
    }

    @Test
    public void test609() {

        float vEd = 0.6036f;
        float vEdRed = 0.503f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.048, result1, DELTA);
    }

    @Test
    public void test663() {

        float vEd = 0.6636f;
        float vEdRed = 0.553f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.044, result1, DELTA);
    }

    @Test
    public void test672() {

        float vEd = 0.6732f;
        float vEdRed = 0.561f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.0, result1, DELTA);
    }
}

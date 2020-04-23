package test.pl.pawz.zelbet.tests.Shearing;

import org.junit.Test;
import pl.pawz.zelbet.ULS.ShearingStirrups;

import static org.junit.Assert.assertEquals;

public class ShearingP3 {


    private double fCk = 30;
    private double fYk = 500;
    private double b = 0.30f;
    private double a1 = 0.05f;
    private double a2 = 0.05f;
    private double h = 0.6f;

    private double cotTheta = 2f;
    private double aSl = 0.0035f;
    private double nS = 2;
    private double fiS = 6 * Math.pow(10, -3);


    double nEd = 0.00f;


    private static final double DELTA = 1e-3;

    @Test
    public void value() {

        double vEd = 0.0624f;
        double vEdRed = 0.052f;


        ShearingStirrups res = new ShearingStirrups(h,b,a1,fCk,fYk,nEd,vEd,vEdRed,aSl,nS,fiS,cotTheta);
        double valueVRdC = res.getVRdC();
        System.out.println(valueVRdC);
        double valueVRdMax = res.getVRdMax();
        System.out.println(valueVRdMax);

        assertEquals(0.133133 ,valueVRdC, 1e-5);
        assertEquals(0.672069 ,valueVRdMax, 1e-5);

    }


    @Test
    public void test146() {

        double vEd = 0.1464f;
        double vEdRed = 0.122f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test159() {

        double vEd = 0.1596f;
        double vEdRed = 0.133f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test161() {

        double vEd = 0.161357f;
        double vEdRed = 0.134464f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.181, result1, DELTA);
    }

    @Test
    public void test255() {

        double vEd = 0.2556f;
        double vEdRed = 0.213f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.114, result1, DELTA);
    }

    @Test
    public void test303() {

        double vEd = 0.3036f;
        double vEdRed = 0.253f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.096, result1, DELTA);
    }

    @Test
    public void test351() {

        double vEd = 0.3516f;
        double vEdRed = 0.293f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.083, result1, DELTA);
    }

    @Test
    public void test398() {

        double vEd = 0.399f;
        double vEdRed = 0.333f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.073, result1, DELTA);
    }

    @Test
    public void test447() {

        double vEd = 0.4476f;
        double vEdRed = 0.373f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.065, result1, DELTA);
    }

    @Test
    public void test507() {

        double vEd = 0.5076f;
        double vEdRed = 0.423f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.058, result1, DELTA);
    }

    @Test
    public void test556() {

        double vEd = 0.5556f;
        double vEdRed = 0.463f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.053, result1, DELTA);
    }

    @Test
    public void test609() {

        double vEd = 0.6036f;
        double vEdRed = 0.503f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.048, result1, DELTA);
    }

    @Test
    public void test663() {

        double vEd = 0.6636f;
        double vEdRed = 0.553f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.044, result1, DELTA);
    }

    @Test
    public void test672() {

        double vEd = 0.6732f;
        double vEdRed = 0.561f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.0, result1, DELTA);
    }
}

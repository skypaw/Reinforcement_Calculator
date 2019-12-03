package pl.pawz.zelbet.tests.shearingstirrups;

import org.junit.Test;
import pl.pawz.zelbet.ULS.ShearingBendRods;

import static org.junit.Assert.assertEquals;

public class ShearingP8 {


    private float fCk = 30;
    private double fYk = 500;
    private float b = 0.30f;
    private float a1 = 0.05f;
    private float a2 = 0.05f;
    private float h = 0.6f;

    private float cotTheta = 2f;
    private float aSl = 0.001f;
    private float nS1 = 2;
    private float nS2 = 1;

    private double fiS1 = 6 * Math.pow(10, -3);
    private double fiS2 = 12 * Math.pow(10, -3);


    float nEd = 0.0f;


    private static final double DELTA = 1e-3;


    @Test
    public void test140() {

        float vEd = 0.1404f;
        float vEdRed = 0.117f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test224() {

        float vEd = 0.2244f;
        float vEdRed = 0.187f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test241() {

        float vEd = 0.2412f;
        float vEdRed = 0.201f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test258() {

        float vEd = 0.258f;
        float vEdRed = 0.215f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.201, result1, DELTA);
    }

    @Test
    public void test274() {

        float vEd = 0.2748f;
        float vEdRed = 0.229f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.180, result1, DELTA);
    }

    @Test
    public void test304() {

        float vEd = 0.3084f;
        float vEdRed = 0.257f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.149, result1, DELTA);
    }

    @Test
    public void test358() {

        float vEd = 0.3588f;
        float vEdRed = 0.299f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.119, result1, DELTA);
    }

    @Test
    public void test392() {

        float vEd = 0.3924f;
        float vEdRed = 0.327f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.104, result1, DELTA);
    }

    @Test
    public void test442() {

        float vEd = 0.4428f;
        float vEdRed = 0.369f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.088, result1, DELTA);
    }

    @Test
    public void test510() {

        float vEd = 0.510f;
        float vEdRed = 0.425f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.074, result1, DELTA);
    }

    @Test
    public void test560() {

        float vEd = 0.5604f;
        float vEdRed = 0.467f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.065, result1, DELTA);
    }

    @Test
    public void test610() {

        float vEd = 0.6108f;
        float vEdRed = 0.509f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.059, result1, DELTA);
    }

    @Test
    public void test661() {

        float vEd = 0.6612f;
        float vEdRed = 0.551f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.053, result1, DELTA);
    }

    @Test
    public void test694() {

        float vEd = 0.6948f;
        float vEdRed = 0.579f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.05, result1, DELTA);
    }

    @Test
    public void test745() {

        float vEd = 0.7452f;
        float vEdRed = 0.621f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.046, result1, DELTA);
    }

    @Test
    public void test778() {

        float vEd = 0.7788f;
        float vEdRed = 0.649f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.044, result1, DELTA);
    }

    @Test
    public void test795() {

        float vEd = 0.7956f;
        float vEdRed = 0.663f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.043, result1, DELTA);
    }

    @Test
    public void test807() {

        float vEd = 0.807f;
        float vEdRed = 0.6725f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.0, result1, DELTA);
    }
}

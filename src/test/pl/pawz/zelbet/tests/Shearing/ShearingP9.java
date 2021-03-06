package test.pl.pawz.zelbet.tests.Shearing;

import org.junit.Test;
import pl.pawz.zelbet.ULS.ShearingBendRods;

import static org.junit.Assert.assertEquals;

public class ShearingP9 {


    private double fCk = 30;
    private double fYk = 500;
    private double b = 0.30f;
    private double a1 = 0.05f;
    private double a2 = 0.05f;
    private double h = 0.6f;

    private double cotTheta = 2f;
    private double aSl = 0.001f;
    private double nS1 = 2;
    private double nS2 = 2;

    private double fiS1 = 6 * Math.pow(10, -3);
    private double fiS2 = 12 * Math.pow(10, -3);


    double nEd = 0.0f;


    private static final double DELTA = 1e-3;

    @Test
    public void value() {

        double vEd = 0.0624f;
        double vEdRed = 0.052f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double valueVRdC = res.getVRdC();
        System.out.println(valueVRdC);
        double valueVRdMax = res.getVRdMax();
        System.out.println(valueVRdMax);

        assertEquals(0.089423 ,valueVRdC, 1e-5);
        assertEquals(0.806482 ,valueVRdMax, 1e-5);

    }

    @Test
    public void test140() {

        double vEd = 0.1404f;
        double vEdRed = 0.117f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test224() {

        double vEd = 0.2244f;
        double vEdRed = 0.187f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test241() {

        double vEd = 0.2412f;
        double vEdRed = 0.201f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test258() {

        double vEd = 0.258f;
        double vEdRed = 0.215f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test274() {

        double vEd = 0.2748f;
        double vEdRed = 0.229f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.213, result1, DELTA);
    }

    @Test
    public void test291() {

        double vEd = 0.2916f;
        double vEdRed = 0.243f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.200, result1, DELTA);
    }

    @Test
    public void test308() {

        double vEd = 0.3084f;
        double vEdRed = 0.257f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.189, result1, DELTA);
    }

    @Test
    public void test358() {

        double vEd = 0.3588f;
        double vEdRed = 0.299f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.163, result1, DELTA);
    }

    @Test
    public void test392() {

        double vEd = 0.3924f;
        double vEdRed = 0.327f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.149, result1, DELTA);
    }

    @Test
    public void test442() {

        double vEd = 0.4428f;
        double vEdRed = 0.369f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.132, result1, DELTA);
    }

    @Test
    public void test510() {

        double vEd = 0.510f;
        double vEdRed = 0.425f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.103, result1, DELTA);
    }

    @Test
    public void test560() {

        double vEd = 0.5604f;
        double vEdRed = 0.467f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.087, result1, DELTA);
    }

    @Test
    public void test610() {

        double vEd = 0.6108f;
        double vEdRed = 0.509f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.076, result1, DELTA);
    }

    @Test
    public void test661() {

        double vEd = 0.6612f;
        double vEdRed = 0.551f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.067, result1, DELTA);
    }

    @Test
    public void test694() {

        double vEd = 0.6948f;
        double vEdRed = 0.579f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.062, result1, DELTA);
    }

    @Test
    public void test745() {

        double vEd = 0.7452f;
        double vEdRed = 0.621f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.056, result1, DELTA);
    }

    @Test
    public void test778() {

        double vEd = 0.7788f;
        double vEdRed = 0.649f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.053, result1, DELTA);
    }

    @Test
    public void test795() {

        double vEd = 0.7956f;
        double vEdRed = 0.663f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.051, result1, DELTA);
    }

    @Test
    public void test807() {

        double vEd = 0.807f;
        double vEdRed = 0.6725f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.0, result1, DELTA);
    }
}

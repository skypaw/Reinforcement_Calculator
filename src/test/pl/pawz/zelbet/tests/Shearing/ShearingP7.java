package test.pl.pawz.zelbet.tests.Shearing;

import org.junit.Test;
import pl.pawz.zelbet.ULS.ShearingStirrups;

import static org.junit.Assert.assertEquals;

public class ShearingP7 {


    private double fCk = 30;
    private double fYk = 500;
    private double b = 0.30f;
    private double a1 = 0.05f;
    private double a2 = 0.05f;
    private double h = 0.6f;

    private double cotTheta = 2f;
    private double aSl = 0.001f;
    private double nS = 6;
    private double fiS = 6 * Math.pow(10, -3);


    double nEd = 0.25f;


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

        assertEquals(0.123798 ,valueVRdC, 1e-5);
        assertEquals(0.672069 ,valueVRdMax, 1e-5);

    }

    @Test
    public void test134() {

        double vEd = 0.1344f;
        double vEdRed = 0.112f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.413, result1, DELTA);
    }

    @Test
    public void test147() {

        double vEd = 0.147072f;
        double vEdRed = 0.12256f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.413, result1, DELTA);
    }

    @Test
    public void test148() {

        double vEd = 0.148557f;
        double vEdRed = 0.123798f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.413, result1, DELTA);
    }

    @Test
    public void test208() {

        double vEd = 0.2088f;
        double vEdRed = 0.174f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.413, result1, DELTA);
    }

    @Test
    public void test220() {

        double vEd = 0.2208f;
        double vEdRed = 0.184f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.397, result1, DELTA);
    }

    @Test
    public void test232() {

        double vEd = 0.2328f;
        double vEdRed = 0.194f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.376, result1, DELTA);
    }

    @Test
    public void test244() {

        double vEd = 0.2448f;
        double vEdRed = 0.204f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.358, result1, DELTA);
    }

    @Test
    public void test256() {

        double vEd = 0.2568f;
        double vEdRed = 0.214f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.341, result1, DELTA);
    }

    @Test
    public void test304() {

        double vEd = 0.3048f;
        double vEdRed = 0.254f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.287, result1, DELTA);
    }

    @Test
    public void test352() {

        double vEd = 0.3528f;
        double vEdRed = 0.294f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.248, result1, DELTA);
    }

    @Test
    public void test400() {

        double vEd = 0.4008f;
        double vEdRed = 0.334f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.219, result1, DELTA);
    }

    @Test
    public void test448() {

        double vEd = 0.4488f;
        double vEdRed = 0.374f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.195, result1, DELTA);
    }

    @Test
    public void test508() {

        double vEd = 0.5088f;
        double vEdRed = 0.424f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.172, result1, DELTA);
    }

    @Test
    public void test556() {

        double vEd = 0.5568f;
        double vEdRed = 0.464f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.157, result1, DELTA);
    }

    @Test
    public void test604() {

        double vEd = 0.6048f;
        double vEdRed = 0.504f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.145, result1, DELTA);
    }

    @Test
    public void test664() {

        double vEd = 0.6648f;
        double vEdRed = 0.554f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.132, result1, DELTA);
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

package pl.pawz.zelbet.tests.Shearing;

import org.junit.Test;
import pl.pawz.zelbet.ULS.ShearingStirrups;

import static org.junit.Assert.assertEquals;

public class ShearingP7 {


    private float fCk = 30;
    private double fYk = 500;
    private float b = 0.30f;
    private float a1 = 0.05f;
    private float a2 = 0.05f;
    private float h = 0.6f;

    private float cotTheta = 2f;
    private float aSl = 0.001f;
    private float nS = 6;
    private double fiS = 6 * Math.pow(10, -3);


    float nEd = 0.25f;


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

        assertEquals(0.123798 ,valueVRdC, 1e-5);
        assertEquals(0.672069 ,valueVRdMax, 1e-5);

    }

    @Test
    public void test134() {

        float vEd = 0.1344f;
        float vEdRed = 0.112f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.413, result1, DELTA);
    }

    @Test
    public void test147() {

        float vEd = 0.147072f;
        float vEdRed = 0.12256f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.413, result1, DELTA);
    }

    @Test
    public void test148() {

        float vEd = 0.148557f;
        float vEdRed = 0.123798f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.413, result1, DELTA);
    }

    @Test
    public void test208() {

        float vEd = 0.2088f;
        float vEdRed = 0.174f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.413, result1, DELTA);
    }

    @Test
    public void test220() {

        float vEd = 0.2208f;
        float vEdRed = 0.184f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.397, result1, DELTA);
    }

    @Test
    public void test232() {

        float vEd = 0.2328f;
        float vEdRed = 0.194f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.376, result1, DELTA);
    }

    @Test
    public void test244() {

        float vEd = 0.2448f;
        float vEdRed = 0.204f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.358, result1, DELTA);
    }

    @Test
    public void test256() {

        float vEd = 0.2568f;
        float vEdRed = 0.214f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.341, result1, DELTA);
    }

    @Test
    public void test304() {

        float vEd = 0.3048f;
        float vEdRed = 0.254f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.287, result1, DELTA);
    }

    @Test
    public void test352() {

        float vEd = 0.3528f;
        float vEdRed = 0.294f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.248, result1, DELTA);
    }

    @Test
    public void test400() {

        float vEd = 0.4008f;
        float vEdRed = 0.334f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.219, result1, DELTA);
    }

    @Test
    public void test448() {

        float vEd = 0.4488f;
        float vEdRed = 0.374f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.195, result1, DELTA);
    }

    @Test
    public void test508() {

        float vEd = 0.5088f;
        float vEdRed = 0.424f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.172, result1, DELTA);
    }

    @Test
    public void test556() {

        float vEd = 0.5568f;
        float vEdRed = 0.464f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.157, result1, DELTA);
    }

    @Test
    public void test604() {

        float vEd = 0.6048f;
        float vEdRed = 0.504f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.145, result1, DELTA);
    }

    @Test
    public void test664() {

        float vEd = 0.6648f;
        float vEdRed = 0.554f;


        ShearingStirrups res = new ShearingStirrups(h, b, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS, fiS, cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.132, result1, DELTA);
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

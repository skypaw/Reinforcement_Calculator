package test.pl.pawz.zelbet.tests.Shearing;

import org.junit.Test;
import pl.pawz.zelbet.ULS.ShearingBendRods;

import static org.junit.Assert.assertEquals;

public class ShearingP6 {


    private double fCk = 30;
    private double fYk = 500;
    private double b = 0.30f;
    private double a1 = 0.05f;
    private double a2 = 0.05f;
    private double h = 0.6f;

    private double cotTheta = 2f;
    private double aSl = 0.001f;
    private double nS1 = 2;
    private double nS2 = 1;

    private double fiS1 = 6 * Math.pow(10, -3);
    private double fiS2 = 12 * Math.pow(10, -3);


    double nEd = 0.25f;


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

        assertEquals(0.123798 ,valueVRdC, 1e-5);
        assertEquals(0.806482 ,valueVRdMax, 1e-5);

    }

    @Test
    public void test147() {

        double vEd = 0.147072f;
        double vEdRed = 0.12256f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test195() {

        double vEd = 0.1956f;
        double vEdRed = 0.163f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test211() {

        double vEd = 0.2112f;
        double vEdRed = 0.176f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test242() {

        double vEd = 0.24249f;
        double vEdRed = 0.202f;


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

        assertEquals(0.201, result1, DELTA);
    }

    @Test
    public void test273() {

        double vEd = 0.2736f;
        double vEdRed = 0.228f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.181, result1, DELTA);
    }



    @Test
    public void test304() {

        double vEd = 0.3048f;
        double vEdRed = 0.254f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.152, result1, DELTA);
    }

    @Test
    public void test351() {

        double vEd = 0.3516f;
        double vEdRed = 0.293f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.122, result1, DELTA);
    }

    @Test
    public void test398() {

        double vEd = 0.3984f;
        double vEdRed = 0.332f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.102, result1, DELTA);
    }

    @Test
    public void test445() {

        double vEd = 0.4452f;
        double vEdRed = 0.371f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.088, result1, DELTA);
    }

    @Test
    public void test507() {

        double vEd = 0.5076f;
        double vEdRed = 0.423f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.074, result1, DELTA);
    }

    @Test
    public void test554() {

        double vEd = 0.5544f;
        double vEdRed = 0.462f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.066, result1, DELTA);
    }

    @Test
    public void test601() {

        double vEd = 0.6012f;
        double vEdRed = 0.501f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.060, result1, DELTA);
    }

    @Test
    public void test663() {

        double vEd = 0.6636f;
        double vEdRed = 0.553f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.053, result1, DELTA);
    }

    @Test
    public void test694() {

        double vEd = 0.6948f;
        double vEdRed = 0.579f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.05, result1, DELTA);
    }

    @Test
    public void test757() {

        double vEd = 0.7572f;
        double vEdRed = 0.631f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.045, result1, DELTA);
    }

    @Test
    public void test788() {

        double vEd = 0.7884f;
        double vEdRed = 0.657f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.043, result1, DELTA);
    }

    @Test
    public void test804() {

        double vEd = 0.804f;
        double vEdRed = 0.670f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta,45);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.042, result1, DELTA);
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

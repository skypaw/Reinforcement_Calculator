package pl.pawz.zelbet.tests.shearingstirrups;

import org.junit.Test;
import pl.pawz.zelbet.ULS.ShearingBendRods;
import pl.pawz.zelbet.ULS.ShearingStirrups;

import static org.junit.Assert.assertEquals;

public class ShearingP6 {


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


    float nEd = 0.25f;


    private static final double DELTA = 1e-3;


    @Test
    public void test147() {

        float vEd = 0.147072f;
        float vEdRed = 0.12256f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test195() {

        float vEd = 0.1956f;
        float vEdRed = 0.163f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test211() {

        float vEd = 0.2112f;
        float vEdRed = 0.176f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.215, result1, DELTA);
    }

    @Test
    public void test242() {

        float vEd = 0.24249f;
        float vEdRed = 0.202f;


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
    public void test273() {

        float vEd = 0.2736f;
        float vEdRed = 0.228f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.181, result1, DELTA);
    }



    @Test
    public void test304() {

        float vEd = 0.3048f;
        float vEdRed = 0.254f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.152, result1, DELTA);
    }

    @Test
    public void test351() {

        float vEd = 0.3516f;
        float vEdRed = 0.293f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.122, result1, DELTA);
    }

    @Test
    public void test398() {

        float vEd = 0.3984f;
        float vEdRed = 0.332f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.102, result1, DELTA);
    }

    @Test
    public void test445() {

        float vEd = 0.4452f;
        float vEdRed = 0.371f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.088, result1, DELTA);
    }

    @Test
    public void test507() {

        float vEd = 0.5076f;
        float vEdRed = 0.423f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.074, result1, DELTA);
    }

    @Test
    public void test554() {

        float vEd = 0.5544f;
        float vEdRed = 0.462f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.066, result1, DELTA);
    }

    @Test
    public void test601() {

        float vEd = 0.6012f;
        float vEdRed = 0.501f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.060, result1, DELTA);
    }

    @Test
    public void test663() {

        float vEd = 0.6636f;
        float vEdRed = 0.553f;


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
    public void test757() {

        float vEd = 0.7572f;
        float vEdRed = 0.631f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.045, result1, DELTA);
    }

    @Test
    public void test788() {

        float vEd = 0.7884f;
        float vEdRed = 0.657f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.043, result1, DELTA);
    }

    @Test
    public void test804() {

        float vEd = 0.804f;
        float vEdRed = 0.670f;


        ShearingBendRods res = new ShearingBendRods(h,a1,b,fCk,nEd,aSl,nS1,nS2,fiS1,fiS2,fYk,vEdRed,vEd,0.55,cotTheta);
        double result1 = res.resultShearingStirrups();
        System.out.println(result1);

        assertEquals(0.042, result1, DELTA);
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

package pl.pawz.zelbet.tests.Diagnostic;

import org.junit.Test;
import pl.pawz.zelbet.Diagnostic.DiagnosticExtension;


import static org.junit.Assert.assertEquals;

public class DiagnosticExtensionTest {

    private float nEd;
    private float mEd;
    private double aS1;
    private double aS2;
    private float h = 0.6f;
    private float b = 0.3f;
    private float a1 = 0.05f;
    private float a2 = 0.05f;
    private float fCk = 30;
    private float fYk = 500;

    private static final double DELTA = 1e-3;

    @Test
    public void test500and0Asymmetric() {
        nEd = 0.5f;
        mEd = 0.0001f;

        aS1 = 5.750034 * Math.pow(10, -4);
        aS2 = 5.750034 * Math.pow(10, -4);

        DiagnosticExtension res = new DiagnosticExtension(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticExtension()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticExtension()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test500and10Asymmetric() {
        nEd = 0.5f;
        mEd = 0.01f;

        aS1 = 6.210037 * Math.pow(10, -4);
        aS2 = 5.290032 * Math.pow(10, -4);

        DiagnosticExtension res = new DiagnosticExtension(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticExtension()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticExtension()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test500and75Asymmetric() {
        nEd = 0.5f;
        mEd = 0.075f;

        aS1 = 9.200055 * Math.pow(10, -4);
        aS2 = 2.300014 * Math.pow(10, -4);

        DiagnosticExtension res = new DiagnosticExtension(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticExtension()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticExtension()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test500and100Asymmetric() {
        nEd = 0.5f;
        mEd = 0.1f;

        aS1 = 10.29313 * Math.pow(10, -4);
        aS2 = 1.8 * Math.pow(10, -4);

        DiagnosticExtension res = new DiagnosticExtension(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticExtension()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticExtension()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test50and200Asymmetric() {
        nEd = 0.05f;
        mEd = 0.2f;

        aS1 = 9.407365 * Math.pow(10, -4);
        aS2 = 1.8 * Math.pow(10, -4);

        DiagnosticExtension res = new DiagnosticExtension(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticExtension()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticExtension()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test50and650Asymmetric() {
        nEd = 0.05f;
        mEd = 0.65f;

        aS1 = 33.83880 * Math.pow(10, -4);
        aS2 = 1.8 * Math.pow(10, -4);

        DiagnosticExtension res = new DiagnosticExtension(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticExtension()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticExtension()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test50and1000Asymmetric() {
        nEd = 0.05f;
        mEd = 1f;

        aS1 = 53.45499 * Math.pow(10, -4);
        aS2 = 12.17093 * Math.pow(10, -4);

        DiagnosticExtension res = new DiagnosticExtension(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticExtension()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticExtension()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test5and1500Asymmetric() {
        nEd = 0.005f;
        mEd = 1.5f;

        aS1 = 75.93761 * Math.pow(10, -4);
        aS2 = 35.68857 * Math.pow(10, -4);

        DiagnosticExtension res = new DiagnosticExtension(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticExtension()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticExtension()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    //Symmetric tests

    @Test
    public void test500and0Symmetric() {
        nEd = 0.5f;
        mEd = 0.0001f;

        aS1 = 5.750034 * Math.pow(10, -4);
        aS2 = aS1;

        DiagnosticExtension res = new DiagnosticExtension(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticExtension()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticExtension()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test500and10Symmetric() {
        nEd = 0.5f;
        mEd = 0.01f;

        aS1 = 6.136741 * Math.pow(10, -4);
        aS2 = aS1;

        DiagnosticExtension res = new DiagnosticExtension(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticExtension()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticExtension()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test500and75Symmetric() {
        nEd = 0.5f;
        mEd = 0.075f;

        aS1 = 8.906260 * Math.pow(10, -4);
        aS2 = aS1;

        DiagnosticExtension res = new DiagnosticExtension(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticExtension()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticExtension()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test500and100Symmetric() {
        nEd = 0.5f;
        mEd = 0.1f;

        aS1 = 10.04298 * Math.pow(10, -4);
        aS2 = aS1;

        DiagnosticExtension res = new DiagnosticExtension(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticExtension()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticExtension()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test50and200Symmetric() {
        nEd = 0.05f;
        mEd = 0.2f;

        aS1 = 9.409347 * Math.pow(10, -4);
        aS2 = aS1;

        DiagnosticExtension res = new DiagnosticExtension(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticExtension()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticExtension()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test50and650Symmetric() {
        nEd = 0.05f;
        mEd = 0.65f;

        aS1 = 30.14430 * Math.pow(10, -4);
        aS2 = aS1;

        DiagnosticExtension res = new DiagnosticExtension(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticExtension()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticExtension()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test50and1000Symmetric() {
        nEd = 0.05f;
        mEd = 1f;

        aS1 = 46.29033 * Math.pow(10, -4);
        aS2 = aS1;

        DiagnosticExtension res = new DiagnosticExtension(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticExtension()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticExtension()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test5and1500Symmetric() {
        nEd = 0.005f;
        mEd = 1.5f;

        aS1 = 68.83768 * Math.pow(10, -4);
        aS2 = aS1;

        DiagnosticExtension res = new DiagnosticExtension(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticExtension()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticExtension()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }
}

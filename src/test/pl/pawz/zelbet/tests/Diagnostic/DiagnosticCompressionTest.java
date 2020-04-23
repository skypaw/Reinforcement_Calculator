package test.pl.pawz.zelbet.tests.Diagnostic;

import org.junit.Test;
import pl.pawz.zelbet.Diagnostic.DiagnosticCompression;


import static org.junit.Assert.assertEquals;

public class DiagnosticCompressionTest {
    double fCk = 30;
    double fYk = 500;
    double h = 0.6f;
    double b = 0.3f;
    double a1 = 0.05f;
    double a2 = 0.05f;


    private static final double DELTA = 1e-3;

    //Symmetric tests

    @Test
    public void test5and10Symmetric() {
        double mEd = 0.01f;
        double nEd = 0.005f;

        double aS1 = 0.329204 * Math.pow(10, -4);
        double aS2 = aS1;

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test100and100Symmetric() {
        double mEd = 0.1f;
        double nEd = 0.1f;

        double aS1 = 3.101074 * Math.pow(10, -4);
        double aS2 = aS1;

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test1000and500Symmetric() {
        double mEd = 0.5f;
        double nEd = 1.0f;

        double aS1 = 12.77754 * Math.pow(10, -4);
        double aS2 = aS1;

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test1000and750Symmetric() {
        double mEd = 0.75f;
        double nEd = 1.0f;

        double aS1 = 24.27754 * Math.pow(10, -4);
        double aS2 = aS1;

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test3500and500Symmetric() {
        double mEd = 0.5f;
        double nEd = 3.5f;

        double aS1 = 21.21958 * Math.pow(10, -4);
        double aS2 = aS1;

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test3500and350Symmetric() {
        double mEd = 0.35f;
        double nEd = 3.5f;

        double aS1 = 13.02856 * Math.pow(10, -4);
        double aS2 = aS1;

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test5000and300Symmetric() {
        double mEd = 0.3f;
        double nEd = 5.0f;

        double aS1 = 26.57117 * Math.pow(10, -4);
        double aS2 = aS1;

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test5000and250Symmetric() {
        double mEd = 0.250f;
        double nEd = 5.0f;

        double aS1 = 24.29538 * Math.pow(10, -4);
        double aS2 = aS1;

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test5000and225Symmetric() {
        double mEd = 0.225f;
        double nEd = 5.0f;

        double aS1 = 23.18530 * Math.pow(10, -4);
        double aS2 = aS1;

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }


    @Test
    public void test5000and100Symmetric() {
        double mEd = 0.1f;
        double nEd = 5.0f;

        double aS1 = 17.73990 * Math.pow(10, -4);
        double aS2 = aS1;

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }


    @Test
    public void test5000and25Symmetric() {
        double mEd = 0.025f;
        double nEd = 5.0f;

        double aS1 = 16.32285 * Math.pow(10, -4);
        double aS2 = aS1;

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test5000and0Symmetric() {
        double mEd = 0.0001f;
        double nEd = 5.0f;

        double aS1 = 16.32285 * Math.pow(10, -4);
        double aS2 = aS1;

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    //Asymmetric tests

    @Test
    public void test5and10Asymmetric() {
        double mEd = 0.01f;
        double nEd = 0.005f;

        double aS1 = 0.21984 * Math.pow(10, -4);
        double aS2 = 1.8 * Math.pow(10, -4);

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test100and100Asymmetric() {
        double mEd = 0.1f;
        double nEd = 0.1f;

        double aS1 = 3.102643 * Math.pow(10, -4);
        double aS2 = 1.8 * Math.pow(10, -4);

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test1000and500Asymmetric() {
        double mEd = 0.5f;
        double nEd = 1.0f;

        double aS1 = 17.95217 * Math.pow(10, -4);
        double aS2 = 1.8 * Math.pow(10, -4);

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test1000and750Asymmetric() {
        double mEd = 0.75f;
        double nEd = 1.0f;

        double aS1 = 29.87916 * Math.pow(10, -4);
        double aS2 = 12.74813 * Math.pow(10, -4);

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test3500and500Asymmetric() {
        double mEd = 0.5f;
        double nEd = 3.5f;

        double aS1 = 4.025 * Math.pow(10, -4);
        double aS2 = 21.79357 * Math.pow(10, -4);

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test3500and350Asymmetric() {
        double mEd = 0.35f;
        double nEd = 3.5f;

        double aS1 = 4.025 * Math.pow(10, -4);
        double aS2 = 12.94635 * Math.pow(10, -4);

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test5000and300Asymmetric() {
        double mEd = 0.3f;
        double nEd = 5.0f;

        double aS1 = 5.75 * Math.pow(10, -4);
        double aS2 = 26.7423 * Math.pow(10, -4);

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test5000and250Asymmetric() {
        double mEd = 0.250f;
        double nEd = 5.0f;

        double aS1 = 5.75 * Math.pow(10, -4);
        double aS2 = 24.60759 * Math.pow(10, -4);

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test5000and225Asymmetric() {
        double mEd = 0.225f;
        double nEd = 5.0f;

        double aS1 = 4.578443 * Math.pow(10, -4);
        double aS2 = 23.49285 * Math.pow(10, -4);

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }


    @Test
    public void test5000and100Asymmetric() {
        double mEd = 0.1f;
        double nEd = 5.0f;

        double aS1 = 12.95305 * Math.pow(10, -4);
        double aS2 = 18.66734 * Math.pow(10, -4);

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }


    @Test
    public void test5000and25Asymmetric() {
        double mEd = 0.025f;
        double nEd = 5.0f;

        double aS1 = 15.58093 * Math.pow(10, -4);
        double aS2 = 17.0095 * Math.pow(10, -4);

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }

    @Test
    public void test5000and0Asymmetric() {
        double mEd = 0.0001f;
        double nEd = 5.0f;

        double aS1 = 16.32650 * Math.pow(10, -4);
        double aS2 = 16.32655 * Math.pow(10, -4);

        DiagnosticCompression res = new DiagnosticCompression(nEd, mEd, fCk, fYk, b, h, a1, a2, aS1, aS2);
        double result1 = res.resultsDiagnosticCompression()[0];
        System.out.println(result1);
        double result2 = res.resultsDiagnosticCompression()[1];
        System.out.println(result2);

        assertEquals(nEd, result1, DELTA);
        assertEquals(mEd, result2, DELTA);
    }
}

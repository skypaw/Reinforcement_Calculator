package pl.pawz.zelbet.SLS;

import pl.pawz.zelbet.BasicValues;

public class Scratch {
    float b;
    float bEffT;
    float h;
    float hFT;
    double aS1;
    double cNom;
    double fiSt;
    double fiS1;
    double nS1;
    double d;
    double mEdk;
    double mEdkLt;
    double fCtm;
    int eS;
    char loadLong;

    double mCr;
    double sigmaS;
    double hCEff;
    double aCEff;
    double rhoPEff;
    double epsilons;
    double sRMax;

    double alphaEOrEEff;
    double xC;
    double xIIorXIIEff;
    double iIIorIIIEff;
    double iC;


    public Scratch(double cNom, double fiSt, double fiS1, double nS1, double fCk, double rH, double tZero, char cement, float b, float bEff, float bEffT, float h, float hF, float hFT, float a1, float a2, double aS1, double aS2, float mEdK, float mEdKLt, float eCm, char alphaChar, int eS, char loadLong) {
        this.b = b;
        this.bEffT = bEffT;
        this.h = h;
        this.hFT = hFT;
        this.aS1 = aS1;
        this.cNom = cNom;
        this.fiSt = fiSt;
        this.fiS1 = fiS1;
        this.nS1 = nS1;

        this.d = BasicValues.dValue(h, a1);

        this.mEdk = mEdK;
        this.mEdkLt = mEdKLt;



        this.eS = eS;
        this.loadLong = loadLong;

        BasicParameters basic = new BasicParameters(eCm, eS, b, h, hF, hFT, bEff, bEffT, a1, a2, aS1, aS2, fCk, rH, tZero, cement, loadLong);
        this.alphaEOrEEff = basic.alphaE;
        this.iC = basic.iC;
        this.xC = basic.xC;
        this.iIIorIIIEff = basic.iII;
        this.xIIorXIIEff = basic.xII;

        this.mCr = basic.mCr;
        this.fCtm = basic.fCtm;

    }



    private void sigmaS() {
        if (loadLong == 'L') {
            sigmaS = alphaEOrEEff * (mEdkLt / iIIorIIIEff) * (d - xIIorXIIEff);
        } else {
            sigmaS = alphaEOrEEff * (mEdk / iIIorIIIEff) * (d - xIIorXIIEff);
        }
    }

    private void heightEff() {
        hCEff = Math.min((h - xIIorXIIEff) / 3, 2.5 * (h - d));
    }

    private void aCtEff() {
        if (hCEff <= hFT) {
            aCEff = bEffT * hCEff;
        } else {
            aCEff = (bEffT - b) * hFT + b * hCEff;
        }
    }

    private void rhoPEff() {
        rhoPEff = aS1 / aCEff;
    }

    private void epsilons() {
        float kT;
        double fCtEff = fCtm;

        if (loadLong == 'L') {
            kT = 0.4f;
        } else {
            kT = 0.6f;
        }

        epsilons = Math.max((sigmaS - kT * (fCtEff / rhoPEff) * (1 + alphaEOrEEff * rhoPEff)) / eS, 0.6 * sigmaS / eS);
    }

    private void sRMax() {
        float k1 = 0.8f;
        float k2 = 0.5f;
        float k3 = 3.4f;
        float k4 = 0.435f;

        double c = cNom + fiSt;
        double a = Math.max((bEffT - 2 * c - fiS1) / (nS1 - 1), 2 * fiS1);

        if (a <= 5 * (c + fiS1 / 2)) {
            sRMax = k3 * c + k1 * k2 * k4 * fiS1 / rhoPEff;
        } else {
            sRMax = 1.3 * (h - xIIorXIIEff);
        }
    }

    public double wK() {
        sigmaS();
        heightEff();
        aCtEff();
        rhoPEff();
        epsilons();
        sRMax();

        if (mEdk <= mCr) {
            return 0;
        } else {
            return sRMax * epsilons;
        }
    }
}

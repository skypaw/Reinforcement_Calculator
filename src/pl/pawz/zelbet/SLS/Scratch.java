package pl.pawz.zelbet.SLS;

public class Scratch {
    private float mEdk;
    private float mEdkLt;
    private float eCm;
    private float alphaE;
    private float eCEff;
    private float fCtm;
    private int eS;
    private double mCr;
    private double sigmaS;
    private boolean loadLong;
    private double iC;
    private float h;
    private double xC;
    private double alphaEff;
    private double iIIEff;
    private double d;
    private double xIIEff;
    private double iII;
    private double xII;
    private double hCEff;
    private double hFT;
    private double aCtEff;
    private double bEffT;
    private float b;
    private double rhoPEff;
    private double aS1;
    private double aCEff;
    private double epsilons;
    private double sRMax;
    private double cNom;
    private double fiSt;
    private double fiS1;
    private double nS1;

    public Scratch(float mEdK, float mEdKLt, float eCm, float alphaE, float eCEff, float fCtm, int eS, boolean loadLong) {
        this.mEdk = mEdK;
        this.mEdkLt = mEdKLt;
        this.eCm = eCm;
        this.alphaE = alphaE;
        this.eCEff = eCEff;
        this.fCtm = fCtm;
        this.eS = eS;
        this.loadLong = loadLong;


    }

    private void mCr() {
        mCr = fCtm * iC / (h - xC);
    }

    private void sigmaS() {
        if (loadLong = true) {
            sigmaS = alphaEff * (mEdkLt / iIIEff) * (d - xIIEff);
        } else {
            sigmaS = alphaE * (mEdk / iII) * (d - xII);
        }
    }

    private void heightEff() {
        hCEff = Math.min((h - xII) / 3, 2.5 * (h - d));
    }

    private void aCtEff() {
        if (hCEff <= hFT) {
            aCtEff = bEffT * hCEff;
        } else {
            aCtEff = (bEffT - b) * hFT + b * hCEff;
        }
    }

    private void rhoPEff() {
        rhoPEff = aS1 / aCEff;
    }

    private void epsilons() {
        float kT;
        double fCtEff = fCtm;

        if (loadLong = true) {
            kT = 0.4f;
        } else {
            kT = 0.6f;
        }

        epsilons = Math.max((sigmaS - kT * (fCtEff / rhoPEff) * (1 + alphaE * rhoPEff)) / eS, 0.6 * sigmaS / eS);
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
            sRMax = 1.3 * (h - xII);
        }
    }

    public double wK() {
        mCr();
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

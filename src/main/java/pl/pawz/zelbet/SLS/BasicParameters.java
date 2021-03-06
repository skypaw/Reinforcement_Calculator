package pl.pawz.zelbet.SLS;

public class BasicParameters {
    double eCm;
    double eS;
    double b;
    double h;
    double hF;
    double bEff;
    double hFT;
    double bEffT;
    char longOrShort;

    double fCk;
    double rH;
    double tZero;
    char cement;

    double fiCrawling;
    double aC;
    double eCEff;
    double hZero;
    double uZero;
    double alphaE;

    double sCC;
    double xC;
    double iC;
    double aI;
    double xI;
    double sCI;
    double sI;
    double iI;
    double iII;
    double xII;
    double sII;

    double mCr;
    double fCtm;

    public BasicParameters(double eS, double b, double h, double hF, double hFT, double bEff, double bEffT, double a1, double a2, double aS1, double aS2, double fCk, double rH, double tZero, char cement, char longOrShort) {
        this.eS = eS;
        this.b = b;
        this.h = h;
        this.hF = hF;
        this.bEff = bEff;
        this.hFT = hFT;
        this.bEffT = bEffT;
        this.longOrShort = longOrShort;


        this.fCk = fCk;
        this.rH = rH;
        this.tZero = tZero;
        this.cement = cement;

        double fCm = fCk + 8;
        this.eCm = 22 * Math.pow(0.1 * fCm, 0.3) * Math.pow(10, 3); //res in GPa so, 10^3

        hZero();
        alphaE();
        eCEff();

        ConcreteCalculations concrete = new ConcreteCalculations(fCk, rH, tZero, cement, hZero);
        this.fiCrawling = concrete.results();

        CrossSectionCharacteristics cross = new CrossSectionCharacteristics(b, bEff, bEffT, h, hF, hFT, a1, a2, aS1, aS2, alphaE);
        this.aC = cross.concreteCrossSection()[0];
        this.sCC = cross.concreteCrossSection()[1];
        this.xC = cross.concreteCrossSection()[2];
        this.iC = cross.concreteCrossSection()[3];

        this.aI = cross.phaseI()[0];
        this.sCI = cross.phaseI()[1];
        this.xI = cross.phaseI()[2];
        this.sI = cross.phaseI()[3];
        this.iI = cross.phaseI()[4];

        this.xII = cross.phaseII()[0];
        this.sII = cross.phaseII()[1];
        this.iII = cross.phaseII()[2];

        if (fCk <= 50) {
            this.fCtm = 0.3 * Math.cbrt(Math.pow(fCk, 2));
        } else {
            this.fCtm = 2.21 * Math.log(1 + 0.1 * (fCk + 8));
        }


        mCr();

    }


    private void mCr() {
        mCr = fCtm * iC / (h - xC);
    }

    void crossSection() {
        aC = h * b + (bEff - b) * (hF) + (bEffT - b) * (hFT);
    }

    void circuit() {
        uZero = (2 * (h - hF - hFT)) + (2 * hFT) + bEffT + (bEffT - b) + (bEff - b);
    }

    void hZero() {
        crossSection();
        circuit();
        hZero = 2 * aC / uZero;
    }

    void eCEff() {

        ConcreteCalculations concrete = new ConcreteCalculations(fCk, rH, tZero, cement, hZero);
        fiCrawling = concrete.results();

        eCEff = eCm / (1 + fiCrawling);
    }

    void alphaE() {
        eCEff();

        if (longOrShort == 'L') {
            alphaE = eS / eCEff;
        } else {
            alphaE = eS / eCm;
        }
    }
}

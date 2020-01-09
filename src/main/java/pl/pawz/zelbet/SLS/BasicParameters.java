package pl.pawz.zelbet.SLS;

public class BasicParameters {
    double eCm;
    double eS;
    float b;
    float h;
    float hF;
    float bEff;
    float hFT;
    float bEffT;
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

    public BasicParameters(double eCm, double eS, float b, float h, float hF, float hFT, float bEff, float bEffT, float a1, float a2, double aS1, double aS2, double fCk, double rH, double tZero, char cement, char longOrShort) {
        this.eCm = eCm;
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
        hZero();
        alphaE();

        ConcreteCalculations concrete = new ConcreteCalculations(fCk, rH, tZero, cement, hZero);

        CrossSectionCharacteristics cross = new CrossSectionCharacteristics(b, bEff, bEffT, h, hF, hFT, a1, a2, aS1, aS2, alphaE);


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
        if (longOrShort == 'L') {
            alphaE = eS / eCm;
        } else {
            alphaE = eS / eCEff;
        }
    }
}

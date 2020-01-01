package pl.pawz.zelbet.SLS;

public class BasicParameters {
    double eCm;
    double eS;

    float b;
    float h;
    float a1;
    float a2;
    float hF;
    float bEff;
    float hFT;
    float bEffT;

    double aS1;
    double aS2;
    double fiS1;
    double fiS2;
    double nS1;
    double nS2;

    double fiS;

    double RH;

    float t0;

    double fiCrawling;

    double aC;

    char longOrShort;

    public BasicParameters() {
        aC = h * b + (bEff - b) * (hF) + (bEffT - b) * (hFT);
    }

    double circuit() {
        return (2 * (h - hF - hFT)) + (2 * hFT) + bEffT + (bEffT - b) + (bEff - b);
    }

    double hZero() {
        return 2 * aC / circuit();
    }

    double eCEff(){
        return eCm/(1+fiCrawling);
    }

    double alphaE(){
        if (longOrShort == 'L'){
            return eS/eCm;
        }else {
            return eS/eCEff();
        }
    }
}

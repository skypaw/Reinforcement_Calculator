package pl.pawz.zelbet.SLS;

public class Deflection {

    public Deflection(float eCm, int eS, float b, float h, float hF, float hFT, float bEff, float bEffT, float a1, float a2, double aS1, double aS2, char longOrShort, float fCk, float rH, char cement, int tZero) {

        float fCm = fCk + 8;

        BasicParameters basic = new BasicParameters(eCm, eS, b, h, hF, hFT, bEff, bEffT, a1, a2, aS1, aS2, fCk, rH, tZero, cement, longOrShort);

        Deformation def = new Deformation(eCm, eS, b, h, hF, hFT, bEff, bEffT, a1, a2, aS1, aS2, tZero, longOrShort, fCm, fCk, rH, cement);


    }

    private void resultsShort(){

    }

    private void resultsLong(){

    }
}
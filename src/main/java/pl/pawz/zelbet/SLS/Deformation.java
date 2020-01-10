package pl.pawz.zelbet.SLS;

public class Deformation {
    private float fCm;
    private float fCk;
    private float rH; //percent
    private double h0;
    private char cement;
    private float kH;
    private float alphaDs1;
    private float alphaDs2;

    public Deformation(float fCm, float fCk, float rH, char cement) {
        this.fCm = fCm;
        this.fCk = fCk;
        this.rH = rH;
        this.cement = cement;

    }

    public double deformationShrink() {
        double epsilonCa = 2.5 * (fCk - 10) * Math.pow(10, -6);

        float[] kHArray = {1, 0.85f, 0.75f, 0.7f};

        if (h0 <= 200) {
            kH = 1f;
        } else if (h0 <= 300) {
            kH = 0.85f;
        } else if (h0 <= 500) {
            kH = 0.75f;
        } else {
            kH = 0.7f;
        }

        int fCm0 = 10;
        int rH0 = 1;
        double betaRh = 1.55 * (1 - Math.pow(rH / rH0, 3));

        if (cement == 'S') {
            alphaDs1 = 3;
        }
        if (cement == 'N') {
            alphaDs1 = 4;
        }
        if (cement == 'R') {
            alphaDs1 = 5;
        }


        if (cement == 'S') {
            alphaDs2 = 0.13f;
        }
        if (cement == 'N') {
            alphaDs2 = 0.12f;
        }
        if (cement == 'R') {
            alphaDs2 = 0.11f;
        }


        double epsilonCdZero = 0.85 * (220 + 110 * alphaDs1) * Math.exp(-alphaDs2 * fCm / fCm0) * betaRh * Math.pow(10, -6);

        double epsilonCd = kH * epsilonCdZero;

        return epsilonCd + epsilonCa;
    }
}

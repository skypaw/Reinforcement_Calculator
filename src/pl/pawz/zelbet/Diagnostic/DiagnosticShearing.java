package pl.pawz.zelbet.Diagnostic;

import pl.pawz.zelbet.ULS.ShearingStirrups;

public class DiagnosticShearing {
    private double dDimension;
    private double bDimension;
    private float fCk;
    private double fCd;
    private float nEd;
    private double aC;
    private double aSl;
    private double vRdMax;
    private double aSw1;
    private double aSw2;
    private double sMin;
    private double nS;
    private double fiS1;
    private double fiS2;
    private double fYd;
    private double fYk;
    private double sDimension;
    private double vEdRed;
    private double z;
    private float cotTheta;
    private float tanTheta;
    private double vRdC;
    private float vEd;
    private double s2;
    private float cotAlpha;
    private float sinAlpha;


    public DiagnosticShearing(double dDimension, float bDimension, float fCk, double fCd, float nEd, double aC, double aSl, double nS, double fiS1, double fiS2, double fYd, double fYk, double vEdRed, float vEd, double s2) {
        this.dDimension = dDimension;
        this.bDimension = bDimension;
        this.fCk = fCk;
        this.fCd = fCd;
        this.nEd = nEd;
        this.aC = aC;
        this.aSl = aSl;
        this.nS = nS;
        this.fiS2 = fiS2;
        this.fiS1 = fiS1;
        this.fYd = fYd;
        this.fYk = fYk;
        this.vEdRed = vEdRed;
        this.vEd = vEd;
        this.s2 = s2;

        this.z = 0.9 * dDimension;

        this.cotTheta = 2; // TODO change this value  - simplify the code  -> connect both shearing to use the same functions in some cases!
        this.tanTheta = 0.5f;
        this.sinAlpha = 0.5f;
        this.cotAlpha = 0.5f;


        ShearingStirrups shearingBasic = new ShearingStirrups(dDimension, bDimension, fCk, fCd, nEd, aC, aSl, nS, fiS1, fYd, fYk, vEdRed, vEd);
        shearingBasic.vRdCValue();

    }
}

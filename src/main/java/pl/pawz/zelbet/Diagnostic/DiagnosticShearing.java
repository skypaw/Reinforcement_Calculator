package pl.pawz.zelbet.Diagnostic;

import pl.pawz.zelbet.BasicValues;
import pl.pawz.zelbet.ULS.ShearingBendRods;
import pl.pawz.zelbet.ULS.ShearingStirrups;

public class DiagnosticShearing {
    private double vRdMax;
    private double nS1;
    private double nS2;
    private double fiS1;
    private double fiS2;
    private double fYd;
    private double z;
    private double cotTheta;
    private double vRdC;
    private double s2;
    private double s1;
    private double cotAlpha;
    private double sinAlpha;
    private double vRdS;


    public DiagnosticShearing(double hDimension, double a1, double bDimension, double fCk, double nEd, double aSl, double nS1, double nS2, double fiS1, double fiS2, double fYk, double vEdRed, double vEd, double s2, double s1, double cotTheta, double alphaAngleDegree) {
        double dDimension = BasicValues.dValue(hDimension, a1);
        this.nS1 = nS1;
        this.nS2 = nS2;
        this.fiS2 = fiS2;
        this.fiS1 = fiS1;
        this.fYd = BasicValues.fYdValue(fYk);
        this.s2 = s2;
        this.s1 = s1;
        this.z = 0.9 * dDimension;

        this.cotTheta = cotTheta; // TODO change this value  - simplify the code  -> connect both shearing to use the same functions in some cases!

        double alphaAngleRadian = alphaAngleDegree * (Math.PI / 180);

        this.sinAlpha = Math.sin(alphaAngleRadian);
        double cosAlpha = Math.cos(alphaAngleRadian);
        double tanAlpha = sinAlpha / cosAlpha;
        this.cotAlpha = 1 / tanAlpha;


        ShearingStirrups shearingBasic = new ShearingStirrups(hDimension, bDimension, a1, fCk, fYk, nEd, vEd, vEdRed, aSl, nS1, fiS1, cotTheta); //Todo ns1 - to check if it is ok, the same bellow
        vRdC = shearingBasic.getVRdC();

        ShearingBendRods shearingBend = new ShearingBendRods(hDimension, a1, bDimension, fCk, nEd, aSl, nS1, nS2, fiS1, fiS2, fYk, vEdRed, vEd, s2, cotTheta, alphaAngleDegree);
        vRdMax = shearingBend.getVRdMax();

    }

    private void vRdS() {
        double aSw1 = nS1 * Math.PI * Math.pow(fiS1 / 2, 2);
        double aSw2 = nS2 * Math.PI * Math.pow(fiS2 / 2, 2);

        double vRdS1 = aSw1 / s1 * z * fYd * cotTheta;
        double vRdS2 = aSw2 / s2 * z * fYd * (cotTheta + cotAlpha) * sinAlpha;


        if (Double.isNaN(vRdS2)) {
            vRdS2 = 0;
        }

        vRdS = Math.min(vRdS1 + vRdS2, 2 * vRdS1);
    }

    public double resultsShearingDiagnostic() {
        vRdS();
        return Math.max(Math.min(vRdS, vRdMax), vRdC);
    }


}

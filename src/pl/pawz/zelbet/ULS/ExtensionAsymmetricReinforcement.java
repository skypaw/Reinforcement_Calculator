package pl.pawz.zelbet.ULS;

import pl.pawz.zelbet.BasicValuesPillars;

public class ExtensionAsymmetricReinforcement {
    private float nEd;
    private float mEd;
    private double epsilonCu3;
    private double epsilonC3;
    private double fCd;
    private double fYd;
    private double etaConcrete;
    private double lambdaConcrete;
    private double dDimension;
    private float bDimension;
    private float hDimension;
    private float a1;
    private float a2;
    private int E_S;
    private double xMinusMinYd;

    private double eS1;
    private double eS2;
    private double sigmaS1;
    private double sigmaS2;
    private double xVar;


    public ExtensionAsymmetricReinforcement(float nEd, float mEd, double epsilonCu3, double epsilonC3, double fCd, double fYd,
                                           double etaConcrete, double lambdaConcrete, double dDimension, float bDimension,
                                           float hDimension, float a1, float a2, int E_S, double xMinusMinYd) {
        this.nEd = nEd;
        this.mEd = mEd;
        this.epsilonCu3 = epsilonCu3;
        this.epsilonC3 = epsilonC3;
        this.fCd = fCd;
        this.fYd = fYd;
        this.etaConcrete = etaConcrete;
        this.lambdaConcrete = lambdaConcrete;
        this.dDimension = dDimension;
        this.bDimension = bDimension;
        this.hDimension = hDimension;
        this.a1 = a1;
        this.a2 = a2;
        this.E_S = E_S;
        this.xMinusMinYd = xMinusMinYd;
        this.sigmaS1 = fYd;
        this.sigmaS2 = fYd;


        BasicValuesPillars eccentricity = new BasicValuesPillars(hDimension, a1, a2, epsilonCu3, epsilonC3, fYd, E_S, mEd, nEd);

        this.eS1 = eccentricity.eccentricityExtension()[0];
        this.eS2 = eccentricity.eccentricityExtension()[1];


    }


}

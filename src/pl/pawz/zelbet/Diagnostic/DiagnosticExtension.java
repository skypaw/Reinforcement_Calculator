package pl.pawz.zelbet.Diagnostic;

import pl.pawz.zelbet.BasicValuesPillars;
import pl.pawz.zelbet.PolynomialSolver;

public class DiagnosticExtension {
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
    private double xMinYd;
    private double xLim;
    private double eS1;
    private double eS2;
    private double sigmaS1;
    private double sigmaS2;
    private double xVar;
    private double aS2Min;
    private double aS1;
    private double aS2;


    public DiagnosticExtension(float nEd, float mEd, double epsilonCu3, double epsilonC3, double fCd, double fYd,
                                            double etaConcrete, double lambdaConcrete, double dDimension, float bDimension,
                                            float hDimension, float a1, float a2, int E_S, double xMinusMinYd, double xLim, double xMinYd) {
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
        this.xLim = xLim;
        this.xMinYd = xMinYd;


        BasicValuesPillars eccentricity = new BasicValuesPillars(hDimension, a1, a2, epsilonCu3, epsilonC3, fYd, E_S, mEd, nEd);

        double eMin = (aS1*(0.5*hDimension-a1)-aS2*(0.5*hDimension-a2))/(aS1+aS2);
        double e = eccentricity.eccentricityExtension()[2];

        if (e < eMin) {
            double aS1Prim = aS2;
            double aS2Prim = aS1;
            this.aS1 = aS1Prim;
            this.aS2 = aS2Prim;
        }


        this.eS1 = eccentricity.eccentricityExtension()[0];
        this.eS2 = eccentricity.eccentricityExtension()[1];

        xVar = 1/lambdaConcrete*((eS2+a2)-Math.sqrt(Math.pow(eS2+a2,2)-(2*fYd*(aS1*eS1-aS2*eS2))/(etaConcrete*fCd*bDimension)));
    }

    private void xSmallerThanXMinYd(){
        double aVar = -2*(eS2+a2)/lambdaConcrete;
        double bVar = 2*(aS1*fYd*eS1-aS2*epsilonCu3*E_S*eS2)/(Math.pow(lambdaConcrete,2)*etaConcrete*fCd*bDimension);
        double cVar = 2*aS2*epsilonCu3*E_S*eS2*a2/(Math.pow(lambdaConcrete,2)*etaConcrete*fCd*bDimension);

        xVar = PolynomialSolver.solver(1, aVar, bVar, cVar, xLim);
    }

    private void xSmallerThanXMinMinusYd(){
        xVar = 1/lambdaConcrete*((eS2+a2)-Math.sqrt(Math.pow(eS2+a2,2)-(2*fYd*(aS1*eS1+aS2*eS2))/(etaConcrete*fCd*bDimension)));
    }

    private void xGreaterThanZero(){
        sigmaS1 = Math.min(epsilonCu3*(dDimension-xVar)/xVar*E_S,fYd);

        sigmaS2 = epsilonCu3 * (xVar - a2) / xVar * E_S;
        if (sigmaS2 > fYd) {
            sigmaS2 = fYd;
        }
        if (sigmaS2 < -fYd) {
            sigmaS2 = -fYd;
        }
    }

    private void xSmallerThanZero(){
        xVar = 0;
        sigmaS1 = fYd;
        sigmaS2 = -fYd;
    }

    public double[] resultsDiagnosticExtension(){

        if (xVar<=xMinYd){
            xSmallerThanXMinYd();
            if (xVar<xMinusMinYd){
                xSmallerThanXMinMinusYd();
            }
        }
        if (xVar>0){
            xGreaterThanZero();
        }else{
            xSmallerThanZero();
        }



        double nRd = -etaConcrete*fCd*bDimension*lambdaConcrete*xVar+sigmaS1*aS1-sigmaS2*aS2;
        double mRd = etaConcrete*fCd*bDimension*lambdaConcrete*xVar*(dDimension-0.5*lambdaConcrete*xVar)+sigmaS2*aS2*(dDimension-a2)+nEd*(0.5*hDimension-a1);

        return new double[]{nRd, mRd};
    }
}

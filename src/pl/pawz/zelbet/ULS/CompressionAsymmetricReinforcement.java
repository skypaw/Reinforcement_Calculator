package pl.pawz.zelbet.ULS;

import pl.pawz.zelbet.BasicValuesPillars;
import pl.pawz.zelbet.PolynomialSolver;

public class CompressionAsymmetricReinforcement {


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
    private double xLim;
    private double xMinusMinYd;
    private double xMinYd;
    private double x0;
    private double xMaxYd;
    private double eS1;
    private double eS2;
    private double sigmaS1;
    private double sigmaS2;
    private double aS1;
    private double aS2;
    private double aS2Min;
    private double aS1Min;

    public CompressionAsymmetricReinforcement(float nEd, float mEd, double epsilonCu3, double epsilonC3, double fCd, double fYd,
                                              double etaConcrete, double lambdaConcrete, double dDimension, float bDimension,
                                              float hDimension, float a1, float a2, int E_S, double xLim, double xMinusMinYd,
                                              double xMinYd, double x0, double xMaxYd) {
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
        this.xLim = xLim;
        this.xMinusMinYd = xMinusMinYd;
        this.xMinYd = xMinYd;
        this.x0 = x0;
        this.xMaxYd = xMaxYd;


        BasicValuesPillars eccentricity = new BasicValuesPillars(hDimension, a1, a2, epsilonCu3, epsilonC3, fYd, E_S, mEd, nEd);

        this.eS1 = eccentricity.eccentricityExtension()[0];
        this.eS2 = eccentricity.eccentricityExtension()[1];

        //min reinforcement according to EC 1992;

        this.aS2Min = Math.max(0.10 * nEd / fYd, (0.002 * bDimension * 100 * hDimension * 100) * Math.pow(10, -4)) / 2;
        this.aS1Min = aS2Min;
    }


    private double sigmaS2Var() {
        double sigmaS2 = epsilonCu3 * (xLim - a2) / xLim * E_S;
        return Math.min(sigmaS2, fYd);
    }

    private void aS2Var() {
        this.aS2 = (nEd * eS1 - etaConcrete * fCd * bDimension * lambdaConcrete * xLim * (dDimension - 0.5 * lambdaConcrete * xLim)) / (sigmaS2Var() * (dDimension - a2));
    }

    private void aS2GreaterThanA2Min() {
        this.aS1 = (sigmaS2 * aS2 + etaConcrete * fCd * bDimension * lambdaConcrete * xLim - nEd) / fYd;
    }

    private double aS1SmallerThan0() {
        double mS1 = epsilonCu3 * E_S * aS1Min * (dDimension - a2);
        double aVar = -2 * a2 / lambdaConcrete;
        double bVar = 2 * (nEd * eS2 + mS1) / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);
        double cVar = -2 * dDimension * mS1 / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);

        return PolynomialSolver.solver(1, aVar, bVar, cVar, xLim);
    }

    private double xGreaterThanH() {
        double mS2 = epsilonC3 * E_S * aS1Min * (dDimension - a2);
        double aVar = -(x0 + 2 * a2 / lambdaConcrete);
        double bVar = 2 * ((nEd * eS2 + mS2) / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension) + a2 * x0 / lambdaConcrete);
        double cVar = (-2 * (nEd * eS2 * x0 + dDimension * mS2)) / (Math.pow(lambdaConcrete, 2) * etaConcrete * fCd * bDimension);

        return PolynomialSolver.solver(1, aVar, bVar, cVar, hDimension);
    }

    private double[] xGreaterThanHByLambda() {
        double f1 = (-nEd * eS2 - etaConcrete * fCd * bDimension * hDimension * (0.5 * hDimension - a2)) * (dDimension - x0);
        double f2 = (nEd * eS1 - etaConcrete * fCd * bDimension * hDimension * (0.5 * hDimension - a1)) * (x0 - a2);

        return new double[]{f1, f2};
    }

    private double f2MinusF1GreaterThan0() {
        double xVar = (-xGreaterThanHByLambda()[0] * a2 + xGreaterThanHByLambda()[1] * dDimension + Math.sqrt(xGreaterThanHByLambda()[0] * xGreaterThanHByLambda()[1]) * (dDimension - a2)) / (xGreaterThanHByLambda()[1] - xGreaterThanHByLambda()[0]);
        return Math.max(xVar, xMaxYd);
    }

    private void aS2SmallerThanAS2Min(){
        aS2 = aS2Min;
    }

    private double aS2EqualAS2Min(){
        return 1/lambdaConcrete*(dDimension-Math.sqrt(Math.pow(dDimension,2)-(2*(nEd*eS1-sigmaS2*aS2*(dDimension-a2)))/(etaConcrete*fCd*bDimension)));
    }

    private double xSmallerThanXMinYd(){
        double mS2 = epsilonCu3*E_S*aS2Min*(dDimension-a2);
        double aVar = -2*dDimension/lambdaConcrete;
        double bVar = (2*(nEd*eS1-mS2))/(Math.pow(lambdaConcrete,2)*etaConcrete*fCd*bDimension);
        double cVar = (2*a2*mS2)/(Math.pow(lambdaConcrete,2)*etaConcrete*fCd*bDimension);

        return PolynomialSolver.solver(1, aVar, bVar, cVar, 0);
    }

    private void xGreaterThanXMinMinusYd(){
        sigmaS2 = epsilonCu3*(xSmallerThanXMinYd()-a2)/xSmallerThanXMinYd()*E_S;
    }

    private void xGreaterThanXMinYd(){
        sigmaS2 = fYd;
    }

    private double xSmallerThanXMinMinusYd(){
        sigmaS2 = -fYd;
        return 1/lambdaConcrete*(dDimension-Math.sqrt(Math.pow(dDimension,2)-(2*(nEd*eS1+fYd*aS2*(dDimension-a2)))/(etaConcrete*fCd*bDimension)));
    }

    private double f2MinusF1SmallerThan0(){
        return Math.pow(10,10);
    }

    public double[] resultsCompressionAsymmetricReinforcement() {
        sigmaS2 = sigmaS2Var();
        aS2Var();
        double xVar;

        if (aS2 <= aS2Min) {
            aS2SmallerThanAS2Min();
            xVar = aS2EqualAS2Min();
            if (xVar<xMinYd){
                xVar =xSmallerThanXMinYd();
                if (xVar<=xMinusMinYd){
                    xVar = xSmallerThanXMinMinusYd();
                }else{
                    xGreaterThanXMinMinusYd();
                }
            }else {
                xGreaterThanXMinYd();
            }

        } else {
            aS2GreaterThanA2Min();
            if (aS1<0){
                xVar = aS1SmallerThan0();
                if (xVar>hDimension){
                    xVar= xGreaterThanH();
                    if (xVar>hDimension/lambdaConcrete){
                        double f1 = xGreaterThanHByLambda()[0];
                        double f2 = xGreaterThanHByLambda()[1];
                        if (f2-f1>0){
                            xVar = f2MinusF1GreaterThan0();
                        }else{
                            xVar = f2MinusF1SmallerThan0();
                        }
                    }else {
                        aS2 = (nEd*eS1-etaConcrete*fCd*bDimension*lambdaConcrete*xVar*(dDimension-0.5*lambdaConcrete*xVar))/(fYd*(dDimension-a2));
                        return new double[]{aS1,aS2};
                    }

                }else {
                    aS2 = (nEd*eS1-etaConcrete*fCd*bDimension*lambdaConcrete*xVar*(dDimension-0.5*lambdaConcrete*xVar))/(fYd*(dDimension-a2));
                    return new double[]{aS1,aS2};
                }

            }else {
                return new double[]{aS1, aS2};
            }
        }
        return new double[]{0,0};
    }
}

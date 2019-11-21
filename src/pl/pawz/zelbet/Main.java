package pl.pawz.zelbet;

import pl.pawz.zelbet.Diagnostic.DiagnosticCompression;
import pl.pawz.zelbet.ULS.BendingBeamT;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        final int E_S = 200000;

        float fCk = 30f;
        float fYk = 500f;

        float b = 0.25f; // TODO from scanner
        float h = 0.45f; // TODO from scanner
        float a1 = 0.05f; // TODO from scanner
        float a2 = 0.05f; // TODO from scanner
        float bW = 0.2f;
        float bEff = 0.9f;
        float  hF = 0.1f;

        float mEd = 0.500f;
        float nEd = 1f;

        double dValue = BasicValues.dValue(h, a1);
        //double fCd = BasicValues.fCdValue(fCk);
        double fYd = BasicValues.fYdValue(fYk);
        double epsilonCu3 = BasicValues.epsilonCu3Value(fCk);
        double epsilonC3 = BasicValues.epsilonC3Value(fCk);
        double lambdaConcrete = BasicValues.lambdaConcreteValue(fCk);
        double etaConcrete = BasicValues.etaConcreteValue(fCk);

        double fCd = 14.3; //for Cypirian



        BasicValuesPillars res = new BasicValuesPillars(h, a1, a2, epsilonCu3, epsilonC3, fYd, E_S, mEd, nEd);
        double xLim = res.xLimVar();
        double xMinusMinYd = res.xMinMinusYdVar();
        double xMinYd = res.xMinYdVar();
        double x0 = res.x0Var();
        double xMaxYd = res.xYdMaxVar();


        BendingBeamT bending = new BendingBeamT(mEd,fCd,epsilonCu3,lambdaConcrete,etaConcrete,fYd,E_S,bW,bEff,hF,a2,dValue);
        double[] ress = bending.resultsBendingT();
        System.out.println(Arrays.toString(ress));
    }

}

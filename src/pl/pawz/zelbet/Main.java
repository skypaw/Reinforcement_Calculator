package pl.pawz.zelbet;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        final int E_S = 200000;

        float fCk = 30f;
        float fYk = 500f;

        float b = 0.3f; // TODO from scanner
        float h = 0.6f; // TODO from scanner
        float a1 = 0.05f; // TODO from scanner
        float a2 = 0.05f; // TODO from scanner

        float mEd = 0.9f;
        float nEd = 0.2f;

        double dValue = BasicValues.dValue(h,a1);
        double fCd = BasicValues.fCdValue(fCk);
        double fYd = BasicValues.fYdValue(fYk);
        double epsilonCu3 = BasicValues.epsilonCu3Value(fCk);
        double epsilonC3 = BasicValues.epsilonC3Value(fCk);
        double lambdaConcrete = BasicValues.lambdaConcreteValue(fCk);
        double etaConcrete = BasicValues.etaConcreteValue(fCk);


        BendingBeamRectangle resultsBeam = new BendingBeamRectangle(mEd, fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, b, a2, dValue);
        double[] results = resultsBeam.resultsBendingBeamRectangle();
        System.out.println(Arrays.toString(results));

        DiagnosticBendingBeamAndT resultDiagnosticBeam = new DiagnosticBendingBeamAndT(fCd, epsilonCu3, lambdaConcrete, etaConcrete, fYd, E_S, b, b, h, h, a1, a2, dValue, 0.0012, 0.0012);
        double resultBeam = resultDiagnosticBeam.resultDiagnostic();
        System.out.println(resultBeam);

    }
}

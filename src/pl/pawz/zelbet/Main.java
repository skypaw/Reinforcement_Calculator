package pl.pawz.zelbet;

import pl.pawz.zelbet.Diagnostic.DiagnosticCompression;

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

        float mEd = 0.750f;
        float nEd = 1f;

        double dValue = BasicValues.dValue(h, a1);
        double fCd = BasicValues.fCdValue(fCk);
        double fYd = BasicValues.fYdValue(fYk);
        double epsilonCu3 = BasicValues.epsilonCu3Value(fCk);
        double epsilonC3 = BasicValues.epsilonC3Value(fCk);
        double lambdaConcrete = BasicValues.lambdaConcreteValue(fCk);
        double etaConcrete = BasicValues.etaConcreteValue(fCk);


        BasicValuesPillars res = new BasicValuesPillars(h, a1, a2, epsilonCu3, epsilonC3, fYd, E_S, mEd, nEd);
        double xLim = res.xLimVar();
        double xMinusMinYd = res.xMinMinusYdVar();
        double xMinYd = res.xMinYdVar();
        double x0 = res.x0Var();
        double xMaxYd = res.xYdMaxVar();

        DiagnosticCompression resultCompression = new DiagnosticCompression(nEd, mEd, epsilonCu3, epsilonC3, fCd, fYd,
                etaConcrete, lambdaConcrete, dValue, b,
                h, a1, a2, E_S, xLim, xMinusMinYd,
                xMinYd, x0, xMaxYd, 29.8791 * 0.0001, 12.748 * 0.0001);

        double[] ress = resultCompression.resultsDiagnosticCompression();
        System.out.println(Arrays.toString(ress));
    }

}

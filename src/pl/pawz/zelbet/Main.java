package pl.pawz.zelbet;

import pl.pawz.zelbet.Diagnostic.DiagnosticBendingBeamAndT;
import pl.pawz.zelbet.GUI.MainWindow;
import pl.pawz.zelbet.ULS.BendingBeamRectangle;
import pl.pawz.zelbet.ULS.BendingBeamT;
import pl.pawz.zelbet.ULS.CompressionSymmetricReinforcement;

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

        float mEd = 0.3f;
        float nEd = 5f;

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
        double eS1 = res.eccentricityCompression()[0];
        double eS2 = res.eccentricityCompression()[1];

        CompressionSymmetricReinforcement resultCompression = new CompressionSymmetricReinforcement(nEd, mEd, epsilonCu3, epsilonC3, fCd, fYd,
                etaConcrete, lambdaConcrete, dValue, b,
                h, a1, a2, E_S, xLim, xMinusMinYd,
                xMinYd, x0, xMaxYd);

        double[] ress = resultCompression.resultsCompressionSymmetricReinforcement();
        System.out.println(Arrays.toString(ress));
    }

}

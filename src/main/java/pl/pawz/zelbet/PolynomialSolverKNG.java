package pl.pawz.zelbet;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.BrentSolver;

import java.util.ArrayList;
import java.util.Collections;

public class PolynomialSolverKNG {

    public static double solverPhaseII(double nValue, double fYd, double aS1, double epsilonCu3, int eS, double aS2, double etaConcrete, double fCd, double bValue, double lambdaConcrete, double a2) {
        BrentSolver solver = new BrentSolver();
        UnivariateFunction f = new UnivariateFunction() {

            @Override
            public double value(double x) {
                return Math.pow(x, 2) - (nValue + fYd * aS1 - epsilonCu3 * eS * aS2) / (etaConcrete * fCd * bValue * lambdaConcrete) * x - (epsilonCu3 * eS * aS2 * a2 / (etaConcrete * fCd * bValue * lambdaConcrete));
            }
        };

        double intervalStart = 0;
        double intervalSize = 0.001;
        int i = 0;
        ArrayList<Double> results = new ArrayList<Double>(i);


        while (intervalStart < 2) {
            intervalStart += intervalSize;
            if (Math.signum(f.value(intervalStart)) != Math.signum(f.value(intervalStart + intervalSize))) {
                double xVar = solver.solve(1000, f, intervalStart, intervalStart + intervalSize);

                results.add(xVar);
                i++;

            }
        }
        return Collections.min(results);
    }


}
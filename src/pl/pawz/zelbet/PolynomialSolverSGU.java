package pl.pawz.zelbet;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.BrentSolver;

import java.util.ArrayList;
import java.util.Collections;

public class PolynomialSolverSGU {

    public static double solver(double aPolynomial, double bPolynomial, double cPolynomial, double limVar) {
        BrentSolver solver = new BrentSolver();
        UnivariateFunction f = new UnivariateFunction() {

            @Override
            public double value(double x) {
                return aPolynomial * Math.pow(x, 2.0) + bPolynomial * x + cPolynomial;
            }
        };

        double intervalStart = limVar;
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

    public static double solverPhaseII3(float b, float bEff, float bEffT, float h, float hF, float hFT, float a1, float a2, double aS1, double aS2, double alphaEOrEEff, double d) {
        BrentSolver solver = new BrentSolver();
        UnivariateFunction f = new UnivariateFunction() {

            @Override
            public double value(double x) {
                return (bEff-b)*hF*(x-hF/2)+b*x*x/2+(bEffT-b)*Math.pow(x-h+hFT,2)/2+alphaEOrEEff*aS2*(x-a2)-alphaEOrEEff*aS1*(d-x);
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
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
}
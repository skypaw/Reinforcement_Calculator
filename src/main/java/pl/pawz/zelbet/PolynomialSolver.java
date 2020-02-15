package pl.pawz.zelbet;

import org.apache.commons.math3.analysis.UnivariateFunction; //apache library math for solving polynomial
import org.apache.commons.math3.analysis.solvers.BrentSolver;

import java.util.*;

public class PolynomialSolver {

    public static double solver(double aPolynomial, double bPolynomial, double cPolynomial, double dPolynomial, double limVar) {
        BrentSolver solver = new BrentSolver();
        UnivariateFunction f = x -> aPolynomial * Math.pow(x, 3.0) + bPolynomial * Math.pow(x, 2.0) + cPolynomial * x + dPolynomial;

        double intervalStart = limVar;
        double intervalSize = 0.001;
        int i = 0;
        ArrayList<Double> results = new ArrayList<>(i);


        while (intervalStart < 2) {
            intervalStart += intervalSize;
            if (Math.signum(f.value(intervalStart)) != Math.signum(f.value(intervalStart + intervalSize))) {
                double xVar = solver.solve(1000, f, intervalStart, intervalStart + intervalSize);

                results.add(xVar);
                i++;

            }
        }
        if (results.isEmpty()) {
            return 0;
        } else {
            return Collections.min(results);
        }
    }
}
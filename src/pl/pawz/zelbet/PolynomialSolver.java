package pl.pawz.zelbet;

import org.apache.commons.math3.analysis.UnivariateFunction; //apache library
import org.apache.commons.math3.analysis.solvers.BrentSolver;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

public class PolynomialSolver {

    public double solveIt(double aPolynomial, double bPolynomial, double cPolynomial, double dPolynomial) {
        BrentSolver solver = new BrentSolver();
        UnivariateFunction f = new UnivariateFunction() {

            @Override
            public double value(double x) {
                return aPolynomial * Math.pow(x, 3.0) + bPolynomial * Math.pow(x, 2.0) + cPolynomial * x + dPolynomial;
            }
        };

        double intervalStart = -100;
        double intervalSize = 0.001;
        double[] results = new double[0];
        int i = 0;
        int j = 0;

        while (intervalStart < 15) {
            intervalStart += intervalSize;
            if (Math.signum(f.value(intervalStart)) != Math.signum(f.value(intervalStart + intervalSize))) {
                double xVar = solver.solve(1000, f, intervalStart, intervalStart + intervalSize);
                i++;
                results = new double[i];

                results[j] = xVar;
                j++;
                System.out.println(Arrays.toString(results));
            }
        }




        Double[] dArray = ArrayUtils.toObject(results);
        List<Double> dList = Arrays.asList(dArray);

        double returnValue = Collections.min(dList);
        System.out.println(returnValue);

        return returnValue;
    }

    public static void main(String[] args) {
        new PolynomialSolver().solveIt(-212.176, -371.769, -10.245, 3.1014);
    }


}
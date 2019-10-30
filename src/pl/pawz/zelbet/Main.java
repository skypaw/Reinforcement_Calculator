package pl.pawz.zelbet;

import java.util.Arrays;

public class Main {
    static final float E_CU_3 = 0.0035f;
    static final float E_C_3 = 0.00175f;
    static final int E_S = 200000; // TODO not constant

    public static void main(String[] args) {


        float E_CU_3 = 0.0035f;
        float E_C_3 = 0.00175f;
        int E_S = 200000; // TODO not constant

        float fCd = 21.43f; // TODO not constant from table - concrete, eta, lambda
        float fYd = 434.78f; // TODO not constant

        float b = 0.3f; // TODO from scanner
        float h = 0.6f; // TODO from scanner
        float a1 = 0.05f; // TODO from scanner
        float a2 = 0.05f; // TODO from scanner
        float etaConcrete = 1.0f;
        float lambdaConcrete = 0.8f;
        float mEd = 0.9f;

        BasicValuesPillars basicValuesPillars = new BasicValuesPillars(h, a1, a2, E_CU_3, E_C_3, fYd, E_S);

        double[] d = basicValuesPillars.values();
        System.out.println(Arrays.toString(d));

        double dDimension = d[0];
        System.out.println(dDimension);


        double[] results = test.resultsBendingBeamRectangle(mEd, fCd, E_CU_3, lambdaConcrete, etaConcrete, fYd, E_S, b, a2, dDimension);
        System.out.println(Arrays.toString(results));

        BendingBeamRectangle results1 = new BendingBeamRectangle(mEd, fCd, E_CU_3, lambdaConcrete, etaConcrete, fYd, E_S, b, a2, dDimension);
        double[] results2 =results1.resultsBendingBeamRectangle();
        System.out.println(Arrays.toString(results2));


    }
}

package pl.pawz.zelbet;

public class Main {
    static final float E_CU_3 = 0.0035f;
    static final float E_C_3 = 0.00175f;
    static final int E_S = 200000; // TODO not constant

    public static void main(String[] args) {

        float d = dDimension();
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

        BendingBeamRectangle cokolwiek = new BendingBeamRectangle(mEd, fCd, E_CU_3, lambdaConcrete, etaConcrete, fYd, E_S, b, a2, d);

    }
}

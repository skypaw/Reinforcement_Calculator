package pl.pawz.zelbet;

import pl.pawz.zelbet.ULS.FourForcesResults;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        FourForcesResults res = new FourForcesResults(0.3f, 0.6f, 0.05f, 0.05f, 0.01f,0.5f,6.0f,0.5f,6f,0.45f,0.01f,0.45f,30,500);
        System.out.println(Arrays.toString(res.diagnostic()));
    }

}

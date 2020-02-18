package pl.pawz.zelbet;

import pl.pawz.zelbet.ULS.FourForcesResults;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        FourForcesResults res = new FourForcesResults(0.3f, 0.6f, 0.05f, 0.05f, 0.001f,0.5f,1.5f,0.3f,6f,0.5f,0.1f,0.5f,30,500);
        System.out.println(Arrays.toString(res.diagnostic()));
    }

}

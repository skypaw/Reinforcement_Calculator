package pl.pawz.zelbet.SLS;

public class ConcreteCalculations {
    double betaC = 1;
    double fiZero;
    double fCm;
    double fiRH;
    double rH;
    double betaFCm;
    double betaTZero;
    double tZero;
    double tZeroT;
    double alpha;
    double hZero;


    public ConcreteCalculations(double fCk, double rH, double tZeroT, char cement, double hZero) {
        this.fCm = fCk + 8;
        this.rH = rH;
        this.tZeroT = tZeroT;
        this.hZero = hZero*1000;


        if (cement == 'S') {
            this.alpha = -1;
        } else if (cement == 'N') {
            this.alpha = 0;
        } else {
            this.alpha = 1;
        }


    }

    private void tZeroCalculations() {
        tZero = Math.max(tZeroT * Math.pow((9 / (2 + Math.pow(tZeroT, 1.2)) + 1), alpha), 0.5);
    }

    private void betaTZeroCalculations() {
        betaTZero = 1 / (0.1 + Math.pow(tZero, 0.2));
    }

    private void betaFCmCalculations() {
        betaFCm = 16.8 / Math.sqrt(fCm);
    }

    private void fiRHCalculations() {
        if (fCm <= 35) {
            fiRH = 1 + (1 - rH / 100) / (0.1 * Math.cbrt(hZero));
        } else {
            double alpha1 = Math.pow(35 / fCm, 0.7);
            double alpha2 = Math.pow(35 / fCm, 0.2);

            fiRH = (1 + (1 - rH / 100) / (0.1 * Math.cbrt(hZero)) * alpha1) * alpha2;
        }
    }

    private void fiZeroCalculations() {
        fiZero = fiRH * betaFCm * betaTZero;
    }

    public double results() {
        tZeroCalculations();
        betaTZeroCalculations();
        betaFCmCalculations();
        fiRHCalculations();
        fiZeroCalculations();

        return fiZero * betaC;
    }
}

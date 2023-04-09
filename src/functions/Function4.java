package functions;

public class Function4 implements Function {
    @Override
    public double compute(double... x) {
        return 3 * Math.pow(x[0], 2) + 2 * x[0] * x[1] - Math.pow(x[1], 2);
    }

    @Override
    public double computePrime1(double... x) {
        return 0;
    }

    @Override
    public double computePrime2(double... x) {
        return 0;
    }
}

package functions;

public class Function3 implements Function {
    @Override
    public double compute(double... x) {
        return Math.pow(x[0], 2) - 3 * x[0] * x[1] - 16;
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

package functions;

public class Function2 implements Function {
    @Override
    public double compute(double... x) {
        return Math.exp(x[0]) - 6 * x[0] - 3;
    }

    @Override
    public double computePrime1(double... x) {
        return Math.exp(x[0]) - 6;
    }

    @Override
    public double computePrime2(double... x) {
        return Math.exp(x[0]);
    }
}

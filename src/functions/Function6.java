package functions;

public class Function6 implements Function {
    @Override
    public double compute(double... x) {
        return 3 * x[0] - Math.cos(x[1]) - 0.9;
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

package functions;

public class Function1 implements Function{
    @Override
    public double compute(double... x) {
        return Math.pow(x[0], 3) - 18 * x[0] - 83;
    }

    @Override
    public double computePrime1(double... x) {
        return 3 * Math.pow(x[0], 2) - 6;
    }

    @Override
    public double computePrime2(double... x) {
        return 6 * x[0];
    }
}

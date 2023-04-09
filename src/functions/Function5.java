package functions;

public class Function5 implements Function {
    @Override
    public double compute(double... x) {
        return Math.sin(x[0] - 0.6) - x[1] - 1.6;
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

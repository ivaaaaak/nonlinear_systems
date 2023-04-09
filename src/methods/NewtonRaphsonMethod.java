package methods;

import functions.Function;

import static java.lang.Math.abs;

public class NewtonRaphsonMethod {

    public Double solve(Function f, Bounds bounds, double epsilon) {
        double a = bounds.a();
        double b = bounds.b();

        double prevX;
        if (f.compute(a) * f.computePrime2(a) > 0) {
            prevX = a;
        } else if (f.compute(b) * f.computePrime2(b) > 0) {
            prevX = b;
        } else {
            return null;
        }

        double x = prevX - f.compute(prevX) / f.computePrime1(prevX);
        while (abs(x - prevX) > epsilon) {
            prevX = x - f.compute(x) / f.computePrime1(x);
            x = prevX - f.compute(prevX) / f.computePrime1(prevX);
        }

        return x;
    }
}

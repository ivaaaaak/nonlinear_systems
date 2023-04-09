package methods;

import functions.Function;

import static java.lang.Math.abs;

public class BisectionMethod {

    public Double solve(Function f, Bounds bounds, double epsilon) {
        double a = bounds.a();
        double b = bounds.b();

        if (f.compute(a) * f.compute(b) > 0) {
            return null;
        }
        double x = (a + b) / 2;

        while (abs(a - b) > epsilon) {
            if (f.compute(x) == 0) {
                return x;
            }
            if (f.compute(a) * f.compute(x) > 0) {
                a = x;
            } else {
                b = x;
            }
            x = (a + b) / 2;
        }
        return x;
    }
}

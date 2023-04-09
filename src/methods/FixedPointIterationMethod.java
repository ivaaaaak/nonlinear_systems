package methods;

import functions.Function;

import static java.lang.Math.abs;

public class FixedPointIterationMethod {

    public Double solve(Function f, Bounds bounds, double epsilon) {
        double a = bounds.a();
        double x0 = f.compute(a);
        double x = f.compute(x0);
        int counter = 0;

        while (abs(x - x0) > epsilon) {
            x0 = f.compute(x);
            x = f.compute(x0);
            counter++;
            if (counter == 1000) {
                return null;
            }
        }
        return x;
    }
}

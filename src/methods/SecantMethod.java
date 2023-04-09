package methods;

import functions.Function;

import static java.lang.Math.abs;

public class SecantMethod {

    public Double solve(Function f, Bounds bounds, double epsilon) {
        double prevPrevX = bounds.a();
        double prevX = bounds.b();
        double x = prevX - f.compute(prevX) * (prevX - prevPrevX) / (f.compute(prevX) - f.compute(prevPrevX));

        while (abs(x - prevX) > epsilon) {
            prevPrevX = prevX;
            prevX = x;
            x = prevX - f.compute(prevX) * (prevX - prevPrevX) / (f.compute(prevX) - f.compute(prevPrevX));
        }

        return x;
    }
}

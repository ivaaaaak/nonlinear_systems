package methods;

import functions.Function;
import linearsystems.LinearSystemMethod;
import linearsystems.matrix.Matrix;

import java.util.Arrays;
import java.util.OptionalDouble;

import static java.lang.Math.abs;

public class NewtonMethod {

    public double[] solve(NonlinearSystem system, LinearSystemMethod method, double epsilon) {
        double[] x = new double[system.n()];
        Matrix linearMatrix;
        double[] deltaX = new double[x.length];
        OptionalDouble maxDelta = Arrays.stream(deltaX).max();

        do {
            linearMatrix = computeLinearMatrix(system, x);
            deltaX = method.solve(linearMatrix);
            if (deltaX != null) {
                addArrays(x, deltaX);
                maxDelta = Arrays.stream(deltaX).max();
            }
        } while (maxDelta.isPresent() && abs(maxDelta.getAsDouble()) > epsilon);

        return x;
    }

    private Matrix computeLinearMatrix(NonlinearSystem system, double[] x) {
        int n = system.n();
        double[][] linearMatrix = new double[n][n + 1];

        for (int i = 0; i < n; i++) {
            Function curF = system.getFunctionByNumber(i);
            for (int j = 0; j < n + 1; j++) {
                if (j == n) {
                    linearMatrix[i][j] = - curF.compute(x);
                } else {
                    x[j] += 0.00001;
                    double increase = curF.compute(x);
                    x[j] -= 0.00001;
                    linearMatrix[i][j] = (increase - curF.compute(x)) / 0.00001;
                }
            }
        }
        return new Matrix(linearMatrix);
    }

    private void addArrays(double[] first, double[] second) {
        for (int i = 0; i < first.length; i++) {
            first[i] += second[i];
        }
    }
}

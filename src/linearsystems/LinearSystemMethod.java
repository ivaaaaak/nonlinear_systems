package linearsystems;

import linearsystems.matrix.Matrix;

public interface LinearSystemMethod {
    double[] solve(Matrix matrix);
}

package linearsystems.gaussmethod;

import linearsystems.matrix.Matrix;

import java.util.LinkedList;

public record TriangularMatrix(LinkedList<Integer> mainRowsIndexes,
                               LinkedList<Integer> mainColumnsIndexes,
                               Matrix matrix) {

    public double calculateDeterminant() {
        int permutationsNum = 0;
        for (Integer index: mainRowsIndexes) {
            if (index - mainRowsIndexes.get(index) != 0) {
                permutationsNum++;
            }
        }
        for (Integer index: mainColumnsIndexes) {
            if (index - mainColumnsIndexes.indexOf(index) != 0) {
                permutationsNum++;
            }
        }
        double determinant = 1;
        for (int k = 0; k < matrix.coefficients().length; k++) {
            int i = mainRowsIndexes.get(k);
            int j = mainColumnsIndexes.get(k);
            determinant *= matrix.coefficients()[i][j];
        }
        return permutationsNum % 2 == 0? determinant: -determinant;
    }

    public Matrix getRealTriangularMatrix() {
        int m = matrix.coefficients().length;
        int n = matrix.coefficients()[0].length;
        double[][] realTriangleMatrix = new double[m][n];

        for (int i = 0; i < m; i++) {
            int mainElemRowIndex = mainRowsIndexes.get(i);

            for (int j = 0; j < n; j++) {
                if (j == n - 1) {
                    realTriangleMatrix[i][j] = matrix.coefficients()[mainElemRowIndex][j];
                    continue;
                }
                int index = mainColumnsIndexes.get(j);
                realTriangleMatrix[i][j] = matrix.coefficients()[mainElemRowIndex][index];
            }
        }
        return new Matrix(realTriangleMatrix);
    }
}

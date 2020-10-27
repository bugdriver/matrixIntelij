package com.step.shape;

import java.util.Arrays;
import java.util.Objects;

public class Matrix {
    private final int[] elements;
    private final int noOfRows;
    private final int noOfCols;

    public Matrix(int[] elements, int noOfRows, int noOfCols) {
        this.elements = elements;
        this.noOfRows = noOfRows;
        this.noOfCols = noOfCols;
    }

    public static Matrix createMatrix(int[] elements, int noOfRows, int noOfCols) {
        if (elements.length < (noOfRows * noOfCols)) {
            throw new RuntimeException("Lesser Number of elements passed for matrix");
        }
        return new Matrix(Arrays.copyOf(elements, noOfRows * noOfCols), noOfRows, noOfCols);
    }

    public Matrix add(Matrix otherMatrix) {
        if (!this.areDimensionEqual(otherMatrix)) {
            return null;
        }
        int[] result = new int[noOfRows * noOfCols];
        for (int idx = 0; idx < this.elements.length; idx++) {
            result[idx] = this.elements[idx] + otherMatrix.elements[idx];
        }
        return createMatrix(result, noOfRows, noOfCols);
    }

    public Matrix subtract(Matrix otherMatrix) {
        if (!this.areDimensionEqual(otherMatrix)) {
            return null;
        }
        int[] result = new int[noOfRows * noOfCols];
        for (int idx = 0; idx < this.elements.length; idx++) {
            result[idx] = this.elements[idx] - otherMatrix.elements[idx];
        }
        return createMatrix(result, noOfRows, noOfCols);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;
        Matrix matrix = (Matrix) o;
        return noOfRows == matrix.noOfRows &&
                noOfCols == matrix.noOfCols &&
                Arrays.equals(elements, matrix.elements);
    }

    private boolean areDimensionEqual(Matrix otherMatrix) {
        return this.noOfRows == otherMatrix.noOfRows && this.noOfCols == otherMatrix.noOfCols;
    }

}
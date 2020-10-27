package com.step.shape;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void createMatrixShouldCreateNewMatrix() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Matrix newMatrix = Matrix.createMatrix(numbers, 3, 3);
        Matrix matrix = new Matrix(numbers, 3, 3);
        assertEquals(matrix, newMatrix);
    }

    @Test
    public void addShouldAddElementsOfTwoMatrices() {
        Matrix firstMatrix = createMatrix3x3(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Matrix secondMatrix = createMatrix3x3(2, 3, 4, 5, 6, 7, 8, 9, 0);
        Matrix expectedMatrix = createMatrix3x3(3, 5, 7, 9, 11, 13, 15, 17, 9);
        assertEquals(expectedMatrix, firstMatrix.add(secondMatrix));
    }

    @Test
    public void subtractShouldSubtractElementsOfTwoMatrices() {
        Matrix firstMatrix = createMatrix3x3(9, 8, 7, 6, 5, 4, 3, 2, 1);
        Matrix secondMatrix = createMatrix3x3(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Matrix expectedMatrix = createMatrix3x3(8, 6, 4, 2, 0, -2, -4, -6, -8);
        assertEquals(expectedMatrix, firstMatrix.subtract(secondMatrix));
    }

    private Matrix createMatrix3x3(int... numbers) {
        return Matrix.createMatrix(numbers, 3, 3);
    }
}
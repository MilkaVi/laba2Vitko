package com.java.se;

import java.util.ArrayList;

public class Matrix {

    public static double calculateDeterminant(double[][] matrix) {

        ArrayList<Integer> listOfColumnsToCreateChildMatrix = new ArrayList<Integer>();

        double Determinant = 0;
        int flag = 1;
        double[][] matrixChild;

        if (matrix.length > 2) {
            for (int amountOfColumnsToCreateChildMatrix = 0; amountOfColumnsToCreateChildMatrix < matrix.length; amountOfColumnsToCreateChildMatrix++) {
                for (int n = 0; n < matrix.length; n++) {
                    listOfColumnsToCreateChildMatrix.add(n);
                }
                listOfColumnsToCreateChildMatrix.remove(amountOfColumnsToCreateChildMatrix);

                matrixChild = new double[matrix.length - 1][matrix.length - 1];

                for (int row = 0; row < matrix.length - 1; row++) {
                    for (int column = 0; column < matrix.length - 1; column++) {
                        matrixChild[row][column] = matrix[row + 1][listOfColumnsToCreateChildMatrix.get(column)];
                    }
                }
                Determinant = Determinant
                        + (matrix[0][amountOfColumnsToCreateChildMatrix] * flag * calculateDeterminant(matrixChild));
                listOfColumnsToCreateChildMatrix.clear();
                flag = flag * (-1);
            }
        }
        if (matrix.length == 2) {
            Determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        return Determinant;
    }

    public static double[][] permulation(double[][] matrix, double[] vector, int s) {
        double[][] result = new double[vector.length][vector.length];
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                if (i == s) {
                    result[i][j] = vector[j];
                } else {
                    result[i][j] = matrix[i][j];
                }
            }
        }
        return result;
    }

    //метод крамера
    public static double[] getResult(double[][] matrix, double[] vector) {
        double[] result = new double[vector.length];
        double det = calculateDeterminant(matrix);
        for (int i = 0; i < vector.length; i++) {
            result[i] = calculateDeterminant(permulation(matrix, vector, i)) / det;
        }
        return result;
    }
}
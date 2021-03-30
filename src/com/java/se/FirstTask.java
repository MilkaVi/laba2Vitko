package com.java.se;

public class FirstTask {
    public static double[] yMatrix;
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public static double[] getYi(double Xi[]) {
        double Yi[] = new double[Xi.length];
        for (int i = 0; i < Xi.length; i++) {

            Yi[i] = roundAvoid(3 * Xi[i] - Math.pow(Math.E, Xi[i]), 4);
        }
        return Yi;
    }

    public static void printTable(double Xi[], double Yi[], double a[]) {
        System.out.println("i  " + "  x   " + "     y" + "     a");

        for (int i = 0; i < Xi.length; i++) {

            System.out.println(i + " | " + Xi[i] + " | " + Yi[i] + " |" + a[i] + " |");
        }
    }

    public static double[] formA(double Yi[]) {
        double a[] = new double[Yi.length];
        a[0] = 0;
        for (int i = 1; i < Yi.length; i++) {
            a[i] = Yi[i];
        }
        return a;
    }

    public static double[][] formMatrix(double Yi[]) {
        double a[][] = new double[Yi.length][Yi.length];
        double vect[] = new double[Yi.length];

        for (int i = 0; i < Yi.length; i++) {
            for (int j = 0; j < Yi.length; j++) {
                a[i][j] = 0;
            }
        }


        for (int i = 1; i < Yi.length - 1; i++) {
            vect[i - 1] = 6 * (Yi[1 + i] - 2 * Yi[i] + Yi[i - 1]);
            a[i][i - 1] = 1;
            a[i][i] = 4;
            a[i][i + 1] = 1;
        }
        yMatrix = new double[Yi.length-2];
        double finalMatrix[][] = new double[Yi.length - 2][Yi.length - 2];
        for (int i = 1; i < Yi.length - 1; i++) {
            for (int j = 1; j < Yi.length-1; j++) {
                    finalMatrix[i - 1][j - 1] = a[i][j];
                    yMatrix[i-1] = vect[i-1];
            }
        }


        return finalMatrix;
    }


}

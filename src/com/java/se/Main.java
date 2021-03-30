package com.java.se;

import static com.java.se.FirstTask.roundAvoid;

public class Main {
    static int n1 = 3;
    static int n2 = 2;
    static int xFirst = 1;
    static double xSecond = 2;
    static double h = 0.2;
    static double x1 = 0.71;
    static double x2 = 1.55;
    static double x3 = 1.94;

    public static void main(String[] args) {
        double Xi[] = new double[(int) ((xSecond - xFirst) / h) + 1];
        Xi[0] = xFirst;

        for (int i = 1; i < (xSecond - xFirst) / h + 1; i++) {
            Xi[i] = roundAvoid(Xi[i - 1] + h, 2);
        }

        double Yi[] = FirstTask.getYi(Xi);

        double a[] = FirstTask.formA(Yi);

        FirstTask.printTable(Xi, Yi, a);

        double c[] = Matrix.getResult(FirstTask.formMatrix(Yi), FirstTask.yMatrix);

        for(int i = 0; i < FirstTask.yMatrix.length; i++)
            System.out.print(FirstTask.yMatrix[i] + " ");
        System.out.println("y--------");
        double newC[] = new double[c.length + 2];
        newC[0] = 0;
        newC[newC.length - 1] = 0;
        for (int i = 1; i < newC.length - 1; i++) {
            newC[i] = c[i - 1];
        }
        System.out.println("print c");
        for (double c1 : newC) {
            System.out.print(c1 + " ");
        }
        System.out.println();

        System.out.println("print d");

        //input h insted of 1
        double firstD[] = FormKoaf.formD(newC, h);



        double d[] = new double[firstD.length + 1];
        d[0] = 0;
        System.out.println(d[0] + " ");
        for (int i = 1; i < d.length; i++) {
            d[i] = firstD[i - 1];
            System.out.print(d[i] + " ");
        }
        System.out.println();


        System.out.println("print b");
        double b[] = FormKoaf.formB(newC, d, Yi, h);
        for (double c1 : b) {
            System.out.print(c1 + " ");
        }
        System.out.println();

        double Cnew[] = new double[c.length + 1];
        for (int i = 0; i < c.length; i++) {
            Cnew[i] = c[i];
        }

        FormKoaf.formS(Cnew, a, firstD, Yi, b, Xi);

    }

}

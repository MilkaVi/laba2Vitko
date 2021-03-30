package com.java.se;

public class FormKoaf {
    public static double[] formD(double c[], double h) {
        double d[] = new double[c.length];
        d[0] = 0;
        for (int i = 1; i < c.length; i++) {
            d[i] = (c[i] - c[i - 1]) / h;
        }
        return d;
    }

    public static double[] formB(double c[], double d[], double y[], double h) {
        double b[] = new double[d.length - 1];
        int j = 0;
        for (int i = 1; i < b.length; i++) {
            b[j] = (c[i] * h) / 2 - d[i] * h * h / 6 + (y[i] - y[i - 1]) / h;
            j++;
        }
        return b;
    }

    public static void formS(double c[], double[] a, double d[], double y[], double[] b, double[] x) {




        double Xi[] = {x[0] + 0.3, x[0] + 0.5 * 0.2, x[x.length-1] - 0.5*0.2 };

        System.out.println(Xi[0] +" " + Xi[1] +" "+ Xi[2]);

        StringBuffer s = new StringBuffer();
        for (int i = 0; i < x.length - 1; i++) {
            s.append("S" + (i+1) + "(x)=" + a[i+1] + " +" + roundAvoid(b[i], 4) + "*(X -" + x[i + 1] + ") + ");
            s.append(roundAvoid(c[i], 4) / 2 + "*(X-" + x[i + 1] + ")^2 + ");
            s.append(roundAvoid(d[i+1] / 6, 4) + "*(X-" + x[i + 1] + ")^3");
            s.append("  x[" + x[i] + "," + x[i + 1] + "]" + "\n");

        }

        StringBuffer valueInPoint = new StringBuffer();
        StringBuffer valueByFunc = new StringBuffer();
        double temp = 0;
        int k = 0;
        for(int j =0; j < 3; j ++){
            valueInPoint.append("значения для точки "+(j+1)+" :");
            valueByFunc.append( "значения для точки "+(j+1)+" :" + roundAvoid((3*Xi[j] - Math.exp(Xi[j])),4) + ";  ");



                for (int i = 0; i < x.length - 1; i++) {
                    if(Xi[j] <= x[i+1] && Xi[j] >= x[i]) {
                        System.out.println("X = " + Xi[j] + " x = " + x[i] + " xi+1 = " +x[i+1] );

                        temp = roundAvoid(a[i+1] + b[i] * (Xi[j] - x[i + 1]) + (c[i] / 2) * Math.pow((Xi[j] - x[i + 1]), 2) +
                            (d[i] / 6) * Math.pow((Xi[j] - x[i + 1]), 3), 4);
                    valueInPoint.append(temp + ";  ");
                }
            }

        }



        String s1 = String.valueOf(s);
        String newString = s1.replace("+ -", " -");
        String newSting = newString.replace("+-", "-");
        System.out.println(newSting);


        System.out.println(valueInPoint);
        System.out.println(valueByFunc);

    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }



}

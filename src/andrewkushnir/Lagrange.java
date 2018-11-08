package andrewkushnir;

public class Lagrange {

    static public void main(String[] args) {
        final double x = -0.2;
        final int size = 4;
        var xValues = new double[size];
        var yValues = new double[size];

        xValues[0] = -1;
        xValues[1] = 0;
        xValues[2] = 1;
        xValues[3] = 2;

        yValues[0] = func(xValues[0]);
        yValues[1] = func(xValues[1]);
        yValues[2] = func(xValues[2]);
        yValues[3] = func(xValues[3]);

        double ksi = interpolateLagrangePolynomial(x, xValues, yValues, size);

        System.out.println("Полином Лагранжа бугага в точке x=-0,2: " + ksi);
    }


    static double interpolateLagrangePolynomial(double x, double[] xValues, double[] yValues, int size) {
        double lagrangePol = 0;

        for (int i = 0; i < size; i++) {
            double basicsPol = 1;
            for (int j = 0; j < size; j++) {
                if (j != i) {
                    basicsPol *= (x - xValues[j]) / (xValues[i] - xValues[j]);
                }
            }
            lagrangePol += basicsPol * yValues[i];
        }

        return lagrangePol;
    }

    static double func(double x) {
        return Math.pow(x, 4) - 2 * x + 3;
    }

}


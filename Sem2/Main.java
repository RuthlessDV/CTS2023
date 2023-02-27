package ro.ase.cts.s02;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();

        double x = calculator.readDouble("Tastați valoarea pentru X: ");
        double y = calculator.readDouble("Tastați valoarea pentru Y: ");

        double xLa3 = calculator.power(x, 3);
        double yLa6 = calculator.power(y, 6);

        calculator.returnareSuma(xLa3,yLa6);


        MatrixDataHandler mH = new MatrixDataHandler(5, 7, "matrix.txt");
        mH.modifyValueAndUpdateFile("matrix.txt", 3, 4, 345);
    }
}

package ro.ase.cts.s02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    /**
     * Aceasta metoda calculeaza suma dintre x ridicat la puterea a-5a si y ridicat la putearea a-7a.
     * @return Returneaza rezultatul calculat.
     * @throws IOException Arunca exceptie daca datele introduse nu au formatul corect.
     */
    public double calculateX5PlusY7() throws NumberFormatException, IOException {
        double x = readDouble("Tastați valoarea pentru X: ");
        double y = readDouble("Tastați valoarea pentru Y: ");

        double x5 = power(x, 5);
        double y7 = power(y, 7);

        return x5 + y7;
    }
    public double readDouble(String message) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print(message);
                String input = reader.readLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ați introdus o valoare nevalidă. Vă rugăm să încercați din nou.");
            }
        }
    }
        public double power(double base, int exponent) {
            double result = 1.0;
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
            return result;
        }

    public void returnareSuma(double x, double y){
        double result = x + y;
        System.out.println("Rezultatul final este: ");
        System.out.println(result);
    }
    }

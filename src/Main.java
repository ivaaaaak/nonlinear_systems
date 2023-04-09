import functions.Function;
import functions.Function1;
import functions.Function2;
import functions.Function3;
import methods.Bounds;
import methods.FixedPointIterationMethod;
import methods.NewtonRaphsonMethod;
import methods.SecantMethod;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FixedPointIterationMethod fixedPointIterationMethod = new FixedPointIterationMethod();
        NewtonRaphsonMethod newtonRaphsonMethod = new NewtonRaphsonMethod();
        SecantMethod secantMethod = new SecantMethod();

        Function f = chooseFunction();
        if (f != null) {
            Bounds bounds = readBounds();
            double epsilon = readAccuracy();

            System.out.println(fixedPointIterationMethod.solve(f, bounds, epsilon));
            System.out.println(secantMethod.solve(f, bounds, epsilon));
        }
    }

    private static Function chooseFunction() {
        int chosenFunction = 0;
        while (chosenFunction != 1 && chosenFunction != 2 && chosenFunction != 3) {
            System.out.println("Choose function:");
            System.out.println("1) ");
            System.out.println("2) ");
            System.out.println("3) ");
            try {
                chosenFunction = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter function's number");
                chosenFunction = 0;
            }
        }

        switch (chosenFunction) {
            case 1 -> {
                return new Function1();
            }
            case 2 -> {
                return new Function2();
            }
            case 3 -> {
                return new Function3();
            }
            default -> {
                return null;
            }
        }
    }

    private static Bounds readBounds() {
        Double a = null;
        Double b = null;

        while (a == null) {
            System.out.println("Enter left bound:");
            try {
                a = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Please enter double number");
            }
        }
        while (b == null) {
            System.out.println("Enter right bound:");
            try {
                b = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Please enter double number");
            }
        }
        return new Bounds(a, b);
    }

    private static double readAccuracy() {
        Double epsilon = null;

        while (epsilon == null) {
            System.out.println("Enter accuracy:");
            try {
                epsilon = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Please enter double number");
            }
        }
        return epsilon;
    }
}

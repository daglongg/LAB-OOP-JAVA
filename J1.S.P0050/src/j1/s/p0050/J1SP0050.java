/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0050;

/**
 *
 * @author dangl
 */
public class J1SP0050 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        double a;
        double b;
        double c;
        do {
            //Step 1: Display a menu and ask users to select an option.
            choice = menu.displayMenu();
            switch (choice) {
                //Step 2: Option  1: Calculate Superlative Equation
                case 1:
                    InputValidation.nameEquation();
                    a = InputValidation.getNumber("Enter A: ");
                    b = InputValidation.getNumber("Enter B: ");
                    calculateSuperlativeEquation(a, b);
                    break;
                //Step 3: Option  2: Calculate Quadratic Equation
                case 2:
                    InputValidation.nameQuadraticEquation();
                    a = InputValidation.getNumber("Enter A: ");
                    b = InputValidation.getNumber("Enter B: ");
                    c = InputValidation.getNumber("Enter C: ");
                    calculateQuadraticEquation(a, b, c);
                    break;
                //Step 4: Option 3: Exit the program
                case 3:
                    System.out.println("Exit the program");
                    break;
            }
        } while (choice != 3);

    }

    private static void calculateSuperlativeEquation(double a, double b) {
        /*
        SuperlativeEquation has form ax + b = 0
        if a = b = 0 => True all x
        if a = 0 and b != 0 => non solution
        a != 0 => has solution = -b/a
        */

        double result = 0;;
        if (a == 0 && b == 0) {
            System.out.println("The solution equation is true for all x");
        } else if (a == 0 && b != 0) {
            System.out.println("Non result");
        } else {
            result = -b / a;
            if (result == 0) {
                result = 0;
            }
            System.out.printf("Solution: x = %.3f \n", result);
        }
        String oddNumer = "";
        if (InputValidation.oddNumber(a)) {
            oddNumer += a + ", ";
        }
        if (InputValidation.oddNumber(b)) {
            oddNumer += b + ", ";
        }
        if (a != 0 && b != 0 && InputValidation.oddNumber(result)) {
            oddNumer += String.format("%.3f", result) + ", ";
        }
        if (oddNumer.isEmpty()) {
            System.out.print("Number is Odd:");
        } else {
            oddNumer = oddNumer.substring(0, oddNumer.length() - 2);
            System.out.print("Number is Odd: " + oddNumer);
        }
        System.out.println();
        String evenNumer = "";
        if (InputValidation.evenNumber(a)) {
            evenNumer += a + ", ";
        }
        if (InputValidation.evenNumber(b)) {
            evenNumer += b + ", ";
        }
        if (a != 0 && b != 0 && InputValidation.evenNumber(result)) {
            evenNumer += result + ", ";
        }
        if (evenNumer.isEmpty()) {
            System.out.print("Number is Even:");
        } else {
            evenNumer = evenNumer.substring(0, evenNumer.length() - 2);
            System.out.print("Number is Even:" + evenNumer);
        }
        System.out.println();
        String perfectSquareNumer = "";
        if (InputValidation.perfectSquare(a)) {
            perfectSquareNumer += a + ", ";
        }
        if (InputValidation.perfectSquare(b)) {
            perfectSquareNumer += b + ", ";
        }
        if (a != 0 && b != 0 && InputValidation.perfectSquare(result)) {
            perfectSquareNumer += result + ", ";
        }
        if (perfectSquareNumer.isEmpty()) {
            System.out.print("Number is Perfect Square:");
        } else {
            perfectSquareNumer = perfectSquareNumer.substring(0, perfectSquareNumer.length() - 2);
            System.out.print("Number is Perfect Square:" + perfectSquareNumer);
        }
        System.out.println();
    }

    private static void calculateQuadraticEquation(double a, double b, double c) {
        double delta;
        double result_1 = 0;
        double result_2 = 0;
        if (a == 0 && b == 0 && c == 0) {
            System.out.println("The solution equation is true for all x");
        } else if (a == 0 && b != 0) {
            calculateSuperlativeEquation(b, c);
        } else {
            delta = (b * b) - 4 * a * c;
            // delta < 0
            if (delta < 0) {
                System.out.println("no solution");
            } else if (delta == 0) {
                if (a == 0) {
                    System.out.println("None result");
                } else {
                    // calculate results
                    result_1 = (-b) / (2 * a);
                    result_2 = result_1;
                    System.out.println("Solutions: x1 = x2 = " + result_1);
                }
            } else {
                result_1 = (-b + Math.sqrt(delta)) / (2 * a);
                result_2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("Solution: x1 = " + String.format("%.3f", result_1) + " and x2 = " + String.format("%.3f", result_2));
            }
        }
        String oddNumer = "";
        if (InputValidation.oddNumber(a)) {
            oddNumer += a + ", ";
        }
        if (InputValidation.oddNumber(b)) {
            oddNumer += b + ", ";
        }
        if (InputValidation.oddNumber(c)) {
            oddNumer += c + ", ";
        }
        if (a != 0 && b != 0 && c != 0 && InputValidation.oddNumber(result_1)) {
            oddNumer += result_1 + ", ";
        }
        if (a != 0 && b != 0 && c != 0 && InputValidation.oddNumber(result_2)) {
            oddNumer += result_2 + ", ";
        }
        if (oddNumer.isEmpty()) {
            System.out.print("Number is Odd:");
        } else {
            oddNumer = oddNumer.substring(0, oddNumer.length() - 2);
            System.out.print("Number is Odd:" + oddNumer);
        }
        System.out.println();
        String evenNumer = "";
        if (InputValidation.evenNumber(a)) {
            evenNumer += a + ", ";
        }
        if (InputValidation.evenNumber(b)) {
            evenNumer += b + ", ";
        }
        if (InputValidation.evenNumber(c)) {
            evenNumer += c + ", ";
        }
        if (a != 0 && b != 0 && c != 0 && InputValidation.evenNumber(result_1)) {
            evenNumer += result_1 + ", ";
        }
        if (a != 0 && b != 0 && c != 0 && InputValidation.evenNumber(result_2)) {
            evenNumer += result_2 + ", ";
        }
        if (evenNumer.isEmpty()) {
            System.out.print("Number is Even:");
        } else {
            evenNumer = evenNumer.substring(0, evenNumer.length() - 2);
            System.out.print("Number is Even:" + evenNumer);
        }
        System.out.println();
        String perfectSquareNumer = "";
        if (InputValidation.perfectSquare(a)) {
            perfectSquareNumer += a + ", ";
        }
        if (InputValidation.perfectSquare(b)) {
            perfectSquareNumer += b + ", ";
        }
        if (InputValidation.perfectSquare(c)) {
            perfectSquareNumer += (c + ", ");
        }
        if (a != 0 && b != 0 && c != 0 && InputValidation.perfectSquare(result_1)) {
            perfectSquareNumer += result_1 + ", ";
        }
        if (a != 0 && b != 0 && c != 0 && InputValidation.perfectSquare(result_2)) {
            perfectSquareNumer += result_2 + ", ";
        }
        if (perfectSquareNumer.isEmpty()) {
            System.out.print("Number is Perfect Square:");
        } else {
            perfectSquareNumer = perfectSquareNumer.substring(0, perfectSquareNumer.length() - 2);
            System.out.print("Number is Perfect Square:" + perfectSquareNumer);
        }
        System.out.println();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0050;

import java.util.Scanner;

/**
 *
 * @author dangl
 */
public class InputValidation {

    public static Scanner sc = new Scanner(System.in);

    public static int getSelect(int firtValue, int lastValue) {
        int choiceUser;
        while (true) {
            try {
                choiceUser = Integer.parseInt(sc.nextLine().trim());
                if (choiceUser >= 1 && choiceUser <= 3) {
                    return choiceUser;
                }else{
                    System.out.println("Can you choise 1, 2 or 3. Enter agian");
                }
            } catch (NumberFormatException errorName) {
                System.out.println("Can you choise 1, 2 or 3");
                System.out.println("Can you enter choise again ");
            }
        }
    }

    public static double getNumber(String sql) {
        double number;
        while (true) {
            System.out.print(sql);
            try {
                number = Double.parseDouble(sc.nextLine().trim());
                return number;
            } catch (NumberFormatException errorName) {
                System.out.println("Please input number");
            }
        }
    }

    public static boolean oddNumber(double input) {
        return (input % 2 != 0);
    }

    public static boolean evenNumber(double input) {
        return (input % 2 == 0);
    }

    //
    public static boolean perfectSquare(double input) {
        for (int i = 0; i <= input; i++) {
            if(input == 0){
                return false;
            }else if (i * i == input) {
                return true;
            }
        }
        return false;
    }
    public static void nameEquation() {
        System.out.println("----- Calculate Equation -----");
    }
    public static void nameQuadraticEquation(){
        System.out.println("----- Calculate Quadratic Equation -----");
    } 
}

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
public class menu {

    public static int displayMenu() {
        int choise;
        System.out.println("========= Equation Program =========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.println("Please choice one option:");
        choise = InputValidation.getSelect(1, 3);

        return choise;
    }
}

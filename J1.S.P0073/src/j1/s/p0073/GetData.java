/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0073;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author dangl
 */
public class GetData {
    public static Scanner sc = new Scanner(System.in);

    public static int getSelect(String msg, int min, int max) {
        int choice;
        //Loop until user enter positive number in range of min and max
        while (true) {
            System.out.print(msg);
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.println("Can you choice 1, 2 or 3");
                }
            } catch (NumberFormatException errorName) {
                System.out.println("This is not digit");
            }
        }
    }
    
    public static String getDate(String mess, String formatRequireMsg, String regex) {
    SimpleDateFormat d2 = new SimpleDateFormat("dd-MMM-yyyy");
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String m = null;

    while (true) {
        System.out.print(mess + ": ");
        dateFormat.setLenient(false);
        String userEnter = sc.nextLine().trim();

        if (userEnter.isEmpty()) {
            System.out.println(mess + " cannot be null or empty.");
        } else {
            if (regex.isEmpty() || userEnter.matches(regex)) {
                try {
                    Date date = dateFormat.parse(userEnter);
                    m = d2.format(date);
                    break;
                } catch (ParseException ex) {
                    System.out.println("Data not exits");
                }
            } else {
                System.out.println(formatRequireMsg);
            }
        }
    }
    return m;
}

    
    public static double getNumber(String msg, int min) {
        double choice;
        //Loop until user enter positive number 
        while (true) {
            System.out.print(msg + ": ");
            try {
                choice = Double.parseDouble(sc.nextLine().trim());
                if (choice > min) {
                    return choice;
                } else {
                    System.out.println("This is not positive");
                }
            } catch (NumberFormatException errorName) {
                System.out.println("This is not digit");
            }
        }
    }
    
    public static String getString(String mess, String fomatRequireMsg, String regex) {
        String input;
        ////Loop until user enter String from the keyboard
        while (true) {
            System.out.print(mess + ": ");
            input = sc.nextLine().trim();
            //User didn't enter anything from the keyboard
            if (input.isEmpty()) {
                System.out.println(mess + " cannot null, empty");
            } else {
                //if regex is empty
                if (regex.isEmpty()) {
                    break;
                } else {
                    //Check matches of the input
                    if (input.matches(regex)) {
                        break;
                    } else {
                        //if input of user not flow the matches with regex
                        System.out.println(fomatRequireMsg);
                    }
                }
            }
        }
        return input;
    }
}

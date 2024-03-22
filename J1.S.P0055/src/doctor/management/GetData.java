/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor.management;

import java.util.Scanner;

/**
 *
 * @author dangl
 */
public class GetData {

    public static Scanner sc = new Scanner(System.in);

    public static int getSelect(String msg, int min, int max) {
        int select;
        //loop until user choice number in range min and max
        while (true) {
            try {
                System.out.print(msg);
                select = Integer.parseInt(sc.nextLine().trim());
                if (select >= min && select <= max) {
                    break;
                } else {
                    System.out.println("Can you enter 1 to 5");
                }
            } catch (NumberFormatException errorName) {
                System.out.println("This is not digit");
            }
        }
        return select;
    }

    public static String getString(String mess, String fomatRequireMsg, String regex) {
        String input;
        ////Loop until user enter String from the keyboard
        while (true) {
            System.out.print(mess);
            input = sc.nextLine().trim();
            //User didn't enter anything from the keyboard
            if (input.isEmpty()) {
                System.out.println("Can not null, empty");
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

    public static int getInt() {
        int input;
        //loop until user enter correct position number
        while (true) {
            try {
                System.out.print("Enter Availability: ");
                input = Integer.parseInt(sc.nextLine().trim());
                if (input > 0) {
                    return input;
                }
                else{
                    System.out.println("This is not positive number");
                }
            } catch (NumberFormatException e) {
                System.out.println("This is not digit");
            }
        }
    }

}

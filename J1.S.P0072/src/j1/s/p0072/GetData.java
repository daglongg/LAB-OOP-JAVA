/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0072;

import static j1.s.p0072.CheckData.sc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dangl
 */
public class GetData {

    public static Scanner sc = new Scanner(System.in);

    public static int getSelect(String msg, int min, int max) {
        System.out.println("============ Login Program =========\n"
                + "1. Add User\n"
                + "2. Login\n"
                + "3) Exit");
        int choice;
        ////Loop until user enter positive number in range of min and max
        while (true) {
            System.out.print("Please choice one option: ");
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

    public static String getUsername(String mess, String regex) {
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
                if (CheckData.checkFileExits() == false) {
                    break;
                } else {
                    if (input.matches(regex)) {
                        //Check matches of the input
                        if (CheckData.checkUsernameExits(input) == false) {
                            break;
                        } else {
                            //if input of user not flow the matches with regex
                            System.out.println("Username already exits in DB");
                        }
                    }else{
                        System.out.println("Sai fomat");
                    }
                }
            }
        }
        return input;
    }

    public static Date getDate(String mess, String fomatRequireMsg, String regex) {
        Date input = null;
        ////Loop until user enter String from the keyboard
        while (true) {
            System.out.print(mess + ": ");
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false);
                String userEnter = sc.nextLine().trim();
                //User didn't enter anything from the keyboard
                if (userEnter.isEmpty()) {
                    System.out.println(mess + " cannot null, empty");
                } else {
                    //if regex is empty
                    if (regex.isEmpty()) {
                        break;
                    } else {
                        //Check matches of the input
                        if (userEnter.matches(regex)) {
                            input = dateFormat.parse(userEnter);
                            break;
                        } else {
                            //if input of user not flow the matches with regex
                            System.out.println(fomatRequireMsg);
                        }
                    }
                }
            } catch (ParseException ex) {
                System.out.println("Date not exits");

            }
        }
        return input;
    }

    static boolean getYesNo(String mess) {
        //loop until user enter correct Yes or No
        while (true) {
            System.out.print(mess + ": ");
            String userEnter = sc.nextLine().trim();
            if (userEnter.equals("Y")) {
                return true;
            } else if (userEnter.equals("N")) {
                return false;
            } else {
                System.out.println("Can you choose Y or N");
            }
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0072;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author dangl
 */
public class CheckData {

    public static Scanner sc = new Scanner(System.in);


    public static boolean checkUsernameExits(String accountNumber) {
        File file = new File("user.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            //Loop until to end of file
            while ((line = br.readLine()) != null) {
                String [] str = line.split("[*]");
                if (str[0].equals(accountNumber)) {
                    return true;
                }
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return false;
    }

    public static boolean checkFileExits() {
        File file = new File("user.txt");
        //check file exits or not
        return file.exists();
    }
    
        public static boolean checkLogin(ArrayList<Account> listAccount,String username, String password) {
        //Loop to check user name end passowrd user enter to correct or not
            for (Account account : listAccount) {
                if(account.getUserName().equals(username) && account.getPassword().equals(password)){
                    return true;
                }
            }
            return false;
    }

}

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
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author dangl
 */
public class J1SP0072 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, IOException, Exception {
        ArrayList<Account> listAccount = new ArrayList<>();
        //Loop until user want program stop
        while (true) {
            //Step 1: The program prompts users to select an option.
            int chose = GetData.getSelect("Please choice one option: ", 1, 3);
            if (chose == 1) {
                //Step 2: Option  1: Add account
                createAccount();
            } //Step 3: Option  2: Login
            else if (chose == 2) {
                loginSystem(listAccount);
            } //Step 4: Option 3: Exit the program.
            else {
                break;
            }
        }

    }

    static void createFile() {
        try {
            File file = new File("user.txt");
            file.createNewFile();
        } catch (IOException ex) {
        }
    }

    public static void createAccount() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("---------- Add User --------");
        J1SP0072 jv = new J1SP0072();
        if (!CheckData.checkFileExits()) {
            String userName = GetData.getUsername("Account", "^[a-zA-Z0-9]+$");
            String password = GetData.getString("Password", "", "");
            String name = GetData.getString("Name", "", "");
            String phone = GetData.getString("Phone", "Phone number must be 10 or 11 number", "^[0-9]{10,11}");
            //String email = GetData.getString("Email", "Email is vaild format", "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
            String email = GetData.getString("Email", "Email is vaild format","^.+@.+\\..+$");
            //"^.+@.+\\..+$"
            String address = GetData.getString("Address", "", "");
            String dob = dateFormat.format(GetData.getDate("DOB", "Date of birth is valid format dd/MM/yyy", "^[0-9]{2}/[0-9]{2}/[0-9]{4}$"));
            createFile();
            try {
                if (jv.addAccount(userName, MD5Encryption(password), name, phone, email, address, dob) == 1) {
                    return;
                }
            } catch (Exception ex) {
            }
        }
        String userName = GetData.getUsername("Account", "^[a-zA-Z0-9]+$");
        String password = GetData.getString("Password", "", "");
        String name = GetData.getString("Name", "", "");
        String phone = GetData.getString("Phone", "Phone number must be 10 or 11 number", "^[0-9]{10,11}");
        String email = GetData.getString("Email", "Email is vaild format", "^.+@.+\\..+$");
        String address = GetData.getString("Address", "", "");
        String dob = dateFormat.format(GetData.getDate("DOB", "Date of birth is valid format dd/MM/yyy", "^[0-9]{2}/[0-9]{2}/[0-9]{4}$"));
        try {
            if ((jv.addAccount(userName, MD5Encryption(password), name, phone, email, address, dob) == 1)) {
                return;
            }
        } catch (Exception ex) {
        }
    }


    private static void loginSystem(ArrayList<Account> listAccount) throws ParseException, IOException, Exception {
        
        System.out.println("------------- Login ----------------");
        listAccount.clear();
        //check file has exits or not
        if (!CheckData.checkFileExits()) {
            System.out.println("File dont exits");
            return;
        }
        loadFromFile(listAccount);
        String userName = GetData.getString("Account", "", "");
        String password = MD5Encryption(GetData.getString("Password", "", ""));
        if (CheckData.checkLogin(listAccount,userName, password) == true) {
            System.out.println("-------------------Wellcome-------------------");
            if (GetData.getYesNo("Hi Skyline, do you want change password now? Y/N") == true) {
                //Loop until user enter correct old password
                for (Account account : listAccount) {
                    if (account.getUserName().equals(userName) && account.getPassword().equals(password)) {
                        while (true) {
                            String oldPassword = MD5Encryption(GetData.getString("Old password", "", ""));
                            if (oldPassword.equals(account.getPassword())) {
                                String newPassword = MD5Encryption(GetData.getString("new password", "", ""));
                                while (true) {
                                    String renewPassword = MD5Encryption(GetData.getString("renew password", "", ""));
                                    if (newPassword.equals(renewPassword)) {
                                        account.setPassword(newPassword);
                                        updateAccount1(listAccount);
                                        break;
                                    } else {
                                        System.out.println("Passoword not same");
                                    }
                                }
                                break;
                            } else {
                                System.out.println("Passoword not same");
                            }
                        }
                    }
                }
            }
        }
    }

    public int addAccount(String username, String password, String name, String phone, String email, String address, String dob) throws Exception {
        File file = new File("user.txt");
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write(username + "*" + password + "*" + name + "*" + phone + "*" + email + "*" + address + "*" + dob + "\n");
            fw.close();
            return 1;
        } catch (IOException ex) {
        }

        return 0;

    }

    static void loadFromFile(ArrayList<Account> listAccount) throws ParseException, IOException {
        File file = new File("user.txt");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (CheckData.checkFileExits()) {
            try {
                Reader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                String line;
                //Loop until to null of file
                while ((line = br.readLine()) != null) {
                    String[] account = line.split("[*]");
                    String userName = account[0];
                    String password = account[1];
                    String name = account[2];
                    String phone = account[3];
                    String email = account[4];
                    String address = account[5];
                    Date dob = dateFormat.parse(account[6]);
                    listAccount.add(new Account(userName, password, name, phone, email, address, dob));
                }
            } catch (FileNotFoundException ex) {
            }
        }
    }

    public static void updateAccount1(ArrayList<Account> listAccount) throws Exception {
        File file = new File("user.txt");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            FileWriter fw = new FileWriter(file);
            for (Account account : listAccount) {
                String dob = dateFormat.format(account.getDateOfBirth());
                fw.write(account.getUserName() + "*" + account.getPassword() + "*" + account.getName() + "*" + account.getPhone() + "*" + account.getEmail() + "*" + account.getAddress() + "*" + dob + "\n");
            }
            fw.close();
        } catch (IOException ex) {
        }

    }
     private static String MD5Encryption(String password) {
         String md5Pass = " ";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            md5Pass = DatatypeConverter.printHexBinary(md.digest()).toLowerCase();
            return  md5Pass;
        } catch (NoSuchAlgorithmException ex) {
        }
        return null;
    }
     
     
     
     
     
     
}

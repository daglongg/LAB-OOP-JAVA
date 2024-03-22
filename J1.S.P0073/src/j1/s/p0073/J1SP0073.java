/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0073;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dangl
 */
public class J1SP0073 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Expense> list = new ArrayList<>();
        //Loop until user want stop program
        while (true) {
            //Step 1: Display menu
            int chose = displayMenu();
            if (chose == 1) {
                //Step 2: If the user chooses 1, add an expense
                addExpense(list);
            } //Step 3: If the user chooses 2, The program displays a list of data as follows
            else if (chose == 2) {
                displayAll(list);
            } //Step 4: If the user chooses 3. Remove an expense
            else if (chose == 3) {
                removeExpense(list);
            } //Step 4: If the user chooses 4, exit program.
            else {
                break;
            }
        }

    }

    private static int displayMenu() {
        int chose = 0;
        System.out.println("======Handy Expense program======");
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expenses");
        System.out.println("3. Delete an expense");
        System.out.println("4. Quit");
        chose = GetData.getSelect("Your choice:", 1, 3);
        return chose;
    }

    private static void addExpense(ArrayList<Expense> list) {
        list.clear();
        J1SP0073 jm = new J1SP0073();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        System.out.println("-------- Add an expense--------");
        if (CheckData.checkFileExits() == false) {
            int id = 1;
            String dob = GetData.getDate("Enter Date", "Date of birth is valid format dd-MM-yyy", "^[0-9]{2}-[0-9]{2}-[0-9]{4}$");
            double quantity = GetData.getNumber("Enter Amount", 0);
            String content = GetData.getString("Enter Content", "", "^[a-zA-Z0-9\\s]*$");
            jm.addExpense(id, dob, quantity, content);
        } else {
            loadFromFile(list);
            int id = jm.getID(list);
            String dob = GetData.getDate("Enter Date", "Date of birth is valid format dd-MM-yyy", "^[0-9]{2}-[0-9]{2}-[0-9]{4}$");
            double quantity = GetData.getNumber("Enter Amount", 0);
            String content = GetData.getString("Enter Content", "", "^[a-zA-Z0-9\\s]*$");
            jm.addExpense(id, dob, quantity, content);
        }
    }

    private static void displayAll(ArrayList<Expense> list) {
        System.out.println("---------Display all expenses------------");
        list.clear();
        loadFromFile(list);
        if (CheckData.checkFileExits() == false) {
            System.out.println("File not exits");
        } else if (list.isEmpty()) {
            System.out.println("List empty");
        } else {
            double total = 0;
            System.out.printf("%-7s%-13s%-10s%-20s\n", "ID", "Date", "Amount", "Content");
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%-7d%-13s%-10s%-20s\n", list.get(i).getID(), list.get(i).getDate(),
                        list.get(i).getQuantity(), list.get(i).getContent());
                total += list.get(i).getQuantity();
            }
            System.out.printf("Total: %-20.0f\n", total);
        }
    }

    private static void removeExpense(ArrayList<Expense> list) {
        System.out.println("--------Delete an expense------");
        list.clear();
        loadFromFile(list);
        if (CheckData.checkFileExits() == false) {
            System.out.println("File not exits");
        } else if (list.isEmpty()) {
            System.out.println("List empty");
        } else {
            int idRemove = (int) GetData.getNumber("Enter ID", 0);
            boolean removed = false;
            if (CheckData.checkIdExits(idRemove)) {
                System.out.println("");
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getID() == idRemove) {
                        list.remove(i);
                    }
                }
            }
            updateAccount1(list);
        }
    }

    

    

    public void addExpense(int ID, String date, double Quantity, String content) {
        File file = new File("user.txt");
        try {
            try (FileWriter fw = new FileWriter(file, true)) {
                fw.write(ID + "*" + date + "*" + Quantity + "*" + content + "\n");
            }
        } catch (IOException ex) {
        }

    }

    static void loadFromFile(ArrayList<Expense> listAccount) {
        File file = new File("user.txt");
        if (CheckData.checkFileExits()) {
            try {
                Reader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                String line;
                //Loop until to null of file
                while ((line = br.readLine()) != null) {
                    String[] account = line.split("[*]");
                    int Id = Integer.parseInt(account[0]);
                    String date = account[1];
                    double quantity = Double.parseDouble(account[2]);
                    String content = account[3];
                    listAccount.add(new Expense(Id, date, quantity, content));
                }
            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            }
        }
    }

    public static void updateAccount1(ArrayList<Expense> listAccount) {
        File file = new File("user.txt");
        try {
            try (FileWriter fw = new FileWriter(file)) {
                for (Expense account : listAccount) {
                    fw.write(account.getID() + "*" + account.getDate() + "*" + account.getQuantity() + "*" + account.getContent() + "\n");
                }
            }
        } catch (IOException ex) {
        }
    }

    public int getID(ArrayList<Expense> listAccount) {
        int id = 0;
        if (listAccount.isEmpty()) {
            return 1;
        } else {
            for (Expense expense : listAccount) {
                if (expense.getID() == listAccount.size()) {
                    id = expense.getID() + 1;
                }
            }
        }
        return id;
    }

}

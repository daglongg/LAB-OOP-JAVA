/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor.management;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dangl
 */
public class DoctorManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Doctor> listDoctor = new ArrayList<>();
        //loop until user want exit program
        while (true) {
            //Step 1: User runs the program. The program prompts users selection 
            int choose = displayMenu();
            //Step 2: Option  1: Add Doctor
            if (choose == 1) {
                addDoctor();
            } //Step 3: Option  2: Update Doctor
            else if (choose == 2) {
                updateDoctor(listDoctor);
            } //Step 4: Option  3: Delete Doctor
            else if (choose == 3) {
                deleteDoctor(listDoctor);
            } //Step 5: Option 4: Search Doctor
            else if (choose == 4) {
                searchDoctor(listDoctor);
                //Step 6: Option 5: Exit the program.
            } else if (choose == 5) {
                exitProgram();
                break;
            }
        }

    }

    private static int displayMenu() {
        System.out.println("========= Doctor Management ==========\n"
                + "1.	Add Doctor\n"
                + "2.	Update Doctor\n"
                + "3.	Delete Doctor\n"
                + "4.	Search Doctor\n"
                + "5.	Exit");
        int choice = GetData.getSelect("Enter select: ", 1, 5);
        return choice;
    }

    private static void addDoctor() {
        ArrayList<Doctor> listDoctor = new ArrayList<>();
        if (ChechData.checkFileExits() == false) {
            String code = GetData.getString("Enter Code: ", "Code must be letter and number", "^[a-zA-Z0-9\\s]*$");
            String name = GetData.getString("Enter Name: ", "", "");
            String specialization = GetData.getString("Enter Specialization: ", "", "");
            int availability = GetData.getInt();
            listDoctor.clear();
            createFile();
            listDoctor.add(new Doctor(code, name, specialization, availability));
            addDataToFile(listDoctor);
        } else {
            listDoctor.clear();
            loadFromFile(listDoctor);
            String code = GetData.getString("Enter Code: ", "Code must be letter and number", "^[a-zA-Z0-9\\s]*$");
            if (ChechData.checkCodeExits(listDoctor, code) == false) {
                String name = GetData.getString("Enter Name: ", "", "");
                String specialization = GetData.getString("Enter Specialization: ", "", "");
                int availability = GetData.getInt();
                listDoctor.add(new Doctor(code, name, specialization, availability));
                addDataToFile(listDoctor);
                System.out.println("Succseful");
            } else {
                System.out.println("Code exits");
            }
        }
    }

    private static void updateDoctor(ArrayList<Doctor> listDoctor) {
        Scanner sc = new Scanner(System.in);
        listDoctor.clear();
        loadFromFile(listDoctor);
        if (ChechData.checkFileExits() == false) {
            System.out.println("There are not doctor in update");
        } else if (listDoctor.isEmpty()) {
            System.out.println("There are not doctor 1 in update");
        } else {
            String code = GetData.getString("Enter Code: ", "", "^[a-zA-Z0-9\\s]*$");
            if (ChechData.checkDuplicate(listDoctor, code)) {
                for (Doctor doctor : listDoctor) {
                    if (doctor.getCode().equals(code)) {
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine().trim();
                        if (!name.isEmpty()) {
                            doctor.setName(name);
                        }
                        System.out.print("Enter Specialization: ");
                        String specialization = sc.nextLine().trim();
                        if (!specialization.isEmpty()) {
                            doctor.setSpecialization(specialization);
                        }
                        int availability = GetData.getInt();
                        if (doctor.getAvailability() != availability) {
                            doctor.setAvailability(availability);
                        }
                        addDataToFile(listDoctor);
                        System.out.println("Succseful");
                        return;
                    }
                }
            } else {
                System.out.println("code does not exist Doctor");
            }
        }
    }

    private static void deleteDoctor(ArrayList<Doctor> listDoctor) {
        listDoctor.clear();
        loadFromFile(listDoctor);
        if (ChechData.checkFileExits() == false) {
            System.out.println("There are not doctor in update");
        } else if (listDoctor.isEmpty()) {
            System.out.println("There are not doctor in update");
        } else {
            String code = GetData.getString("Enter Code", "", "^[a-zA-Z0-9\\s]*$");
            if (ChechData.checkDuplicate(listDoctor, code)) {
                for (Doctor doctor : listDoctor) {
                    if (doctor.getCode().equals(code)) {
                        listDoctor.remove(doctor);
                        addDataToFile(listDoctor);
                        System.out.println("Succseful");
                        return;
                    }
                }
            } else {
                System.out.println("code does not exist Doctor");
            }
        }
    }

    private static void searchDoctor(ArrayList<Doctor> listDoctor) {
        Scanner sc = new Scanner(System.in);
        listDoctor.clear();
        loadFromFile(listDoctor);
        if (ChechData.checkFileExits() == false) {
            System.out.println("There are not doctor in update");
        } else if (listDoctor.isEmpty()) {
            System.out.println("There are not doctor in update");
        } else {
            String text = sc.nextLine().trim();
            ArrayList<Doctor> list = new ArrayList<>();
            list.clear();
            if (!text.isEmpty()) {
                for (Doctor doctor : listDoctor) {
                    if (doctor.getCode().contains(text) || doctor.getName().contains(text) || doctor.getSpecialization().contains(text)) {
                        list.add(doctor);
                    }
                }
                if (list.isEmpty() == false) {
                    for (Doctor doctor : list) {
                        System.out.println(doctor.getCode() + " " + doctor.getName() + " " + doctor.getSpecialization() + " " + doctor.getAvailability());
                    }
                } else {
                    System.out.println("Dont find text in list");
                }
            }
        }
    }

    private static void exitProgram() {
        System.out.println("Exit program");
    }

    public static void loadFromFile(ArrayList<Doctor> listDoctor) {
        File file = new File("user.txt");
        try {
            FileInputStream fl = new FileInputStream(file);
            ObjectInputStream objectTaskInput = new ObjectInputStream(fl);
            Doctor doctor = (Doctor) objectTaskInput.readObject();
            //loop until there are no more objects to read 
            while (doctor != null) {
                listDoctor.add(doctor);
                doctor = (Doctor) objectTaskInput.readObject();
            }
            objectTaskInput.close();
            fl.close();
        } catch (Exception fileException) {
        }

    }

    public static void addDataToFile(ArrayList<Doctor> listDoctor) {
        try {
            FileOutputStream file = new FileOutputStream("user.txt", false);
            ObjectOutputStream objectTaskOutput = new ObjectOutputStream(file);
            //Loop through from the first to the last element of list
            for (Doctor doctor : listDoctor) {
                objectTaskOutput.writeObject(doctor);
            }
            objectTaskOutput.close();
            file.close();
        } catch (Exception fileException) {
        }
    }

    public static void createFile() {
        File file = new File("user.txt");
        try {
            file.createNewFile();
        } catch (IOException ex) {
        }
    }

}

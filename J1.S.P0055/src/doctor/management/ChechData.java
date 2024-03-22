/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor.management;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author dangl
 */
public class ChechData {
    public static boolean checkFileExits(){
        File file = new File("user.txt");
        return file.exists();
    }
    

    
    public static boolean checkCodeExits(ArrayList<Doctor> listDoctor, String code){
        for (Doctor doctor : listDoctor) {
            if(doctor.getCode().equalsIgnoreCase(code)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkDuplicate(ArrayList<Doctor> listDoctor, String code){
        for (Doctor doctor : listDoctor) {
            if(doctor.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }
    
}

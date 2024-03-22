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
import java.io.IOException;


/**
 *
 * @author dangl
 */
public class CheckData {
    public static boolean checkIdExits(int id) {
        File file = new File("user.txt");
        try {
            try (FileReader fr = new FileReader(file)) {
                BufferedReader br = new BufferedReader(fr);
                String line;
                //Loop until to end of file
                while ((line = br.readLine()) != null) {
                    String [] str = line.split("[*]");
                    int idcheck = Integer.parseInt(str[0]);
                    if (idcheck == id) {
                        return true;
                    }
                }
                br.close();
            }
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
  
}

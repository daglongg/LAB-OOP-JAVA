/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011_change_base_number;
import static j1.s.p0011_change_base_number.J1SP0011_Change_Base_Number.sc;

/**
 *
 * @author dangl
 */
public class Menu {
        public static int enterUserChoose(){
        int number = 0;
        boolean checkUserEnter = false;
        //Display menu and ask user and check condition
        do{
           System.out.println("Welcome to Change number system (16,10,2)");
            System.out.println("If you want change number. Please enter 1");
            System.out.println("If you want close the program. Please enter 2");
            String ennterUser = sc.next();
            //Check enter user 
        try{
            number = Integer.parseInt(ennterUser);
            if(number > 0 && number < 3){
                checkUserEnter = true;
            }else{
                System.out.println("Error. Can you choose 1 or 2");
            }
        }catch(NumberFormatException e){
            System.out.println("Enter the number. Can you enter again");
        }
    }while(!checkUserEnter);
    return number;
    }       
}

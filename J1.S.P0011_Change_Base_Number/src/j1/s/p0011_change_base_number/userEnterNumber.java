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
public class userEnterNumber {
    public static String askUserNumber(int numberInput){
        String numberUserInput = null;
        if(numberInput == 1){
            boolean checkNumber = false;
            String numberUserEnter;
            do{
                System.out.println("Enter the number you want change: ");
                numberUserEnter = sc.next();
                if(numberUserEnter.matches("[01]+")){
                    checkNumber = true;
                    numberUserInput = numberUserEnter;
                }else{
                    System.out.println("Please check the binary number again.");
                }
            }while(!checkNumber);
            
//        for(int i = 0; i < numberUserInput.length(); i++){
//            System.out.print(numberUserInput.charAt(i));
//            }
        }
        if(numberInput == 2){
            boolean checkNumber = false;
            String numberUserEnter;
            do{
                System.out.println("Enter the number you want change: ");
                numberUserEnter = sc.next();
                if(numberUserEnter.matches("[0-9]+")){
                    checkNumber = true;
                    numberUserInput = numberUserEnter;
                }else{
                    System.out.println("Please check the binary number again.");
                }

            }while(!checkNumber); 
            numberUserInput = numberUserEnter;
        }
        if(numberInput == 3){
            boolean checkNumber = false;
            String numberUserEnter;
            do{
                System.out.println("Enter the number you want change: ");
                numberUserEnter = sc.next();
                if(numberUserEnter.matches("[0-9A-F]+")){
                    checkNumber = true;
                    numberUserInput = numberUserEnter;
                }else{
                    System.out.println("Please check the binary number again.");
                }
            }while(!checkNumber);  
        }
        
        
        return numberUserInput;
    } 
    
}

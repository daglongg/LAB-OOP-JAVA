package j1.s.p0011_change_base_number;


import static j1.s.p0011_change_base_number.ChangNumber.changeBase;
import java.util.Scanner;


public class J1SP0011_Change_Base_Number {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choise = 0;
            do{
                // Enter the number user choose.
                choise = Menu.enterUserChoose();
                switch(choise){
                    case 1:
                        //Step 1: Ask use choose the base number input
                        int numberInput= inputNumber();
                        //Step 2: Ask use choose the base number output
                        int numberOutput = outputNumber();
                        //Step 3: Ask user the number
                        String number = userEnterNumber.askUserNumber(numberInput);
                        //Step 4: Change Base Number
                            String numberChange =  changeBase(numberInput, numberOutput, number);
                        //Step 4: Output value after change
                        ChangNumber.displayValue(numberChange);
                        break;
                    case 2:
                    break;
                }
        }while(choise != 2);
            
    }    
    
    public static int inputNumber(){
        int number = 0;
        boolean checkNumber = false;
        do{
            System.out.println(" choose the input base system: ");
            System.out.println(" 1 is binary, 2 is decimal,  3 is hexadecimal.");
            String numberUserChoose = sc.next();
            try{
             number = Integer.parseInt(numberUserChoose);
                if(number == 1 || number == 2 || number == 3){
                    checkNumber = true;
                }else{
                System.out.println("Can you choose 1 or 2 or 3.");
            }
              
            }catch(NumberFormatException e){
                System.out.println("Can you enter the number ?");
            }
        }while(!checkNumber);
        
        return number;
    }
    
    public static int outputNumber(){
        int number = 0;
        boolean checkNumber = false;
        do{
            System.out.println(" choose the output base system: ");
            System.out.println(" 1 is binary, 2 is decimal,  3 is hexadecimal.");
            String numberUserChoose = sc.next();
            try{
                number = Integer.parseInt(numberUserChoose);
                if(number == 1 || number == 2 || number == 3){
                    checkNumber = true;
                }else{
                    System.out.println("Can you choose 1 or 2 or 3.");
                }
            }catch(NumberFormatException e){
                System.out.println("Can you enter the number ?");
            }
        }while(!checkNumber);
        return number; 
    }
}

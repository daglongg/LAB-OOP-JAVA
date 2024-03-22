/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011_change_base_number;

import java.math.BigInteger;

/**
 *
 * @author dangl
 */
public class ChangNumber {
    public static String changeBase(int inputNumber, int outputNumber, String number){
        StringBuilder numberChange = new StringBuilder();
        //User input BIN and outPut BIN
        if(inputNumber == 1  && outputNumber == 1){
            numberChange.append(Integer.parseInt(number));
        }else if(inputNumber == 1  && outputNumber == 2){
            numberChange.append(binaryToDecimal(number));
        }else if(inputNumber == 1  && outputNumber == 3){
            numberChange.append(decimalToHex(binaryToDecimal(number)));
        }else if (inputNumber == 2 && outputNumber == 1) {
            numberChange.append(decimalToBin(number));
        }else if (inputNumber == 2 && outputNumber == 2) {
            numberChange.append(Integer.parseInt(number));
        }else if (inputNumber == 2 && outputNumber == 3) {
            numberChange.append(decimalToHex(number));
        }else if(inputNumber == 3  && outputNumber == 1){
            numberChange.append(decimalToBin(hexToDecimal(number)));
        }else if(inputNumber == 3  && outputNumber == 2){
           numberChange.append(hexToDecimal(number));
        }else{
            numberChange.append(number);
        }
        return numberChange.toString();
        
    }
    //
 ́́/*
          */
   
    public static String binaryToDecimal(String number){
        BigInteger value = BigInteger.ZERO;
            int mu = number.length() - 1;
            for(int i= 0; i < number.length(); i++){
                if(number.charAt(i) == '1'){
                value  = value.add(BigInteger.valueOf(2).pow(mu));
                }
                mu--;
            }
            return value.toString();
    }
    
    public static String decimalToHex(String decimalNumber){
        BigInteger value = new BigInteger(decimalNumber);
        String valueHex = "";
        while (value.compareTo(new BigInteger("0")) != 0) {
            BigInteger[] divAndRemain = value.divideAndRemainder(new BigInteger("16"));
            value = divAndRemain[0];
        BigInteger remainder = divAndRemain[1];
        if (remainder.intValue() >= 0 && remainder.compareTo(new BigInteger("9")) <= 0) {
            valueHex = remainder.toString() + valueHex;
        } else if (remainder.compareTo(new BigInteger("10")) >= 0 && remainder.compareTo(new BigInteger("15")) <= 0) {
            char hexChar = (char) ('A' + remainder.intValue() - 10);
            valueHex = hexChar + valueHex;
        }
    }
        
        return valueHex;

    }
     
    public static String decimalToBin(String inputValue ) {
        String valueBinary = "";
        BigInteger inputDec = new BigInteger(inputValue);
        // Div until divisor = 0;
        // Take remainder into String from last --> 0
        while (inputDec.compareTo(new BigInteger("0")) != 0) {
            BigInteger[] divAndRemain = inputDec.divideAndRemainder(new BigInteger("2"));
            inputDec = divAndRemain[0];
            BigInteger remainder = divAndRemain[1];
            valueBinary = remainder + valueBinary;
        }
        return valueBinary;
    }
    
    public static String hexToDecimal(String hex) {
        BigInteger value = BigInteger.ZERO; //To save value after convert
        int mu = hex.length() - 1;
        for (int i = 0; i < hex.length(); i++) {
            int element = hex.charAt(i) - '0'; // Chuyển đổi ký tự thành số

        BigInteger powerOfIdx = BigInteger.valueOf(16).pow(mu);
        if (element >= 0 && element <= 9) {
            value = value.add(BigInteger.valueOf(element).multiply(powerOfIdx)); // Tính giá trị trực tiếp
        } else {
            value = value.add(BigInteger.valueOf(10 + (hex.charAt(i) - 'A')).multiply(powerOfIdx)); // Chuyển đổi ký tự [a, f] thành giá trị số
        }        
        mu--; // Giảm index
    }
        //System.out.println(" = " + decimal);
        return value.toString();
        
    }
    static void displayValue(String numberChange) {
        System.out.println(numberChange);
    }
    
    
    
    
}

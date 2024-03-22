/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0002_selection_sort;

import java.util.Random;
import java.util.Scanner;

public class J1SP0002_Selection_Sort {

    public static void main(String[] args) {
//        //1. Display a screen to ask users to enter a positive decimal number and Users input a positive decimal number.
//        int sizeArray = displayPositive();
//        //2. Generate random integer in number range for each array element.
//        int array[] = arrayRandomNumber(sizeArray);
//        //3. Display array before Sort. 
//        displayUnsortedArray(array);
//        //4. Sort Array
//        int arraySort[] = sortArray(array);
//        //5.Dispay after sorting.
//        displaySortedArray(arraySort);
        //Step 6: Test code
        int[] arrayNumber = {5, 1, 12, -5, 16, 2, 12, 14};

        sortArray(arrayNumber);

    }

    //1. Display a screen to ask users to enter a positive decimal number and Users input a positive decimal number.
//    private static int displayPositive(){
//        Scanner sc = new Scanner(System.in);
//        //Supposed Positive Number = 0;
//        int positiveNumber = 0;
//        // Create variable to check if the number is a Positive Number ?
//        boolean checkPositiveNumber = false;
//        // Use loop to check, if true then stop loop.
//        do{
//            //Use try catch to check, if no true then ask again.
//            try{
//                //Display "Enter number of array: "
//                System.out.println("Enter number of array: ");
//                String Position = sc.next();
//                //Check user have enter true Number ? 
//                // If not catch active now, display and ask user again.
//                positiveNumber = Integer.parseInt(Position);
//                //Check this numebr have true Position Number ?
//                if(positiveNumber > 0){
//                    checkPositiveNumber = true;
//                // If not, display and ask again ?
//                }else{
//                    System.out.println("This number is not Positive Number. Can you enter again ?");
//                }
//            }catch(NumberFormatException e){
//                System.out.println("This is not a number." + e);
//            }
//        }while(!checkPositiveNumber);
//        // Return Positive Number
//        return positiveNumber;
//    }
//    
//    //2. Generate random integer in number range for each array element and Display array before Sort. 
//    private static int[]arrayRandomNumber(int sizeArray){
//        //Create array have size is sizeArray.
//        int[]array = new int[sizeArray];
//        //Use library to crated random number.
//        Random random = new Random();
//        //Use loop to assign random number to array.
//        for(int i = 0; i < sizeArray; i++){
//            //assign random number to array
//            //Cteat and assgim
//            array[i] = random.nextInt(sizeArray);
//        }
//        // Return Array
//        return array;               
//    }
//    //3. Display array before Sort. 
//    public static void displayUnsortedArray(int[]array){
//        // Display Unsorted Array
//        System.out.print("Unsorted array: [");
//        //Use loop to display array.
//        for(int i = 0; i < array.length; i++){
//            System.out.print(array[i]);
//            // create ', ' 
//            if(i< array.length - 1){
//                System.out.print(", ");
//            }
//        }
//        System.out.println("]");
//    }
    //3.Use Selection Sort to Sort, and dispay after sorting.
    private static int[] sortArray(int[] array) {
        //use for loop traverse elements
        for (int i = 0; i < array.length; i++) {
            //reset the min of the array after loop
            int minArray = i;
            //use for loop traverse elements
            for (int j = i + 1; j < array.length; j++) {
                //compare with min of array
                if (array[j] < array[minArray]) { 
                    //Update position min of array
                    minArray = j;  
                }
            }
            
            //Swap min of array
            int temp = array[minArray];
            array[minArray] = array[i];
            array[i] = temp;

        }
        return array;
    }

    public static void displaySortedArray(int[] array) {
        // Display Unsorted Array
        System.out.print("Sorted array: [");
        //Use loop to display array.
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            // create ', ' 
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}

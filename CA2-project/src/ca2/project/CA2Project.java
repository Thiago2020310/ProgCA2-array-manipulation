/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca2.project;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class CA2Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            Scanner input = new Scanner(System.in);
            /*
            Task 1: Array Search – Find the First Repeated Element
            Take the size of the array and its elements as input.
                - First declare the array.
                - Get the size of the array from the user
                - Get the elements of the array from the user, based on the size input
            Find and print the first element that repeats in the array (i.e., occurs more than once).
                - Loop through the array:
                    - Get next index and loop through the array to check if equals.
                    - If no element repeats, print "No repeated elements found."
            
            System.out.println("Enter the Size of the array: ");
            int arraySize = input.nextInt();
            System.out.println("Enter the elements of the array: ");
            int[] arrayElements = new int[arraySize];
            int tempElement = input.nextInt();
            arrayElements[0] = tempElement;
            for(int i = 1; i < arraySize; i++){
                System.out.println("Enter the next element of the array: ");
                tempElement = input.nextInt();
                arrayElements[i] = tempElement;
            }
            System.out.println("Your array is " + Arrays.toString(arrayElements));
            boolean isDuplicate = false;
            for(int i = 0; i < arrayElements.length; i++){
                for(int j = i+1; j < arrayElements.length; j++){
                    if(arrayElements[i] == arrayElements[j]){
                        System.out.println("Duplicate element found: " + arrayElements[i] + " and " + arrayElements[j]);
                        isDuplicate = true;
                        return;
                    }
                }
            }
            if(!isDuplicate){
                System.out.println("No duplicate elements found.");
            }
            
            */
            
            
            /*
            Task 2: Multiplication Table Using 2D Array
            Write a program that generates a multiplication table using a 2D array. The size of the table (e.g.n×n)should be input by the user.
                - Declare a 2d array.
                - Get the rows and columns from the user.
                - The size of the array is the multiplication of the user inputs.
            Populate the 2D array with the multiplication values and display the table in matrix form.
                -Loops to create the multiplication table, with outer loop representing the rows and the inner looping representing the columns:
            
            System.out.println("What is the size of the multiplication table: ");
            int multTableSize = input.nextInt();
            int[][] multTable = new int[multTableSize][multTableSize];
            int num1 = 1;
            int multiplier = 1;
            System.out.println("This is your Matrix multiplication table: ");
            for(int i=0; i < multTable.length; i++){
                for(int j=0; j< multTable.length; j++){
                    int result = num1 * multiplier;
                    multTable[i][j] = result;
                    multiplier++;
                    if(result < 10){
                        System.out.print("  0" + multTable[i][j] + "   ");
                    }else{
                        System.out.print("  " + multTable[i][j] + "   ");
                    }
                }
                mult++;
                multiplier = 1;
                System.out.println(" ");
            }
            
            //System.out.println(Arrays.deepToString(multTable));
            */
            
            
            
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }

        
        
        

    }
    
}

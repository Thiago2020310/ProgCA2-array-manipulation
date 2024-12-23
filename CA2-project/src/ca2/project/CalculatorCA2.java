/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2.project;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class CalculatorCA2 {
    
    private int num1;
    private int num2;
    
    
    public CalculatorCA2(){
        this.num1 = num1;
        this.num2 = num2;
        int result;
    }
    
    
    /*
    Ps. All of the Tasks are separated by methods. The methods error handling are similar or equal to each other:
    Try and catch is being used for the whole code inside the methods, since we are only accepting integers, the programs will only break if the user don't enter a integer.
    A try and catch is being used on the size of the matrixes to send a personalized message for the user and stop the function as soon as that error is found.
    */
    
    /*
    //_________________________________________TASK 1_______________________________________
    Task 1: Array Search – Find the First Repeated Element
    Take the size of the array and its elements as input.
        - First declare the array.
        - Get the size of the array from the user
        - Get the elements of the array from the user, based on the size input
    Find and print the first element that repeats in the array (i.e., occurs more than once).
        - Loop through the array:
            - Get next index and loop through the array to check if equals.
            - If no element repeats, print "No repeated elements found."
     */
    Scanner input = new Scanner(System.in);
    
    public String getFirstElement(){
        String message = "";
        boolean error = false;
        try{
            int arraySize = 0;
            System.out.println("Enter the Size of the array: ");
            try{
                arraySize = input.nextInt();
            }catch(Exception e){
                System.out.println("Error: You need to input an integer number for the size of the array.");
                error = true;
            }
            if (error) {
                return null;
            }
            System.out.println("Enter the elements of the array: ");
            int[] arrayElements = new int[arraySize];
            int tempElement = input.nextInt();
            arrayElements[0] = tempElement;
            for (int i = 1; i < arraySize; i++) {
                System.out.println("Enter the next element of the array: ");
                tempElement = input.nextInt();
                arrayElements[i] = tempElement;
            }
            System.out.println("Your array is " + Arrays.toString(arrayElements));
            boolean isDuplicate = false;
            for (int i = 0; i < arrayElements.length; i++) {
                for (int j = i + 1; j < arrayElements.length; j++) {
                    if (arrayElements[i] == arrayElements[j]) {
                        isDuplicate = true;
                        //The message will be returned if a repeated element is found.
                        message = "The first elements to repeat are: " + arrayElements[i] + " and " + arrayElements[j];
                        //Since we are only looking for the first element, we can use the return to stop the function and return the message to the user.
                        return message;
                    }
                }
            }
            if (!isDuplicate) {
                message = "No duplicate elements found.";
                return message;
            }
        }catch(Exception e){
            System.out.println("Error: Only numbers are accepted. ");
            error = true;
        }
        if(error){
            return null;
        }else{
            return message;
        }
    }
    
    
    
    
    
    //_________________________________________TASK 2_______________________________________
    /*
    Task 2: Multiplication Table Using 2D Array
    Write a program that generates a multiplication table using a 2D array. The size of the table (e.g.n×n)should be input by the user.
        - Declare a 2d array.
        - Get the rows and columns from the user.
        - The size of the array is the multiplication of the user inputs.
    Populate the 2D array with the multiplication values and display the table in matrix form.
        -Loops to create the multiplication table, with outer loop representing the rows and the inner looping representing the columns:
     */
    public String multTable2D(){
        String message = "";
        boolean error = false;
        try{
            System.out.println("What is the size of the multiplication table: ");
            int multTableSize = 0;
            System.out.println("Enter the Size of the array: ");
            try {
                multTableSize = input.nextInt();
            } catch (Exception e) {
                System.out.println("Error: You need to input an integer number for the size of the array.");
                error = true;
            }
            if (error) {
                return null;
            }
            int[][] multTable = new int[multTableSize][multTableSize];
            int num1 = 1;
            int multiplier = 1;
            int result = 0;
            System.out.println("This is your Matrix multiplication table: ");
            for (int i = 0; i < multTable.length; i++) {
                for (int j = 0; j < multTable.length; j++) {
                    result = num1 * multiplier;
                    multTable[i][j] = result;
                    multiplier++;
                    if (result < 10) {
//                        System.out.print("  0" + multTable[i][j] + "   ");
                        message += "  0" + multTable[i][j] + "   ";
                    } else {
//                        System.out.print("  " + multTable[i][j] + "   ");
                        message += "  " + multTable[i][j] + "   ";
                    }
                }
                num1++;
                multiplier = 1;
                message += "\n";
            }
        }catch(Exception e){
            System.out.println("Error: Only ingeter numbers accepted.");
            error = true;
        }


        //The return here will not actualy return any value. The table will be displayed to the user with the for loop.
        if (error) {
            return null;
        } else {
            return message;
        }
        //System.out.println(Arrays.deepToString(multTable));
    }
    
    
    
    
    
    //_________________________________________TASK 3_______________________________________
    /*     
    Task 3: Diagonal Sum of a Matrix
    Write a Java program to calculate the sum of the main diagonal and the secondary diagonal of a
    square matrix. 
        -Firstly we need to create an 2d array, we can use the array created on task 2 on this task. (multTable)
        -We will need to get the length of the array.
            -We get the length of the array(matrix) from the user input.
            -Create a 2d array and set the size of rows and column by the size input from the user.
            -Run a loop to get the elements from the user.
            -I'm using another loop to display the matrix for the user.
        -To calculate the main diagonal we will use the i for both indexes on the table.
            -To calculate the main diagonal we only need to run a one for loop. Theres no need for a loop inside a loop.
            -We can use i for both indexes of row and column. And increment the element on those indexes to the sum. 
        -To calculate the secondary diagonal of a square matrix:
            -First we need to hold the value of row (starting on 0)
            -Then run a for loop, but now we are going to use the values inverted:
                -The order for the calc will be last item on row 1, second last item on row 2 and so on
                -The loop will start from the max length. 
                -Since we need index 0, the loop will start on higher than -1 (equals 0)
                -Lastly we substract 1 from i every loop;
                -Within the loop we will calculate the result by adding the sum with the element on row and i;
                -Lastly we will increment the row variable within the loop to jump to next row. 
     */
    
    public String diagSum(){
        String message = "";
        boolean error = false;
        try{
            System.out.println("Enter the size of the matrix");
            int matrixSize = 0;
            try {
                matrixSize = input.nextInt();
            } catch (Exception e) {
                System.out.println("Error: You need to input an integer number for the size of the array.");
                error = true;
            }
            if (error) {
                return null;
            }
            System.out.println("Enter the elements row by row: ");
            int[][] diagonalSum = new int[matrixSize][matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                System.out.println("Row " + i + ": (one by one)");
                for (int j = 0; j < matrixSize; j++) {
                    diagonalSum[i][j] = input.nextInt();
                }
            }
            System.out.println("This is your matrix: ");
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    if (diagonalSum[i][j] < 10) {
                        System.out.print("  0" + diagonalSum[i][j] + "   ");
                    } else {
                        System.out.print("  " + diagonalSum[i][j] + "   ");
                    }
                }
                System.out.println(" ");
            }
            int mainSumResult = 0;
            for (int i = 0; i < diagonalSum.length; i++) {
                mainSumResult += diagonalSum[i][i];
            }

            int secSumResult = 0;
            int row = 0;
            for (int i = diagonalSum.length - 1; i > -1; i--) {
                secSumResult += diagonalSum[row][i];
                row++;
            }
            message = "The main diagonal on this matrix sum to: " + mainSumResult + "\n"
                    + "The sum of the secondary diagonal on this matrix is: " + secSumResult;
            
        }catch(Exception e){
            System.out.println("Error: Only integer numbers accept.");
            error = true;
        }
        if (error) {
            return null;
        } else {
            return message;
        }
    }
    
    /*
    Task 4: Spiral Traversal of a Matrix
    Write a program to traverse a matrix in spiral order. The program should accept the dimensions and
    elements of the matrix as input and then display the spiral traversal.
        -The dimension will be 2d based on the array size input (nxn) like the past arrays.
        -The elements will be input by the user like the previous tasks.
        -To spiral the elements 
        1   2   3       1,2,3 - First row, then:
        4   5   6   ->  6,9 - Last column, then:
        7   8   9       8,7 - Last row inverted:
                        4,5 - middle row.
        -First we need to define the boundaries of the starter point (top) and last row (bottom)
        -We also need left define, which will be 0,1,2,3,4(Similar method to the multiplication matrix calc)
        -The right side will be defined by column -1, like used on the secondary diagonal calculator.
        -With these defined we can work on the loop that will go as follows:
            -Loop to the end of first row (top) increment the top bound
            -Then go down on the right bound (every last element of the rows).Then decrement the right bound.
            -Then go reverse on the bottom row. Then decrement the bottom row.
            -Then go bottom to top on the left boundarie.
            -Repeat the process untill left > right and top > bottom.
     */
    
    public String spiralTrav(){
        String message = "";
        boolean error = false;
        try{
            System.out.print("Enter the size of the matrix: ");
            int trasvMatrixSize = 0;
            try {
                trasvMatrixSize = input.nextInt();
            } catch (Exception e) {
                System.out.println("Error: You need to input an integer number for the size of the array.");
                error = true;
            }
            if (error) {
                return null;
            }
            int[][] transvMatrix = new int[trasvMatrixSize][trasvMatrixSize];
            System.out.println("Enter the elements of the array: (one by one)");
            for (int i = 0; i < transvMatrix.length; i++) {
                System.out.println("Row " + i + ":");
                for (int j = 0; j < transvMatrix.length; j++) {
                    transvMatrix[i][j] = input.nextInt();
                }
            }
            System.out.println("This is your matrix: ");
            for (int i = 0; i < transvMatrix.length; i++) {
                for (int j = 0; j < transvMatrix.length; j++) {
                    if (transvMatrix[i][j] < 10) {
                        System.out.print("  0" + transvMatrix[i][j] + "   ");
                    } else {
                        System.out.print("  " + transvMatrix[i][j] + "   ");
                    }
                }
                System.out.println(" ");
            }
            int[] transverseArray = new int[trasvMatrixSize * trasvMatrixSize];
            int elementPos = 0;
            //Row and column to control the loops 
            int top = 0;
            int bottom = transvMatrix.length - 1;
            int right = transvMatrix.length - 1;
            int left = 0;

            while (top <= bottom && left <= right) {
                //Transverse rigth
                for (int i = left; i <= bottom; i++) {
                    transverseArray[elementPos] = transvMatrix[top][i];
                    elementPos++;
                }
                top++;

                //Transverse to bottom
                for (int i = top; i <= bottom; i++) {
//                System.out.println(i);
//                System.out.println("right: " + right);
//                System.out.println("Pushing: " + transvMatrix[right][i]);
                    transverseArray[elementPos] = transvMatrix[i][right];
                    elementPos++;
                }
                right--;

                //Transverse to left
                if (top <= bottom) {
                    for (int i = right; i >= left; i--) {
                        //                System.out.println(i);
                        //                System.out.println("Left: " + left);
                        //                System.out.println("Pushing: " + transvMatrix[bottom][i]);
                        transverseArray[elementPos] = transvMatrix[bottom][i];
                        elementPos++;
                    }
                    bottom--;
                }

                //Transverse to top
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        //                System.out.println(i);
                        //                System.out.println("Top: " + top);
                        //                System.out.println("Pushing: " + transvMatrix[i][left]);
                        transverseArray[elementPos] = transvMatrix[i][left];
                        elementPos++;
                    }
                    left++;
                }

                //Repeat from top until condition is met.
            }
            
            message = "This is your matrix transversed: \n " + Arrays.toString(transverseArray);
            
        }catch(Exception e){
            System.out.println("Error: Only integer numbers accepted.");
            error = true;
        }
        if (error) {
            return null;
        } else {
            return message;
        }
    }
    
    /*
    Task 5: Bubble Sort - Sorting an Array Write a Java program to implement the Bubble Sort algorithm to sort an array of integers in
    ascending order
    . The program should:
    1. Accept the size of the array and the elements of the array as input
    2. Sort the array using the Bubble Sort technique
        -For this we will loop through the array elements. 
        -Buble sort is the technique of comparing two elements and sort them on an array from low to high.
    3. Display the array before and after sorting.
    4. Count and display the total number of swaps performed during the sorting process.
    -We can use a variable to hold this number and increment the variable when the conditional is true.
    */
    public String bubbleSort(){
        String message = "";
        boolean error = false;
        try{
            System.out.println("Enter the Size of the array: ");
            int arraySize = 0;
            try {
                arraySize = input.nextInt();
            } catch (Exception e) {
                System.out.println("Error: You need to input an integer number for the size of the array.");
                error = true;
            }
            if (error) {
                return null;
            }
            int[] arraySort = new int[arraySize];
            System.out.println("Enter the elements of the array: (ONE BY ONE)");
            int tempElement = input.nextInt();
            arraySort[0] = tempElement;
            for (int i = 1; i < arraySize; i++) {
                System.out.println("Enter the next element of the array: ");
                tempElement = input.nextInt();
                arraySort[i] = tempElement;
            }
            System.out.println(Arrays.toString(arraySort));
            int counter = 0;
            for (int i = 0; i < arraySort.length; i++) {
                for (int j = 0; j < arraySort.length - 1 - i; j++) {
                    if (arraySort[j] > arraySort[j + 1]) {
                        int tempNum = arraySort[j];
                        arraySort[j] = arraySort[j + 1];
                        arraySort[j + 1] = tempNum;
                        counter++;
                        System.out.println("Elements swaped: " + counter);
                        System.out.println("This is the array after the swap " + Arrays.toString(arraySort));
                    }
                }
            }
            message = "This is the array after finishing sorting: " + Arrays.toString(arraySort) + "\n"
                    + "The elements had been swaped " + counter + " times.";
        }catch(Exception e){
            System.out.println("Error: Only integer numbers accepted.");
            error = true;
        }
        if (error) {
            return null;
        } else {
            return message;
        }
        
        
        
    }
    
    /**
     * 
     * @return an integer input by the user based on the menu choice.
     */
    public int getChoice(){
        int menuChoice = 0;
        try{
            System.out.println(
                        "\nEnter the operation:\n"
                        + "1. Find the first repeated element on a list.\n"
                        + "2. Multiplication Table Using 2D list. \n"
                        + "3. Get the diagonal sum of a Matrix. \n"
                        + "4. Get a list of the traversal of a Matrix. \n"
                        + "5. Bubble sort a list.\n"
                        + "0. Exit. \n");
            menuChoice = input.nextInt();
        }catch(Exception e){
            System.out.println("Error: Plese enter a valid integer number from the Menu provided.");
        }
        return menuChoice;
    } 
    
}


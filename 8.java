import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CST150JMHW8intArray {

    static String fileInput = null;
    public static void main(String[] args) throws IOException {

        //Take user input for filename 
        Scanner inputFile = new Scanner(System.in);   
        System.out.println("Enter filename and extension: ");
        fileInput = inputFile.nextLine();
        
        int[] theArray = buildArray(); //Initialize buildArray method
        userChoice(theArray); //Initialize userChoice method

    }

    /*                  
                        Dynamic Array
    
    The method buildArray essentially reads integers from a file and 
    adjusts the number of elements the array can take according to the
    number of integers present in the accessed file. 
    The elements are indexed serially with respect to the file.
     
    
    */
    public static int[] buildArray() throws IOException {

        //Variable initializations
        int[] intArray = {};
        int sumOfElements = 0;
        int index = 0;
        
        //Initialization of File and Scanner objects
        
        File sumOfIntegers = new File(fileInput);
        Scanner elementScanner = new Scanner(sumOfIntegers);

        //Loop that increases the num of array elements by 1 every time
        //it acknowledges an integer value within the file and subtracts
        //1 from the array elements when the sentinel value is reached.
        while (elementScanner.hasNextInt()) {
            sumOfElements++;
            
            
            //Assign next int scanner method to x variable
            //Used to process if boolean condition
            int x = elementScanner.nextInt();

            //When -999 sentinel value is reached reduce num of array elements
            //by 1 since we do not want it included
            if (x == -999) {
                sumOfElements = sumOfElements - 1;
                intArray = new int[sumOfElements];
            }
            //Assign sumOfElements as num of array elements
            intArray = new int[sumOfElements]; 

        }

        //new scanner to reset abstract cursor of file
        elementScanner = new Scanner(sumOfIntegers);
        for (index = 0; index < sumOfElements; index++) {
            int x = elementScanner.nextInt();

            if (x != -999) {
                intArray[index] = x;
            }

        }

        //Closes the file/scanner
        elementScanner.close();

        return intArray;
    }

    //Requests user input for selecting functionality
    //Depending on user choice, Display Array, Display Average
    //Display Average & Array and Quit app
    public static void userChoice(int[] array) throws IOException {
        Scanner userInput = new Scanner(System.in);
        
        int userSelect = 0;
        
        while (userSelect < 1 || userSelect > 4 || userSelect != 4) {
            System.out.println("Enter a digit 1-4.\n1 = Display Array"
                    + "\n2 = Display Average \n3 = Display Array & Average" + 
                    "\n4 = Quit");
            userSelect = userInput.nextInt();
            
            switch (userSelect) {
                case 1:
                    System.out.println("Displaying array: " +
                            Arrays.toString(array));
                    break;
                case 2:
                    System.out.println("The average: " + getAverage(array));
                    break;
                case 3:
                    System.out.println("Array Values: " + 
                            Arrays.toString(array) + 
                            "\nArray Average: " + getAverage(array));
                    break;
                case 4:
                   break;
                default:
                    System.out.println("Invalid Input!");
                    break;
            }
        }

    }

    //Method that calculates the total of an array
    public static double arrayTotal(int[] array ) throws IOException {
        double total = 0;

        for (int i = 0; i != array.length; i++) {
            total = total + array[i];
        }
        return total;
    }

    //Method that uses the arrayTotal method to 
    //acquire the average of the array
    public static double getAverage(int[] array) throws IOException {
        double arrayAverage = 0;
        arrayAverage = arrayTotal(array) / array.length;

        return arrayAverage;

    }
}

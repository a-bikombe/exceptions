package Exceptions;

public class Exceptions {

    static String[] stringValues = {"A", "   ", "n", "ZZ", "I", "B", "C", "D", "b", "B", "E", "F", "33", "2.1", "quit"};    // create an array of strings
    static int count;
    static int sum = 0;

    public static void main(String[] args) {

        for (String item : stringValues) {    // loop through array
            try {
                char returnedGrade = validChars(item);    // sets character (A, B, C, D, F)
                int convertedGrade = letToNumConvert(returnedGrade);    // sets number (4, 3, 2, 1, 0)
                System.out.println("Grade Conversion of " + returnedGrade + ": " + convertedGrade);    // prints letter grade and number grade
                count++;    // add 1 to count
                sum = sum += convertedGrade;    // add to sum
            } catch (Exception e) {
                System.out.println(e.getMessage());    // prints exception message
            }
        }
        
        if (count == 0) {
            System.out.println("stringValues count is 0.");    // avoid division by 0
        } else {
            double average = sum / count;    // get average
            System.out.println("GPA: " + average);    // print average
        }
    }
        
    public static char validChars(String values) throws Exception {    // method that validates the strings for use as grades

        switch (values) {    // The grade must be between A and D inclusive, or F
            case "A":
                return 'A';    // return the valid character
            case "B":
                return 'B';
            case "C":
                return 'C';
            case "D":
                return 'D';
            case "F":
                return 'F';
            default:
                throw new IllegalArgumentException("Error: Grade out of range");    // decides what the exception message for the method will be
        }
    }

    public static int letToNumConvert(char returnedGrade) {    // converts char to number

        switch (returnedGrade) {    // A counts as 4, B as 3, C as 2, D as 1 and F as 0
            case 'A':
                return 4;
            case 'B':
                return 3;
            case 'C':
                return 2;
            case 'D':
                return 1;
            default:
                return 0;
        }
    }
}
import java.util.Scanner;

public class UserDefinedException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of grades: ");
        int numGrades = scanner.nextInt();

        // Create an array to store the grades
        int[] grades = new int[numGrades];

        scanner.nextLine(); // Consume the newline character

        // Prompt for and read each grade
        for (int i = 0; i < numGrades; i++) {
            while (true) {
                System.out.print("Enter grade " + (i + 1) + ": ");
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Exiting the input loop."); // This is a debug statement
                    System.exit(0); // Exit the program
                }

                try {
                    grades[i] = Integer.parseInt(input); // Convert the input to an integer
                    break; // Break out of the while loop
                } catch (NumberFormatException e) { // Catch the exception
                    System.out.println("Invalid input. Please enter a valid integer grade."); // Print an error message
                }
            }
        }
        int average = 0;
        String total = "";
        // Process or display the grades as needed
        
        
        System.out.print("The grades are, ");
        for (int grade : grades) { // for each grade in grades
            System.out.print(", " + grade); // print the grade
            average += grade; // add the grade to the average
        }
        
        average = average / grades.length; // divide the average by the number of grades
        System.out.println();
        System.out.println("Average: " + average);

        scanner.close();
    }
}

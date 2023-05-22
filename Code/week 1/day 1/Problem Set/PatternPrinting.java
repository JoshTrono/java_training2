import java.util.Scanner;

public class PatternPrinting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int numRows = scanner.nextInt();

        
        // Print the pattern
        String printed = "";
        for (int rows = 0; rows <= numRows;  rows ++) {
            System.out.println(printed);
            printed += "*";

        }
    }
}
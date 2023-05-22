import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        boolean isPrime = true;

        // Check if the number is prime

        // goes into a loop that only divides the number by each number half of it. If I use more numbers it will just be repeating the combination. It ignores 1 and doesn't check itself.
        // if a number divided by another number than it's not a prime number.
        isPrime = IsItPrime(number);

        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }
    private static boolean IsItPrime(int number) {
        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                return false;
            }
            else {
                return true;
            }
        } 
        return false;
    }
}

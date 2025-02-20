package Hospital;
import java.util.*;
public class InputChecker {
    public static int getIntegerBetween(int a, int b) {
        // Validate bounds
        Scanner scanner = new Scanner(System.in);
        if (a > b) {
            throw new IllegalArgumentException("Lower bound cannot be greater than upper bound (a=" + a + ", b=" + b + ")");
        }

        while (true) {
            try {
                System.out.printf("Please enter a number between %d and %d: ", a, b);
                String input = scanner.nextLine().trim();

                // Check for empty input
                if (input.isEmpty()) {
                    System.out.println("Error: Input cannot be empty.");
                    continue;
                }

                // Parse the integer
                int number = Integer.parseInt(input);

                // Validate bounds
                if (number < a || number > b) {
                    System.out.printf("Error: Number must be between %d and %d.%n", a, b);
                    continue;
                }

                return number;

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
    public static String getAlphabeticString(int minLength, int maxLength) {
        // Validate length parameters
        Scanner scanner = new Scanner(System.in);
        if (minLength < 0 || maxLength < 0) {
            throw new IllegalArgumentException("Length bounds cannot be negative");
        }
        if (minLength > maxLength) {
            throw new IllegalArgumentException("Minimum length cannot be greater than maximum length");
        }

        while (true) {
            try {
                String input = scanner.nextLine().trim();

                // Check for empty input
                if (input.isEmpty()) {
                    System.out.println("Error: Input cannot be empty.");
                    continue;
                }

                // Check length constraints
                if (input.length() < minLength || input.length() > maxLength) {
                    System.out.printf("Error: Input must be between %d and %d characters long.%n",
                            minLength, maxLength);
                    continue;
                }

                // Check for non-alphabetic characters
                if (!input.matches("^[a-zA-Z]+$")) {
                    System.out.println("Error: Input must contain only letters (A-Z, a-z).");
                    continue;
                }

                return input;

            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    /**
     * Overloaded method for getting alphabetic input without length constraints
     */
    public static String getAlphabeticString(Scanner scanner) {
        return getAlphabeticString(1, Integer.MAX_VALUE);
    }

    /**
     * Utility method to check if a string contains only alphabetic characters
     */
    public static boolean isAlphabetic(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("^[a-zA-Z]+$");
    }
}

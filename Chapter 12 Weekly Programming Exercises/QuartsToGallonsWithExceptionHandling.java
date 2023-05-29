import java.util.Scanner;

public class QuartsToGallonsWithExceptionHandling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean isValidInput = false;
        double quarts = 0.0;

        while (!isValidInput) {
            try {
                System.out.print("Enter the number of quarts: ");
                quarts = Double.parseDouble(input.nextLine());

                if (quarts < 0) {
                    throw new NumberFormatException();
                }

                isValidInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a non-negative numeric value.");
            }
        }

        double gallons = quarts / 4;
        System.out.printf("%.2f quarts is equal to %.2f gallons.", quarts, gallons);
    }
}

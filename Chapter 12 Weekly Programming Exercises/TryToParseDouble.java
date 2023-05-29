import java.util.Scanner;

public class TryToParseDouble {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double number;

        System.out.print("Enter a double number: ");
        String userInput = input.nextLine();

        try {
            number = Double.parseDouble(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Setting number to 0.");
            number = 0;
        }

        System.out.println("The number is: " + number);
    }
}

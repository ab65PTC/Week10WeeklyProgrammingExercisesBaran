import java.util.Scanner;

public class SqrtException {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        String str = input.nextLine();

        int num;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, number set to 0.");
            num = 0;
        }

        if (num < 0) {
            try {
                throw new ArithmeticException("Cannot take the square root of a negative number.");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        } else {
            double sqrt = Math.sqrt(num);
            System.out.println("The square root of " + num + " is " + sqrt);
        }

        input.close();
    }
}

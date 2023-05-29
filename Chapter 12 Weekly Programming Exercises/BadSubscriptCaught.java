import java.util.Scanner;

public class BadSubscriptCaught {
    public static void main(String[] args) {
        String[] firstNames = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry"};

        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter an integer between 1 and 8: ");
            int index = input.nextInt() - 1;
            System.out.println("The name in position " + (index + 1) + " is " + firstNames[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: index is out of range.");
        }
    }
}

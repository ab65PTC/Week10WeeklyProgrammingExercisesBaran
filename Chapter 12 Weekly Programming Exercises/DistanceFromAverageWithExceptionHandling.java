import java.util.Scanner;

public class DistanceFromAverageWithExceptionHandling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraySize = 0;
        double[] array = null;

        while (true) {
            try {
                System.out.print("Enter an integer array size: ");
                arraySize = scanner.nextInt();
                break; // Exit loop if integer is entered successfully
            } catch (Exception e) {
                System.out.println("Error: Input must be an integer.");
                scanner.nextLine(); // Clear input buffer
            }
        }

        try {
            array = new double[arraySize];
        } catch (NegativeArraySizeException e) {
            System.out.println("Error: Array size must be a positive integer. Defaulting to size of 5.");
            array = new double[5];
        }

        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            while (true) {
                try {
                    System.out.print("Enter a double value for index " + i + ": ");
                    array[i] = scanner.nextDouble();
                    sum += array[i];
                    break; // Exit loop if double is entered successfully
                } catch (Exception e) {
                    System.out.println("Error: Input must be a double.");
                    scanner.nextLine(); // Clear input buffer
                }
            }
        }

        double average = sum / array.length;

        for (int i = 0; i < array.length; i++) {
            double distance = Math.abs(array[i] - average);
            System.out.println("Distance from average for index " + i + ": " + distance);
        }
    }

}

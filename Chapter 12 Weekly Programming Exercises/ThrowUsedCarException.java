import java.util.Scanner;

public class ThrowUsedCarException {

    public static void main(String[] args) throws UsedCarException {
        Scanner scanner = new Scanner(System.in);

        UsedCar[] cars = new UsedCar[7];
        int count = 0;

        while (count < cars.length) {
            try {
                System.out.print("Enter VIN: ");
                int vin = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter make (Ford, Honda, Toyota, Chrysler, Other): ");
                String make = scanner.nextLine();
                System.out.print("Enter year (1997-2024): ");
                int year = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter mileage: ");
                int mileage = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter price: ");
                double price = Double.parseDouble(scanner.nextLine());

                UsedCar car = new UsedCar(vin, make, year, mileage, price);
                cars[count] = car;
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        System.out.println("Successfully constructed cars:");
        for (UsedCar car : cars) {
            if (car != null) {
                System.out.println(car);
            }
        }
    }
}

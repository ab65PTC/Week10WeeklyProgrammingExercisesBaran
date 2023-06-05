import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerItemOrder {
    public static void main(String[] args) {
        String customerFile = "customer.txt";
        String itemFile = "items.txt";

        // Step 1: Load customer and item data into memory
        Map<String, String> customers = loadCustomerData(customerFile);
        Map<String, String> items = loadItemData(itemFile);

        // Step 2: Prompt user for customer number and item ordered
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer number: ");
        String customerNumber = scanner.nextLine();
        System.out.print("Enter item ordered: ");
        String itemNumber = scanner.nextLine();
        scanner.close();

        // Step 3: Check if customer and item exist and display information
        if (customers.containsKey(customerNumber) && items.containsKey(itemNumber)) {
            System.out.println("Customer Information:");
            System.out.println("Customer Number: " + customerNumber);
            System.out.println("Last Name: " + customers.get(customerNumber));

            System.out.println("Item Information:");
            System.out.println("Item Number: " + itemNumber);
            System.out.println("Description: " + items.get(itemNumber));
        } else {
            System.out.println("Error: Customer or item does not exist.");
        }
    }

    private static Map<String, String> loadCustomerData(String customerFile) {
        Map<String, String> customers = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(customerFile))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(" ", 2);
                customers.put(data[0], data[1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Customer file not found.");
            e.printStackTrace();
        }

        return customers;
    }

    private static Map<String, String> loadItemData(String itemFile) {
        Map<String, String> items = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(itemFile))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(" ", 2);
                items.put(data[0], data[1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Item file not found.");
            e.printStackTrace();
        }

        return items;
    }
}

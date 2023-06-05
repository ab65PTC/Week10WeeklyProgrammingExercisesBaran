import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CreateItemFile {
    public static void main(String[] args) {
        String fileName = "items.txt";

        // Step 1: Create an empty file
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
            return;
        }

        // Step 2: Accept user input to populate the file
        try (FileWriter writer = new FileWriter(fileName, true); Scanner scanner = new Scanner(System.in)) {
            Set<String> itemNumbers = new HashSet<>();

            while (true) {
                System.out.print("Enter item number (three digits): ");
                String itemNumber = scanner.nextLine();

                if (itemNumber.length() != 3 || !itemNumber.matches("\\d+")) {
                    System.out.println("Invalid item number. Please enter a three-digit number.");
                    continue;
                }

                if (itemNumbers.contains(itemNumber)) {
                    System.out.println("Item number already exists. Please enter a different item number.");
                    continue;
                }

                System.out.print("Enter item description (up to 20 characters): ");
                String description = scanner.nextLine().trim();

                if (description.length() > 20) {
                    description = description.substring(0, 20);
                }

                // Save the record to the file
                writer.write(itemNumber + " " + description + "\n");
                itemNumbers.add(itemNumber);

                System.out.print("Do you want to add another item (Y/N)? ");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("Y")) {
                    break;
                }
            }

            System.out.println("Item records saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

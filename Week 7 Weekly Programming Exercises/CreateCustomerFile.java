import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CreateCustomerFile {
    public static void main(String[] args) {
        String fileName = "customer.txt";

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
            Set<String> idNumbers = new HashSet<>();

            while (true) {
                System.out.print("Enter customer ID (three digits): ");
                String id = scanner.nextLine();

                if (id.length() != 3 || !id.matches("\\d+")) {
                    System.out.println("Invalid ID number. Please enter a three-digit number.");
                    continue;
                }

                if (idNumbers.contains(id)) {
                    System.out.println("ID number already exists. Please enter a different ID.");
                    continue;
                }

                System.out.print("Enter customer last name (six characters): ");
                String lastName = scanner.nextLine().trim();

                if (lastName.length() < 6) {
                    lastName = String.format("%-6s", lastName).replace(' ', '_');
                } else if (lastName.length() > 6) {
                    lastName = lastName.substring(0, 6);
                }

                System.out.print("Enter customer zip code (five digits): ");
                String zipCode = scanner.nextLine();

                if (zipCode.length() != 5 || !zipCode.matches("\\d+")) {
                    System.out.println("Invalid zip code. Please enter a five-digit number.");
                    continue;
                }

                // Save the record to the file
                writer.write(id + " " + lastName + " " + zipCode + "\n");
                idNumbers.add(id);

                System.out.print("Do you want to add another customer (Y/N)? ");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("Y")) {
                    break;
                }
            }

            System.out.println("Customer records saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

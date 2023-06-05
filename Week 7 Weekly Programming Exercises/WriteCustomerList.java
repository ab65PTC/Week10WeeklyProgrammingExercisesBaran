import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteCustomerList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the filename to save customer records: ");
        String filename = scanner.nextLine();
        
        try {
            FileWriter writer = new FileWriter(filename, true); // true for append mode
            
            while (true) {
                System.out.println("\nEnter customer details:");
                System.out.print("ID number: ");
                String id = scanner.nextLine();
                
                System.out.print("First name: ");
                String firstName = scanner.nextLine();
                
                System.out.print("Last name: ");
                String lastName = scanner.nextLine();
                
                System.out.print("Balance owed: ");
                String balance = scanner.nextLine();
                
                String record = id + "," + firstName + "," + lastName + "," + balance + "\n";
                writer.write(record);
                
                System.out.print("\nDo you want to enter another customer record? (Y/N): ");
                String choice = scanner.nextLine();
                
                if (!choice.equalsIgnoreCase("Y")) {
                    break;
                }
            }
            
            writer.close();
            System.out.println("\nCustomer records saved successfully.");
            
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
        
        scanner.close();
    }
}

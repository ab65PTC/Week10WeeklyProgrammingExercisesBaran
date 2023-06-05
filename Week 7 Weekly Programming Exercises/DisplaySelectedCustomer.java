import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DisplaySelectedCustomer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("Which file would you like to view >> ");
            String filename = scanner.nextLine(); // Specify the filename of the customer records
            
            System.out.print("Enter the ID number: ");
            String idToSearch = scanner.nextLine();
            
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line;
            boolean customerFound = false;
            
            while ((line = bufferedReader.readLine()) != null) {
                String[] customerData = line.split(",");
                String id = customerData[0];
                
                if (id.equals(idToSearch)) {
                    String firstName = customerData[1];
                    String lastName = customerData[2];
                    String balance = customerData[3];
                    
                    System.out.println("\nCustomer Details:");
                    System.out.println("ID: " + id);
                    System.out.println("First Name: " + firstName);
                    System.out.println("Last Name: " + lastName);
                    System.out.println("Balance Owed: " + balance);
                    
                    customerFound = true;
                    break;
                }
            }
            
            if (!customerFound) {
                System.out.println("Customer with ID number " + idToSearch + " not found.");
            }
            
            bufferedReader.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        
        scanner.close();
    }
}

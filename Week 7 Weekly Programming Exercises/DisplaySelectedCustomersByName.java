import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisplaySelectedCustomersByName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("Which file would you like to view >> ");
            String filename = scanner.nextLine(); // Specify the filename of the customer records
            
            System.out.print("Enter the last name: ");
            String lastNameToSearch = scanner.nextLine();
            
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line;
            List<String> matchingCustomers = new ArrayList<>();
            
            while ((line = bufferedReader.readLine()) != null) {
                String[] customerData = line.split(",");
                String lastName = customerData[2];
                
                if (lastName.equalsIgnoreCase(lastNameToSearch)) {
                    matchingCustomers.add(line);
                }
            }
            
            if (!matchingCustomers.isEmpty()) {
                System.out.println("\nCustomer Details:");
                
                for (String customer : matchingCustomers) {
                    String[] customerData = customer.split(",");
                    String id = customerData[0];
                    String firstName = customerData[1];
                    String lastName = customerData[2];
                    String balance = customerData[3];
                    
                    System.out.println("ID: " + id);
                    System.out.println("First Name: " + firstName);
                    System.out.println("Last Name: " + lastName);
                    System.out.println("Balance Owed: " + balance);
                    System.out.println("--------------------");
                }
            } else {
                System.out.println("No customers found with the last name " + lastNameToSearch + ".");
            }
            
            bufferedReader.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        
        scanner.close();
    }
}

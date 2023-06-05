import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DisplaySavedCustomerList {
    public static void main(String[] args) {
        try {

            Scanner keyboard = new Scanner(System.in);
            System.out.println("Which file would you like to view >> ");
            String filename = keyboard.nextLine(); // Specify the filename of the customer records
            
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line;
            System.out.println("Customer Records:\n");
            
            while ((line = bufferedReader.readLine()) != null) {
                String[] customerData = line.split(",");
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
            
            bufferedReader.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}

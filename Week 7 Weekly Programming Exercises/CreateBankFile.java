import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class CreateBankFile {
    public static void main(String[] args) {
        final String FILE_PATH = "bank_records.dat";
        final int RECORD_SIZE = 40; // Size of each record in bytes
        final int MAX_RECORDS = 10000;

        try (RandomAccessFile file = new RandomAccessFile(FILE_PATH, "rw")) {
            // Create 10,000 blank records
            for (int i = 0; i < MAX_RECORDS; i++) {
                writeRecord(file, i, "", 0.0);
            }

            // Prompt the user to enter customer account information
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter account number (9998 or less, -1 to exit): ");
                int accountNumber = scanner.nextInt();
                if (accountNumber == -1) {
                    break;
                }

                System.out.print("Enter last name: ");
                String lastName = scanner.next();

                System.out.print("Enter balance: ");
                double balance = scanner.nextDouble();

                // Validate the balance
                if (balance > 99000.00) {
                    System.out.println("Invalid balance. Please enter a balance of 99,000.00 or less.");
                    continue;
                }

                // Pad or truncate the last name to 8 characters
                if (lastName.length() > 8) {
                    lastName = lastName.substring(0, 8);
                } else if (lastName.length() < 8) {
                    lastName = String.format("%-8s", lastName);
                }

                // Write the record to the file at the specified location
                writeRecord(file, accountNumber, lastName, balance);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error accessing file: " + e.getMessage());
        }
    }

    private static void writeRecord(RandomAccessFile file, int accountNumber, String lastName, double balance)
            throws IOException {
        // Calculate the position of the record in the file
        long position = accountNumber * 40L; // Multiply by record size

        // Seek to the position in the file
        file.seek(position);

        // Write the account number
        file.writeInt(accountNumber);

        // Write the last name
        file.writeBytes(lastName);

        // Write the balance
        file.writeDouble(balance);
    }
}

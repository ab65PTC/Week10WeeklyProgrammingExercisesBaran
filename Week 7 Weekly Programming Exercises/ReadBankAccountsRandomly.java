import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ReadBankAccountsRandomly {
    public static void main(String[] args) {
        final String FILE_PATH = "bank_records.dat";
        final int RECORD_SIZE = 40; // Size of each record in bytes
        final int MAX_RECORDS = 10000;

        try (RandomAccessFile file = new RandomAccessFile(FILE_PATH, "r")) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Enter an account number (9999 to exit): ");
                int accountNumber = scanner.nextInt();
                if (accountNumber == 9999) {
                    break;
                }

                if (accountNumber < 0 || accountNumber >= MAX_RECORDS) {
                    System.out.println("Invalid account number. Please try again.");
                    continue;
                }

                Account account = readRecord(file, accountNumber);
                if (account != null) {
                    System.out.println("Account Balance: $" + account.getBalance());
                } else {
                    System.out.println("Account not found.");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error accessing file: " + e.getMessage());
        }
    }

    private static Account readRecord(RandomAccessFile file, int accountNumber) throws IOException {
        // Calculate the position of the record in the file
        long position = accountNumber * 40L; // Multiply by record size

        // Seek to the position in the file
        file.seek(position);

        try {
            // Read the account number
            int readAccountNumber = file.readInt();

            // Read the last name
            byte[] lastNameBytes = new byte[8];
            file.readFully(lastNameBytes);
            String lastName = new String(lastNameBytes).trim();

            // Read the balance
            double balance = file.readDouble();

            return new Account(readAccountNumber, lastName, balance);
        } catch (IOException e) {
            // Reached the end of the file or an error occurred
            return null;
        }
    }

    private static class Account {
        private int accountNumber;
        private String lastName;
        private double balance;

        public Account(int accountNumber, String lastName, double balance) {
            this.accountNumber = accountNumber;
            this.lastName = lastName;
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }
    }
}

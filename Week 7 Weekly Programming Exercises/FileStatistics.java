import java.io.File;
import java.util.Scanner;

public class FileStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the filename: ");
        String filename = scanner.nextLine();
        
        File file = new File(filename);
        
        if (file.exists()) {
            System.out.println("Path: " + file.getAbsolutePath());
            System.out.println("Name: " + file.getName());
            System.out.println("Folder: " + file.getParent());
            System.out.println("Size: " + file.length() + " bytes");
            System.out.println("Last Modified: " + file.lastModified());
        } else {
            System.out.println("File does not exist.");
        }
        
        scanner.close();
    }
}
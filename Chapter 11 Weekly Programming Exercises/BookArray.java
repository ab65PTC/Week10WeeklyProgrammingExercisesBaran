import java.util.Scanner;

public class BookArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Book[] books = new Book[10];
        
        for (int i = 0; i < books.length; i++) {
            System.out.print("Enter the title of book #" + (i+1) + ": ");
            String title = input.nextLine();
            System.out.print("Is it fiction or nonfiction? (F/N): ");
            char type = input.nextLine().toUpperCase().charAt(0);
            
            while (type != 'F' && type != 'N') {
                System.out.print("Invalid input. Please enter F or N: ");
                type = input.nextLine().toUpperCase().charAt(0);
            }
            
            if (type == 'F') {
                books[i] = new Fiction(title);
            } else {
                books[i] = new NonFiction(title);
            }
        }
        
        System.out.println("\nBooks:");
        for (Book b : books) {
            b.display();
            System.out.println();
        }
    }
}

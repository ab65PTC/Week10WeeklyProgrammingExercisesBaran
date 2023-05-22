import java.util.Scanner;

public class UseBook {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user for book details
        System.out.print("Enter the title of the fiction book: ");
        String fictionTitle = input.nextLine();
        System.out.print("Enter the title of the non-fiction book: ");
        String nonFictionTitle = input.nextLine();

        // Create the Fiction and NonFiction objects
        Fiction fictionBook = new Fiction(fictionTitle);
        NonFiction nonFictionBook = new NonFiction(nonFictionTitle);

        // Display the book details
        System.out.println("Fiction Book:");
        System.out.println("Title: " + fictionBook.getTitle());
        System.out.println("Price: $" + fictionBook.getPrice());

        System.out.println("\nNon-Fiction Book:");
        System.out.println("Title: " + nonFictionBook.getTitle());
        System.out.println("Price: $" + nonFictionBook.getPrice());
    }
}

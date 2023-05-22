import java.util.Scanner;

public class UseGeometric {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GeometricFigure[] figures = new GeometricFigure[5];
        
        for (int i = 0; i < figures.length; i++) {
            System.out.printf("Enter data for figure %d:\n", i + 1);
            System.out.print("  Height: ");
            double height = input.nextDouble();
            System.out.print("  Width: ");
            double width = input.nextDouble();
            System.out.print("  Type (square or triangle): ");
            String type = input.next();
            if (type.equals("square")) {
                figures[i] = new Square(height, width);
            } else if (type.equals("triangle")) {
                figures[i] = new Triangle(height, width);
            } else {
                System.out.println("Invalid figure type. Using default (square).");
                figures[i] = new Square(height, width);
            }
        }
        
        System.out.println("\nFigure data:");
        for (int i = 0; i < figures.length; i++) {
            System.out.printf("Figure %d:\n", i + 1);
            System.out.printf("  Type: %s\n", figures[i].figureType);
            System.out.printf("  Height: %.2f\n", figures[i].height);
            System.out.printf("  Width: %.2f\n", figures[i].width);
            System.out.printf("  Area: %.2f\n", figures[i].getArea());
            System.out.println();
        }
    }
}

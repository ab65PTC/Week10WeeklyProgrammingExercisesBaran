import java.util.Scanner;

public class UseGeometric2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GeometricFigure2[] figures = new GeometricFigure2[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter figure type (square/triangle): ");
            String type = input.next();

            System.out.print("Enter height: ");
            double height = input.nextDouble();

            System.out.print("Enter width: ");
            double width = input.nextDouble();

            if (type.equalsIgnoreCase("square")) {
                figures[i] = new Square2(height, width);
            } else if (type.equalsIgnoreCase("triangle")) {
                figures[i] = new Triangle2(height, width);
            }
        }

        for (GeometricFigure2 figure : figures) {
            System.out.println("Figure type: " + figure.getFigureType());
            System.out.println("Height: " + figure.getHeight());
            System.out.println("Width: " + figure.getWidth());
            System.out.println("Area: " + figure.getArea());
            figure.displaySides();
            System.out.println();
        }
    }
}

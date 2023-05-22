public class Triangle2 extends GeometricFigure2 {

    private double area;

    public Triangle2(double height, double width) {
        super(height, width, "Triangle");
        area = 0.5 * height * width;
    }

    @Override
    public double area() {
        return area;
    }

    @Override
    public void displaySides() {
        System.out.println("A triangle has three sides.");
    }
}

public class Triangle extends GeometricFigure {
    private double area;

    public Triangle(double height, double width) {
        super(height, width, "triangle");
        area = 0.5 * height * width;
    }

    public double getArea() {
        return area;
    }
}

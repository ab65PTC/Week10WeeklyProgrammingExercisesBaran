public class Square extends GeometricFigure {
    private double area;

    public Square(double height, double width) {
        super(height, width, "square");
        area = height * width;
    }

    public double getArea() {
        return area;
    }
}

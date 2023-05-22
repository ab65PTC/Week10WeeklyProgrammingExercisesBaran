public class Square2 extends GeometricFigure2 {

    private double area;

    public Square2(double height, double width) {
        super(height, width, "Square");
        area = height * width;
    }

    @Override
    public double area() {
        return area;
    }

    @Override
    public void displaySides() {
        System.out.println("A square has four sides.");
    }
}

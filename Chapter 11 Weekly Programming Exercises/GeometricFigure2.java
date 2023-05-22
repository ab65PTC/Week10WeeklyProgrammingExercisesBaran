public abstract class GeometricFigure2 implements SidedObject {
    protected double height;
    protected double width;
    protected String figureType;

    public GeometricFigure2(double h, double w, String figure) {
        height = h;
        width = w;
        figureType = figure;
    }

    public abstract double area();

    @Override
    public abstract void displaySides();

    public String getFigureType() {
        return figureType;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getArea() {
        return (height * width);
    }

    public String toString() {
        return figureType + " with height " + height + " and width " + width + " has an area of " + area();
    }
}

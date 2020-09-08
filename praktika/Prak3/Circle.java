package praktika.Prak3;

public class Circle extends Shape {

    protected double radius;

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public Circle(double radius) {
        this.color = "blue";
        this.filled = false;
        this.radius = radius;
    }

    public Circle() {
        this.color = "blue";
        this.filled = false;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius*radius*Math.PI;
    }

    @Override
    public double getPerimeter() {
        return radius*Math.PI*2;
    }

    @Override
    public String toString() {
        return "Shape: Circle" +
                "\n Area " + getArea() +
                "\n Perimeter " + getPerimeter() +
                "\n Color " + getColor();
    }
}

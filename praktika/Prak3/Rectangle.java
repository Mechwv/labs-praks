package  rtu_IT_IKBO_06_19_Vizer.praktika.Prak3;

public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle() {
        this.color = "blue";
        this.filled = false;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length) {
        this.color = "blue";
        this.filled = false;
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return length*width;
    }

    @Override
    public double getPerimeter() {
        return (length+width)*2;
    }

    @Override
    public String toString() {
        return "Shape: Rectangle" +
                "\n Area " + getArea() +
                "\n Perimeter " + getPerimeter() +
                "\n Color " + getColor();
    }
}

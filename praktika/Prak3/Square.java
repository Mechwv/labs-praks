package praktika.Prak3;

public class Square extends Rectangle {

    protected double side; //В UML диаграмме этого поля не было указано, но при этом были геттеры и сеттеры (?)

    public Square() {
        this.color = "blue";
        this.filled = false;
    }

    public Square(double side) {
        this.color = "blue";
        this.filled = false;
        this.side = side;
    }

    public Square(double side, String color, boolean filled){
       this.color = color;
       this.filled = filled;
       this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void setWidth(double side){
        super.setWidth(side);
    }

    @Override
    public void setLength(double side) {
        super.setLength(side);
    }

    @Override
    public String toString() {
        return "Shape: Rectangle" +
                "\n Area " + getArea() +
                "\n Perimeter " + getPerimeter() +
                "\n Color " + getColor();
    }
}

package praktika.Prak10;

public class Complex {
    int x;
    int y;

    public Complex() {

    }

    public Complex(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println(print());
    }

    public String print() {
        return "Complex{" + x + " + " + y +"i"  + '}';
    }
}

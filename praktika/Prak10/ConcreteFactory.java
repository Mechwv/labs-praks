package praktika.Prak10;

public class ConcreteFactory implements ComplexAbstractFactory{
    @Override
    public Complex createComplex() {
        Complex complex = new Complex();
        return complex;
    }

    @Override
    public Complex createComplex(int real, int image) {
        Complex complex = new Complex(real, image);
        return complex;
    }

    public static void main(String[] args) {
        ConcreteFactory factory = new ConcreteFactory();
        factory.createComplex(8,6);
    }
}

package praktika.Prak11;

public class FunctionalChair implements Chair{
    public int sum(int a, int b){
        return a+b;
    }

    @Override
    public void sit() {
        System.out.println("2+2 is " + sum(2,3));
    }
}

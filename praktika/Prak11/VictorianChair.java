package praktika.Prak11;

public class VictorianChair implements Chair{
    private int age;

    public VictorianChair(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void sit() {
        System.out.println("You have sat on Victorian Chair which is " + getAge() + " years old!") ;
    }
}

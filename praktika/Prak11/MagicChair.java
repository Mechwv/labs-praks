package praktika.Prak11;

public class MagicChair implements Chair{
    public void doMagic(){
        System.out.println("Skidadle - skidoodle u now live in Russland");
    }

    @Override
    public void sit() {
        System.out.println("WOOOOOOB");
    }
}

package rtu.IT.IKBO_06_19.Vizer.Lab3;

public class Lab3test {
    public static void main(String[] args) {
        Archers archers = new Archers("bow",12.4f,"Archers", 10, false);
        Warriors warriors = new Warriors("sword",25.4f,"Warriors", 20, false);
        archers.displayInfo();
        warriors.displayInfo();
    }
}

package rtu.IT.IKBO_06_19.Vizer.Lab4;

public class intertest {
    public static void main(String[] args) {
        Student s = new Student();
        s.select();
        Teacher t = new Teacher();
        t.select();
        System.out.println(s.isSelected() + "\n" + t.isSelected() + " " + t.getName());

    }
}

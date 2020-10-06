package praktika.Prak9;

public class Student implements Comparable<praktika.Prak9.Student>{
    private int id;
    private String fio;
    private double GPA;

    public Student() {}

    public Student(int id, String fio, double GPA) {
        this.id = id;
        this.fio = fio;
        this.GPA = GPA;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public double getGPA() {
        return GPA;
    }

    @Override
    public int compareTo(Student student) {
        return Double.compare(this.GPA,student.GPA);
    }
}

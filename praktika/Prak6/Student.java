package praktika.Prak6;

public class Student implements Comparable<Student>{
    private double GPA;
    private int id;

    public Student(double GPA, int id) {
        this.GPA = GPA;
        this.id = id;
    }

    public Student() {
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int compareTo(Student o) {
        return Double.compare(this.GPA,o.GPA);
    }
}

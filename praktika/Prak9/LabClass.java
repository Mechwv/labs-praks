package praktika.Prak9;

import javax.swing.*;
import java.util.ArrayList;

public class LabClass extends Student{
    private String group;
    private ArrayList<Student> students = new ArrayList<>();

    public LabClass(int id, String fio, double GPA, String group) throws EmptyStringExeption{
        super(id, fio, GPA);
        if (fio.equals(""))
            throw new StudentNotFoundExeption("Empty String!");
        this.group = group;

    }

    public LabClass(String group) throws EmptyStringExeption{
        try {
            this.group = group;
        } catch (EmptyStringExeption err) {
            throw new StudentNotFoundExeption("Empty String!");
        }
    }

    public void add(int id, String fio, double GPA) throws EmptyStringExeption{
        if (fio.equals(""))
            throw new EmptyStringExeption("Empty FIO!");
            students.add(new Student(id, fio, GPA));

    }
    public Student find(String fio) throws StudentNotFoundExeption, EmptyStringExeption{
        if (fio.equals(""))
            throw new EmptyStringExeption("Empty String!");
                for (Student o : students) {
                    if (o.getFio().equals(fio)) {
                        JOptionPane.showMessageDialog(null, o.getFio()+" "+o.getId()+" "+o.getGPA(), "Найдено",JOptionPane.INFORMATION_MESSAGE);
                        return o;
                    }
                }
                throw new StudentNotFoundExeption("Student was not found!");
    }

    public void qSort(Comparable[] list, int a, int b){
        if (a < b) {
            int i = a, j = b;
            Comparable x = list[(i + j) / 2];
            do {
                while (list[i].compareTo(x) < 0)
                    i++;
                while (x.compareTo(list[j]) < 0)
                    j--;
                if ( i <= j) {
                    Comparable tmp = list[i];
                    list[i] = list[j];
                    list[j] = tmp;
                    i++;
                    j--;
                }

            } while (i <= j);
            qSort(list, a, j);
            qSort(list, i, b);
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}

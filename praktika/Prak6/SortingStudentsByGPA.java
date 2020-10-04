package praktika.Prak6;

public class SortingStudentsByGPA {
    public static void qSort(Comparable[] list, int a, int b){
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

    public static void main(String[] args){
        int n = 10;
        Student[] st = new Student[n];
        for (int i = 0; i < n; i++){
            st[i] = new Student(i%5 + 0.5,i);
        }
        qSort(st,0,9);
        for (Student t : st){
            System.out.println(t.getId() + " " + t.getGPA());
        }
    }
}

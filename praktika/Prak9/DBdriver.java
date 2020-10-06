package praktika.Prak9;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class DBdriver{
    private DefaultTableModel tableModel;
    private LabClass DB = new LabClass("first");

    public DBdriver(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void add(int id, String fio, double GPA){
        DB.add(id,fio,GPA);
        Object[] row = {id, fio, GPA};
        tableModel.addRow(row);
    }

    public void sort(){
        Student[] kek = new Student[DB.getStudents().size()];
        kek = DB.getStudents().toArray(kek);
        DB.qSort(kek, 0,DB.getStudents().size()-1);
        for (int i =0; i < kek.length; i++){
            tableModel.setValueAt(kek[i].getId(), i, 0);
            tableModel.setValueAt(kek[i].getFio(), i, 1);
            tableModel.setValueAt(kek[i].getGPA(), i, 2);
        }
    }

    public void find(String fio){
        Student kek = DB.find(fio);
    }

}

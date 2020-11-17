package Lab16.obolochka;

import javax.swing.table.DefaultTableModel;

public class TM extends DefaultTableModel {

    public TM(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}

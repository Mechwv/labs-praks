package praktika.Prak9;

import javax.swing.*;

public class EmptyStringExeption extends RuntimeException{
    public EmptyStringExeption(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }
}

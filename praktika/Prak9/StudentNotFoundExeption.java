package praktika.Prak9;

import javax.swing.*;

public class StudentNotFoundExeption extends RuntimeException{
    public StudentNotFoundExeption(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "Ошибка",JOptionPane.ERROR_MESSAGE);
    }
}

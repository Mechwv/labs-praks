package rtu_IT_IKBO_06_19_Vizer.Lab4;

public class Student implements Selectable {

    private boolean selected = false;

    @Override
    public void select() {
        selected = true;
    }

    public boolean isSelected() {
        return selected;
    }
}

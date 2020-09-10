package rtu.IT.IKBO_06_19.Vizer.Lab4;

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

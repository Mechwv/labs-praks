package rtu.IT.IKBO_06_19.Vizer.Lab4;

public class Teacher implements Selectable{

    private boolean selected = false;
    private String name;

    @Override
    public void select() {
        selected = true;
        name = "pepega";
    }

    public boolean isSelected() {
        return selected;
    }

    public String getName() {
        return name;
    }
}

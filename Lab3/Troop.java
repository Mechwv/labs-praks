package rtu_IT_IKBO_06_19_Vizer.Lab3;

public abstract class Troop {
    private String weapon;
    private float atk_per_unit;
    private String type;
    private int size_of_troop;

    public Troop(String weapon, float atk_per_unit, String type, int size_of_troop) {
        this.weapon = weapon;
        this.atk_per_unit = atk_per_unit;
        this.type = type;
        this.size_of_troop = size_of_troop;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void displayInfo();

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public float getAtk_per_unit() {
        return atk_per_unit;
    }

    public void setAtk_per_unit(float atk_per_unit) {
        this.atk_per_unit = atk_per_unit;
    }

    public int getSize_of_troop() {
        return size_of_troop;
    }

    public void setSize_of_troop(int size_of_troop) {
        this.size_of_troop = size_of_troop;
    }
}
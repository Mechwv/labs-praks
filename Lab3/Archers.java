package rtu.IT.IKBO_06_19.Vizer.Lab3;

class Archers extends Troop {

    private boolean fire_upgrade = false;

    public Archers(String weapon, float atk_per_unit, String type, int size_of_troop, boolean fire_upgrade) {
        super(weapon, atk_per_unit, type, size_of_troop);
        this.fire_upgrade = fire_upgrade;
    }


    @Override
    public void displayInfo() {
        System.out.println("Тип: " + super.getType() +
                " \nРазмер войск: " + super.getSize_of_troop() +
                " \nУрон одного юнита: " + super.getAtk_per_unit() +
                " \nОружие: " + super.getWeapon() +
                " \nОгненное улучшение: " + isFire_upgrade());
    }

    public boolean isFire_upgrade() {
        return fire_upgrade;
    }

    public void setFire_upgrade(boolean fire_upgrade) {
        this.fire_upgrade = fire_upgrade;
    }
}


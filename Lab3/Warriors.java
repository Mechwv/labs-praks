package rtu_IT_IKBO_06_19_Vizer.Lab3;

class Warriors extends Troop {

    private boolean armor_upgrade = false;

    public Warriors(String weapon, float atk_per_unit, String type, int size_of_troop, boolean armor_upgrade) {
        super(weapon, atk_per_unit, type, size_of_troop);
        this.armor_upgrade = armor_upgrade;
    }

    @Override
    public void displayInfo() {
        System.out.println("Тип: " + super.getType() +
                " \nРазмер войск: " + super.getSize_of_troop() +
                " \nУрон одного юнита: " + super.getAtk_per_unit() +
                " \nОружие: " + super.getWeapon() +
                " \nБронное улучшение: " + isArmor_upgrade());
    }

    public boolean isArmor_upgrade() {
        return armor_upgrade;
    }

    public void setArmor_upgrade(boolean armor_upgrade) {
        this.armor_upgrade = armor_upgrade;
    }
}


package Lab16;

public class Drink extends MenuItem implements Alcoholable {
    private double alcoholVol;
    private DrinkTypeEnum type;

    public Drink(int cost, String name, String description, double alcoholVol, DrinkTypeEnum typeEnum) {
        super(cost, name, description);
        this.alcoholVol = alcoholVol;
        this.type = typeEnum;
    }

    public DrinkTypeEnum getType() {
        return type;
    }

    @Override
    public boolean isAlcoholicDrink() {
        return alcoholVol > 0;
    }

    @Override
    public double getAlcoholVol() {
        return alcoholVol;
    }
}

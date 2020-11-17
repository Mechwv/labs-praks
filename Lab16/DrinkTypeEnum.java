package Lab16;

public enum DrinkTypeEnum {
    BEER,
    VODKA,
    BRANDY,
    CHAMPANGE,
    WHISKEY,
    TEQUILA,
    RUM,
    VERMUTH,
    LIQUOR,
    JAGERMEISTER,
    JUICE,
    COFFEE,
    GREEN_TEA,
    BLACK_TEA,
    MILK,
    WATER,
    SODA;

    static {
        BEER.value = new Drink(100, "Beer", "Perfect beer", 0.05, BEER);
        VODKA.value = new Drink(200, "Vodka", "Just vodka. Please do not play balalayka", 0.4, VODKA);
        BRANDY.value = new Drink(400, "Brandy", "Classy drink for serious men", 0.4, BRANDY);
        CHAMPANGE.value = new Drink(450, "Chanpange", "Soft, bubble drink", 0.1, CHAMPANGE);
        WHISKEY.value = new Drink(500, "Whiskey", "Oh you are a cowboy?", 0.6, WHISKEY);
        TEQUILA.value = new Drink(400, "Tequila", "Made from pure mexican cactus", 0.5, TEQUILA);
        RUM.value = new Drink(400, "Rum", "Many not a very good memories are related to rum", 0.4, RUM);
        VERMUTH.value = new Drink(500, "Vermuth", "The best wine available", 0.15, VERMUTH);
        LIQUOR.value = new Drink(350, "Liquor", "Same as vodka but better", 0.4, LIQUOR);
        JAGERMEISTER.value = new Drink(500, "Jagermeister", "Legenday \"Jager\" is here", 0.35, JAGERMEISTER);
        JUICE.value = new Drink(50, "Juice", "Fresh orange juice", 0, JUICE);
        COFFEE.value = new Drink(50, "Coffee", "Black as my soul coffee", 0, COFFEE);
        GREEN_TEA.value = new Drink(50, "Green tea", "Green and eco-friendly tea", 0, GREEN_TEA);
        BLACK_TEA.value = new Drink(50, "Black tea", "Black and flavored tea", 0, BLACK_TEA);
        MILK.value = new Drink(50, "Milk", "Milk from a cow", 0, MILK);
        WATER.value = new Drink(20, "Pure water", "Just water", 0, WATER);
        SODA.value = new Drink(50, "Soda", "The best soda in this country", 0, SODA);
    }

    private Drink value;

    public Drink getValue() {
        return value;
    }
}

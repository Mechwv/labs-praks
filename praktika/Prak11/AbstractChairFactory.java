package praktika.Prak11;

public interface AbstractChairFactory {
    VictorianChair createVictorianChair();
    MagicChair createMagicanChair();
    FunctionalChair createFunctionalChair();
}

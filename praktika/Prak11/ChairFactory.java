package praktika.Prak11;

public class ChairFactory implements AbstractChairFactory{

    @Override
    public VictorianChair createVictorianChair(){
        return new VictorianChair(96);
    }

    @Override
    public MagicChair createMagicanChair() {
        return new MagicChair();
    }

    @Override
    public FunctionalChair createFunctionalChair() {
        return new FunctionalChair();
    }
}

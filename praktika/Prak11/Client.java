package praktika.Prak11;

import java.util.Scanner;

public class Client implements Chair{
    public Chair chair;

    @Override
    public void sit() {
        chair.sit();
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public static void main(String[] args) {
        System.out.println("Перед тобой 3 стула: " +
                "\n1 - Victorian chair" +
                "\n2 - Functional chair" +
                "\n3 - Magic chair " +
                "\n на какой сам сядешь, на какой кота посадишь?");
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();
        AbstractChairFactory factory = new ChairFactory();
        switch (scanner.nextInt()) {
            case 1:
                client.setChair(factory.createVictorianChair());
                break;
            case 2:
                client.setChair(factory.createFunctionalChair());
                break;
            case 3:
                client.setChair(factory.createMagicanChair());
                break;
        }
        client.sit();
    }
}

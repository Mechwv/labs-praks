package praktika.Prak8;

public class Main {
    public static void main(String[] args) {
        WaitList<Integer> waitList = new WaitList<>();
        BoundedWaitList<Integer> boundedWaitList = new BoundedWaitList<>(10);
        UnfairWaitList<Integer> unfairWaitList = new UnfairWaitList<>();

        for (int i = 0; i < 11; i++){
            waitList.add(i);
            boundedWaitList.add(i);
            unfairWaitList.add(i);
        }

        System.out.println(waitList.toString());
        System.out.println(boundedWaitList.toString());
        System.out.println(unfairWaitList.toString());

        unfairWaitList.moveToBack(4);
        System.out.println("4-ку в конец");
        System.out.println(unfairWaitList.toString());

        unfairWaitList.remove(10);
        System.out.println("10-ку удаляем");
        System.out.println(unfairWaitList.toString());
    }
}

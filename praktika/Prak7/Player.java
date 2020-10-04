package praktika.Prak7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private Queue<Integer> a = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);
    public Player() {
        Random random = new Random();
        for (int i =0; i < 5; i++){
            a.add(scanner.nextInt());
        }
    }

    public int get_card(){
        if (a.peek() != null)
            return a.poll();
        return -1;
    }

    public int peek_card(){
        if (a.peek() != null)
            return a.peek();
        return -1;
    }

    public boolean isEmpty(){
        if (a.peek() == null)
            return true;
        return false;
    }
    public void put_card(int card){
        a.add(card);
    }

}

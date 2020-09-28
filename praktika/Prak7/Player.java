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
        return a.poll();
    }

    public int peek_card(){
        return a.peek();
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

package Lab7;

import java.util.LinkedList;

public class Lab7 {
    private static LinkedList<Character> list = new LinkedList<>();


    public static void print(String command){
        System.out.print(command + ": ");
        for (Object e : list) {
            System.out.print(e + " ");
        }
        System.out.println();
    }


    public static void test(){
        print("add");

        list.addFirst('ъ');
        print("addFirst");

        list.addLast('й');
        print("addLast");

        list.removeFirst();
        print("removeFirst");

        list.removeLast();
        print("removeLast");

        list.getFirst();
        print("getFirst");

        list.getLast();
        print("getLast");

        list.add(3,'3');
        print("add to index");

        Character a = '3'; // char a = '3' - ошибка
        list.remove(a); // list.remove('3'); - ошибка
        print("remove object by it`s value");
    }


    public static void main(String[] args) {
        for (int i =1; i < 11; i++){
            list.add((char)(' '+i*10));
        }
        test();
    }
}

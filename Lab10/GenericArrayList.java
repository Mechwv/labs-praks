package Lab10;

import java.util.*;
public class GenericArrayList {
    private int size; // количество элементов- емкость списка
    private Object[] elements;

    public GenericArrayList() {
        size = 0;
        elements = new Object[size];
    }

    public <T> void add(T e) {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, size + 1);
        }
        elements[size] = e;
        ++size;
    }

    public void printList() {
        for (Object o : elements)
                System.out.println(o);
    }

    public static void main(String[] args) {
        GenericArrayList list = new GenericArrayList();
        list.add(5);
        list.add(1.5);
        list.add(191919191992345234L);
        byte k = 123;
        list.add(k);
        list.printList();
    }
}
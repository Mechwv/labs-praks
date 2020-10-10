package Lab10;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class ArraytoArraylist {
    public static <T> void arrayToList(T[] arr, ArrayList<T> list) {
        list.addAll(Arrays.asList(arr));
    }

    public static <T> int  getIndex(T[] arr, T element){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == element)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] a = new String[10];
        Arrays.fill(a,"0");
        a[7] = "kek";
        System.out.println("Index is: " + getIndex(a,"kek"));
    }
}

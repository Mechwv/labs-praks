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

    public static void katalog() {
        File dir = new File("Lab10/katalog");
        if (dir.isDirectory()) {
            int cnt = 0;
            for (File item : dir.listFiles()) {
                if (cnt == 5) break;
                System.out.println(item.getName());
                cnt++;
            }
        }
    }

    public static void main(String[] args) {
        String[] a = new String[10];
        Arrays.fill(a,"0");
        a[7] = "kek";
        System.out.println("Index is: " + getIndex(a,"kek"));
        katalog();
    }
}

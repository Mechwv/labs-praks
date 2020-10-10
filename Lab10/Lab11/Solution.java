package Lab10.Lab11;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static java.lang.Integer.min;

public class Solution {

    public static <T> ArrayList<T> newArrayList(T[] a){
        return new ArrayList<>(Arrays.asList(a));
    }

    public static <T> HashSet<T> newHashSet(T[] a){
        return new HashSet<>(Arrays.asList(a));
    }

    public static <K,V> HashMap<K,V> newHashMap(K[] keys, V[] values) throws Exception{
        HashMap<K,V> hashMap = new HashMap<>();
        int size = min(keys.length, values.length);
        for (int i = 0; i< size; i++){
            hashMap.put(keys[i], values[i]);
        }
        return hashMap;
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
        katalog();
    }
}

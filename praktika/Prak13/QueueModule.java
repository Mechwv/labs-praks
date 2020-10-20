package praktika.Prak13;

import java.util.Arrays;

public class QueueModule {
    private static int start=0;
    private static int end=-1;
    private static int maxSize = 10;
    private static int[] queue = new int[maxSize];
    private static int nElem=0;

    private static void checkUpdSize() {
        if (nElem == maxSize) {
            queue = Arrays.copyOf(queue, 2 * maxSize);
            maxSize*=2;
        }
    }

    public static void enqueue(int elem) {
        checkUpdSize();
        if (end == maxSize - 1) {  // циклический перенос
            end = -1;
        }

        queue[++end] = elem;  //увеличение end и вставка
        nElem++;  // увеличение количества элементов в очереди
    }

    //@requires nElem > 0
    //@ensures first element returned
    public static int element() {
        return (nElem > 0) ? queue[start] : null;
    }

    //@requires nElem > 0
    //@ensures deletes first element and returns it
    public static Integer dequeue() {
        if (nElem > 0) {
            int temp = queue[start++]; // получаем первый элемент из очереди

            if (start == maxSize) { // циклический перенос
                start = 0;
            }
            nElem--; // уменьшаем количество элементов в очереди
            return temp;
        }
        else
            return null;
    }

    public static int size() {
        return nElem;
    }

    public static boolean isEmpty() {
        return nElem == 0;
    }

    public static void clear() {
        for (int i = 0; i < nElem; i++) {
            queue[i] = 0;
        }
        nElem = 0;
        end = -1;
        start = 0;
    }

}
package praktika.Prak13;

import java.util.Arrays;

public class QueueADT <T> {

    private int start;
    private int end;
    private T[] queue;
    private int maxSize;
    private int nElem;

    //@requires maxSize > 0
    //@ensures QueueModule constructor
    public QueueADT(int maxSize) {
        maxSize = (maxSize > 0) ? maxSize : 1;
        this.maxSize = maxSize;
        queue = (T[]) new Object[maxSize];
        end = -1;
        start = 0;
        nElem = 0;
    }

    private void checkUpdSize() {
        if (nElem == maxSize) {
            queue = Arrays.copyOf(queue, 2 * maxSize);
        }
    }

    public void enqueue(T elem) {
        checkUpdSize();
        if (end == maxSize - 1) {  // циклический перенос
            end = -1;
        }

        queue[++end] = elem;  //увеличение end и вставка
        nElem++;  // увеличение количества элементов в очереди
    }

    //@requires nElem > 0
    //@ensures first element returned
    public T element(){
        return (nElem > 0) ? queue[start] : null;
    }

    //@requires nElem > 0
    //@ensures deletes first element and returns it
    public T dequeue(){
        if (nElem > 0) {
            T temp = queue[start++]; // получаем первый элемент из очереди

            if (start == maxSize) { // циклический перенос
                start = 0;
            }
            nElem--; // уменьшаем количество элементов в очереди
            return temp;
        }
        else
            return null;
    }

    public int size(){
        return nElem;
    }

    public boolean isEmpty(){
        return nElem == 0;
    }

    public void clear(){
        Arrays.fill(queue, null);
        nElem = 0;
        end = -1;
        start = 0;
    }
}

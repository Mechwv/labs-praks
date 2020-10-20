package praktika.Prak13;

import java.util.Arrays;

public class Queue {
    private int start;
    private int end;
    private int[] queue;
    private int maxSize;
    private int nElem;

    //@requires maxSize > 0
    //@ensures QueueModule constructor
    public Queue(int maxSize) {
        maxSize = (maxSize > 0) ? maxSize : 1;
        this.maxSize = maxSize;
        queue = new int[maxSize];
        end = -1;
        start = 0;
        nElem = 0;
    }

    private void checkUpdSize() {
        if (nElem == maxSize) {
            queue = Arrays.copyOf(queue, 2 * maxSize);
            maxSize*=2;
        }
    }

    public void enqueue(int elem) {
        checkUpdSize();
        if (end == maxSize - 1) {  // циклический перенос
            end = -1;
        }

        queue[++end] = elem;  //увеличение end и вставка
        nElem++;  // увеличение количества элементов в очереди
    }


    //@requires nElem > 0
    //@ensures first element returned
    public int element(){
        return queue[start];
    }


    //@requires nElem > 0
    //@ensures deletes first element and returns it
    public int dequeue(){
        int temp = queue[start++]; // получаем первый элемент из очереди

        if (start == maxSize) { // циклический перенос
            start = 0;
        }
        nElem--; // уменьшаем количество элементов в очереди
        return temp;

    }

    public int size(){
        return nElem;
    }

    public boolean isEmpty(){
        return nElem == 0;
    }

    public void clear(){
        for (int i = 0; i < nElem; i++){
            queue[i] = 0;
        }
        nElem = 0;
        end = -1;
        start = 0;
    }

    public static void main(String[] args) {
        System.out.println("////////////Queue////////////");
        Queue queue = new Queue(4);
        System.out.println(queue.isEmpty());
        queue.enqueue(3);
        System.out.println(queue.element());
        queue.enqueue(5);
        queue.dequeue();
        System.out.println(queue.element());
        System.out.println(queue.isEmpty());


        QueueADT <String> queueADT = new QueueADT<>(4);
        System.out.println("////////////QueueADT////////////" + "\n" +queueADT.isEmpty());
        queueADT.enqueue("bipki");
        queueADT.enqueue("kek");
        queueADT.enqueue("meow");
        queueADT.clear();
        System.out.println(queueADT.element());
        System.out.println(queueADT.isEmpty());


        System.out.println("////////////QueueModule////////////");
        QueueModule.dequeue();
        QueueModule.enqueue(234);
        System.out.println(QueueModule.element());
        System.out.println(QueueModule.isEmpty());
    }
}

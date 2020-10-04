package praktika.Prak8;

/**
 * Список ожидания с ограниченной емкостью
 */
public class BoundedWaitList<E> extends WaitList<E>{
    private final int capacity;

    public BoundedWaitList(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * добавление элемента @param element, если позволяет размер
     */
    @Override
    public void add(E element) {
        if (content.size() < capacity)
            super.add(element);
    }

    @Override
    public String toString() {
        return "BoundedWaitList{" +
                "capacity=" + capacity +
                ", content=" + content +
                '}';
    }
}

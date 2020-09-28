package praktika.Prak8;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * Обычная реализация WaitList
 */
public class WaitList<E> implements IWaitList<E> {
    protected ConcurrentLinkedQueue<E> content = new ConcurrentLinkedQueue<>();

    /**
     * Коснтруктор по умолчанию
     */
    public WaitList() {}

    /**
     * Коснтруктор с заполнением из коллекции @param content
     */
    public WaitList(Collection<E> content) {
            this.content.addAll(content);
    }

    @Override
    public String toString() {
        return "WaitList{" +
                "content=" + content +
                '}';
    }

    @Override
    public void add(E element) {
        content.add(element);
    }

    @Override
    public E remove() {
        return content.poll();
    }

    @Override
    public boolean contains(E element) {
        return content.contains(element);
    }

    @Override
    public boolean containsAll(Collection<E> c) {
        return content.containsAll(c);
    }

    @Override
    public boolean isEmpty() {
        return content.isEmpty();
    }
}

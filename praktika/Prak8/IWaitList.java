package praktika.Prak8;

import java.util.Collection;

/** интерфейс для WaitList
 * @param <E> - используемый элемент
 */
public interface IWaitList<E> {
    /**
     * добавление элемента @param element
     */
    void add(E element);

    /**
     * Извлечение и возврат элемента в очереди
     */
    E remove();

    /**
     * Проверка на наличие @param element в очереди
     */
    boolean contains(E element);

    /**
     * Проверка на наличие @param c в очереди
     */
    boolean containsAll(Collection<E> c);

    /**
     * Проверка, пустая ли очередь
     */
    boolean isEmpty();
}

package praktika.Prak8;

/**
 * Список ожидания, в котором можно удалить любой элемент либо переместить в конец списка
 */
public class UnfairWaitList<E> extends WaitList<E>{

    public UnfairWaitList() {}

    /**
     * Удаление @param element
     */
    public void remove(E element) {
        if (content.peek() != element)
            content.remove(element);
    }

    /**
     * Перемещение в конец @param element
     */
    public void moveToBack(E element) {
        if (content.remove(element))
            content.add(element);
    }
}

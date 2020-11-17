package Lab16;

public class QueueNode {
    private QueueNode next = null;
    private QueueNode prev = null;
    private Order value;

    public QueueNode(QueueNode prev, Order order) {
        this.prev = prev;
        this.value = order;
    }

    public QueueNode() {

    }

    public Order getValue() {
        return value;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }

    public void setPrev(QueueNode prev) {
        this.prev = prev;
    }

    public QueueNode getNext() {
        return next;
    }

    public QueueNode getPrev() {
        return prev;
    }

    public void setValue(Order value) {
        this.value = value;
    }
}

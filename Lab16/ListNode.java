package Lab16;

public class ListNode {
    private ListNode next;
    private MenuItem value;

    public ListNode(ListNode next, MenuItem value) {
        this.next = next;
        this.value = value;
    }

    public ListNode() {
        next = null;
        value = null;
    }

    public ListNode getNext() {
        return next;
    }

    public MenuItem getValue() {
        return value;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setValue(MenuItem value) {
        this.value = value;
    }
}

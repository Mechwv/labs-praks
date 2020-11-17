package Lab16;

public class InternetOrdersManager implements OrdersManager {
    private QueueNode head = null;
    private QueueNode tail = null;
    private int size = 0;

    @Override
    public int itemsQuantity(String itemName) {
        QueueNode node = head;
        int cnt = 0;
        while (node != null) {
            cnt += node.getValue().itemQuantity(itemName);
            node = node.getNext();
        }
        return cnt;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        return itemsQuantity(item.getName());
    }

    @Override
    public Order[] getOrders() {
        QueueNode node = head;
        Order[] orders = new Order[size];
        int j = 0;
        while (node != null) {
            orders[j++] = node.getValue();
            node = node.getNext();
        }
        return orders;
    }

    @Override
    public int ordersCostSummary() {
        QueueNode node = head;
        int cost = 0;
        while (node != null) {
            cost += node.getValue().costTotal();
            node = node.getNext();
        }
        return cost;
    }

    @Override
    public int ordersQuantity() {
        return size;
    }

    private QueueNode getOrderNode(Address address) {
        QueueNode node = head;
        while (node != null) {
            if (node.getValue().getCustomer().getAddress().equals(address))
                return node;
            node = node.getNext();
        }
        return null;
    }

    public boolean add(Order order) throws OrderAlreadyAddedException {
        if (head == null)
            head = new QueueNode();
        if (head.getValue() == null)
            head.setValue(order);
        else if (tail == null) {
            if (head.getValue().getCustomer().getAddress().equals(order.getCustomer().getAddress()))
                throw new OrderAlreadyAddedException("Address " + order.getCustomer().getAddress().toString() + " has already ordered");
            tail = new QueueNode(head, order);
            head.setNext(tail);
        } else {
            QueueNode orderNode = getOrderNode(order.getCustomer().getAddress());
            if (orderNode != null)
                throw new OrderAlreadyAddedException("Address " + order.getCustomer().getAddress().toString() + " has already ordered");
            tail = new QueueNode(tail, order);
            (tail.getPrev()).setNext(tail); // Set `node before tail`.next
        }
        size++;
        return true;
    }

    public Order remove(Address orderAddress){
        QueueNode orderNode = getOrderNode(orderAddress);
        if (orderNode == null)
            return null;
        if (orderNode.getNext() != null)
            (orderNode.getNext()).setPrev(orderNode.getPrev());
        if (orderNode.getPrev() != null)
            (orderNode.getPrev()).setNext(orderNode.getNext());
        if (orderNode == head)
            head = null;
        size--;
        return orderNode.getValue();
    }

    public Order order(Address orderAddress){
        QueueNode orderNode = getOrderNode(orderAddress);
        if (orderNode == null)
            return null;
        else
            return orderNode.getValue();
    }
}

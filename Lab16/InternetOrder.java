package Lab16;

import java.util.Arrays;

public class InternetOrder implements Order{
    private int size=0;
    private ListNode head = null;
    private ListNode tail = null;
    private Customer customer;

    public InternetOrder(MenuItem[] items) {
        for (MenuItem item : items)
            add(item);
    }

    @Override
    public MenuItem[] getItems() {
        if (tail == null) {
            if (head.getValue() != null)
                return new MenuItem[]{head.getValue()};
            return new MenuItem[]{};
        }
        MenuItem[] items = new MenuItem[size];
        ListNode buf = tail;
        for (int i = 0; i < size; i++){
            items[i] = buf.getValue();
            buf = buf.getNext();
        }
        return items;
    }

    @Override
    public boolean add(MenuItem item) {
        if (head == null)
            head = new ListNode();
        if (head.getValue() == null)
            head.setValue(item);
        else if (tail == null)
            tail = new ListNode(head, item);
        else
            tail = new ListNode(tail, item);
        size++;
        return true;
    }

    @Override
    public String[] itemsNames() {
        String[] names = new String[size];
        ListNode buf = tail;
        for (int i =0; i < size; i++){
            names[i] = buf.getValue().getName();
            buf = buf.getNext();
        }
        return names;
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemQuantity(String itemName) {
        MenuItem[] items = getItems();
        int cnt = 0;
        for (MenuItem i : items){
            if (i.getName().equals(itemName)){
                cnt++;
            }
        }
        return cnt;
    }

    @Override
    public int itemQuantity(MenuItem item) {
        return itemQuantity(item.getName());
    }


    @Override
    public boolean remove(String itemName) {
        if (tail == null) {
            if (head.getValue() != null && head.getValue().getName().equals(itemName)) {
                head.setValue(null);
                return true;
            }
            return false;
        }
        ListNode buf = tail;
        ListNode buf1 = tail;
        while (buf != null) {
            if (buf.getValue().getName().equals(itemName)) {
                if (buf == tail){
                    tail = null;
                    return true;
                }
                if (buf == head){
                    buf1.setValue(buf.getValue());
                    buf1.setNext(null);
                    head = buf1;
                    return true;
                }
                buf1.setNext(buf.getNext());
                return true;
            }
            buf1 = buf;
            buf = buf.getNext();
        }
        return false;
    }

    @Override
    public boolean remove(MenuItem item) {
       return remove(item.getName());
    }

    @Override
    public int removeAll(String itemName) {
        int cnt = 0;
        while (remove(itemName))
            cnt++;
        return cnt;
    }

    @Override
    public int removeAll(MenuItem item) {
        return removeAll(item.getName());
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] items = getItems();
        for (int i = 0; i < items.length; i++) {
            boolean wasSwap = false;
            for (int j = 1; j < items.length; j++) {
                if (items[j - 1].getCost() < items[j].getCost()) {
                    MenuItem tmp = items[j];
                    items[j] = items[j - 1];
                    items[j - 1] = tmp;
                    wasSwap = true;
                }
            }
            if (!wasSwap)
                break;
        }
        return items;
    }

    @Override
    public int costTotal() {
        MenuItem[] items = getItems();
        int cnt = 0;
        for (MenuItem i : items){
            cnt+=i.getCost();
        }
        return cnt;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public static void main(String[] args) {
        MenuItem[] items = new MenuItem[5];
        MenuItem buf = new MenuItem(100,"Vodka", "оп и в стельку");
        items[0] = buf;
        items[2] = buf;
        items[3] = buf;
        items[4] = buf;
        buf = new MenuItem(200,"Djin", "я колдун");
        items[1] = buf;
        InternetOrder order = new InternetOrder(items);
        System.out.println(order.itemQuantity("Vodka"));
    }
}

package Lab16;

import java.util.HashMap;

public class TableOrder implements Order{
    private int size = 0;
    private MenuItem[] items = new MenuItem[1];
    private Customer customer;
    private int table;

    public void update(){
        int nsize = size;
        for (int i = 0, j = 0; i < size; i++) {
            if (items[i] != null)
                items[j++] = items[i];
            else
                nsize--;
        }
        size = nsize;
    }

    public String getType() {
        return "TABLE";
    }

    public TableOrder(int table){
        this.table = table;
    }

    @Override
    public boolean add(MenuItem item) {
        if (size == items.length) {
            MenuItem[] new_items = new MenuItem[(size == 0) ? 1 : (size * 2)];
            System.arraycopy(items, 0, new_items, 0, size);
            items = new_items;
        }
        items[size++] = item;
        return true;
    }

    @Override
    public String[] itemsNames() {
        MenuItem[] items = getItems();
        HashMap<String, Boolean> orders = new HashMap<>();
        for (int i = 0; i < size; i++)
            if (!orders.containsKey(items[i].getName()))
                orders.put(items[i].getName(), true);

        return (String[]) orders.keySet().toArray();
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemQuantity(String itemName) {
        int cnt = 0;
        for (int i = 0; i < size; i++)
            if (items[i].getName().equals(itemName))
                cnt++;
        return cnt;
    }

    @Override
    public int itemQuantity(MenuItem item) {
        return itemQuantity(item.getName());
    }

    @Override
    public MenuItem[] getItems() {
        MenuItem[] new_items = new MenuItem[size];
        System.arraycopy(items, 0, new_items, 0, size);
        return new_items;
    }

    @Override
    public boolean remove(String itemName) {
        for (int i = size - 1; i >= 0; i--) {
            if (items[i].getName().equals(itemName)) {
                items[i] = null;
                update();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(MenuItem item) {
        return remove(item.getName());
    }

    @Override
    public int removeAll(String itemName) {
        int nsize = size;
        for (int i = size - 1; i >= 0; i--) {
            if (items[i] != null && items[i].getName().equals(itemName)) {
                items[i] = null;
                nsize--;
            }
        }
        if (nsize == size)
            return 0;
        int loss = size - nsize;
        update();
        return loss;
    }

    @Override
    public int removeAll(MenuItem item) {
        return removeAll(item.getName());
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] new_items = getItems();
        qSort(new_items, 0, size);
        return new_items;
    }

    public static void qSort(Comparable[] list, int a, int b){
        if (a < b) {
            int i = a, j = b;
            Comparable x = list[(i + j) / 2];
            do {
                while (list[i].compareTo(x) < 0)
                    i++;
                while (x.compareTo(list[j]) < 0)
                    j--;
                if ( i <= j) {
                    Comparable tmp = list[i];
                    list[i] = list[j];
                    list[j] = tmp;
                    i++;
                    j--;
                }

            } while (i <= j);
            qSort(list, a, j);
            qSort(list, i, b);
        }
    }

    @Override
    public int costTotal() {
        int sum = 0;
        for (int i = 0; i < size; i++)
            sum += items[i].getCost();
        return sum;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }
}

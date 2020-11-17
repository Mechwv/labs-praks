package Lab16;

public class TableOrdersManager implements OrdersManager{
    public static final int ALL_TABLES = 4;
    private TableOrder[] orders = new TableOrder[ALL_TABLES];
    private int ordersCount = 0;

    public void checkTableNumber(int tableNumber) {
        if (tableNumber > ALL_TABLES || tableNumber <= 0)
            try {
                throw new IllegalTableNumber("Table with number " + tableNumber + " does not exist");
            } catch (IllegalTableNumber illegalTableNumber) {
                illegalTableNumber.printStackTrace();
            }
    }

    public void add(TableOrder order, int tableNumber) throws OrderAlreadyAddedException {
        checkTableNumber(tableNumber);
        if (orders[tableNumber - 1] != null)
            throw new OrderAlreadyAddedException("Table №" + tableNumber + " has already have an order");
        order.setTable(tableNumber);
        ordersCount++;
        orders[tableNumber - 1] = order;
        orders[tableNumber - 1].setTable(tableNumber);
    }

    public void add(int tableNumber) throws OrderAlreadyAddedException {
        checkTableNumber(tableNumber);
        if (orders[tableNumber - 1] != null)
            throw new OrderAlreadyAddedException("Table №" + tableNumber + " has already have an order");
    }

    public void addItem(MenuItem item, int tableNumber) {
        checkTableNumber(tableNumber);
        if (orders[tableNumber - 1] == null)
            throw new IllegalArgumentException("Table №" + tableNumber + " has no order!");
        orders[tableNumber - 1].add(item);
    }

    public int freeTableNumber() {
        for (int i = 0; i < ALL_TABLES; i++)
            if (orders[i] == null)
                return i;
        return -1;
    }

    public int[] freeTableNumbers() {
        int[] freeNumbers = new int[ALL_TABLES - ordersCount];
        int j = 0;
        for (int i = 0; i < ALL_TABLES; i++)
            if (orders[i] == null)
                freeNumbers[j++] = i + 1;
        return freeNumbers;
    }

    public TableOrder getOrder(int tableNumber) {
        checkTableNumber(tableNumber);
        return orders[tableNumber - 1];
    }

    public void remove(int tableNumber) {
        checkTableNumber(tableNumber);
        if (orders[tableNumber - 1] != null) {
            ordersCount--;
            orders[tableNumber - 1] = null;
        }
    }

    public int remove(Order order) {
        if (order == null)
            return 0;
        for (int i = 0; i < ALL_TABLES; i++) {
            if (order.equals(orders[i])) {
                orders[i] = null;
                ordersCount--;
                return 1;
            }
        }
        return 0;
    }

    public int removeAll(Order order) {
        if (order == null)
            return 0;
        int removeCnt = 0;
        for (int i = 0; i < ALL_TABLES; i++) {
            if (order.equals(orders[i])) {
                removeCnt++;
                orders[i] = null;
            }
        }
        ordersCount -= removeCnt;
        return removeCnt;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int cnt = 0;
        for (Order order : orders) {
            if (order != null)
                cnt += order.itemQuantity(itemName);
        }
        return cnt;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        return itemsQuantity(item.getName());
    }

    @Override
    public TableOrder[] getOrders() {
        TableOrder[] activeOrders = new TableOrder[ordersCount];
        int j = 0;
        for (int i = 0; i < ALL_TABLES; i++)
            if (orders[i] != null)
                activeOrders[j++] = orders[i];
        return activeOrders;
    }

    @Override
    public int ordersCostSummary() {
        int cost = 0;
        for (Order order : orders) {
            if (order != null)
                cost += order.costTotal();
        }
        return cost;
    }

    @Override
    public int ordersQuantity() {
        return ordersCount;
    }

    public void setOrder(Order order, int table){
        orders[table-1] = (TableOrder) order;
    }


}

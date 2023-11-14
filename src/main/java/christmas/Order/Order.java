package christmas.Order;

import christmas.Menu;
import java.util.HashMap;

public class Order {
    private static HashMap<String, Integer> order;

    public Order() {
        this.order = new HashMap<>();
    }

    public static HashMap<String, Integer> processOrder(String OrderInput) {
        String[] orderItems = OrderInput.split(",");
        for (String orderItem : orderItems) {
            String[] itemInfo = orderItem.trim().split("-");
            String name = itemInfo[0];
            int quantity = Integer.parseInt(itemInfo[1]);
            if (order.containsKey(name)) {
                order.clear();
                throw new IllegalArgumentException();
            }
            Menu.valueOf(name);
            order.put(name, quantity);
        }
        if (Order.calculateTotalOrder()>20 || OrderByType.quantityOfNotDrink()==0) {
            order.clear();
            throw new IllegalArgumentException();
        }
        return order;
    }

    public static HashMap<String, Integer> getOrder() {
        return order;
    }

    public static int calculateTotalOrder() {
        int totalOrders = 0;
        for (int value : order.values()) {
            totalOrders += value;
        }
        return totalOrders;
    }
}

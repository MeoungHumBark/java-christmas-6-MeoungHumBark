package christmas;

import java.util.HashMap;

public class Order {
    private static HashMap<String, Integer> order;

    public Order() {
        this.order = new HashMap<>();
    }

    public void processOrder(String OrderInput) {
        String[] orderItems = OrderInput.split(",");
        for (String orderItem : orderItems) {
            String[] itemInfo = orderItem.trim().split("-");
            String name = itemInfo[0];
            int quantity = Integer.parseInt(itemInfo[1]);
            validateProcess(name);
            order.put(name, quantity);
        }
        validateOrder();
    }

    private void validateProcess(String name) {
        Menu.valueOf(name);
        if (order.containsKey(name)) {
            order.clear();
            throw new IllegalArgumentException();
        }
    }

    private void validateOrder() {
        if (calculateTotalOrder()>20 || calculateTotalOrder()==quantityOfType("음료")) {
            order.clear();
            throw new IllegalArgumentException();
        }
    }

    public static HashMap<String, Integer> getOrder() {
        return order;
    }

    private int calculateTotalOrder() {
        int totalOrders = 0;
        for (int value : order.values()) {
            totalOrders += value;
        }
        return totalOrders;
    }

    public static int quantityOfType(String kind) {
        int totalQuantityOfType = 0;

        for (String name : order.keySet()) {
            int quantity = order.get(name);
            String type = Menu.valueOf(name).getType();

            if (type.equals(kind)) {
                totalQuantityOfType += quantity;
            }
        }
        return totalQuantityOfType;
    }
}

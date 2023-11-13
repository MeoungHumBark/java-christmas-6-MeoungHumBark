package christmas;

import java.util.HashMap;

public class Order {
    private HashMap<String, Integer> order;

    public HashMap<String, Integer> processOrder(String OrderInput) {
        String[] orderItems = OrderInput.split(",");
        for (String orderItem : orderItems) {
            String[] itemInfo = orderItem.trim().split("-");
            String name = itemInfo[0];
            int quantity = Integer.parseInt(itemInfo[1]);
            order.put(name, quantity);
        }
        return order;
    }

    public HashMap<String, Integer> getOrder() {
        return order;
    }
}

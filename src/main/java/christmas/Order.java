package christmas;

import java.util.HashMap;

public class Order {
    private HashMap<String, Integer> order;

    public Order(HashMap<String, Integer> order) {
        this.order = new HashMap<>(order);
    }

    public HashMap<String, Integer> getOrder() {
        return order;
    }
}

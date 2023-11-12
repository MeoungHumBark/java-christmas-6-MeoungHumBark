package christmas;

import java.util.HashMap;

public class Order {
    private HashMap<String, Integer> order;

    public HashMap<String, Integer> processOrder(Object... args) {
        for (int i = 0; i < args.length; i += 2) {
            String key = (String) args[i];
            Integer value = (Integer) args[i + 1];
            order.put(key, value);
        }
        return order;
    }

    public HashMap<String, Integer> getOrder() {
        return order;
    }
}

package christmas;

import java.util.HashMap;

public class TotalAmount {
    public int calculateTotalPrice(HashMap<String, Integer> order) {
        int totalPrice = 0;

        for (String name : order.keySet()) {
            int quantity = order.get(name);
            int price = Menu.getPriceByName(name);
            totalPrice += (quantity * price);
        }
        return totalPrice;
    }
}

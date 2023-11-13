package christmas;

import java.util.HashMap;

public class TotalAmount {
    public static int calculateTotalPrice(HashMap<String, Integer> order) {
        int totalPrice = 0;

        for (String name : order.keySet()) {
            int quantity = order.get(name);
            int price = Menu.getPriceByName(name);
            totalPrice += (quantity * price);
        }
        return totalPrice;
    }

    public static int quantityOfMain(HashMap<String, Integer> order) {
        int totalQuantityOfMain = 0;

        for (String name : order.keySet()) {
            int quantity = order.get(name);
            String type = Menu.getTypeByName(name);

            if (type.equals("메인")) {
                totalQuantityOfMain += quantity;
            }
        }
        return totalQuantityOfMain;
    }

    public static int quantityOfDessert(HashMap<String, Integer> order) {
        int totalQuantityOfDessert = 0;

        for (String name : order.keySet()) {
            int quantity = order.get(name);
            String type = Menu.getTypeByName(name);

            if (type.equals("디저트")) {
                totalQuantityOfDessert += quantity;
            }
        }
        return totalQuantityOfDessert;
    }
}

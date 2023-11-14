package christmas;

import java.util.HashMap;

public class TotalAmount {
    public static int calculateTotalPrice() {
        int totalPrice = 0;

        for (String name : Order.getOrder().keySet()) {
            int quantity = Order.getOrder().get(name);
            int price = Menu.getPriceByName(name);
            totalPrice += (quantity * price);
        }
        return totalPrice;
    }

    public static boolean isBonus(int totalAmount) {
        return totalAmount >= 120000;
    }

    public static int quantityOfMain() {
        int totalQuantityOfMain = 0;

        for (String name : Order.getOrder().keySet()) {
            int quantity = Order.getOrder().get(name);
            String type = Menu.getTypeByName(name);

            if (type.equals("메인")) {
                totalQuantityOfMain += quantity;
            }
        }
        return totalQuantityOfMain;
    }

    public static int quantityOfDessert() {
        int totalQuantityOfDessert = 0;

        for (String name : Order.getOrder().keySet()) {
            int quantity = Order.getOrder().get(name);
            String type = Menu.getTypeByName(name);

            if (type.equals("디저트")) {
                totalQuantityOfDessert += quantity;
            }
        }
        return totalQuantityOfDessert;
    }
}

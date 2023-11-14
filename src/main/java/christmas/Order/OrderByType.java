package christmas.Order;

import christmas.Menu;

public class OrderByType {
    public static int quantityOfMain() {
        int totalQuantityOfMain = 0;

        for (String name : Order.getOrder().keySet()) {
            int quantity = Order.getOrder().get(name);
            String type = Menu.valueOf(name).getType();

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
            String type = Menu.valueOf(name).getType();

            if (type.equals("디저트")) {
                totalQuantityOfDessert += quantity;
            }
        }
        return totalQuantityOfDessert;
    }

    public static int quantityOfNotDrink() {
        int totalQuantityOfNotDrink = 0;

        for (String name : Order.getOrder().keySet()) {
            int quantity = Order.getOrder().get(name);
            String type = Menu.valueOf(name).getType();

            if (!type.equals("음료")) {
                totalQuantityOfNotDrink += quantity;
            }
        }
        return totalQuantityOfNotDrink;
    }
}

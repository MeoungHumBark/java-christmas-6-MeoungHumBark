package christmas;

public class TotalAmount {
    private static int totalPrice = 0;

    public TotalAmount() {
        this.totalPrice = 0;
    }

    public static int getTotalPrice() {
        return totalPrice;
    }

    public static void calculateTotalPrice() {
        for (String name : Order.getOrder().keySet()) {
            int quantity = Order.getOrder().get(name);
            int price = Menu.valueOf(name).getPrice();
            totalPrice += (quantity * price);
        }
    }

    public static boolean isBonus() {
        return totalPrice >= 120000;
    }
}

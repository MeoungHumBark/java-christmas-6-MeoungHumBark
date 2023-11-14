package christmas;

import christmas.Order.Order;

public class TotalAmount {

    public static int calculateTotalPrice() {
        int totalPrice = 0;
        for (String name : Order.getOrder().keySet()) {
            int quantity = Order.getOrder().get(name);
            int price = Menu.valueOf(name).getPrice();
            totalPrice += (quantity * price);
        }
        return totalPrice;
    }

    public static int calculateTotalPay() {
        int totalPay = 0;
        totalPay = calculateTotalPrice() + BenefitAmount.calculateTotalBenefit();
        if(TotalAmount.isBonus()) totalPay += Menu.샴페인.getPrice();
        return totalPay;
    }

    public static boolean isBonus() {
        return calculateTotalPrice() >= 120000;
    }

    public static boolean isEvent() {
        return calculateTotalPrice() >= 10000;
    }
}

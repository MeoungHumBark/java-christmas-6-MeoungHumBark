package christmas;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.welcomeMessage();
        int date = InputView.printVisitDateInput();
        String orderInput = InputView.printOrderInput();
        HashMap<String, Integer> order = Order.processOrder(orderInput);
        OutputView.printEventBenefit(date);
        OutputView.printOrderMenu(order);
        int totalPrice = TotalAmount.calculateTotalPrice(order);
        OutputView.printTotalPrice(totalPrice);
        boolean isBonus = TotalAmount.isBonus(totalPrice);
        OutputView.printBonus(isBonus);
    }
}

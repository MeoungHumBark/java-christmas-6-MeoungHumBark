package christmas;

import christmas.Order.Order;
import christmas.View.InputView;
import christmas.View.OutputView;

public class Application {
    public static void main(String[] args) {
        int date = InputView.printVisitDateInput();
        Order order = new Order();
        InputView.printOrderInput(order);
        OutputView.printResult(date,order);
    }
}

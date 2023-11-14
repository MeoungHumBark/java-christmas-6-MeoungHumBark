package christmas;

import christmas.Order.Order;
import christmas.View.InputView;
import christmas.View.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.welcomeMessage();
        int date = InputView.printVisitDateInput();
        Order order = new Order();
        InputView.printOrderInput(order);

        OutputView.printEvent(date);
        OutputView.printOrderMenu(order);

        OutputView.printTotalPrice();
        OutputView.printBonus();

        new BenefitAmount(date);
        OutputView.printBenefit();
        OutputView.printTotalBenefit();
        OutputView.printPayment();
        OutputView.printBadge();
    }
}

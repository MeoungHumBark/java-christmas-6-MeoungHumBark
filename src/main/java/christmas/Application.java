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

        TotalAmount.calculateTotalPrice();
        OutputView.printTotalPrice();
        OutputView.printBonus();

        BenefitAmount benefit = new BenefitAmount();
        benefit.christmasDiscount(date);
        benefit.weekDiscount(date);
        benefit.specialDiscount(date);
        benefit.bonus();
        OutputView.printBenefit(benefit);

        OutputView.printTotalBenefit(benefit);
        int totalBenefit = benefit.calculateTotalBenefits();
        OutputView.printPayment(totalBenefit);
        OutputView.printBadge(totalBenefit);
    }
}

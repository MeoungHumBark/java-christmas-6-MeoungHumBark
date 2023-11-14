package christmas;

import christmas.View.InputView;
import christmas.View.OutputView;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        OutputView.welcomeMessage();
        int date = InputView.printVisitDateInput();
        Order order = new Order();
        InputView.printOrderInput(order);

        OutputView.printEvent(date);
        OutputView.printOrderMenu(order);

        int totalPrice = TotalAmount.calculateTotalPrice();
        OutputView.printTotalPrice(totalPrice);

        boolean isBonus = TotalAmount.isBonus(totalPrice);
        OutputView.printBonus(isBonus);

        int christmasDiscounts = BenefitAmount.christmasDiscount(date);
        int weekDiscounts = BenefitAmount.weekDiscount(date,TotalAmount.quantityOfMain(),TotalAmount.quantityOfDessert());
        int specialDiscounts = BenefitAmount.specialDiscount(date);
        int bonus = BenefitAmount.bonus(isBonus);

        int totalBenefit = BenefitAmount.calculateTotalBenefits(christmasDiscounts,weekDiscounts,specialDiscounts,bonus);
        OutputView.printBenefit(christmasDiscounts,weekDiscounts,specialDiscounts,bonus,totalBenefit);

        OutputView.printTotalBenefit(totalBenefit);
        OutputView.printPayment(totalPrice,totalBenefit,isBonus);
        OutputView.printBadge(totalBenefit);
    }
}

package christmas;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        OutputView.welcomeMessage();
        int date = InputView.printVisitDateInput();
        String orderInput = InputView.printOrderInput();
        HashMap<String, Integer> order = Order.processOrder(orderInput);
        OutputView.printEvent(date);
        OutputView.printOrderMenu(order);
        int totalPrice = TotalAmount.calculateTotalPrice(order);
        OutputView.printTotalPrice(totalPrice);
        boolean isBonus = TotalAmount.isBonus(totalPrice);
        OutputView.printBonus(isBonus);
        int christmasDiscounts = BenefitAmount.christmasDiscount(date);
        int weekDiscounts = BenefitAmount.weekDiscount(date,TotalAmount.quantityOfMain(order),TotalAmount.quantityOfDessert(order));
        int specialDiscounts = BenefitAmount.specialDiscount(date);
        int bonus = BenefitAmount.bonus(isBonus);
        int totalBenefit = BenefitAmount.calculateTotalBenefits(christmasDiscounts,weekDiscounts,specialDiscounts,bonus);
        OutputView.printBenefit(christmasDiscounts,weekDiscounts,specialDiscounts,bonus,totalBenefit);
        OutputView.printTotalBenefit(totalBenefit);
        OutputView.printPayment(totalPrice,totalBenefit,isBonus);
        OutputView.printBadge(totalBenefit);
    }
}

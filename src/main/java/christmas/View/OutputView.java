package christmas.View;

import christmas.BenefitAmount;
import christmas.Order;
import christmas.TotalAmount;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    private static final DecimalFormat decimalFormat = new DecimalFormat("#,###");
    public static void welcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }
    public static void printEvent(int date) {
        System.out.println("12월 "+date+"일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static void printOrderMenu(Order order) {
        System.out.println();
        System.out.println("<주문 메뉴>");
        for (Map.Entry<String, Integer> entry : Order.getOrder().entrySet()) {
            String name = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(name + " " + quantity + "개");
        }
    }

    public static void printTotalPrice() {
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        String totalAmount = decimalFormat.format(TotalAmount.getTotalPrice());
        System.out.println(totalAmount + "원");
    }

    public static void printBonus() {
        System.out.println();
        System.out.println("<증정 메뉴>");
        if(TotalAmount.isBonus()) System.out.println("샴페인 1개");
        if(!TotalAmount.isBonus()) System.out.println("없음");
    }

    public static void printBenefit(BenefitAmount benefit) {
        System.out.println();
        System.out.println("<혜택 내역>");
        if(benefit.calculateTotalBenefits()==0) {
            System.out.println("없음");
        }
        for(String name : benefit.getBenefit().keySet()){
            if(benefit.getBenefit().get(name)!=0) {
                System.out.println(name + decimalFormat.format(benefit.getBenefit().get(name)) + "원");
            }
        }

    }

    public static void printTotalBenefit(BenefitAmount benefit) {
        System.out.println();
        System.out.println("<총혜택 금액>");
        String totalAmount = decimalFormat.format(benefit.calculateTotalBenefits());
        System.out.println(totalAmount + "원");
    }

    public static void printPayment(int totalBenefit) {
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        int totalPay = TotalAmount.getTotalPrice() + totalBenefit;
        if(TotalAmount.isBonus()) totalPay += 25000;
        String totalAmount = decimalFormat.format(totalPay);
        System.out.println(totalAmount + "원");
    }

    public static void printBadge(int totalBenefit) {
        System.out.println();
        System.out.println("<12월 이벤트 배지>");
        System.out.println(BenefitAmount.eventBadge(totalBenefit));
    }
}
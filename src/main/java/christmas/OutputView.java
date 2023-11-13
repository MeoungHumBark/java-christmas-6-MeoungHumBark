package christmas;

import java.text.DecimalFormat;
import java.util.HashMap;

public class OutputView {
    private static final DecimalFormat decimalFormat = new DecimalFormat("#,###");
    public static void welcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }
    public static void printEvent(int date) {
        System.out.println("12월 "+date+"일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static void printOrderMenu(HashMap<String, Integer> order) {
        System.out.println();
        System.out.println("<주문 메뉴>");
        order.forEach((name, quantity) -> System.out.println(name + " " + quantity + "개"));
    }

    public static void printTotalPrice(int total) {
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        String totalAmount = decimalFormat.format(total);
        System.out.println(totalAmount + "원");
    }

    public static void printBonus(boolean isBonus) {
        System.out.println();
        System.out.println("<증정 메뉴>");
        if(isBonus) System.out.println("샴페인 1개");
        if(!isBonus) System.out.println("없음");
    }

    public static void printBenefit(int christmasDiscounts, int weekDiscounts, int specialDiscounts, int bonus) {
        System.out.println();
        System.out.println("<혜택 내역>");
        System.out.println("크리스마스 디데이 할인: " + decimalFormat.format(christmasDiscounts) + "원");
        System.out.println("평일 할인: " + decimalFormat.format(weekDiscounts) + "원");
        System.out.println("특별 할인: " + decimalFormat.format(specialDiscounts) + "원");
        System.out.println("증정 이벤트: " + decimalFormat.format(bonus) + "원");
    }

    public static void printTotalBenefit(int total) {
        System.out.println();
        System.out.println("<총혜택 금액>");
        String totalAmount = decimalFormat.format(total);
        System.out.println(totalAmount + "원");
    }

    public static void printPayment(int totalPrice, int totalBenefit,boolean isBonus) {
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        int totalPay = totalPrice + totalBenefit;
        if(isBonus) totalPay += 25000;
        String totalAmount = decimalFormat.format(totalPay);
        System.out.println(totalAmount + "원");
    }

    public static void printBadge(int totalPrice) {
        System.out.println();
        System.out.println("<12월 이벤트 배지>");
        System.out.println(BenefitAmount.eventBadge(totalPrice));
    }
}
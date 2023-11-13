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

    public static void printBenefit(int date, HashMap<String, Integer> order, boolean isBonus) {
        System.out.println();
        System.out.println("<혜택 내역>");
        System.out.println("크리스마스 디데이 할인: " + decimalFormat.format(BenefitAmount.christmasDiscount(date)) + "원");
        System.out.println("평일 할인: " + decimalFormat.format(BenefitAmount.weekDiscount(date
                                        ,TotalAmount.quantityOfMain(order)
                                        ,TotalAmount.quantityOfDessert(order))) + "원");
        System.out.println("특별 할인: " + decimalFormat.format(BenefitAmount.specialDiscount(date)) + "원");
        System.out.println("증정 이벤트: " + decimalFormat.format(BenefitAmount.bonus(isBonus)) + "원");
    }
}

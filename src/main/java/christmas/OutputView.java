package christmas;

import java.text.DecimalFormat;
import java.util.HashMap;

public class OutputView {
    public static void welcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }
    public static void printEventBenefit(int date) {
        System.out.println("12월 "+date+"일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static void printOrderMenu(HashMap<String, Integer> order) {
        System.out.println();
        System.out.println("<주문 메뉴>");
        order.forEach((name, quantity) -> System.out.println(name + " " + quantity + "개"));
    }

    public static void printTotalPrice(int total) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
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
}

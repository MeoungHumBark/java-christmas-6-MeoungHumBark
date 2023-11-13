package christmas;

import java.util.HashMap;

public class OutputView {
    public static void welcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }
    public static void printEventBenefit(int date) {
        System.out.println("12월 "+date+"일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static void printOrderMenu(HashMap<String, Integer> order) {
        System.out.println("<주문 메뉴>");
        order.forEach((name, quantity) -> System.out.println(name + " " + quantity + "개"));
    }

    public static void printTotalPrice(int total) {
        System.out.println("<할인 전 총주문 금액>");
        //todo
        /*total 가격 string으로 바꾸면서 , 추가
        System.out.println(total + "원");
        */
    }
}

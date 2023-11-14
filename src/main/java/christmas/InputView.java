package christmas;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputView {
    public static int printVisitDateInput() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        int dateInput = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                String input = Console.readLine();
                dateInput = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
        return dateInput;
    }

    public static String printOrderInput() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        boolean validInput = false;
        while (!validInput) {
            try {
                String OrderInput = Console.readLine();
                if (!isOrderFormatValid(OrderInput)) {
                    throw new IllegalArgumentException();
                }
                validInput = true;
                return OrderInput;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
        return "";
    }
    public static boolean isOrderFormatValid(String orderInput) {
        String orderFormatRegex = "^[a-zA-Z가-힣]+-\\d+([,][a-zA-Z가-힣]+-\\d+)*$";
        return Pattern.matches(orderFormatRegex, orderInput);
    }
}

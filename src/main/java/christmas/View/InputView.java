package christmas.View;

import camp.nextstep.edu.missionutils.Console;
import christmas.Order.Order;
import java.util.regex.Pattern;

public class InputView {
    public static int printVisitDateInput() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        int dateInput = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                dateInput = Integer.parseInt(Console.readLine());
                validateDate(dateInput);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
        return dateInput;
    }

    public static void validateDate(int dateInput) {
        if (dateInput < 1 || dateInput > 31) {
            throw new IllegalArgumentException();
        }
    }

    public static void printOrderInput(Order order) {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        boolean validInput = false;
        while (!validInput) {
            try {
                String OrderInput = Console.readLine();
                validateFormat(OrderInput);
                order.processOrder(OrderInput);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }
    public static void validateFormat(String orderInput) {
        String orderFormatRegex = "^[a-zA-Z가-힣]+-[1-9]\\d*(,[a-zA-Z가-힣]+-[1-9]\\d*)*$";
        if (!Pattern.matches(orderFormatRegex, orderInput)) {
            throw new IllegalArgumentException();
        }
    }
}

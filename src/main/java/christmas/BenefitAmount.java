package christmas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BenefitAmount {
    private static final List<Integer> starDate = Arrays.asList(3, 10, 17, 24, 25, 31);
    private static final List<Integer> weekend = Arrays.asList(1,2,8,9,15,16,22,23,29,30);
    private static int weekDiscountAmount = -2023;

    private static int christmasDiscountAmount = -1000;
    private static int specialDiscountAmount = -1000;
    private final HashMap<String, Integer> benefit = new HashMap<>();

    public HashMap<String, Integer> getBenefit() {
        return benefit;
    }
    public void christmasDiscount(int date) {
        if(date >= 1 && date <= 25 && TotalAmount.getTotalPrice()>=10000)  {
            christmasDiscountAmount-=100*(date-1);
            benefit.put("크리스마스 디데이 할인: ",christmasDiscountAmount);
        }
    }

    public void weekDiscount(int date) {
        if(weekend.contains(date) && TotalAmount.getTotalPrice()>=10000) {
            weekDiscountAmount = quantityOfMain()*weekDiscountAmount;
            benefit.put("주말 할인: ",weekDiscountAmount);
        }
        if(!weekend.contains(date) && TotalAmount.getTotalPrice()>=10000){
            weekDiscountAmount = quantityOfDessert()*weekDiscountAmount;
            benefit.put("평일 할인: ",weekDiscountAmount);
        }
    }

    public void specialDiscount(int date) {
        if(starDate.contains(date) && TotalAmount.getTotalPrice()>=10000) {
            benefit.put("특별 할인: ",specialDiscountAmount);
        }
    }

    public void bonus() {
        if(TotalAmount.isBonus() && TotalAmount.getTotalPrice()>=10000) {
            benefit.put("증정 이벤트: ",-Menu.샴페인.getPrice());
        }
    }

    public int calculateTotalBenefits() {
        int totalBenefits = 0;
        for (int value : benefit.values()) {
            totalBenefits += value;
        }
        return totalBenefits;
    }

    public static String eventBadge(int totalBenefits) {
        if (-totalBenefits >= 20000) return "산타";
        if (-totalBenefits >= 10000) return "트리";
        if (-totalBenefits >= 5000) return "별";
        return "없음";
    }

    public static int quantityOfMain() {
        int totalQuantityOfMain = 0;

        for (String name : Order.getOrder().keySet()) {
            int quantity = Order.getOrder().get(name);
            String type = Menu.valueOf(name).getType();

            if (type.equals("메인")) {
                totalQuantityOfMain += quantity;
            }
        }
        return totalQuantityOfMain;
    }

    public static int quantityOfDessert() {
        int totalQuantityOfDessert = 0;

        for (String name : Order.getOrder().keySet()) {
            int quantity = Order.getOrder().get(name);
            String type = Menu.valueOf(name).getType();

            if (type.equals("디저트")) {
                totalQuantityOfDessert += quantity;
            }
        }
        return totalQuantityOfDessert;
    }

    public static int quantityOfNotDrink() {
        int totalQuantityOfNotDrink = 0;

        for (String name : Order.getOrder().keySet()) {
            int quantity = Order.getOrder().get(name);
            String type = Menu.valueOf(name).getType();

            if (!type.equals("음료")) {
                totalQuantityOfNotDrink += quantity;
            }
        }
        return totalQuantityOfNotDrink;
    }
}

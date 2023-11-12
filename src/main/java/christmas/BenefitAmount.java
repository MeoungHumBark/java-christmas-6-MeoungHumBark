package christmas;

import java.util.Arrays;
import java.util.List;

public class BenefitAmount {
    private static final List<Integer> starDate = Arrays.asList(3, 10, 17, 24, 25, 31);
    private static final List<Integer> weekend = Arrays.asList(1,2,8,9,15,16,22,23,29,30);
    private static int weekDiscountAmount = -2023;
    private int discountAmount = -1000;

    public int specialDiscount(int date) {
        if(starDate.contains(date)) return discountAmount;
        return 0;
    }

    public int christmasDiscount(int date) {
        discountAmount-=100*(date-1);
        return discountAmount;
    }

    public int weekDiscount(int date, int numberOfMain, int numberOfDessert) {
        if(weekend.contains(date)) return numberOfMain*weekDiscountAmount;
        return numberOfDessert*weekDiscountAmount;
    }
    public int bonus(int totalAmount) {
        if(totalAmount>=120000) return -25000;
        return 0;
    }
}

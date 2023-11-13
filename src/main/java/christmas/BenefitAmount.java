package christmas;

import java.util.Arrays;
import java.util.List;

public class BenefitAmount {
    private static final List<Integer> starDate = Arrays.asList(3, 10, 17, 24, 25, 31);
    private static final List<Integer> weekend = Arrays.asList(1,2,8,9,15,16,22,23,29,30);
    private static int weekDiscountAmount = -2023;

    private static int christmasDiscountAmount = -1000;
    private static int specialDiscountAmount = -1000;

    public static int specialDiscount(int date) {
        if(starDate.contains(date)) return specialDiscountAmount;
        return 0;
    }

    public static int christmasDiscount(int date) {
        if(date >= 1 && date <= 25)  return christmasDiscountAmount-=100*(date-1);
        return 0;
    }

    public static int weekDiscount(int date, int numberOfMain, int numberOfDessert) {
        if(weekend.contains(date)) return numberOfMain*weekDiscountAmount;
        return numberOfDessert*weekDiscountAmount;
    }
    public static int bonus(int totalAmount) {
        if(totalAmount>=120000) return -25000;
        return 0;
    }

    public static int calculateTotalBenefits(int date, int numberOfMain, int numberOfDessert, int totalAmount) {
        int totalBenefits = 0;
        totalBenefits += specialDiscount(date)
                +christmasDiscount(date)
                +weekDiscount(date, numberOfMain, numberOfDessert)
                +bonus(totalAmount);
        return totalBenefits;
    }
}

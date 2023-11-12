package christmas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BenefitAmount {
    private static final List<Integer> starDate = Arrays.asList(3, 10, 17, 24, 25, 31);
    private static int discountAmount = -1000;

    public int specialDiscount(int date) {
        if(starDate.contains(date)) return discountAmount;
        return 0;
    }

    public int christmasDiscount(int date) {
        discountAmount-=100*(date-1);
        return discountAmount;
    }

    public int weekDiscount() {
        return -1;
    }

    public int bonus() {
        return -1;
    }
}

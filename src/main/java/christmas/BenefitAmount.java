package christmas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BenefitAmount {
    private static final List<Integer> starDate = Arrays.asList(3, 10, 17, 24, 25, 31);
    private static final int SPECIAL_DISCOUNT_AMOUNT = -1000;

    public int specialDiscount(int date) {
        if(starDate.contains(date)) return SPECIAL_DISCOUNT_AMOUNT;
        return 0;
    }

    public int christmasDiscount() {
        return -1;
    }

    public int weekDiscount() {
        return -1;
    }

    public int bonus() {
        return -1;
    }
}

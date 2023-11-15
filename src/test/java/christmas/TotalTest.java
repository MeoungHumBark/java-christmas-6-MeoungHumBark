package christmas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalTest {
    Order order = new Order();

    @Test
    void 총_주문_금액() {
        order.processOrder("초코케이크-2");
        int total = TotalAmount.calculateTotalPrice();
        assertEquals(total,30000);
    }

    @Test
    void 결제할_금액() {
        int date = 1;
        order.processOrder("초코케이크-2");
        BenefitAmount benefit = new BenefitAmount(date);
        benefit.calculateTotalBenefit();
        int totalPay = TotalAmount.calculateTotalPay();
        assertEquals(totalPay,29000);
    }
}

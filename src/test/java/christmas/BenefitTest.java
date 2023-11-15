package christmas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BenefitTest {
    private int date;
    private Order order;
    private BenefitAmount benefit;

    @BeforeEach
    protected final void init() {
        date = 25;
        order = new Order();
        benefit = new BenefitAmount(date);
    }

    @Test
    void 크리스마스_디데이_할인() {
        order.processOrder("초코케이크-1"); //10,000원 이상 구매
        benefit.christmasDiscount(date);
        assertThat(benefit.getBenefit()).containsEntry("크리스마스 디데이 할인: ", -3400);
    }

    @Test
    void 특별_할인() {
        order.processOrder("초코케이크-1"); //10,000원 이상 구매
        benefit.specialDiscount(date);
        assertThat(benefit.getBenefit()).containsEntry("특별 할인: ",-1000);
    }

    @Test
    void 주중_할인() {
        order.processOrder("초코케이크-2"); //10,000원 이상 구매
        benefit.weekDiscount(date);
        assertThat(benefit.getBenefit()).containsEntry("평일 할인: ",-4046);
    }

    @Test
    void 주말_할인() {
        date = 29; //주말(금,토)
        order.processOrder("티본스테이크-2"); //10,000원 이상 구매
        benefit.weekDiscount(date);
        assertThat(benefit.getBenefit()).containsEntry("주말 할인: ",-4046);
    }

    @Test
    void 증정() {
        order.processOrder("티본스테이크-2,초코케이크-1"); //120,000원 이상 구매
        benefit.bonus();
        assertThat(benefit.getBenefit()).containsEntry("증정 이벤트: ",-25000);
    }
}

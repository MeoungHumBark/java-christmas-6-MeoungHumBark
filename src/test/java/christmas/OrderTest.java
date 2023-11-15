package christmas;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderTest {
    Order order = new Order();

    @Test
    void 메뉴판에_없는_메뉴() {
        assertThatThrownBy(() -> order.processOrder("라면-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복_메뉴() {
        assertThatThrownBy(() -> order.processOrder("타파스-1,타파스-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 주문_수량_초과() {
        assertThatThrownBy(() -> order.processOrder("타파스-20,제로콜라-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음료만_주문() {
        assertThatThrownBy(() -> order.processOrder("제로콜라-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

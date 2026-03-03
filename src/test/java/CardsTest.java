import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.Cards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardsTest {

    @Test
    @DisplayName("카드 합계를 계산한다: 10,K -> 20")
    void calculateSum_case1() {
        int sum = Cards.from("10,K").calculateSum();
        assertThat(sum).isEqualTo(20);
    }

    @Test
    @DisplayName("카드 합계를 계산한다: A,9 -> 20")
    void calculateSum_case2() {
        int sum = Cards.from("A,9").calculateSum();
        assertThat(sum).isEqualTo(20);
    }

    @Test
    @DisplayName("카드 합계를 계산한다: 2,3,4 -> 9")
    void calculateSum_case3() {
        int sum = Cards.from("2,3,4").calculateSum();
        assertThat(sum).isEqualTo(9);
    }

    @Test
    @DisplayName("예외 케이스: 잘못된 카드 문자는 예외가 발생한다 (Z)")
    void invalidCardSymbol_throwsException() {
        assertThatThrownBy(() -> Cards.from("10,Z").calculateSum())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("예외 케이스: 존재하지 않는 숫자 카드 값(1)은 예외가 발생해야 한다")
    void invalidCard_one_shouldThrowException() {
        assertThatThrownBy(() -> Cards.from("1,8,9"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("예외 케이스: Ace는 합계가 21을 초과하면 1로 계산되어야 한다")
    void ace_shouldBeCalculatedAsOneWhenBust() {
        int sum = Cards.from("A,K,9").calculateSum();
        assertThat(sum).isEqualTo(20);
    }
}

package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    void Suits와_Rank로_Card를_생성할_수_있다() {
        Card card = Card.of(Suits.HEART, Rank.ACE);
        assertThat(card).isNotNull();
    }

    @Test
    void Suits이_null이면_Card를_생성시_오류가_발생한다() {
        assertThatThrownBy(() -> {
            Card.of(null, Rank.ACE);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Rank이_null이면_Card를_생성시_오류가_발생한다() {
        assertThatThrownBy(() -> {
            Card.of(Suits.HEART, null);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
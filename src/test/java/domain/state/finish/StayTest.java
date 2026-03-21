package domain.state.finish;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import domain.Rank;
import domain.Suits;
import domain.card.Card;
import domain.card.Hand;
import domain.state.Stay;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StayTest {
    Hand hand;

    @BeforeEach
    void setUp() {
        hand = Hand.of(List.of(Card.of(Suits.HEART, Rank.ACE), Card.of(Suits.SPADE, Rank.JACK)));
    }


    @Test
    void 스테이일때_draw하면_에러가_발생한다() {
        Stay stay = new Stay(hand);
        assertThatThrownBy(() -> stay.draw(Card.of(Suits.HEART, Rank.NINE)))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 스테이일때_stay하면_에러가_발생한다() {
        Stay stay = new Stay(hand);
        assertThatThrownBy(() -> stay.stay())
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 스테이일때_isFinished하면_참이_반환된다() {
        Stay stay = new Stay(hand);
        assertThat(stay.isFinished()).isTrue();
    }
}
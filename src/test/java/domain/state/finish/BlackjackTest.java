package domain.state.finish;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import domain.Rank;
import domain.Suits;
import domain.card.Card;
import domain.card.Hand;
import domain.state.Blackjack;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BlackjackTest {

    Hand hand;

    @BeforeEach
    void setUp() {
        hand = Hand.of(List.of(Card.of(Suits.HEART, Rank.ACE), Card.of(Suits.SPADE, Rank.JACK)));
    }


    @Test
    void 블랙잭일때_draw하면_에러가_발생한다() {
        Blackjack blackjack = new Blackjack(hand);
        assertThatThrownBy(() -> blackjack.draw(Card.of(Suits.HEART, Rank.NINE)))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 블랙잭일때_stay하면_에러가_발생한다() {
        Blackjack blackjack = new Blackjack(hand);
        assertThatThrownBy(() -> blackjack.stay())
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 블랙잭일때_isFinished하면_참이_반환된다() {
        Blackjack blackjack = new Blackjack(hand);
        assertThat(blackjack.isFinished()).isTrue();
    }

}
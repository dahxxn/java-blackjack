package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.card.Card;
import domain.card.Hand;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DealerTest {
    Hand hand;

    @BeforeEach
    void setup() {
        hand = Hand.of(List.of(Card.of(Suits.CLOVER, Rank.ACE), Card.of(Suits.HEART, Rank.NINE)));
    }


    @Test
    void Dealer_생성_시점에_두장을_받아서_상태를_결정하고_생성한다() {
        Dealer dealer = Dealer.create(hand);
        assertThat(dealer).isNotNull();
    }

    @Test
    void Dealer_생성_시점에_두장_합이_21이면_Blackjack_상태로_생성된다() {
        Hand hand = Hand.of(List.of(Card.of(Suits.HEART, Rank.ACE), Card.of(Suits.SPADE, Rank.JACK)));
        Dealer dealer = Dealer.create(hand);
        assertThat(dealer.isFinished()).isTrue();
    }

    @Test
    void Dealer_생성_시점에_두장_합이_21이_아니면_Hit_상태로_생성된다() {
        Dealer dealer = Dealer.create(hand);
        assertThat(dealer.isFinished()).isFalse();
    }

    @Test
    void 딜러는_16이하이면_shouldHit이_true다() {
        hand = Hand.of(List.of(Card.of(Suits.HEART, Rank.TWO), Card.of(Suits.SPADE, Rank.JACK)));
        Dealer dealer = Dealer.create(hand);
        assertThat(dealer.shouldHit()).isTrue();
    }

    @Test
    void 딜러는_17이상이면_shouldHit이_false다() {
        Dealer dealer = Dealer.create(hand);
        assertThat(dealer.shouldHit()).isFalse();
    }

    @Test
    void 딜러가_stay하면_종료된다() {
        Dealer dealer = Dealer.create(hand);
        dealer.stay();
        assertThat(dealer.isFinished()).isTrue();
    }
}
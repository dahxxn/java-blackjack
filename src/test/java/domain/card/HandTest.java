package domain.card;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import domain.Rank;
import domain.Suits;
import java.util.List;
import org.junit.jupiter.api.Test;

class HandTest {

    @Test
    void Card_리스트로_Hand를_생성할_수_있다() {
        Hand hand = Hand.of(List.of(Card.of(Suits.HEART, Rank.ACE), Card.of(Suits.DIAMOND, Rank.TWO)));
        assertThat(hand).isNotNull();
    }

    @Test
    void Card_리스트_null이면_Hand_생성시_오류가_발생한다() {
        assertThatThrownBy(() -> {
            Hand.of(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Card들의_누적합을_구할_수_있다() {
        Hand hand = Hand.of(List.of(Card.of(Suits.HEART, Rank.ACE), Card.of(Suits.DIAMOND, Rank.TWO)));

        int expected = 13;
        assertThat(hand.calculateScore()).isEqualTo(expected);
    }

    @Test
    void Card를_받을때_누적합이_버스트기준을_넘고_ACE를_갖고있다면_ACE를_1로_자동_계산한다() {
        Hand hand = Hand.of(List.of(Card.of(Suits.HEART, Rank.ACE), Card.of(Suits.DIAMOND, Rank.TWO)));
        hand.receive(Card.of(Suits.CLOVER, Rank.NINE));
        assertThat(hand.calculateScore()).isEqualTo(12);
    }

    @Test
    void Card를_받을때_ACE가_여러장이면서_버스트기준을_넘는다면_21이하가_되는순간_ACE_점수_전환을_멈춘다() {
        Hand hand = Hand.of(List.of(Card.of(Suits.HEART, Rank.ACE), Card.of(Suits.DIAMOND, Rank.NINE)));
        hand.receive(Card.of(Suits.CLOVER, Rank.ACE));
        assertThat(hand.calculateScore()).isEqualTo(21);
    }

    @Test
    void 현재상태가_블랙잭이면_isBlackjack이_true이다() {
        Hand hand = Hand.of(List.of(Card.of(Suits.HEART, Rank.ACE), Card.of(Suits.DIAMOND, Rank.JACK)));
        assertThat(hand.isBlackjack()).isTrue();
    }

    @Test
    void 현재상태가_블랙잭이_아니면_isBlackjack이_false이다() {
        Hand hand = Hand.of(List.of(Card.of(Suits.HEART, Rank.ACE), Card.of(Suits.DIAMOND, Rank.TWO)));
        assertThat(hand.isBlackjack()).isFalse();
    }


}
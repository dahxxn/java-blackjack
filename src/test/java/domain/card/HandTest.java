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


}
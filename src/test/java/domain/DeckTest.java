package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    void Card_목록으로_생성할_수_있다() {
        Deck deck = Deck.of(List.of(Card.of(Suits.HEART, Rank.ACE)));
        assertThat(deck).isNotNull();
    }

    @Test
    void Card_목록이_null이면_Deck_생성시_오류가_발생한다() {
        assertThatThrownBy(() -> {
            Deck.of(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Card_목록에_중복이_존재하면_Deck_생성시_오류가_발생한다() {
        assertThatThrownBy(() -> {
            Deck.of(List.of(Card.of(Suits.HEART, Rank.ACE), Card.of(Suits.HEART, Rank.ACE)));
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
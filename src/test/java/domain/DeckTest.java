package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    void Deck생성_시_자동으로_카드뭉치를_생성후_섞는다() {
        Deck deck = Deck.create(new RandomShuffleStrategy());
        assertThat(deck).isNotNull();
    }

    @Test
    void Deck에서_카드를_한장_뽑는다() {
        Deck deck = Deck.create(new RandomShuffleStrategy());
        assertThat(deck.draw()).isNotNull();
    }

}
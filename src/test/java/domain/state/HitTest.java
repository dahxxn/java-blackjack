package domain.state;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.Rank;
import domain.Suits;
import domain.card.Card;
import domain.card.Hand;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HitTest {
    Hand hand;

    @BeforeEach
    void setUp() {
        hand = Hand.of(List.of(Card.of(Suits.HEART, Rank.JACK), Card.of(Suits.SPADE, Rank.TWO)));
    }


    @Test
    void draw할때_블랙잭_기준을_넘으면_Bust다() {
        Hit hit = new Hit(hand);
        State state = hit.draw(Card.of(Suits.HEART, Rank.QUEEN));
        assertThat(state).isInstanceOf(Bust.class);
    }

    @Test
    void draw할때_블랙잭_기준과_같아지면_자동_Stay다() {
        Hit hit = new Hit(hand);
        State state = hit.draw(Card.of(Suits.HEART, Rank.NINE));
        assertThat(state).isInstanceOf(Stay.class);
    }

    @Test
    void draw할떄_블랙잭_기준보다_작으면_Hit다() {
        Hit hit = new Hit(hand);
        State state = hit.draw(Card.of(Suits.HEART, Rank.SIX));
        assertThat(state).isInstanceOf(Hit.class);
    }

}
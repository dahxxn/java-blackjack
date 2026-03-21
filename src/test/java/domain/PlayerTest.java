package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.card.Card;
import domain.card.Hand;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
    Hand hand;
    Name name;

    @BeforeEach
    void setup() {
        hand = Hand.of(List.of(Card.of(Suits.CLOVER, Rank.ACE), Card.of(Suits.HEART, Rank.NINE)));
        name = Name.of("handa");
    }

    @Test
    void Player_생성_시점에_두장을_받아서_상태를_결정하고_생성한다() {
        Player player = Player.create(name, hand);
        assertThat(player).isNotNull();
    }

    @Test
    void 두장_합이_21이면_Blackjack_상태로_생성된다() {
        Hand hand = Hand.of(List.of(Card.of(Suits.HEART, Rank.ACE), Card.of(Suits.SPADE, Rank.JACK)));
        Player player = Player.create(name, hand);
        assertThat(player.isFinished()).isTrue();
    }

    @Test
    void 두장_합이_21이_아니면_Hit_상태로_생성된다() {
        Player player = Player.create(name, hand);
        assertThat(player.isFinished()).isFalse();
    }

    @Test
    void 플레이어턴일때_Hit상태에서_draw로_카드를_받고_Bust상태가_될_수_있다() {
        hand = Hand.of(List.of(Card.of(Suits.SPADE, Rank.JACK), Card.of(Suits.DIAMOND, Rank.EIGHT)));
        Player player = Player.create(name, hand);
        player.draw(Card.of(Suits.SPADE, Rank.SIX));
        assertThat(player.isFinished()).isTrue();
    }

    @Test
    void 플레이어턴일떄_Hit상태에서_stay할_수_있다() {
        Player player = Player.create(name, hand);
        player.stay();
        assertThat(player.isFinished()).isTrue();
    }

    @Test
    void 플레이어의_이름_정보를_가져올_수_있다() {
        Player player = Player.create(name, hand);
        assertThat(player.name()).isEqualTo("handa");
    }


}
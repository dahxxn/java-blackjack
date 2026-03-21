package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.card.Card;
import domain.card.Hand;
import domain.state.Blackjack;
import domain.state.Bust;
import domain.state.Stay;
import java.util.List;
import org.junit.jupiter.api.Test;

class EarningRateTest {
    @Test
    void 플레이어_블랙잭_딜러_블랙잭이면_무승부다() {
        Blackjack player = new Blackjack(
                Hand.of(List.of(Card.of(Suits.HEART, Rank.ACE), Card.of(Suits.SPADE, Rank.JACK))));
        Blackjack dealer = new Blackjack(
                Hand.of(List.of(Card.of(Suits.CLOVER, Rank.ACE), Card.of(Suits.DIAMOND, Rank.JACK))));
        assertThat(player.earningRate(dealer)).isEqualTo(EarningRate.DRAW);
    }

    @Test
    void 플레이어_블랙잭_딜러_블랙잭아니면_블랙잭승리다() {
        Blackjack player = new Blackjack(
                Hand.of(List.of(Card.of(Suits.HEART, Rank.ACE), Card.of(Suits.SPADE, Rank.JACK))));
        Stay dealer = new Stay(Hand.of(List.of(Card.of(Suits.CLOVER, Rank.TEN), Card.of(Suits.DIAMOND, Rank.NINE))));
        assertThat(player.earningRate(dealer)).isEqualTo(EarningRate.BLACKJACK);
    }

    @Test
    void 플레이어_버스트면_무조건_패다() {
        Bust player = new Bust(Hand.of(List.of(Card.of(Suits.HEART, Rank.TEN), Card.of(Suits.SPADE, Rank.TEN))));
        Stay dealer = new Stay(Hand.of(List.of(Card.of(Suits.CLOVER, Rank.TEN), Card.of(Suits.DIAMOND, Rank.NINE))));
        assertThat(player.earningRate(dealer)).isEqualTo(EarningRate.LOSE);
    }

    @Test
    void 플레이어_스테이_딜러_블랙잭이면_패다() {
        Stay player = new Stay(Hand.of(List.of(Card.of(Suits.HEART, Rank.TEN), Card.of(Suits.SPADE, Rank.NINE))));
        Blackjack dealer = new Blackjack(
                Hand.of(List.of(Card.of(Suits.CLOVER, Rank.ACE), Card.of(Suits.DIAMOND, Rank.JACK))));
        assertThat(player.earningRate(dealer)).isEqualTo(EarningRate.LOSE);
    }

    @Test
    void 플레이어_스테이_딜러_버스트면_승리다() {
        Stay player = new Stay(Hand.of(List.of(Card.of(Suits.HEART, Rank.TEN), Card.of(Suits.SPADE, Rank.NINE))));
        Bust dealer = new Bust(Hand.of(List.of(Card.of(Suits.CLOVER, Rank.TEN), Card.of(Suits.DIAMOND, Rank.NINE))));
        assertThat(player.earningRate(dealer)).isEqualTo(EarningRate.WIN);
    }

    @Test
    void 플레이어_스테이_딜러_스테이_점수높으면_승리다() {
        Stay player = new Stay(Hand.of(List.of(Card.of(Suits.HEART, Rank.TEN), Card.of(Suits.SPADE, Rank.NINE))));
        Stay dealer = new Stay(Hand.of(List.of(Card.of(Suits.CLOVER, Rank.TEN), Card.of(Suits.DIAMOND, Rank.EIGHT))));
        assertThat(player.earningRate(dealer)).isEqualTo(EarningRate.WIN);
    }

    @Test
    void 플레이어_스테이_딜러_스테이_점수같으면_무승부다() {
        Stay player = new Stay(Hand.of(List.of(Card.of(Suits.HEART, Rank.TEN), Card.of(Suits.SPADE, Rank.NINE))));
        Stay dealer = new Stay(Hand.of(List.of(Card.of(Suits.CLOVER, Rank.TEN), Card.of(Suits.DIAMOND, Rank.NINE))));
        assertThat(player.earningRate(dealer)).isEqualTo(EarningRate.DRAW);
    }

    @Test
    void 플레이어_스테이_딜러_스테이_점수낮으면_패다() {
        Stay player = new Stay(Hand.of(List.of(Card.of(Suits.HEART, Rank.TEN), Card.of(Suits.SPADE, Rank.EIGHT))));
        Stay dealer = new Stay(Hand.of(List.of(Card.of(Suits.CLOVER, Rank.TEN), Card.of(Suits.DIAMOND, Rank.NINE))));
        assertThat(player.earningRate(dealer)).isEqualTo(EarningRate.LOSE);
    }
}
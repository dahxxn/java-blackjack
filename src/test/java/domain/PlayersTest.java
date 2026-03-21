package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.card.Deck;
import java.util.List;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    void Players가_이름목록과_Deck으로_정상_생성된다() {
        Players players = Players.create(List.of("handa", "pobi"), Deck.create(new RandomShuffleStrategy()));
        assertThat(players).isNotNull();
    }
}
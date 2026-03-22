package domain.card;

import domain.Rank;
import domain.Suits;
import java.util.Objects;

public class Card {
    private final Rank rank;
    private final Suits suits;


    private Card(final Rank rank, final Suits suits) {
        validate(rank, suits);
        this.rank = rank;
        this.suits = suits;
    }

    public static Card of(Suits suits, Rank rank) {
        return new Card(rank, suits);
    }

    private void validate(Rank rank, Suits suits) {
        validateRank(rank);
        validateSuits(suits);
    }

    private void validateRank(Rank rank) {
        validateNotNull(rank);
    }

    private void validateSuits(Suits suits) {
        validateNotNull(suits);
    }

    private void validateNotNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("null이 올 수 없습니다");
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suits);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        return Objects.equals(this.hashCode(), obj.hashCode());
    }

    public int rankScore() {
        return rank.getScore();
    }


    public boolean isAce() {
        if (rank == Rank.ACE) {
            return true;
        }
        return false;
    }

    public String rankName() {
        return rank.name();
    }

    public String suitName() {
        return suits.name();
    }
}

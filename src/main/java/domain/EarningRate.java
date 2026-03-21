package domain;

public enum EarningRate {
    WIN(1.0),
    BLACKJACK(1.5),
    LOSE(-1.0),
    DRAW(0.0);

    private final double rate;

    EarningRate(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}

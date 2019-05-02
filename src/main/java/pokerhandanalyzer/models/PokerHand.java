package pokerhandanalyzer.models;

import java.util.List;

public class PokerHand implements Hand {
    private List<Card> cards;

    public PokerHand(List<Card> cards) {
        if (cards.size() != 5)
            throw new IllegalArgumentException("a poker hand must hold exactly five cards");

        this.cards = cards;
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }

    @Override
    public void setCards(List<Card> cards) {
        if (cards.size() != 5)
            throw new IllegalArgumentException("a poker hand must hold exactly five cards");

        this.cards = cards;
    }
}

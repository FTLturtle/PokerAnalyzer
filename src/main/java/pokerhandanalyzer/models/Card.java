package pokerhandanalyzer.models;

import pokerhandanalyzer.enums.Rank;
import pokerhandanalyzer.enums.Suit;

public class Card implements Comparable<Card>{
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public int compareTo(Card otherCard) {
        return this.rank.compareTo(otherCard.getRank());
    }
}

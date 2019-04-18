package objectorientedanalyzer.models;

import objectorientedanalyzer.enums.Rank;
import objectorientedanalyzer.enums.Suit;

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
        return this.rank.getRankValue() - otherCard.getRank().getRankValue();
    }
}

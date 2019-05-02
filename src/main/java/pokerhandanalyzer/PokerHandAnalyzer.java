package pokerhandanalyzer;

import pokerhandanalyzer.enums.PokerHandType;
import pokerhandanalyzer.enums.Rank;
import pokerhandanalyzer.enums.Suit;
import pokerhandanalyzer.models.Card;
import pokerhandanalyzer.models.PokerHand;

import java.util.*;

public class PokerHandAnalyzer {
    private List<Card> cards;
    private Map<Rank, Integer> handRankHistogram;
    private PokerHandType pokerHandType;

    public PokerHandAnalyzer(PokerHand pokerHand) {
        cards = pokerHand.getCards();
        handRankHistogram = new HashMap<>();
        for (Card card : cards) {
            handRankHistogram.put(card.getRank(), handRankHistogram.getOrDefault(card.getRank(), 0) + 1);
        }
    }

    public PokerHandType getPokerHandType() {
        if (pokerHandType == null)
            pokerHandType = evaluatePokerHandType();

        return pokerHandType;
    }

    private PokerHandType evaluatePokerHandType() {
        boolean isFlush = isFlush();
        boolean isStraight = isStraight();
        List<Integer> handRankHistogramValueList = getHandRankHistogramValueList();
        return evaluateHandType(handRankHistogramValueList, isFlush, isStraight);
    }

    // determines if hand is a flush
    private boolean isFlush() {
        Suit lastSuit;
        for (int i = 1; i < 5; i++) {
            lastSuit = cards.get(i - 1).getSuit();
            if (! cards.get(i).getSuit().equals(lastSuit)) {
                return false;
            }
        }
        return true;
    }

    // determines if hand is a straight
    private boolean isStraight() {
        if (handRankHistogram.size() != 5) { // if there are any cards that are match each other, then the hand cannot be a straight
            return false;
        } else {
            Collections.sort(cards);
            // if there are 5 cards in order, and the last card's rank is 4 less than the first card, then the hand is a straight
            return (cards.get(4).getRank().getOrdinal() - cards.get(0).getRank().getOrdinal() == 4);
        }
    }

    // gets a list of the values in the handRankHistogram
    private List<Integer> getHandRankHistogramValueList() {
        List<Integer> handRankHistogramValueList = new ArrayList<>();
        for (Rank key : handRankHistogram.keySet()) {
            handRankHistogramValueList.add(handRankHistogram.get(key));
        }
        return handRankHistogramValueList;
    }

    // Uses the flush status, straight status, and the list of the values in the hand rank histogram to evaluate the
    // hand type.
    private PokerHandType evaluateHandType(List<Integer> handRankHistogramValueList, boolean isFlush, boolean isStraight) {
        handRankHistogramValueList.sort(Collections.reverseOrder()); // orders the list from largest to smallest
        int numberOfDifferentCardRanks = handRankHistogramValueList.size(); // number of different types of cards in the hand

        PokerHandType pokerHandType;
        if (isFlush && isStraight) {
            pokerHandType = PokerHandType.STRAIGHT_FLUSH;
        } else if (numberOfDifferentCardRanks == 2 && handRankHistogramValueList.get(0) == 4) {
            pokerHandType = PokerHandType.FOUR_OF_A_KIND;
        } else if (numberOfDifferentCardRanks == 2 && handRankHistogramValueList.get(0) == 3) {
            pokerHandType = PokerHandType.FULL_HOUSE;
        } else if (isFlush) {
            pokerHandType = PokerHandType.FLUSH;
        } else if (isStraight) {
            pokerHandType = PokerHandType.STRAIGHT;
        } else if (numberOfDifferentCardRanks == 3 && handRankHistogramValueList.get(0) == 3) {
            pokerHandType = PokerHandType.THREE_OF_A_KIND;
        } else if (numberOfDifferentCardRanks == 3 && handRankHistogramValueList.get(0) == 2) {
            pokerHandType = PokerHandType.TWO_PAIR;
        } else if (numberOfDifferentCardRanks == 4 && handRankHistogramValueList.get(0) == 2) {
            pokerHandType = PokerHandType.PAIR;
        } else {
            pokerHandType = PokerHandType.HIGH_CARD;
        }

        return pokerHandType;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Map<Rank, Integer> getHandRankHistogram() {
        return handRankHistogram;
    }
}

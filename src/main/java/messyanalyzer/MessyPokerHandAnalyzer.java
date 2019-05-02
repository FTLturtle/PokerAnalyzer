package messyanalyzer;

import java.util.*;
import java.util.stream.Collectors;

public class MessyPokerHandAnalyzer {
    /**
     * This method takes a string representation of two five-card poker hands, e.g., "AH TD 5C 9S JS 3D 7H 5S JC 5H".
     * The left five represent the left hand, and the right five represent the right hand. The method then returns
     * 'left', 'right', or 'neither' depending on which hand won.
     *
     * @param hands a string representation of two five-card poker hands, e.g., "AH TD 5C 9S JS 3D 7H 5S JC 5H". The
     *              left five units represent the left hand, and the right five units represent the right hand.
     * @return 'left', 'right', or 'neither' depending on which hand won.
     */
    public static String analyzeHands(String hands) {
        // Split the string into individual card representations
        String[] twoHandArray = hands.split(" ");

        // Create the left hand
        PokerHand leftPokerHand = getHandFromTwoHandArray(twoHandArray, 0);

        // Create the right hand
        PokerHand rightPokerHand = getHandFromTwoHandArray(twoHandArray, 5);

        // Return who won
        return getWhoWon(leftPokerHand, rightPokerHand);
    }

    // extracts a single hand from the two hand array
    private static PokerHand getHandFromTwoHandArray(String[] twoHandArray, int offset) {
        Card[] cards = new Card[5];
        for (int i = offset; i < offset + 5; i++) {
            cards[i - offset] = new Card(twoHandArray[i]);
        }
        return new PokerHand(cards);
    }

    // determines who won based on the compareHandResult
    private static String getWhoWon(PokerHand leftPokerHand, PokerHand rightPokerHand) {
        int compareHandResult = getCompareHandResult(leftPokerHand, rightPokerHand);

        String whoWon;
        if (compareHandResult == 0) {
            whoWon = "neither";
        } else if (compareHandResult > 0) {
            whoWon = "left";
        } else {
            whoWon = "right";
        }
        return whoWon;
    }

    // uses a handComparator to get hand result
    private static int getCompareHandResult(PokerHand leftPokerHand, PokerHand rightPokerHand) {
        PokerHandComparator pokerHandComparator = new PokerHandComparator();
        return pokerHandComparator.compare(leftPokerHand, rightPokerHand);
    }
}


// class for representing poker hands
class PokerHand {
    private List<Card> cards; // list of all the cards
    private Map<Integer, Integer> handRankHistogram; // histogram of the ranks
    private int handTypeValue; // the value of the hand type: high card is 0, pair is 1, two pair is 2, three of a kind is 3,
    // straight is 4, flush is 5, full house is 6, four of a kind is 7, straight flush is 8 (royal flush is just a
    // special case of a straight flush). An enum would be appropriate here.

    /**
     * Constructor for creating a poker hand. creates a list of cards, creates a histogram for storing the number of
     * times each rank appears in the hand, and evaluates the hand type value, saving all three in instance fields.
     * @param cards an array of cards, must have a length of 5.
     */
    public PokerHand(Card[] cards) {
        this.cards = new ArrayList<>(Arrays.asList(cards));
        handRankHistogram = new HashMap<>();
        for (Card card : cards) {
            handRankHistogram.put(card.getRank(), handRankHistogram.getOrDefault(card.getRank(), 0) + 1);
        }
        handTypeValue = evaluateHandTypeValue();
    }

    // This method will determine the value of the hand by its hand type
    // high card is 0, pair is 1, two pair is 2, three of a kind is 3,
    // straight is 4, flush is 5, full house is 6, four of a kind is 7, straight flush is 8
    private int evaluateHandTypeValue() {
        boolean isFlush = isFlush(); // determine if hand is a flush

        boolean isStraight = isStraight(); // determine if hand is a straight

        List<Integer> handRankHistogramValueList = getHandRankHistogramValueList(); // get the list of values from the handRankHistogram

        return evaluateHandType(handRankHistogramValueList, isFlush, isStraight); // use those 3 pieces of data to evaluate the hand type
    }

    // determines if hand is a flush
    private boolean isFlush() {
        char lastSuit;
        for (int i = 1; i < 5; i++) {
            lastSuit = cards.get(i - 1).getSuit();
            if (cards.get(i).getSuit() != lastSuit) {
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
            return (cards.get(4).getRank() - cards.get(0).getRank() == 4);
        }
    }

    // gets a list of the values in the handRankHistogram
    private List<Integer> getHandRankHistogramValueList() {
        List<Integer> handRankHistogramValueList = new ArrayList<>();
        for (Integer key : handRankHistogram.keySet()) {
            handRankHistogramValueList.add(handRankHistogram.get(key));
        }
        return handRankHistogramValueList;
    }

    // Uses the flush status, straight status, and the list of the values in the hand rank histogram to evaluate the
    // value of the hand type. High card is 0, pair is 1, two pair is 2, three of a kind is 3, straight is 4, flush is 5,
    // full house is 6, four of a kind is 7, straight flush is 8
    private int evaluateHandType(List<Integer> handRankHistogramValueList, boolean isFlush, boolean isStraight) {
        handRankHistogramValueList.sort(Collections.reverseOrder()); // orders the list from largest to smallest
        int numberOfDifferentCardRanks = handRankHistogramValueList.size(); // number of different types of cards in the hand

        int handValue;
        if (isFlush && isStraight) { // straight flush
            handValue = 8;
        } else if (numberOfDifferentCardRanks == 2 && handRankHistogramValueList.get(0) == 4) { // four of a kind
            handValue = 7;
        } else if (numberOfDifferentCardRanks == 2 && handRankHistogramValueList.get(0) == 3) { // full house
            handValue = 6;
        } else if (isFlush) { // flush
            handValue = 5;
        } else if (isStraight) { // straight
            handValue = 4;
        } else if (numberOfDifferentCardRanks == 3 && handRankHistogramValueList.get(0) == 3) { // three of a kind
            handValue = 3;
        } else if (numberOfDifferentCardRanks == 3 && handRankHistogramValueList.get(0) == 2) { // two pair
            handValue = 2;
        } else if (numberOfDifferentCardRanks == 4 && handRankHistogramValueList.get(0) == 2) { // pair
            handValue = 1;
        } else { // high card
            handValue = 0;
        }

        return handValue;
    }

    /**
     * @return the list of card objects the hand contains. The order of the cards is not guaranteed.
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * @return a map representation of a histogram of the ranks of the hand. A hand with three 7s, an 8, and an Ace
     * would be stored in a map like this: {7:3, 8:1, 14:1}. The order of entries is not guaranteed.
     */
    public Map<Integer, Integer> getHandRankHistogram() {
        return handRankHistogram;
    }

    /**
     * @return an integer representing the value of the hand type (high card is 0, pair is 1, two pair is 2,
     * three of a kind is 3, straight is 4, flush is 5, full house is 6, four of a kind is 7, straight flush is 8)
     */
    public int getHandTypeValue() {
        return handTypeValue;
    }
}

// class for representing cards
class Card implements Comparable<Card> {
    private Integer rank; // an enum would be appropriate here
    private Character suit; // an enum would be appropriate here

    /**
     * Constructor that sets the rank and suit of the card based on a two character input string, e.g., "AH" would
     * result in a card with rank: 14, and suit: H
     * @param cardRepresentation a two-character string representation of a card (e.g., AH, TC, and 3S would represent
     *                           Ace of Hearts, Ten of Clubs, and Three of Spades respectively)
     */
    public Card(String cardRepresentation) {
        rank = getRankIntFromRankChar(cardRepresentation.charAt(0));
        suit = cardRepresentation.charAt(1);
    }

    // converting the rank character ("A", "K",... , "3", "2") into an integer (14, 13,... , 3, 2) for ease of comparison
    private int getRankIntFromRankChar(char rankChar) {
        int rankInt;
        if (rankChar == 'A') {
            rankInt = 14;
        } else if (rankChar == 'K') {
            rankInt = 13;
        } else if (rankChar == 'Q') {
            rankInt = 12;
        } else if (rankChar == 'J') {
            rankInt = 11;
        } else if (rankChar == 'T') {
            rankInt = 10;
        } else {
            rankInt = Integer.parseInt("" + rankChar);
        }
        return rankInt;
    }

    /**
     * @return the rank of the card, represented as a number
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * @return the suit of the card, represented as a single character
     */
    public Character getSuit() {
        return suit;
    }

    /**
     * method for comparing other cards against this card. returns a positive value if this card has a higher rank and
     * a negative value if otherCard has a higher rank
     * @param otherCard card to be compared to this card
     * @return a positive value if this card has a higher rank and a negative value if otherCard has a higher rank
     */
    @Override
    public int compareTo(Card otherCard) {
        return this.getRank() - otherCard.getRank();
    }
}

// class for comparing hands
class PokerHandComparator implements Comparator<PokerHand> {

    /**
     * method for comparing two poker hands. First compares by hand type value, then breaks ties by comparing the rank
     * of individual cards in the hand, first comparing the rank with the greatest frequency (e.g., compare the three of
     * a kind in a full house prior to comparing the pair in a full house). If two ranks have the same frequency (e.g.,
     * comparing the pairs of a two pair, or comparing the kickers which all have frequency 1), then the higher rank is
     * compared first. Returns a positive value if the first hand has a higher value, and returns a negative value if
     * the second hand has a higher value.
     * @param pokerHand1 first poker hand to be compared
     * @param pokerHand2 second poker hand to be compared
     * @return a positive value if pokerHand1 has a higher value, and a negative value if pokerHand2 has a higher value
     */
    @Override
    public int compare(PokerHand pokerHand1, PokerHand pokerHand2) {
        int result = pokerHand1.getHandTypeValue() - pokerHand2.getHandTypeValue();

        // if the hand types are the same, then compare by value of individual cards
        if (result == 0) {
            result = compareHandsOfSameType(pokerHand1, pokerHand2);
        }

        return result;
    }

    // method for comparing hands of the same type
    private int compareHandsOfSameType(PokerHand pokerHand1, PokerHand pokerHand2) {
        // I use a linked hash map, because it can be sorted by both key and value, and its order is guaranteed.
        LinkedHashMap<Integer, Integer> sortedHandRankHistogram1 = getSortedMapByValDescBreakTieByKeyDesc(pokerHand1.getHandRankHistogram());
        LinkedHashMap<Integer, Integer> sortedHandRankHistogram2 = getSortedMapByValDescBreakTieByKeyDesc(pokerHand2.getHandRankHistogram());

        List<Integer> keyList1 = new ArrayList<>(sortedHandRankHistogram1.keySet());
        List<Integer> keyList2 = new ArrayList<>(sortedHandRankHistogram2.keySet());

        int result = 0;
        for (int i = 0; i < keyList1.size(); i++) {
            if (keyList1.get(i) > keyList2.get(i)) {
                result = 1;
                break;
            } else if (keyList1.get(i) < keyList2.get(i)) {
                result = -1;
                break;
            }
        }
        return result;
    }

    // This method orders a map based on value descending, and breaks ties based on key descending. This is useful
    // for sorting a hand representation, since when comparing hands you always compare them first by the largest set
    // (e.g. you compare the three of a kind before the pair in a full house), and if you have two sets that are equal
    // size, you compare the higher ranked one first (e.g., you compare the higher of the pairs in a two pair first)
    private LinkedHashMap<Integer, Integer> getSortedMapByValDescBreakTieByKeyDesc(Map<Integer, Integer> map) {
        return map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey())) // I use reverse order here, since I want the highest value cards first
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) // I use reverse order here, since I want the largest sets of cards first (e.g., three of a kind before pair, pair before single)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }
}

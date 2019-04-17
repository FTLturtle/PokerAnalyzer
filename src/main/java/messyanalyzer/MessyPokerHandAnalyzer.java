package messyanalyzer;

import java.util.*;
import java.util.stream.Collectors;

public class MessyPokerHandAnalyzer {

    // This method takes a string representation of two five-card poker hands, e.g., "AH TD 5C 9S JS 3D 7H 5S JC 5H".
    // The left five represent the left hand, and the right five represent the right hand. The method then returns
    // 'left', 'right', or 'none' depending on which hand won
    public static String analyzeHands(String hands) {
        // Split the string into individual card representations
        String[] twoHandArray = hands.split(" ");

        // Create the left hand
        Card[] leftHandArray = new Card[5];
        for (int i = 0; i < 5; i++) {
            leftHandArray[i] = new Card(twoHandArray[i]);
        }
        Hand leftHand = new Hand(leftHandArray);

        // Create the right hand
        Card[] rightHandArray = new Card[5];
        for (int i = 5; i < twoHandArray.length; i++) {
            rightHandArray[i - 5] = new Card(twoHandArray[i]);
        }
        Hand rightHand = new Hand(rightHandArray);

        // Compare Hands
        HandComparator handComparator = new HandComparator();
        int compareHandResult = handComparator.compare(leftHand, rightHand);

        // Return who won
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
}

// class for representing hands
class Hand {
    private boolean allCardsSameSuit; // are all the cards the same suit
    Map<Integer, Integer> handRankMap; // histogram of the ranks
    List<Integer> handRankList; // list of all the ranks
    int handTypeValue;  // the value of the hand type: high card is 0, pair is 1, two pair is 2, three of a kind is 3,
    // straight is 4, flush is 5, full house is 6, four of a kind is 7, straight flush is 8

    public Hand(Card[] cards) {
        handRankMap = new HashMap<>();
        handRankList = new ArrayList<>();
        for (Card card : cards) {
            handRankMap.put(card.rank, handRankMap.getOrDefault(card.rank, 0) + 1);
            handRankList.add(card.rank);
        }

        char currentSuit = cards[0].suit;
        allCardsSameSuit = true;
        for (int i = 1; i < 5; i++) {
            if (cards[i].suit != currentSuit) {
                allCardsSameSuit = false;
                break;
            }
            currentSuit = cards[i].suit;
        }

        handTypeValue = evaluateHandTypeValue();

    }

    // This method will determine the value of the hand by its hand type
    // high card is 0, pair is 1, two pair is 2, three of a kind is 3,
    // straight is 4, flush is 5, full house is 6, four of a kind is 7, straight flush is 8
    private int evaluateHandTypeValue() {
        List<Integer> histogramList = new ArrayList<>();
        for (Integer key : handRankMap.keySet()) {
            histogramList.add(handRankMap.get(key));
        }
        histogramList.sort(Collections.reverseOrder());
        int listSize = histogramList.size();

        boolean isFlush = allCardsSameSuit;

        boolean isStraight;
        if (listSize != 5) {
            isStraight = false;
        } else {
            isStraight = evaluateStraight();
        }

        if (isFlush && isStraight) { // straight flush
            return 8;
        } else if (listSize == 2 && histogramList.get(0) == 4) { // four of a kind
            return 7;
        } else if (listSize == 2 && histogramList.get(0) == 3) { // full house
            return 6;
        } else if (isFlush) { // flush
            return 5;
        } else if (isStraight) { // straight
            return 4;
        } else if (listSize == 3 && histogramList.get(0) == 3) { // three of a kind
            return 3;
        } else if (listSize == 3 && histogramList.get(0) == 2) { // two pair
            return 2;
        } else if (listSize == 4 && histogramList.get(0) == 2) { // pair
            return 1;
        } else { // high card
            return 0;
        }
    }

    // Method for determining if a hand is a straight
    private boolean evaluateStraight() {
        Collections.sort(handRankList);
        return (handRankList.get(4) - handRankList.get(0) == 4);
    }
}

// class for representing cards
class Card {
    Integer rank;
    Character suit;

    // Sets the rank and suit of the card based on the two character string, e.g., "AH" would be rank: 14, Suit: H
    public Card(String cardRepresentation) {
        char rankChar = cardRepresentation.charAt(0);
        if (rankChar == 'A') {
            rank = 14;
        } else if (rankChar == 'K') {
            rank = 13;
        } else if (rankChar == 'Q') {
            rank = 12;
        } else if (rankChar == 'J') {
            rank = 11;
        } else if (rankChar == 'T') {
            rank = 10;
        } else {
            rank = Integer.parseInt("" + rankChar);
        }

        suit = cardRepresentation.charAt(1);
    }
}

// class for comparing hands
class HandComparator implements Comparator<Hand> {

    // Compares hands by type, then by individual card values
    @Override
    public int compare(Hand hand1, Hand hand2) {
        int result = hand1.handTypeValue - hand2.handTypeValue;

        // if the hand types are the same, then compare by value of individual cards
        if (result == 0) {
            result = compareHandsOfSameType(hand1.handTypeValue, hand1, hand2);
        }

        return result;
    }

    // method for comparing hands of the same type
    private int compareHandsOfSameType(int handTypeValue, Hand hand1, Hand hand2) {
        // I use a linked hash map, because it can be sorted by both key and value, and its order is guaranteed.
        LinkedHashMap<Integer, Integer> sortedHandRankMap1 = getSortedMapByValDescBreakTieByKeyDesc(hand1.handRankMap);
        LinkedHashMap<Integer, Integer> sortedHandRankMap2 = getSortedMapByValDescBreakTieByKeyDesc(hand2.handRankMap);

        List<Integer> keyList1 = new ArrayList<>(sortedHandRankMap1.keySet());
        List<Integer> keyList2 = new ArrayList<>(sortedHandRankMap2.keySet());

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

    private LinkedHashMap<Integer, Integer> getSortedMapByValDescBreakTieByKeyDesc(Map<Integer, Integer> map) {
        return map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }
}

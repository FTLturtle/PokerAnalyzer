package pokerhandanalyzer;

import pokerhandanalyzer.enums.Rank;
import pokerhandanalyzer.enums.Suit;
import pokerhandanalyzer.models.Card;
import pokerhandanalyzer.models.PokerHand;

import java.util.ArrayList;
import java.util.List;

public class StringPokerHandAnalyzer {
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
        List<Card> cards = new ArrayList<>();
        Suit suit;
        Rank rank;
        for (int i = offset; i < offset + 5; i++) {
            rank = Rank.getRankByCharacterRepresentation(twoHandArray[i].charAt(0));
            suit = Suit.getSuitByCharacterRepresentation(twoHandArray[i].charAt(1));
            cards.add(new Card(rank, suit));
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

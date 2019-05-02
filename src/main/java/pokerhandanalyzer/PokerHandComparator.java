package pokerhandanalyzer;

import pokerhandanalyzer.enums.Rank;
import pokerhandanalyzer.models.PokerHand;

import java.util.*;
import java.util.stream.Collectors;

public class PokerHandComparator implements Comparator<PokerHand> {
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
        PokerHandAnalyzer pokerHandAnalyzer1 = new PokerHandAnalyzer(pokerHand1);
        PokerHandAnalyzer pokerHandAnalyzer2 = new PokerHandAnalyzer(pokerHand2);

        int result = pokerHandAnalyzer1.getPokerHandType().compareTo(pokerHandAnalyzer2.getPokerHandType());

        // if the hand types are the same, then compare by value of individual cards
        if (result == 0) {
            result = compareHandsOfSameType(pokerHandAnalyzer1, pokerHandAnalyzer2);
        }

        return result;
    }

    // method for comparing hands of the same type
    private int compareHandsOfSameType(PokerHandAnalyzer pokerHandAnalyzer1, PokerHandAnalyzer pokerHandAnalyzer2) {
        // I use a linked hash map, because it can be sorted by both key and value, and its order is guaranteed.
        LinkedHashMap<Rank, Integer> sortedHandRankHistogram1 = getSortedMapByValDescBreakTieByKeyDesc(pokerHandAnalyzer1.getHandRankHistogram());
        LinkedHashMap<Rank, Integer> sortedHandRankHistogram2 = getSortedMapByValDescBreakTieByKeyDesc(pokerHandAnalyzer2.getHandRankHistogram());

        List<Rank> keyList1 = new ArrayList<>(sortedHandRankHistogram1.keySet());
        List<Rank> keyList2 = new ArrayList<>(sortedHandRankHistogram2.keySet());

        int result = 0;
        for (int i = 0; i < keyList1.size(); i++) {
            result = keyList1.get(i).compareTo(keyList2.get(i));
            if (result != 0) {
                break;
            }
        }
        return result;
    }

    // This method orders a map based on value descending, and breaks ties based on key descending. This is useful
    // for sorting a hand representation, since when comparing hands you always compare them first by the largest set
    // (e.g. you compare the three of a kind before the pair in a full house), and if you have two sets that are equal
    // size, you compare the higher ranked one first (e.g., you compare the higher of the pairs in a two pair first)
    private LinkedHashMap<Rank, Integer> getSortedMapByValDescBreakTieByKeyDesc(Map<Rank, Integer> map) {
        return map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey())) // I use reverse order here, since I want the highest value cards first
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) // I use reverse order here, since I want the largest sets of cards first (e.g., three of a kind before pair, pair before single)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }
}

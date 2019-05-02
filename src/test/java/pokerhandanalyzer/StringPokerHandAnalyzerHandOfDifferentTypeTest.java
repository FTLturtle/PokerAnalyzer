package pokerhandanalyzer;

import org.junit.Assert;
import org.junit.Test;

public class StringPokerHandAnalyzerHandOfDifferentTypeTest {
    private String straightFlush = "JH TH 9H 8H 7H";
    private String fourOfAKind = "JD JS 2H JC JH";
    private String fullHouse = "5S 5D 3S 3H 5C";
    private String flush = "3H 5H AH 8H TH";
    private String straight = "JH TC 7D 8S 9H";
    private String threeOfAKind = "TH TD TS KC 7C";
    private String twoPair = "4S 4C 9D 9H 2H";
    private String pair = "6H 7S 2C KS 6D";
    private String highCard = "4D KC 5S QH 3C";

    private String left = "left";
    private String right = "right";

    // NOTE: I used a round robin tournament generator to generate all the pairings I needed to test.

    @Test
    public void analyzeHandsTest1() {
        // Given
        String input = highCard + " " + flush;
        String expectedOutput = right;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest2() {
        // Given
        String input = pair + " " + fullHouse;
        String expectedOutput = right;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest3() {
        // Given
        String input = twoPair + " " + fourOfAKind;
        String expectedOutput = right;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest4() {
        // Given
        String input = threeOfAKind + " " + straightFlush;
        String expectedOutput = right;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest5() {
        // Given
        String input = pair + " " + highCard;
        String expectedOutput = left;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest6() {
        // Given
        String input = flush + " " + twoPair;
        String expectedOutput = left;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest7() {
        // Given
        String input = fullHouse + " " + threeOfAKind;
        String expectedOutput = left;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest8() {
        // Given
        String input = fourOfAKind + " " + straight;
        String expectedOutput = left;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest9() {
        // Given
        String input = highCard + " " + twoPair;
        String expectedOutput = right;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest10() {
        // Given
        String input = threeOfAKind + " " + pair;
        String expectedOutput = left;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest11() {
        // Given
        String input = straight + " " + flush;
        String expectedOutput = right;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest12() {
        // Given
        String input = straightFlush + " " + fourOfAKind;
        String expectedOutput = left;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest13() {
        // Given
        String input = highCard + " " + threeOfAKind;
        String expectedOutput = right;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest14() {
        // Given
        String input = straight + " " + twoPair;
        String expectedOutput = left;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest15() {
        // Given
        String input = straightFlush + " " + flush;
        String expectedOutput = left;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest16() {
        // Given
        String input = fourOfAKind + " " + fullHouse;
        String expectedOutput = left;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest17() {
        // Given
        String input = highCard + " " + straight;
        String expectedOutput = right;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest18() {
        // Given
        String input = straightFlush + " " + twoPair;
        String expectedOutput = left;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest19() {
        // Given
        String input = fourOfAKind + " " + pair;
        String expectedOutput = left;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest20() {
        // Given
        String input = fullHouse + " " + flush;
        String expectedOutput = left;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest21() {
        // Given
        String input = straightFlush + " " + straight;
        String expectedOutput = left;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest22() {
        // Given
        String input = fourOfAKind + " " + threeOfAKind;
        String expectedOutput = left;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest23() {
        // Given
        String input = twoPair + " " + fullHouse;
        String expectedOutput = right;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest24() {
        // Given
        String input = pair + " " + flush;
        String expectedOutput = right;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest25() {
        // Given
        String input = highCard + " " + straightFlush;
        String expectedOutput = right;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest26() {
        // Given
        String input = fullHouse + " " + straight;
        String expectedOutput = left;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest27() {
        // Given
        String input = flush + " " + threeOfAKind;
        String expectedOutput = left;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest28() {
        // Given
        String input = pair + " " + twoPair;
        String expectedOutput = right;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest29() {
        // Given
        String input = highCard + " " + fourOfAKind;
        String expectedOutput = right;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest30() {
        // Given
        String input = fullHouse + " " + straightFlush;
        String expectedOutput = right;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest31() {
        // Given
        String input = pair + " " + straight;
        String expectedOutput = right;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest32() {
        // Given
        String input = twoPair + " " + threeOfAKind;
        String expectedOutput = right;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest33() {
        // Given
        String input = fullHouse + " " + highCard;
        String expectedOutput = left;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest34() {
        // Given
        String input = flush + " " + fourOfAKind;
        String expectedOutput = right;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest35() {
        // Given
        String input = straightFlush + " " + pair;
        String expectedOutput = left;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest36() {
        // Given
        String input = threeOfAKind + " " + straight;
        String expectedOutput = right;

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }


}
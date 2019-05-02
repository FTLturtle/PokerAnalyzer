package pokerhandanalyzer;

import org.junit.Assert;
import org.junit.Test;

public class StringPokerHandAnalyzerPokerHandOfSameTypeTest {

    // Comparing two equivalent high card hands
    @Test
    public void analyzeHandsTest1() {
        // Given
        String input = "QH TD 5C 9S KS KD 5H 9S QC TH";
        String expectedOutput = "neither";

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // Comparing two different high card hands
    @Test
    public void analyzeHandsTest2() {
        // Given
        String input = "AH KD 5C QS TS TD KH 5S JC 9H";
        String expectedOutput = "left";

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // Comparing two equivalent pair hands
    @Test
    public void analyzeHandsTest3() {
        // Given
        String input = "AH TD TC 9S JS AD TH TS 9C JH";
        String expectedOutput = "neither";

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing two different pair hands, same pair, different kickers
    @Test
    public void analyzeHandsTest4() {
        // Given
        String input = "AH TD JH 3S JS AD TH 9S JC JD";
        String expectedOutput = "right";

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing two different pair hands, different pair, same kickers
    @Test
    public void analyzeHandsTest5() {
        // Given
        String input = "AH TD JH 9C 9S AD TH JS QC QH";
        String expectedOutput = "right";

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing two different pair hands, different pair, different kickers
    @Test
    public void analyzeHandsTest6() {
        // Given
        String input = "QD 6H AS KS 6C 5H 3D JC 7S 7D";
        String expectedOutput = "right";

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing two equivalent three of a kind hands (note: only possible in a game where cards are shared, such as Hold 'em)
    @Test
    public void analyzeHandsTest7() {
        // Given
        String input = "3H 3D 3C 9S JS 3D 3H 3S 9C JS";
        String expectedOutput = "neither";

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing two different three of a kind hands
    @Test
    public void analyzeHandsTest8() {
        // Given
        String input = "4H 4D 4C 9S JC 3D 3H 3S 9C JS";
        String expectedOutput = "left";

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing two equivalent straight hands
    @Test
    public void analyzeHandsTest9() {
        // Given
        String input = "TD 7C 8C 6H 9S 8D 6S 9H 7D TC";
        String expectedOutput = "neither";

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing two different straight hands
    @Test
    public void analyzeHandsTest10() {
        // Given
        String input = "TD 7C 8C JH 9S 8D 6S 9H 7D TC";
        String expectedOutput = "left";

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing two equivalent flush hands
    @Test
    public void analyzeHandsTest11() {
        // Given
        String input = "QH TH 5H 9H KH QS TS 5S KS 9S";
        String expectedOutput = "neither";

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing two different flush hands
    @Test
    public void analyzeHandsTest12() {
        // Given
        String input = "KH TH 5H 9H JH QS 2S 3S KS 6S";
        String expectedOutput = "right";

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing two equivalent full house hands (note: only possible in a game where cards are shared, such as Hold 'em)
    @Test
    public void analyzeHandsTest13() {
        // Given
        String input = "JD 3D JS 3S 3C 3D 3H 3S JC JH";
        String expectedOutput = "neither";

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing two different full house hands
    @Test
    public void analyzeHandsTest14() {
        // Given
        String input = "4H 4D 4C 2S 2C 3D 3H 3S AC AS";
        String expectedOutput = "left";

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing two equivalent four of a kind hands (note: only possible in a game where cards are shared, such as Hold 'em)
    @Test
    public void analyzeHandsTest15() {
        // Given
        String input = "QH QD QS QC 9H QD QH 9C QC QS";
        String expectedOutput = "neither";

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing two different four of a kind hands
    @Test
    public void analyzeHandsTest16() {
        // Given
        String input = "5H 5D 5S 5C 7H 5D 5H 5C 5C 2S";
        String expectedOutput = "left";

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing two equivalent straight flush hands
    @Test
    public void analyzeHandsTest17() {
        // Given
        String input = "8C 6C 7C 4C 5C 4D 6D 8D 5D 7D";
        String expectedOutput = "neither";

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing two different straight flush hands
    @Test
    public void analyzeHandsTest18() {
        // Given
        String input = "8C 6C 7C 9C TC 4D 6D 3D 5D 7D";
        String expectedOutput = "left";

        // When
        String actualOutput = StringPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
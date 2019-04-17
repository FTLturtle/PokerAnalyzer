package quickanalyzer;

import org.junit.Assert;
import org.junit.Test;
import quickanalyzer.QuickPokerHandAnalyzer;

public class QuickPokerHandAnalyzerTest {

    // Comparing two equivalent high card hands
    @Test
    public void analyzeHandsTest1() {
        // Given
        String input = "QH TD 5C 9S KS KD 5H 9S QC TH";
        String expectedOutput = "neither";

        // When
        String actualOutput = QuickPokerHandAnalyzer.analyzeHands(input);

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
        String actualOutput = QuickPokerHandAnalyzer.analyzeHands(input);

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
        String actualOutput = QuickPokerHandAnalyzer.analyzeHands(input);

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
        String actualOutput = QuickPokerHandAnalyzer.analyzeHands(input);

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
        String actualOutput = QuickPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing a pair with a full house
    @Test
    public void analyzeHandsTest6() {
        // Given
        String input = "AH TD JH 9S JS 3D 3H 3S JC JH";
        String expectedOutput = "right";

        // When
        String actualOutput = QuickPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing a pair with a full house
    @Test
    public void analyzeHandsTest7() {
        // Given
        String input = "AH TD JH 9S JS 3D 3H 3S JC JH";
        String expectedOutput = "right";

        // When
        String actualOutput = QuickPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing a pair with a full house
    @Test
    public void analyzeHandsTest8() {
        // Given
        String input = "AH TD JH 9S JS 3D 3H 3S JC JH";
        String expectedOutput = "right";

        // When
        String actualOutput = QuickPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing a pair with a full house
    @Test
    public void analyzeHandsTest9() {
        // Given
        String input = "AH TD JH 9S JS 3D 3H 3S JC JH";
        String expectedOutput = "right";

        // When
        String actualOutput = QuickPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing a pair with a full house
    @Test
    public void analyzeHandsTest10() {
        // Given
        String input = "AH TD JH 9S JS 3D 3H 3S JC JH";
        String expectedOutput = "right";

        // When
        String actualOutput = QuickPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing a pair with a full house
    @Test
    public void analyzeHandsTest11() {
        // Given
        String input = "AH TD JH 9S JS 3D 3H 3S JC JH";
        String expectedOutput = "right";

        // When
        String actualOutput = QuickPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing a pair with a full house
    @Test
    public void analyzeHandsTest12() {
        // Given
        String input = "AH TD JH 9S JS 3D 3H 3S JC JH";
        String expectedOutput = "right";

        // When
        String actualOutput = QuickPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    // comparing a pair with a full house
    @Test
    public void analyzeHandsTest13() {
        // Given
        String input = "AH TD JH 9S JS 3D 3H 3S JC JH";
        String expectedOutput = "right";

        // When
        String actualOutput = QuickPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }


}
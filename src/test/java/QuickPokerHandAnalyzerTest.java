import org.junit.Assert;
import org.junit.Test;

public class QuickPokerHandAnalyzerTest {

    @Test
    public void analyzeHandsTest1() {
        // Given
        String input = "AH TD 5C 9S JS 3D 7H 5S JC 5H";
        String expectedOutput = "right";

        // When
        String actualOutput = QuickPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest2() {
        // Given
        String input = "AH KD JC QS TS QD KH TS JC 9H";
        String expectedOutput = "left";

        // When
        String actualOutput = QuickPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest3() {
        // Given
        String input = "AH TD 5C 9S JS AD 5H TS 9C JH";
        String expectedOutput = "neither";

        // When
        String actualOutput = QuickPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void analyzeHandsTest4() {
        // Given
        String input = "AH TD 5C 9S JS 3D 3H 3S JC JH";
        String expectedOutput = "right";

        // When
        String actualOutput = QuickPokerHandAnalyzer.analyzeHands(input);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }


}
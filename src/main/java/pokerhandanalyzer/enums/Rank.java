package pokerhandanalyzer.enums;

public enum Rank {
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),
    TEN('T'),
    JACK('J'),
    QUEEN('Q'),
    KING('K'),
    ACE('A');

    private final Character characterRepresentation;

    Rank(Character characterRepresentation) {
        this.characterRepresentation = characterRepresentation;
    }

    public Integer getOrdinal() {
        return ordinal();
    }

    public Character getCharacterRepresentation() {
        return characterRepresentation;
    }

    public static Rank getRankByCharacterRepresentation(Character character) {
        for (Rank rank: values()) {
            if (rank.getCharacterRepresentation().equals(character)) {
                return rank;
            }
        }
        return null;
    }
}

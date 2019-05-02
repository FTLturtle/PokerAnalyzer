package pokerhandanalyzer.enums;

public enum Suit {
    CLUBS('C'),
    SPADES('S'),
    HEARTS('H'),
    DIAMONDS('D');

    private final Character characterRepresentation;

    Suit(char characterRepresentation) {
        this.characterRepresentation = characterRepresentation;
    }

    public Character getCharacterRepresentation() {
        return characterRepresentation;
    }

    public static Suit getSuitByCharacterRepresentation(Character character) {
        for (Suit suit: values()) {
            if (suit.getCharacterRepresentation().equals(character)) {
                return suit;
            }
        }
        return null;
    }
}

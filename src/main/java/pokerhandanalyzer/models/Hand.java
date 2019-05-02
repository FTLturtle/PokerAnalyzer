package pokerhandanalyzer.models;

import java.util.List;

public interface Hand {
    List<Card> getCards();
    void setCards(List<Card> cards);
}
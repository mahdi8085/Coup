package MODEL;

import java.util.ArrayList;

public class Deck {

    private final ArrayList<Card> deck;

    public Deck() {

        this.deck = new ArrayList<>();

        for (CardName cardName : CardName.values()) {
            for (int i = 0; i < 3; i++) {
                this.deck.add(new Card(cardName));
            }
        }

    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}

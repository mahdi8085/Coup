package MODEL;

import javafx.scene.image.Image;

public class Card {

    private int value;
    private CardName cardName;
    private Image cardImage;
    private Image backCardImage;

    public Card(CardName cardName) {
        this.value = cardName.getValue();
        this.cardName = cardName;
        this.backCardImage = new Image("Images\\CoupCard.jpg");
        if (cardName == CardName.Duke)
            this.cardImage = new Image("Images\\Duke.jpg");
        else if (cardName == CardName.Assassin)
            this.cardImage = new Image("Images\\Assassin.jpg");
        else if (cardName == CardName.Contessa)
            this.cardImage = new Image("Images\\Contessa.jpg");
        else if (cardName == CardName.Captain)
            this.cardImage = new Image("Images\\Captain.jpg");
        else
            this.cardImage = new Image("Images\\Ambassador.jpg");
    }

    public int getValue() {
        return value;
    }

    public CardName getCardName() {
        return cardName;
    }

    public Image getCardImage() {
        return cardImage;
    }

    public Image getBackCardImage() {
        return backCardImage;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setCardName(CardName cardName) {
        this.cardName = cardName;
    }

    public void setCardImage(Image cardImage) {
        this.cardImage = cardImage;
    }

    public void setBackCardImage(Image backCardImage) {
        this.backCardImage = backCardImage;
    }
}

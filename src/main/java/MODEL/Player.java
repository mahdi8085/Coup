package MODEL;

import java.util.ArrayList;

public abstract class Player {

    private String name;
    private int coin;
    private boolean isHuman;
    private ArrayList<Card> hand;

    public Player() {
        this.coin = 2;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void income() {
        this.setCoin(this.getCoin() + 1);
    }

    public void foreignAid() {
        this.setCoin(this.getCoin() + 2);
    }

    public void tax() {
        this.setCoin(this.getCoin() + 3);
    }
}

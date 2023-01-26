package LOGIC;

import MODEL.*;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private Deck deckCards;
    private ArrayList<Card> outDuke;
    private ArrayList<Card> outAssassin;
    private ArrayList<Card> outContessa;
    private ArrayList<Card> outCaptain;
    private ArrayList<Card> outAmbassador;
    private ArrayList<Card> outCards;
    private int coins;
    private Human player;
    private Bot firstBot;
    private Bot secondBot;
    private Bot thirdBot;
    private ArrayList<Bot> bots;
    private int turn;

    private String bot3LastTarget;
    private String attackType;
    private boolean bot2ShouldChallenge;

    public Game() {
        this.deckCards = new Deck();
        //Collections.shuffle(this.deckCards.getDeck());
        this.outDuke = new ArrayList<>();
        this.outAssassin = new ArrayList<>();
        this.outContessa = new ArrayList<>();
        this.outCaptain = new ArrayList<>();
        this.outAmbassador = new ArrayList<>();
        this.outCards = new ArrayList<>();
        this.coins = 42;
        this.player = new Human();
        this.firstBot = new Bot(Bot.BotType.Bot4);
        this.secondBot = new Bot(Bot.BotType.Bot3);
        this.thirdBot = new Bot(Bot.BotType.Bot2);
        this.bots = new ArrayList<>();
        bots.add(firstBot); bots.add(secondBot); bots.add(thirdBot);
        this.turn = 0;
        this.bot3LastTarget = "null";
        this.attackType = "null";
        this.bot2ShouldChallenge = false;
    }

    public Deck getDeckCards() {
        return deckCards;
    }

    public void setDeckCards(Deck deck) {
        this.deckCards = deck;
    }

    public ArrayList<Card> getOutDuke() {
        return outDuke;
    }

    public void setOutDuke(ArrayList<Card> outDuke) {
        this.outDuke = outDuke;
    }

    public ArrayList<Card> getOutAssassin() {
        return outAssassin;
    }

    public void setOutAssassin(ArrayList<Card> outAssassin) {
        this.outAssassin = outAssassin;
    }

    public ArrayList<Card> getOutContessa() {
        return outContessa;
    }

    public void setOutContessa(ArrayList<Card> outContessa) {
        this.outContessa = outContessa;
    }

    public ArrayList<Card> getOutCaptain() {
        return outCaptain;
    }

    public void setOutCaptain(ArrayList<Card> outCaptain) {
        this.outCaptain = outCaptain;
    }

    public ArrayList<Card> getOutAmbassador() {
        return outAmbassador;
    }

    public void setOutAmbassador(ArrayList<Card> outAmbassador) {
        this.outAmbassador = outAmbassador;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public ArrayList<Card> getOutCards() { return outCards; }

    public void setOutCards(ArrayList<Card> outCards) { this.outCards = outCards; }

    public Human getPlayer() {
        return player;
    }

    public void setPlayer(Human player) {
        this.player = player;
    }

    public Bot getFirstBot() {
        return firstBot;
    }

    public void setFirstBot(Bot firstBot) {
        this.firstBot = firstBot;
    }

    public Bot getSecondBot() {
        return secondBot;
    }

    public void setSecondBot(Bot secondBot) {
        this.secondBot = secondBot;
    }

    public Bot getThirdBot() {
        return thirdBot;
    }

    public void setThirdBot(Bot thirdBot) {
        this.thirdBot = thirdBot;
    }

    public ArrayList<Bot> getBots() { return bots; }

    public void setBots(ArrayList<Bot> bots) { this.bots = bots; }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public String getBot3LastTarget() { return bot3LastTarget; }

    public void setBot3LastTarget(String bot3LastTarget) { this.bot3LastTarget = bot3LastTarget; }

    public String getAttackType() { return attackType; }

    public void setAttackType(String attackType) { this.attackType = attackType; }

    public boolean isBot2ShouldChallenge() { return bot2ShouldChallenge; }

    public void setBot2ShouldChallenge(boolean bot2ShouldChallenge) { this.bot2ShouldChallenge = bot2ShouldChallenge; }

    public void addOutCards(Card card) {

        // add fired card to suitable list
        if (card.getCardName() == CardName.Duke)
            this.outDuke.add(card);
        else if (card.getCardName() == CardName.Assassin)
            this.outAssassin.add(card);
        else if (card.getCardName() == CardName.Contessa)
            this.outContessa.add(card);
        else if (card.getCardName() == CardName.Captain)
            this.outCaptain.add(card);
        else if (card.getCardName() == CardName.Ambassador)
            this.outAmbassador.add(card);
    }

    public void removeOutCards(Card card) {

        // remove fired card from suitable list
        if (card.getCardName() == CardName.Duke)
            this.outDuke.remove(card);
        else if (card.getCardName() == CardName.Assassin)
            this.outAssassin.remove(card);
        else if (card.getCardName() == CardName.Contessa)
            this.outContessa.remove(card);
        else if (card.getCardName() == CardName.Captain)
            this.outCaptain.remove(card);
        else if (card.getCardName() == CardName.Ambassador)
            this.outAmbassador.remove(card);
    }

    public void fireCard(int n) {

        // fire a player card according to n
        if (n == 0) {

            bot3LastTarget = "player";
            if (attackType.equals("assassinate"))
                System.out.println(this.player.getName() + ": Assassinate");
            else if (attackType.equals("coup"))
                System.out.println(this.player.getName() + ": Coup");

            if (this.player.getHand().size() == 1) {
                System.out.println(this.player.getName() + "->" + "KILL" + ": " + this.player.getHand().get(0).getCardName());
                this.addOutCards(this.player.getHand().get(0));
                this.outCards.add(this.player.getHand().get(0));
                this.player.getHand().remove(0);
            }
            else {
                System.out.println(this.player.getName() + "->" + "KILL" + ": " + this.player.getHand().get(1).getCardName());
                this.addOutCards(this.player.getHand().get(1));
                this.outCards.add(this.player.getHand().get(1));
                this.player.getHand().remove(1);
            }

        } else if (n == 1) {

            bot3LastTarget = "firstBot";
            if (attackType.equals("assassinate"))
                System.out.println(this.firstBot.getName() + ": Assassinate");
            else if (attackType.equals("coup"))
                System.out.println(this.firstBot.getName() + ": Coup");

            if (this.firstBot.getHand().size() == 1) {
                this.bots.remove(this.firstBot);
                this.setCoins(this.getCoins() + this.firstBot.getCoin());
                this.firstBot.setCoin(0);
            }

            if (this.firstBot.getHand().size() == 2) {
                System.out.println(this.firstBot.getName() + "->" + "KILL" + ": " + this.firstBot.getHand().get(1).getCardName());
                this.addOutCards(this.firstBot.getHand().get(1));
                this.outCards.add(this.firstBot.getHand().get(1));
                this.firstBot.getHand().remove(1);
            }
            else if (this.firstBot.getHand().size() == 1) {
                System.out.println(this.firstBot.getName() + "->" + "KILL" + ": " + this.firstBot.getHand().get(0).getCardName());
                this.addOutCards(this.firstBot.getHand().get(0));
                this.outCards.add(this.firstBot.getHand().get(0));
                this.firstBot.getHand().remove(0);
            }

        } else if (n == 2) {

            bot3LastTarget = "secondBot";
            if (attackType.equals("assassinate"))
                System.out.println(this.secondBot.getName() + ": Assassinate");
            else if (attackType.equals("coup"))
                System.out.println(this.secondBot.getName() + ": Coup");

            if (this.secondBot.getHand().size() == 1) {
                this.bots.remove(this.secondBot);
                this.setCoins(this.getCoins() + this.secondBot.getCoin());
                this.secondBot.setCoin(0);
            }

            if (this.secondBot.getHand().size() == 2) {
                System.out.println(this.secondBot.getName() + "->" + "KILL" + ": " + this.secondBot.getHand().get(1).getCardName());
                this.addOutCards(this.secondBot.getHand().get(1));
                this.outCards.add(this.secondBot.getHand().get(1));
                this.secondBot.getHand().remove(1);
            }
            else if (this.secondBot.getHand().size() == 1) {
                System.out.println(this.secondBot.getName() + "->" + "KILL" + ": " + this.secondBot.getHand().get(0).getCardName());
                this.addOutCards(this.secondBot.getHand().get(0));
                this.outCards.add(this.secondBot.getHand().get(0));
                this.secondBot.getHand().remove(0);
            }

        } else {

            bot3LastTarget = "thirdBot";
            if (attackType.equals("assassinate"))
                System.out.println(this.thirdBot.getName() + ": Assassinate");
            else if (attackType.equals("coup"))
                System.out.println(this.thirdBot.getName() + ": Coup");

            if (this.thirdBot.getHand().size() == 1) {
                this.bots.remove(this.thirdBot);
                this.setCoins(this.getCoins() + this.thirdBot.getCoin());
                this.thirdBot.setCoin(0);
            }

            if (this.thirdBot.getHand().size() == 2) {
                System.out.println(this.thirdBot.getName() + "->" + "KILL" + ": " + this.thirdBot.getHand().get(1).getCardName());
                this.addOutCards(this.thirdBot.getHand().get(1));
                this.outCards.add(this.thirdBot.getHand().get(1));
                this.thirdBot.getHand().remove(1);
            }
            else if (this.thirdBot.getHand().size() == 1) {
                System.out.println(this.thirdBot.getName() + "->" + "KILL" + ": " + this.thirdBot.getHand().get(0).getCardName());
                this.addOutCards(this.thirdBot.getHand().get(0));
                this.outCards.add(this.thirdBot.getHand().get(0));
                this.thirdBot.getHand().remove(0);
            }
        }
    }

    public void nextTurn() {

        // next turn
        if (this.turn < 3)
            this.turn++;
        else
            this.turn = 0;

        // check for out bots
        if (this.turn == 1 && this.firstBot.getHand().isEmpty())
            this.turn++;
        else if (this.turn == 2 && this.secondBot.getHand().isEmpty())
            this.turn++;
        else if (this.turn == 3 && this.thirdBot.getHand().isEmpty())
            this.turn = 0;
    }

    public void botTurn() {

        // call each bot action function
        if (this.turn == 1) {

            if (this.firstBot.getName().equals(Bot.BotType.Bot1.toString()))
                this.Bot1Action(this.firstBot, 1);
            else if (this.firstBot.getName().equals(Bot.BotType.Bot2.toString()))
                this.Bot2Action(this.firstBot, 1);
            else if (this.firstBot.getName().equals(Bot.BotType.Bot3.toString()))
                this.Bot3Action(this.firstBot, 1);
            else
                this.Bot4Action(this.firstBot, 1);

        } else if (this.turn == 2) {

            if (this.secondBot.getName().equals(Bot.BotType.Bot1.toString()))
                this.Bot1Action(this.secondBot, 2);
            else if (this.secondBot.getName().equals(Bot.BotType.Bot2.toString()))
                this.Bot2Action(this.secondBot, 2);
            else if (this.secondBot.getName().equals(Bot.BotType.Bot3.toString()))
                this.Bot3Action(this.secondBot, 2);
            else
                this.Bot4Action(this.secondBot, 2);

        } else {

            if (this.thirdBot.getName().equals(Bot.BotType.Bot1.toString()))
                this.Bot1Action(this.thirdBot, 3);
            else if (this.thirdBot.getName().equals(Bot.BotType.Bot2.toString()))
                this.Bot2Action(this.thirdBot, 3);
            else if (this.thirdBot.getName().equals(Bot.BotType.Bot3.toString()))
                this.Bot3Action(this.thirdBot, 3);
            else
                this.Bot4Action(this.thirdBot, 3);

        }
    }

    private void Bot1Action(Bot bot, int n) {

        // couper
        if (bot.getCoin() < 7) {

            if (n == 1) {

                System.out.println(this.firstBot.getName() + "->" + "BANK" + ": Tax");
                this.firstBot.tax();

            } else if (n == 2) {

                System.out.println(this.secondBot.getName() + "->" + "BANK" + ": Tax");
                this.secondBot.tax();

            } else {

                System.out.println(this.thirdBot.getName() + "->" + "BANK" + ": Tax");
                this.thirdBot.tax();
            }

            this.setCoins(this.getCoins() - 3);
            this.nextTurn();

        } else {

            attackType = "coup";
            attackCard(n, 7);
        }
    }

    private void Bot2Action(Bot bot, int n) {

        // paranoid
        if (bot.getCoin() < 7) {

            if (n == 1) {

                System.out.println(this.firstBot.getName() + "->" + "BANK" + ": Income");
                this.firstBot.income();

            } else if (n == 2) {

                System.out.println(this.secondBot.getName() + "->" + "BANK" + ": Income");
                this.secondBot.income();

            } else {

                System.out.println(this.thirdBot.getName() + "->" + "BANK" + ": Income");
                this.thirdBot.income();
            }

            this.setCoins(this.getCoins() - 1);
            this.nextTurn();

        } else {

            attackType = "coup";
            attackCard(n, 7);
        }
    }

    private void Bot3Action(Bot bot, int n) {

        // cautious assassin
        boolean haveAssassin = false;
        for (Card card : bot.getHand()) {
            if (card.getCardName().equals(CardName.Assassin)) {
                haveAssassin = true;
                break;
            }
        }

        if (haveAssassin && bot.getCoin() > 2) {

            attackType = "assassinate";
            this.attackCard(n, 3);

        } else if (haveAssassin && bot.getCoin() < 3) {

            if (n == 1) {

                System.out.println(this.firstBot.getName() + "->" + "BANK" + ": Income");
                this.firstBot.income();

            } else if (n == 2) {

                System.out.println(this.secondBot.getName() + "->" + "BANK" + ": Income");
                this.secondBot.income();

            } else {

                System.out.println(this.thirdBot.getName() + "->" + "BANK" + ": Income");
                this.thirdBot.income();
            }

            this.setCoins(this.getCoins() - 1);
            this.nextTurn();

        } else {

            boolean haveAmbassador = false;
            for (Card card : bot.getHand()) {
                if (card.getCardName().equals(CardName.Ambassador)) {
                    haveAmbassador = true;
                    break;
                }
            }

            if (haveAmbassador) {

                if (n == 1)
                    System.out.println(this.firstBot.getName() + "->" + "DECK" + ": Exchange");
                else if (n == 2)
                    System.out.println(this.secondBot.getName() + "->" + "DECK" + ": Exchange");
                else
                    System.out.println(this.thirdBot.getName() + "->" + "DECK" + ": Exchange");

                if (this.deckCards.getDeck().get(0).getCardName().equals(CardName.Assassin)
                        || this.deckCards.getDeck().get(1).getCardName().equals(CardName.Assassin)) {

                    if (n == 1) {

                        this.firstBot.getHand().add(this.deckCards.getDeck().get(0));
                        this.firstBot.getHand().add(this.deckCards.getDeck().get(1));
                        this.deckCards.getDeck().add(this.firstBot.getHand().get(0));
                        this.deckCards.getDeck().add(this.firstBot.getHand().get(1));
                        this.firstBot.getHand().remove(0);
                        this.firstBot.getHand().remove(0);
                        this.deckCards.getDeck().remove(0);
                        this.deckCards.getDeck().remove(0);

                    } else if (n == 2) {

                        this.secondBot.getHand().add(this.deckCards.getDeck().get(0));
                        this.secondBot.getHand().add(this.deckCards.getDeck().get(1));
                        this.deckCards.getDeck().add(this.secondBot.getHand().get(0));
                        this.deckCards.getDeck().add(this.secondBot.getHand().get(1));
                        this.secondBot.getHand().remove(0);
                        this.secondBot.getHand().remove(0);
                        this.deckCards.getDeck().remove(0);
                        this.deckCards.getDeck().remove(0);

                    } else {

                        this.thirdBot.getHand().add(this.deckCards.getDeck().get(0));
                        this.thirdBot.getHand().add(this.deckCards.getDeck().get(1));
                        this.deckCards.getDeck().add(this.thirdBot.getHand().get(0));
                        this.deckCards.getDeck().add(this.thirdBot.getHand().get(1));
                        this.thirdBot.getHand().remove(0);
                        this.thirdBot.getHand().remove(0);
                        this.deckCards.getDeck().remove(0);
                        this.deckCards.getDeck().remove(0);
                    }
                }

                this.nextTurn();

            } else {

                if (bot.getCoin() == 0) {

                    if (n == 1) {

                        System.out.println(this.firstBot.getName() + "->" + "BANK" + ": Foreign Aid");
                        this.firstBot.foreignAid();

                    } else if (n == 2) {

                        System.out.println(this.secondBot.getName() + "->" + "BANK" + ": Foreign Aid");
                        this.secondBot.foreignAid();

                    } else {

                        System.out.println(this.thirdBot.getName() + "->" + "BANK" + ": Foreign Aid");
                        this.thirdBot.foreignAid();
                    }

                    this.setCoins(this.getCoins() - 2);
                    this.nextTurn();

                } else if (bot.getCoin() > 9) {

                    attackType = "coup";
                    attackCard(n, 7);

                } else {

                    if (n == 1) {

                        System.out.println(this.firstBot.getName() + "->" + "DECK" + ": New Exchange");

                        this.firstBot.getHand().add(this.deckCards.getDeck().get(0));
                        this.deckCards.getDeck().add(this.firstBot.getHand().get(0));
                        this.firstBot.getHand().remove(0);
                        this.deckCards.getDeck().remove(0);
                        this.firstBot.setCoin(this.firstBot.getCoin() - 1);

                    } else if (n == 2) {

                        System.out.println(this.secondBot.getName() + "->" + "DECK" + ": New Exchange");

                        this.secondBot.getHand().add(this.deckCards.getDeck().get(0));
                        this.deckCards.getDeck().add(this.secondBot.getHand().get(0));
                        this.secondBot.getHand().remove(0);
                        this.deckCards.getDeck().remove(0);
                        this.secondBot.setCoin(this.secondBot.getCoin() - 1);

                    } else {

                        System.out.println(this.thirdBot.getName() + "->" + "DECK" + ": New Exchange");

                        this.thirdBot.getHand().add(this.deckCards.getDeck().get(0));
                        this.deckCards.getDeck().add(this.thirdBot.getHand().get(0));
                        this.thirdBot.getHand().remove(0);
                        this.deckCards.getDeck().remove(0);
                        this.thirdBot.setCoin(this.thirdBot.getCoin() - 1);
                    }

                    Collections.shuffle(this.deckCards.getDeck());
                    this.setCoins(this.getCoins() + 1);
                    this.nextTurn();
                }
            }
        }
    }

    private void Bot4Action(Bot bot, int n) {

        // optional
        if (bot.getCoin() < 7) {

            if (n == 1) {

                System.out.println(this.firstBot.getName() + "->" + "BANK" + ": Income");
                this.firstBot.income();

            } else if (n == 2) {

                System.out.println(this.secondBot.getName() + "->" + "BANK" + ": Income");
                this.secondBot.income();

            } else {

                System.out.println(this.thirdBot.getName() + "->" + "BANK" + ": Income");
                this.thirdBot.income();
            }

            this.setCoins(this.getCoins() - 1);
            this.nextTurn();

        } else {

            attackType = "coup";
            this.attackCard(n, 7);
        }
    }

    private boolean checkValidTargetBot(int random) {

        // check bots list
        if (random == 0 && !this.player.getHand().isEmpty())
            return true;
        else if (random == 1 && !this.firstBot.getHand().isEmpty())
            return true;
        else if (random == 2 && !this.secondBot.getHand().isEmpty())
            return true;
        else return random == 3 && !this.thirdBot.getHand().isEmpty();
    }

    private void attackCard(int n, int coinNumber) {

        // assassinate another player card
        if (n == 1) {

            this.firstBot.setCoin(this.firstBot.getCoin() - coinNumber);
            while (true) {
                int random = (int) Math.floor(Math.random() * (3 + 1));
                if (random != 1 && checkValidTargetBot(random)) {
                    System.out.print(this.firstBot.getName() + "->");
                    this.fireCard(random);
                    break;
                }
            }

        } else if (n == 2) {

            this.secondBot.setCoin(this.secondBot.getCoin() - coinNumber);
            while (true) {
                int random = (int) Math.floor(Math.random() * (3 + 1));
                if (random != 2 && checkValidTargetBot(random)) {
                    System.out.print(this.secondBot.getName() + "->");
                    this.fireCard(random);
                    break;
                }
            }

        } else {

            this.thirdBot.setCoin(this.thirdBot.getCoin() - coinNumber);
            while (true) {
                int random = (int) Math.floor(Math.random() * (3 + 1));
                if (random != 3 && checkValidTargetBot(random)) {
                    System.out.print(this.thirdBot.getName() + "->");
                    this.fireCard(random);
                    break;
                }
            }
        }

        this.setCoins(this.getCoins() + coinNumber);
        this.nextTurn();
    }
}

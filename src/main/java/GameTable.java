import LOGIC.Game;
import MODEL.Bot;
import MODEL.Card;
import MODEL.CardName;
import MODEL.Player;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class GameTable implements Initializable {

    private Game game;

    @FXML private Label cardsInDeckLabel;
    @FXML private Label coinsInTreasuryLabel;
    @FXML private Label turnLabel;
    @FXML private Label firstTableBotLabel;
    @FXML private Label secondTableBotLabel;
    @FXML private Label thirdTableBotLabel;
    @FXML private Label playerCoinLabel;
    @FXML private Label firstBotCoinLabel;
    @FXML private Label secondBotCoinLabel;
    @FXML private Label thirdBotCoinLabel;
    @FXML private Label dukeOutLabel;
    @FXML private Label assassinOutLabel;
    @FXML private Label contessaOutLabel;
    @FXML private Label captainOutLabel;
    @FXML private Label ambassadorOutLabel;
    @FXML private ImageView playerCardOneImage;
    @FXML private ImageView playerCardTwoImage;
    @FXML private ImageView firstBotCardOneImage;
    @FXML private ImageView firstBotCardTwoImage;
    @FXML private ImageView secondBotCardOneImage;
    @FXML private ImageView secondBotCardTwoImage;
    @FXML private ImageView thirdBotCardOneImage;
    @FXML private ImageView thirdBotCardTwoImage;
    @FXML private Button challengeButton;
    @FXML private Button incomeButton;
    @FXML private Button foreignAidButton;
    @FXML private Button taxButton;
    @FXML private Button assassinateButton;
    @FXML private Button stealButton;
    @FXML private Button exchangeButton;
    @FXML private Button coupButton;
    @FXML private Button blockForeignAidButton;
    @FXML private Button blockStealingButton;
    @FXML private Button blockAssassinationButton;
    @FXML private Button newExchangeButton;
    @FXML private Button skipButton;
    @FXML private Label whichLabel;
    @FXML private ChoiceBox<String> whichChoiceBox;

    private String challengeType;
    private String challengeBotOrder;
    private int botChallengerOrder;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // make a new game
        this.game = new Game();

        // deal cards
        startGame();

        // set additional information
        setTableInformation();
    }

    public void startGame() {

        // DEALING CARDS MANUALLY

        // 0-2 Duke
        // 3-5 Assassin
        // 6-8 Contessa
        // 9-11 Captain
        // 12-14 Ambassador

        game.getPlayer().getHand().add(game.getDeckCards().getDeck().get(0));
        game.getPlayer().getHand().add(game.getDeckCards().getDeck().get(1));

        game.getFirstBot().getHand().add(game.getDeckCards().getDeck().get(2));
        game.getFirstBot().getHand().add(game.getDeckCards().getDeck().get(3));

        game.getSecondBot().getHand().add(game.getDeckCards().getDeck().get(4));
        game.getSecondBot().getHand().add(game.getDeckCards().getDeck().get(5));

        game.getThirdBot().getHand().add(game.getDeckCards().getDeck().get(6));
        game.getThirdBot().getHand().add(game.getDeckCards().getDeck().get(7));

        // REMOVE INVERSELY

        game.getDeckCards().getDeck().remove(7);
        game.getDeckCards().getDeck().remove(6);
        game.getDeckCards().getDeck().remove(5);
        game.getDeckCards().getDeck().remove(4);
        game.getDeckCards().getDeck().remove(3);
        game.getDeckCards().getDeck().remove(2);
        game.getDeckCards().getDeck().remove(1);
        game.getDeckCards().getDeck().remove(0);

        // deal cards to player and bots
//        for (int i = 0; i < 2; i++) {
//            game.getPlayer().getHand().add(game.getDeckCards().getDeck().get(i));
//            game.getDeckCards().getDeck().remove(i);
//        }
//
//        for (int i = 0; i < 2; i++) {
//            game.getFirstBot().getHand().add(game.getDeckCards().getDeck().get(i));
//            game.getDeckCards().getDeck().remove(i);
//        }
//
//        for (int i = 0; i < 2; i++) {
//            game.getSecondBot().getHand().add(game.getDeckCards().getDeck().get(i));
//            game.getDeckCards().getDeck().remove(i);
//        }
//
//        for (int i = 0; i < 2; i++) {
//            game.getThirdBot().getHand().add(game.getDeckCards().getDeck().get(i));
//            game.getDeckCards().getDeck().remove(i);
//        }
    }

    public void setTableInformation() {

        // check if game is finished
        if (game.getPlayer().getHand().isEmpty()) {
            System.out.println("Game Over !");
            Platform.exit();
        } else if (game.getFirstBot().getHand().isEmpty()
                && game.getSecondBot().getHand().isEmpty()
                && game.getThirdBot().getHand().isEmpty()) {
            System.out.println("Victory !");
            Platform.exit();
        }

        // set card images as null
        playerCardOneImage.setImage(null);
        playerCardTwoImage.setImage(null);
        firstBotCardOneImage.setImage(null);
        firstBotCardTwoImage.setImage(null);
        secondBotCardOneImage.setImage(null);
        secondBotCardTwoImage.setImage(null);
        thirdBotCardOneImage.setImage(null);
        thirdBotCardTwoImage.setImage(null);

        // set card images
        if (!game.getPlayer().getHand().isEmpty()) {
            if (game.getPlayer().getHand().size() == 2) {
                playerCardOneImage.setImage(game.getPlayer().getHand().get(0).getCardImage());
                playerCardTwoImage.setImage(game.getPlayer().getHand().get(1).getCardImage());
            }
            else {
                playerCardOneImage.setImage(game.getPlayer().getHand().get(0).getCardImage());
            }
        }

        if (!game.getFirstBot().getHand().isEmpty()) {
            if (game.getFirstBot().getHand().size() == 2) {
                firstBotCardOneImage.setImage(game.getFirstBot().getHand().get(0).getBackCardImage());
                firstBotCardTwoImage.setImage(game.getFirstBot().getHand().get(1).getBackCardImage());
            }
            else {
                firstBotCardOneImage.setImage(game.getFirstBot().getHand().get(0).getBackCardImage());
            }
        }

        if (!game.getSecondBot().getHand().isEmpty()) {
            if (game.getSecondBot().getHand().size() == 2) {
                secondBotCardOneImage.setImage(game.getSecondBot().getHand().get(0).getBackCardImage());
                secondBotCardTwoImage.setImage(game.getSecondBot().getHand().get(1).getBackCardImage());
            }
            else {
                secondBotCardOneImage.setImage(game.getSecondBot().getHand().get(0).getBackCardImage());
            }
        }

        if (!game.getThirdBot().getHand().isEmpty()) {
            if (game.getThirdBot().getHand().size() == 2) {
                thirdBotCardOneImage.setImage(game.getThirdBot().getHand().get(0).getBackCardImage());
                thirdBotCardTwoImage.setImage(game.getThirdBot().getHand().get(1).getBackCardImage());
            }
            else {
                thirdBotCardOneImage.setImage(game.getThirdBot().getHand().get(0).getBackCardImage());
            }
        }

        // set bot names
        firstTableBotLabel.setText(game.getFirstBot().getName());
        secondTableBotLabel.setText(game.getSecondBot().getName());
        thirdTableBotLabel.setText(game.getThirdBot().getName());

        // set turn
        if (game.getTurn() == 0)
            turnLabel.setText("Player");
        else if (game.getTurn() == 1)
            turnLabel.setText(game.getFirstBot().getName());
        else if (game.getTurn() == 2)
            turnLabel.setText(game.getSecondBot().getName());
        else
            turnLabel.setText(game.getThirdBot().getName());

        // set coins and deck cards number
        cardsInDeckLabel.setText(String.valueOf(game.getDeckCards().getDeck().size()));
        coinsInTreasuryLabel.setText(String.valueOf(game.getCoins()));
        playerCoinLabel.setText(String.valueOf(game.getPlayer().getCoin()));
        firstBotCoinLabel.setText(String.valueOf(game.getFirstBot().getCoin()));
        secondBotCoinLabel.setText(String.valueOf(game.getSecondBot().getCoin()));
        thirdBotCoinLabel.setText(String.valueOf(game.getThirdBot().getCoin()));

        // set out cards number
        dukeOutLabel.setText(String.valueOf(game.getOutDuke().size()));
        assassinOutLabel.setText(String.valueOf(game.getOutAssassin().size()));
        contessaOutLabel.setText(String.valueOf(game.getOutContessa().size()));
        captainOutLabel.setText(String.valueOf(game.getOutCaptain().size()));
        ambassadorOutLabel.setText(String.valueOf(game.getOutAmbassador().size()));

        // set buttons
        if (game.getTurn() == 0) {
            incomeButton.setDisable(false);
            foreignAidButton.setDisable(false);
            assassinateButton.setDisable(game.getPlayer().getCoin() < 3);
            taxButton.setDisable(false);
            stealButton.setDisable(false);
            exchangeButton.setDisable(false);
            newExchangeButton.setDisable(game.getPlayer().getCoin() < 1);
            challengeButton.setDisable(true);
            skipButton.setDisable(true);
            blockAssassinationButton.setDisable(true);
            blockForeignAidButton.setDisable(true);
            blockStealingButton.setDisable(true);
            coupButton.setDisable(game.getPlayer().getCoin() < 7);
            if (game.getPlayer().getCoin() >= 10) {
                incomeButton.setDisable(true);
                foreignAidButton.setDisable(true);
                assassinateButton.setDisable(true);
                taxButton.setDisable(true);
                stealButton.setDisable(true);
                exchangeButton.setDisable(true);
                newExchangeButton.setDisable(true);
                challengeButton.setDisable(true);
                skipButton.setDisable(true);
                blockAssassinationButton.setDisable(true);
                blockForeignAidButton.setDisable(true);
                blockStealingButton.setDisable(true);
            }
        } else {
            incomeButton.setDisable(true);
            foreignAidButton.setDisable(true);
            assassinateButton.setDisable(true);
            taxButton.setDisable(true);
            stealButton.setDisable(true);
            exchangeButton.setDisable(true);
            coupButton.setDisable(true);
            newExchangeButton.setDisable(true);
            skipButton.setDisable(false);
            if (game.getTurn() == 1) {
                challengeBotOrder = "firstBot";
                helpSetButton(game.getFirstBot());
            } else if (game.getTurn() == 2) {
                challengeBotOrder = "secondBot";
                helpSetButton(game.getSecondBot());
            } else {
                challengeBotOrder = "thirdBot";
                helpSetButton(game.getThirdBot());
            }
            game.botTurn();
            if (game.getBot3LastTarget() != null && !game.getBot3LastTarget().equals("player"))
                blockAssassinationButton.setDisable(true);
        }

        // set choice box
        whichLabel.setText("");
        whichChoiceBox.getItems().removeAll(whichChoiceBox.getItems());
        whichChoiceBox.setValue(null);
        whichChoiceBox.setVisible(false);

        if (game.getFirstBot().getName().equals(Bot.BotType.Bot2.toString())
                && !game.getFirstBot().getHand().isEmpty())
            botChallengerOrder = 1;
        else if (game.getSecondBot().getName().equals(Bot.BotType.Bot2.toString())
                && !game.getSecondBot().getHand().isEmpty())
            botChallengerOrder = 2;
        else if (game.getThirdBot().getName().equals(Bot.BotType.Bot2.toString())
                && !game.getThirdBot().getHand().isEmpty())
            botChallengerOrder = 3;
        else
            botChallengerOrder = 0;
    }

    private void helpSetButton(Bot bot) {

        // set buttons according to bot type
        if (bot.getName().equals(Bot.BotType.Bot1.toString())) {
            challengeButton.setDisable(bot.getCoin() > 6);
            blockForeignAidButton.setDisable(true);
            blockAssassinationButton.setDisable(true);
            blockStealingButton.setDisable(true);
            challengeType = "Duke";
        } else if (bot.getName().equals(Bot.BotType.Bot3.toString())) {
            boolean haveAssassin = false;
            boolean haveAmbassador = false;
            for (Card card : bot.getHand()) {
                if (card.getCardName().equals(CardName.Assassin))
                    haveAssassin = true;
                else if (card.getCardName().equals(CardName.Ambassador))
                    haveAmbassador = true;
                if (haveAssassin && bot.getCoin() > 2) {
                    challengeButton.setDisable(false);
                    blockForeignAidButton.setDisable(true);
                    blockAssassinationButton.setDisable(false);
                    blockStealingButton.setDisable(true);
                    challengeType = "Assassin";
                } else if (haveAssassin && bot.getCoin() < 3) {
                    challengeButton.setDisable(true);
                    blockForeignAidButton.setDisable(true);
                    blockAssassinationButton.setDisable(true);
                    blockStealingButton.setDisable(true);
                } else if (haveAmbassador) {
                    challengeButton.setDisable(false);
                    blockForeignAidButton.setDisable(true);
                    blockAssassinationButton.setDisable(true);
                    blockStealingButton.setDisable(true);
                    challengeType = "Ambassador";
                } else if (bot.getCoin() == 0) {
                    challengeButton.setDisable(true);
                    blockForeignAidButton.setDisable(false);
                    blockAssassinationButton.setDisable(true);
                    blockStealingButton.setDisable(true);
                } else {
                    challengeButton.setDisable(true);
                    blockForeignAidButton.setDisable(true);
                    blockAssassinationButton.setDisable(true);
                    blockStealingButton.setDisable(true);
                }
            }
        } else {
            challengeButton.setDisable(true);
            blockForeignAidButton.setDisable(true);
            blockAssassinationButton.setDisable(true);
            blockStealingButton.setDisable(true);
        }
    }

    public void challenge(ActionEvent event) {

        game.setAttackType("null");

        if (challengeType.equals("Duke"))
            challengeAction(CardName.Duke);
        else if (challengeType.equals("Assassin"))
            challengeAction(CardName.Assassin);
        else
            challengeAction(CardName.Ambassador);
    }

    private void challengeAction(CardName cardName) {

        if (challengeBotOrder.equals("firstBot")) {

            System.out.println(game.getPlayer().getName() + "->" + game.getFirstBot().getName() + ": Challenge");

            if (checkValidCard(game.getFirstBot(), cardName)) {

                game.fireCard(0);
                game.getFirstBot().getHand().add(game.getDeckCards().getDeck().get(0));
                game.getDeckCards().getDeck().add(game.getFirstBot().getHand().get(0));
                game.getFirstBot().getHand().remove(0);
                game.getDeckCards().getDeck().remove(0);
                Collections.shuffle(game.getDeckCards().getDeck());
                setTableInformation();

            } else {

                undoChallengeAction(cardName);
                game.fireCard(1);
                setTableInformation();
            }

        } else if (challengeBotOrder.equals("secondBot")) {

            System.out.println(game.getPlayer().getName() + "->" + game.getSecondBot().getName() + ": Challenge");

            if (checkValidCard(game.getSecondBot(), cardName)) {

                game.fireCard(0);
                game.getSecondBot().getHand().add(game.getDeckCards().getDeck().get(0));
                game.getDeckCards().getDeck().add(game.getSecondBot().getHand().get(0));
                game.getSecondBot().getHand().remove(0);
                game.getDeckCards().getDeck().remove(0);
                Collections.shuffle(game.getDeckCards().getDeck());
                setTableInformation();

            } else {

                undoChallengeAction(cardName);
                game.fireCard(2);
                setTableInformation();
            }

        } else {

            System.out.println(game.getPlayer().getName() + "->" + game.getThirdBot().getName() + ": Challenge");

            if (checkValidCard(game.getThirdBot(), cardName)) {

                game.fireCard(0);
                game.getThirdBot().getHand().add(game.getDeckCards().getDeck().get(0));
                game.getDeckCards().getDeck().add(game.getThirdBot().getHand().get(0));
                game.getThirdBot().getHand().remove(0);
                game.getDeckCards().getDeck().remove(0);
                Collections.shuffle(game.getDeckCards().getDeck());
                setTableInformation();

            } else {

                undoChallengeAction(cardName);
                game.fireCard(3);
                setTableInformation();
            }
        }
    }

    private void undoChallengeAction(CardName cardName) {

        if (challengeBotOrder.equals("firstBot")) {

            if (cardName.equals(CardName.Duke)) {

                game.getFirstBot().setCoin(game.getFirstBot().getCoin() - 3);
                game.setCoins(game.getCoins() + 3);

            } else if (cardName.equals(CardName.Assassin)) {

                game.getFirstBot().setCoin(game.getFirstBot().getCoin() + 3);
                game.setCoins(game.getCoins() - 3);
                undoAssassinationProcess();
                game.removeOutCards(game.getOutCards().get(game.getOutCards().size() - 1));
                game.getOutCards().remove(game.getOutCards().size() - 1);

            } else {

                game.getFirstBot().getHand().add(game.getDeckCards().getDeck().get(0));
                game.getFirstBot().getHand().add(game.getDeckCards().getDeck().get(1));
                game.getDeckCards().getDeck().add(game.getFirstBot().getHand().get(0));
                game.getDeckCards().getDeck().add(game.getFirstBot().getHand().get(1));
                game.getFirstBot().getHand().remove(0);
                game.getFirstBot().getHand().remove(0);
                game.getDeckCards().getDeck().remove(0);
                game.getDeckCards().getDeck().remove(0);
            }

        } else if (challengeBotOrder.equals("secondBot")) {

            if (cardName.equals(CardName.Duke)) {

                game.getSecondBot().setCoin(game.getSecondBot().getCoin() - 3);
                game.setCoins(game.getCoins() + 3);

            } else if (cardName.equals(CardName.Assassin)) {

                game.getSecondBot().setCoin(game.getSecondBot().getCoin() + 3);
                game.setCoins(game.getCoins() - 3);
                undoAssassinationProcess();
                game.removeOutCards(game.getOutCards().get(game.getOutCards().size() - 1));
                game.getOutCards().remove(game.getOutCards().size() - 1);

            } else {

                game.getSecondBot().getHand().add(game.getDeckCards().getDeck().get(0));
                game.getSecondBot().getHand().add(game.getDeckCards().getDeck().get(1));
                game.getDeckCards().getDeck().add(game.getSecondBot().getHand().get(0));
                game.getDeckCards().getDeck().add(game.getSecondBot().getHand().get(1));
                game.getSecondBot().getHand().remove(0);
                game.getSecondBot().getHand().remove(0);
                game.getDeckCards().getDeck().remove(0);
                game.getDeckCards().getDeck().remove(0);
            }

        } else {

            if (cardName.equals(CardName.Duke)) {

                game.getThirdBot().setCoin(game.getThirdBot().getCoin() - 3);
                game.setCoins(game.getCoins() + 3);

            } else if (cardName.equals(CardName.Assassin)) {

                game.getThirdBot().setCoin(game.getThirdBot().getCoin() + 3);
                game.setCoins(game.getCoins() - 3);
                undoAssassinationProcess();
                game.removeOutCards(game.getOutCards().get(game.getOutCards().size() - 1));
                game.getOutCards().remove(game.getOutCards().size() - 1);

            } else {

                game.getThirdBot().getHand().add(game.getDeckCards().getDeck().get(0));
                game.getThirdBot().getHand().add(game.getDeckCards().getDeck().get(1));
                game.getDeckCards().getDeck().add(game.getThirdBot().getHand().get(0));
                game.getDeckCards().getDeck().add(game.getThirdBot().getHand().get(1));
                game.getThirdBot().getHand().remove(0);
                game.getThirdBot().getHand().remove(0);
                game.getDeckCards().getDeck().remove(0);
                game.getDeckCards().getDeck().remove(0);
            }
        }
    }

    private boolean checkValidCard(Player player, CardName cardName) {

        for (Card card : player.getHand()) {
            if (card.getCardName().equals(cardName)) {
                return true;
            }
        }
        return false;
    }

    public void income(ActionEvent event) {

        System.out.println(game.getPlayer().getName() + "->" + "BANK" + ": Income");

        game.getPlayer().income();
        game.setCoins(game.getCoins() - 1);
        game.nextTurn();
        setTableInformation();
    }

    public void foreignAid(ActionEvent event) {

        System.out.println(game.getPlayer().getName() + "->" + "BANK" + ": Foreign Aid");

        game.getPlayer().foreignAid();
        game.setCoins(game.getCoins() - 2);
        game.nextTurn();
        setTableInformation();
    }

    public void tax(ActionEvent event) {

        game.setAttackType("null");

        System.out.println(game.getPlayer().getName() + "->" + "BANK" + ": Tax");

        if (game.isBot2ShouldChallenge() && botChallengerOrder != 0) {

            if (botChallengerOrder == 1)
                System.out.println(game.getFirstBot().getName() + "->" + game.getPlayer().getName() + ": Challenge");
            else if (botChallengerOrder == 2)
                System.out.println(game.getSecondBot().getName() + "->" + game.getPlayer().getName() + ": Challenge");
            else
                System.out.println(game.getThirdBot().getName() + "->" + game.getPlayer().getName() + ": Challenge");

            if (checkValidCard(game.getPlayer(), CardName.Duke)) {

                game.getPlayer().tax();
                game.setCoins(game.getCoins() - 3);
                game.nextTurn();
                game.fireCard(botChallengerOrder);

            } else {

                game.nextTurn();
                game.fireCard(0);
            }

            game.setBot2ShouldChallenge(!game.isBot2ShouldChallenge());
            setTableInformation();

        } else {

            game.setBot2ShouldChallenge(!game.isBot2ShouldChallenge());
            game.getPlayer().tax();
            game.setCoins(game.getCoins() - 3);
            game.nextTurn();
            setTableInformation();
        }
    }

    public void assassinate(ActionEvent event) {

        if (!whichChoiceBox.isVisible()) {

            whichLabel.setText("Which Bot ?");
            for (Bot bot : game.getBots()) {
                whichChoiceBox.getItems().add(bot.getName());
            }
            whichChoiceBox.setOnAction(this::assassinate);
            whichChoiceBox.setVisible(true);

            incomeButton.setDisable(true);
            foreignAidButton.setDisable(true);
            assassinateButton.setDisable(true);
            taxButton.setDisable(true);
            stealButton.setDisable(true);
            exchangeButton.setDisable(true);
            newExchangeButton.setDisable(true);
            coupButton.setDisable(true);

        } else if (whichChoiceBox.getValue() != null) {

            game.setAttackType("assassinate");
            System.out.print(game.getPlayer().getName() + "->");

            if (whichChoiceBox.getValue().equals(game.getFirstBot().getName())) {

                game.fireCard(1);

            } else if (whichChoiceBox.getValue().equals(game.getSecondBot().getName())) {

                game.fireCard(2);

            } else {

                game.fireCard(3);
            }

            game.getPlayer().setCoin(game.getPlayer().getCoin() - 3);
            game.setCoins(game.getCoins() + 3);
            game.nextTurn();
            setTableInformation();
        }
    }

    public void steal(ActionEvent event) {

        if (!whichChoiceBox.isVisible()) {

            whichLabel.setText("Which Bot ?");
            for (Bot bot : game.getBots()) {
                whichChoiceBox.getItems().add(bot.getName());
            }
            whichChoiceBox.setOnAction(this::steal);
            whichChoiceBox.setVisible(true);

            incomeButton.setDisable(true);
            foreignAidButton.setDisable(true);
            assassinateButton.setDisable(true);
            taxButton.setDisable(true);
            stealButton.setDisable(true);
            exchangeButton.setDisable(true);
            newExchangeButton.setDisable(true);
            coupButton.setDisable(true);

        } else if (whichChoiceBox.getValue() != null) {

            if (whichChoiceBox.getValue().equals(game.getFirstBot().getName())) {

                System.out.println(game.getPlayer().getName() + "->" + game.getFirstBot().getName() + ": Steal");

                if (game.getFirstBot().getCoin() >= 2) {
                    game.getPlayer().foreignAid();
                    game.getFirstBot().setCoin(game.getFirstBot().getCoin() - 2);
                } else if (game.getFirstBot().getCoin() == 1) {
                    game.getPlayer().income();
                    game.getFirstBot().setCoin(game.getFirstBot().getCoin() - 1);
                }

            } else if (whichChoiceBox.getValue().equals(game.getSecondBot().getName())) {

                System.out.println(game.getPlayer().getName() + "->" + game.getSecondBot().getName() + ": Steal");

                if (game.getSecondBot().getCoin() >= 2) {
                    game.getPlayer().foreignAid();
                    game.getSecondBot().setCoin(game.getSecondBot().getCoin() - 2);
                } else if (game.getSecondBot().getCoin() == 1) {
                    game.getPlayer().income();
                    game.getSecondBot().setCoin(game.getSecondBot().getCoin() - 1);
                }

            } else {

                System.out.println(game.getPlayer().getName() + "->" + game.getThirdBot().getName() + ": Steal");

                if (game.getThirdBot().getCoin() >= 2) {
                    game.getPlayer().foreignAid();
                    game.getThirdBot().setCoin(game.getThirdBot().getCoin() - 2);
                } else if (game.getThirdBot().getCoin() == 1) {
                    game.getPlayer().income();
                    game.getThirdBot().setCoin(game.getThirdBot().getCoin() - 1);
                }
            }

            game.nextTurn();
            setTableInformation();
        }
    }

    public void exchange(ActionEvent event) {

        game.setAttackType("null");

        System.out.println(game.getPlayer().getName() + "->" + "DECK" + ": Exchange");

        if (game.isBot2ShouldChallenge() && botChallengerOrder != 0) {

            if (botChallengerOrder == 1)
                System.out.println(game.getFirstBot().getName() + "->" + game.getPlayer().getName() + ": Challenge");
            else if (botChallengerOrder == 2)
                System.out.println(game.getSecondBot().getName() + "->" + game.getPlayer().getName() + ": Challenge");
            else
                System.out.println(game.getThirdBot().getName() + "->" + game.getPlayer().getName() + ": Challenge");

            if (checkValidCard(game.getPlayer(), CardName.Ambassador)) {

                game.getPlayer().getHand().add(game.getDeckCards().getDeck().get(0));
                game.getPlayer().getHand().add(game.getDeckCards().getDeck().get(1));
                game.getDeckCards().getDeck().add(game.getPlayer().getHand().get(0));
                game.getDeckCards().getDeck().add(game.getPlayer().getHand().get(1));
                game.getPlayer().getHand().remove(0);
                game.getPlayer().getHand().remove(0);
                game.getDeckCards().getDeck().remove(0);
                game.getDeckCards().getDeck().remove(0);
                Collections.shuffle(game.getDeckCards().getDeck());
                game.nextTurn();
                game.fireCard(botChallengerOrder);

            } else {

                game.nextTurn();
                game.fireCard(0);
            }

            game.setBot2ShouldChallenge(!game.isBot2ShouldChallenge());
            setTableInformation();

        } else {

            game.getPlayer().getHand().add(game.getDeckCards().getDeck().get(0));
            game.getPlayer().getHand().add(game.getDeckCards().getDeck().get(1));
            game.getDeckCards().getDeck().add(game.getPlayer().getHand().get(0));
            game.getDeckCards().getDeck().add(game.getPlayer().getHand().get(1));
            game.getPlayer().getHand().remove(0);
            game.getPlayer().getHand().remove(0);
            game.getDeckCards().getDeck().remove(0);
            game.getDeckCards().getDeck().remove(0);
            Collections.shuffle(game.getDeckCards().getDeck());
            game.nextTurn();
            game.setBot2ShouldChallenge(!game.isBot2ShouldChallenge());
            setTableInformation();
        }
    }

    public void coup(ActionEvent event) {

        if (!whichChoiceBox.isVisible()) {

            whichLabel.setText("Which Bot ?");
            for (Bot bot : game.getBots()) {
                whichChoiceBox.getItems().add(bot.getName());
            }
            whichChoiceBox.setOnAction(this::coup);
            whichChoiceBox.setVisible(true);

            incomeButton.setDisable(true);
            foreignAidButton.setDisable(true);
            assassinateButton.setDisable(true);
            taxButton.setDisable(true);
            stealButton.setDisable(true);
            exchangeButton.setDisable(true);
            newExchangeButton.setDisable(true);
            coupButton.setDisable(true);

        } else if (whichChoiceBox.getValue() != null) {

            game.setAttackType("assassin");
            System.out.print(game.getPlayer().getName() + "->");

            if (whichChoiceBox.getValue().equals(game.getFirstBot().getName())) {

                game.fireCard(1);

            } else if (whichChoiceBox.getValue().equals(game.getSecondBot().getName())) {

                game.fireCard(2);

            } else {

                game.fireCard(3);
            }

            game.getPlayer().setCoin(game.getPlayer().getCoin() - 7);
            game.setCoins(game.getCoins() + 7);
            game.nextTurn();
            setTableInformation();
        }
    }

    public void blockForeignAid(ActionEvent event) {

        System.out.println(game.getPlayer().getName() + "->" + "Bot3" + ": Block Assassination");

        switch (challengeBotOrder) {

            case "firstBot":

                game.getFirstBot().setCoin(game.getFirstBot().getCoin() - 2);
                game.setCoins(game.getCoins() + 2);
                break;

            case "secondBot":

                game.getSecondBot().setCoin(game.getSecondBot().getCoin() - 2);
                game.setCoins(game.getCoins() + 2);
                break;

            case "thirdBot":

                game.getThirdBot().setCoin(game.getThirdBot().getCoin() - 2);
                game.setCoins(game.getCoins() + 2);
                break;
        }
        setTableInformation();
    }

    public void blockStealing(ActionEvent event) {

        switch (challengeBotOrder) {

            case "firstBot":

                game.getFirstBot().setCoin(game.getFirstBot().getCoin() - 2);
                game.getPlayer().setCoin(game.getPlayer().getCoin() + 2);
                break;

            case "secondBot":

                game.getSecondBot().setCoin(game.getSecondBot().getCoin() - 2);
                game.getPlayer().setCoin(game.getPlayer().getCoin() + 2);
                break;

            case "thirdBot":

                game.getThirdBot().setCoin(game.getThirdBot().getCoin() - 2);
                game.getPlayer().setCoin(game.getPlayer().getCoin() + 2);
                break;
        }
        setTableInformation();
    }

    public void blockAssassination(ActionEvent event) {

        System.out.println(game.getPlayer().getName() + "->" + "Bot3" + ": Block Assassination");

        if (game.getBot3LastTarget().equals("player")) {
            game.getPlayer().getHand().add(game.getOutCards().get(game.getOutCards().size() - 1));
            game.removeOutCards(game.getOutCards().get(game.getOutCards().size() - 1));
            game.getOutCards().remove(game.getOutCards().size() - 1);
        }
        setTableInformation();
    }

    private void undoAssassinationProcess() {

        switch (game.getBot3LastTarget()) {

            case "player":

                game.getPlayer().getHand().add(game.getOutCards().get(game.getOutCards().size() - 1));
                break;

            case "firstBot":

                game.getFirstBot().getHand().add(game.getOutCards().get(game.getOutCards().size() - 1));
                break;

            case "secondBot":

                game.getSecondBot().getHand().add(game.getOutCards().get(game.getOutCards().size() - 1));
                break;

            case "thirdBot":

                game.getThirdBot().getHand().add(game.getOutCards().get(game.getOutCards().size() - 1));
                break;
        }
    }

    public void newExchange(ActionEvent event) {

        if (!whichChoiceBox.isVisible()) {

            whichLabel.setText("Which Card ?");
            whichChoiceBox.getItems().addAll(game.getPlayer().getHand().get(0).getCardName().toString(),
                    game.getPlayer().getHand().get(1).getCardName().toString());
            whichChoiceBox.setOnAction(this::newExchange);
            whichChoiceBox.setVisible(true);

            incomeButton.setDisable(true);
            foreignAidButton.setDisable(true);
            assassinateButton.setDisable(true);
            taxButton.setDisable(true);
            stealButton.setDisable(true);
            exchangeButton.setDisable(true);
            newExchangeButton.setDisable(true);
            coupButton.setDisable(true);

        } else if (whichChoiceBox.getValue() != null) {

            System.out.println(game.getPlayer().getName() + "->" + "DECK" + ": New Exchange");

            if (whichChoiceBox.getValue().equals(game.getPlayer().getHand().get(0).getCardName().toString())) {

                game.getPlayer().getHand().add(game.getDeckCards().getDeck().get(0));
                game.getDeckCards().getDeck().add(game.getPlayer().getHand().get(0));
                game.getPlayer().getHand().remove(0);
                game.getDeckCards().getDeck().remove(0);
                Collections.shuffle(game.getDeckCards().getDeck());

            } else {

                game.getPlayer().getHand().add(game.getDeckCards().getDeck().get(0));
                game.getDeckCards().getDeck().add(game.getPlayer().getHand().get(1));
                game.getPlayer().getHand().remove(1);
                game.getDeckCards().getDeck().remove(0);
                Collections.shuffle(game.getDeckCards().getDeck());
            }

            game.getPlayer().setCoin(game.getPlayer().getCoin() - 1);
            game.setCoins(game.getCoins() + 1);
            game.nextTurn();
            setTableInformation();
        }
    }

    public void skip(ActionEvent event) {

        Collections.shuffle(game.getDeckCards().getDeck());
        setTableInformation();
    }
}

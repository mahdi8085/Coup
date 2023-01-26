package MODEL;

public class Bot extends Player{

    public enum BotType {
        Bot1,
        Bot2,
        Bot3,
        Bot4
    }

    public Bot(BotType botType) {
        super();
        this.setName(botType.toString());
    }
}

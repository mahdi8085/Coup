package MODEL;

public enum CardName {
    Duke (0),
    Assassin (1),
    Contessa (2),
    Captain (3),
    Ambassador (4);

    private final int value;

    CardName(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

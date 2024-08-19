package mandy.app;

public enum Suit {
    DIAMONDS("Diamonds"),
    HEARTS("Hearts"),
    CLUBS("Clubs"),
    SPADES("Spades");
    private final String text;
    Suit(String text) {
        this.text = text;
    }
    public String toString() {
        return text;
    }
}

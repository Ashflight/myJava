package mandy.app;

public class Blackjack {
    private final Deck deck;
    private final Player player;
    private final Dealer dealer;

    public Blackjack(Deck deck, Player player, Dealer dealer) {
        this.deck = deck;
        this.player = player;
        this.dealer = dealer;
    }
    //this class may eventually be deleted if it's not needed.
}

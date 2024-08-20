package mandy.app;
import static mandy.app.Result.*;

public class Blackjack {
    private final Deck deck;
    private final Dealer dealer;
    private final Player player;
    public Blackjack() {
        deck = new Deck();
        dealer = new Dealer(deck);
        player = new Player(deck);
    }
    public Result playerTurn(String input) {
        return player.playTurn(input, deck);
    }
    public Result dealerTurn() {
        return dealer.playTurn(deck, player.getScore());
    }
    public Result compareScores() {
        if (player.getScore() > dealer.getScore()) {
            return WIN;
        }
        else if (player.getScore() < dealer.getScore()) {
            return BUST;
        }
        else {
            return TIE;
        }
    }
    public Dealer getDealer() {
        return dealer;
    }
    public Player getPlayer() {
        return player;
    }
}

package mandy.app;
import static mandy.app.Result.*;

public class Blackjack {
    private Deck deck;
    private Dealer dealer;
    private Player player;
    public Blackjack() {
        deck = new Deck();
        dealer = new Dealer(deck);
        player = new Player(deck);
    }
    public void display() {
        System.out.println("The dealer has: " + dealer.getPrintableHand());
        System.out.println("You have: " + player.getPrintableHand());
    }
    public Result playerTurn(String input) {
        player.playTurn(input, deck);
        if (player.getScore() > 21) {
            return BUST;
        }
        else if (player.getScore() == 21) {
            return WIN;
        }
        else return CONTINUE;
    }
    public Result dealerTurn() {
        do {
            dealer.hit(deck);
        } while (dealer.getScore() < 17);
        display();
        if (dealer.getScore() > 21) {
            return BUST;
        }
        else if (dealer.getScore() == 21) {
            return WIN;
        }
        else return CONTINUE;
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
}

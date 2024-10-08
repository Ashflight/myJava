package mandy.app;

import java.util.ArrayList;
import java.util.Collections;
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

    public Blackjack(Deck deck, Player player, Dealer dealer) {
        this.deck = deck;
        this.player = player;
        this.dealer = dealer;
    }
    public Result playerTurn(String input) {
        return player.playTurn(input, deck);
    }
    public Result dealerTurn() {
        return dealer.playTurn(deck, player.getScore());
    }
    public boolean checkBlackjack() {
        ArrayList<String> case1 = new ArrayList<>();
        case1.add("Ace of Spades");
        case1.add("Jack of Spades");
        ArrayList<String> case2 = new ArrayList<>();
        case2.add("Ace of Spades");
        case2.add("Jack of Clubs");
        ArrayList<String> holder = player.getPrintableHand();
        Collections.sort(holder);
        return holder.equals(case1) || holder.equals(case2);
    }
    public Dealer getDealer() {
        return dealer;
    }
    public Player getPlayer() {
        return player;
    }
    public Result getPlayerResult() {
        if (checkBlackjack()) {
            return BLACKJACK;
        }
        else if (player.getScore() == 21) {
            return WIN;
        }
        return CONTINUE;
    }
}
package mandy.app;

import java.util.Scanner;

public class Blackjack {
    Deck deck = new Deck();
    Dealer dealer = new Dealer(deck);
    Player player = new Player(deck);
}

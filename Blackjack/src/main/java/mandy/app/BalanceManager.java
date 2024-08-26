package mandy.app;

import static mandy.app.Result.*;

public class BalanceManager {
    private int balance;
    private int bet;
    public BalanceManager(int balance) {
        this.balance = balance;
    }
    public int getBalance() {
        return balance;
    }
    public void setBet(int newBet) {
        this.bet = newBet;
    }
    public int getBet() {
        return bet;
    }
    public int updateBalance(Result result) {
        if (result == WIN) {
            balance = balance + bet;
        }
        else if (result == BUST) {
            balance = balance - bet;
        }
        else if (result == BLACKJACK) {
            balance = balance + 10*bet;
        }
        return balance;
    }
    public boolean checkBalance() {
        if (balance < 1) {
            return true;
        }
        return false;
    }
}

package mandy.app;

import org.junit.jupiter.api.Test;
import static mandy.app.Result.*;
import static org.junit.jupiter.api.Assertions.*;

public class BalanceManagerTest {
    @Test
    public void testBalanceManagerInit() {
        BalanceManager balanceManager = new BalanceManager(10);
        assertEquals(10, balanceManager.getBalance());
        assertEquals(0, balanceManager.getBet());
    }
    @Test
    public void testSetBet() {
        BalanceManager balanceManager = new BalanceManager(10);
        balanceManager.setBet(3);
        assertEquals(3, balanceManager.getBet());
    }
    @Test
    public void testUpdateBalanceBlackjack() {
        BalanceManager balanceManager = new BalanceManager(10);
        balanceManager.setBet(3);
        assertEquals(40, balanceManager.updateBalance(BLACKJACK));
        assertEquals(40, balanceManager.getBalance());
    }
    @Test
    public void testUpdateBalanceWin() {
        BalanceManager balanceManager = new BalanceManager(10);
        balanceManager.setBet(3);
        assertEquals(13, balanceManager.updateBalance(WIN));
        assertEquals(13, balanceManager.getBalance());
    }
    @Test
    public void testUpdateBalanceLose() {
        BalanceManager balanceManager = new BalanceManager(10);
        balanceManager.setBet(3);
        assertEquals(7, balanceManager.updateBalance(BUST));
        assertEquals(7, balanceManager.getBalance());
    }
    @Test
    public void testUpdateBalanceTie() {
        BalanceManager balanceManager = new BalanceManager(10);
        balanceManager.setBet(3);
        assertEquals(10, balanceManager.updateBalance(TIE));
        assertEquals(10, balanceManager.getBalance());
    }
    @Test
    public void testUpdateBalanceContinue() {
        BalanceManager balanceManager = new BalanceManager(10);
        balanceManager.setBet(3);
        assertEquals(10, balanceManager.updateBalance(CONTINUE));
        assertEquals(10, balanceManager.getBalance());
    }
    @Test
    public void testCheckBalanceFalse() {
        BalanceManager balanceManager = new BalanceManager(10);
        assertFalse(balanceManager.checkBalance());
    }
    @Test
    public void testCheckBalanceTrue() {
        BalanceManager balanceManager = new BalanceManager(10);
        balanceManager.setBet(10);
        balanceManager.updateBalance(BUST);
        assertTrue(balanceManager.checkBalance());
    }
}

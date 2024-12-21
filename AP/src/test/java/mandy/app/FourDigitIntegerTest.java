package mandy.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FourDigitIntegerTest {

    @Test
    void isOdd() {
    }

    @Test
    void isPalindrome() {
    }

    @Test
    void isPalindromeIterative() {
        int example = 1221;
        FourDigitInteger tester = new FourDigitInteger(example);
        assertTrue(tester.isPalindromeIterative());
        example = 1222;
        FourDigitInteger tester2 = new FourDigitInteger(example);
        assertTrue(!tester2.isPalindromeIterative());
        // CURSED 5 DIGIT VERSION
        example = 12121;
        FourDigitInteger tester3 = new FourDigitInteger(example);
        assertTrue(tester3.isPalindromeIterative());
    }

    @Test
    void testIsPalindromeRecursive() {
        int example = 1221;
        FourDigitInteger tester = new FourDigitInteger(example);
        assertTrue(tester.isPalindromeRecursive());
        example = 1222;
        FourDigitInteger tester2 = new FourDigitInteger(example);
        assertTrue(!tester2.isPalindromeRecursive());
        // CURSED 5 DIGIT VERSION
        example = 12121;
        FourDigitInteger tester3 = new FourDigitInteger(example);
        assertTrue(tester3.isPalindromeRecursive());
    }

    @Test
    void isPerfectSquare() {
    }
}
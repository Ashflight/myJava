package mandy.app;

public class FourDigitInteger {
    private int value;

    public FourDigitInteger (int aValue)
    {
        value = aValue;
    }

    /** Return true if value is odd, false otherwise. */
    public boolean isOdd()
    {
        // To be implemented in part (a)
        // My Answer:
        return (value % 2 == 1);
    }

    /** Return true if value is a palindrome number, as described
     *  in part (b). Return false otherwise.
     */
    public boolean isPalindrome()
    {
        // To be implemented in part (b)
        //My Answer:
        String valueString = "" + value;
        return valueString.substring(0,1).equals(valueString.substring(3,4)) &&
                valueString.substring(1,2).equals(valueString.substring(2,3));
        // Not the solution suggested by the textbook but still functional.
    }

    // These 2? 3? functions were a later addition, outside the given questions.

    public boolean isPalindromeButBetter(String data)
    {
        int start = 0;
        int end = data.length() - 1;
        while (start < end) {
            if (data.charAt(start) != data.charAt(end)) { // discovery of charAt is a lifesaver, no more ugly complicated substrings
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeRecursive(String data)
    {
        return isPalindromeRecursive(data, 0, data.length());
    }

    public boolean isPalindromeRecursive(String data, int start, int end)
    {
        if (start < end && data.charAt(start) == data.charAt(end)) {
            start++;
            end--;
            return isPalindromeRecursive(data, start, end);
        }
        if (start < end) {
            return false;
        }
        return true;
    }

    /** Return true if value is a perfect square, false otherwise. */
    public boolean isPerfectSquare()
    {
        // To be implemented in part (c)
        // My Answer:
        for (int i = 32; i < 100; i++) {
            if (value == i * i) {
                return true;
            }
        }
        return false;
    }
}

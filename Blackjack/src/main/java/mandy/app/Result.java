package mandy.app;

public enum Result {
    WIN, BUST, CONTINUE, TIE, BLACKJACK;

    public static Result flipResult(Result result) {
        if (result == WIN) {
            return BUST;
        }
        else if (result == BUST) {
            return WIN;
        }
        return result;
    }

    public static boolean isRoundTerminated(Result result) {
        return result != CONTINUE;
    }
}

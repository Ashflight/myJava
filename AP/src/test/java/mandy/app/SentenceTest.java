package mandy.app;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SentenceTest {

    @Test
    void getBlankPositions() {
    }

    @Test
    void getBlankPositionsButBetter() {
        String example = "abcd efg.";
        Sentence sentence = new Sentence(example);
        List<Integer> expected = List.of(4);
        assertEquals(expected, sentence.getBlankPositionsButBetter());
    }

    @Test
    void countWords() {
    }

    @Test
    void getWords() {
    }
}
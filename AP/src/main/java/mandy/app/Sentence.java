package mandy.app;

import java.util.ArrayList;

public class Sentence {
    /* The sentence to manipulate */
    private String sentence;

    /** Return an ArrayList of integer positions containing a
     *  blank in this sentence. If there are no blanks in the
     *  sentence, returns an empty list.
     */
    public ArrayList<Integer> getBlankPositions()
    {
        // To be implemented in part (a)
        // My Answer:
        ArrayList<Integer> blanks = new ArrayList<Integer>();
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.substring(i, i+1).equals(" ")) {
                blanks.add(i);
            }
        }
        return blanks;
    }

    /** Return the number of words in this sentence
     *  Precondition: Sentence contains at least one word
     */
    public int countWords()
    {
        // Implementation not shown
        // Following implementation is a filler I made for potential testing
        String[] words = sentence.split(" ");
        return words.length;
    }

    /** Returns the array of words in this sentence.
     *  Preconditions:
     *   - Any two words in the sentence are separated by one blank.
     *   - The sentence contains at least one word.
     *  Postcondition: String[] contains the words in this sentence.
     */
    public String[] getWords()
    {
        // To be implemented in part (b)
        // My Answer:
        String[] words = new String[countWords()];
        ArrayList<Integer> blanks = getBlankPositions();
        // The following if statement to deal with 1-word sentence scenarios was not in my original answer,
        // which would cause the line after to throw an index out of bounds error for 1-word sentences.
        if (blanks.size() == 0) {
            words[0] = sentence;
            return words;
        }
        words[0] = sentence.substring(0, blanks.get(0));
        for (int i = 1; i <= blanks.size(); i++) {
            words[i] = sentence.substring(blanks.get(i-1) + 1, blanks.get(i));
        }
        // My original answer had an error where I had a < in the for loop condition instead of a <= which would cause the last word to not be counted
        return words;
    }

    // Constructor and other methods are not shown.
    // The following constructor is a filler I made for potential testing
    public Sentence(String sentence) {
        this.sentence = sentence;
    }
}

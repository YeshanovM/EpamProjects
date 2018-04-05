package model.entity;

import model.entity.enums.SentenceType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SentenceTest {

    private static final String[] STRINGS = {
            "  Quick  ?  ",
            " Yes!",
            "   No  , not   quick  \n,  o'kay ?    ",
            "O'kay."
    };

    private Sentence<SentenceUnit>[] sentences;

    @Before
    public void setUp() {
        sentences = new Sentence[STRINGS.length];
        for(int i = 0; i < STRINGS.length; i++) {
            sentences[i] = new Sentence<>(STRINGS[i]);
        }
    }

    @Test
    public void getStringRepresentationTest() {
        String[] expected = {
                "Quick?",
                "Yes!",
                "No, not quick, o'kay?",
                "O'kay."
        };
        for(int i = 0; i < STRINGS.length; i++) {
            assertTrue(sentences[i].getStringRepresentation().equals(expected[i]));
        }
    }

    @Test
    public void getTypeTest() {
        SentenceType[] expected = {
                SentenceType.INTERROGATIVE,
                SentenceType.EXCLAMATORY,
                SentenceType.INTERROGATIVE,
                SentenceType.AFFIRMATIVE,
        };
        for(int i = 0; i < STRINGS.length; i++) {
            assertTrue(sentences[i].getType() == expected[i]);
        }
    }

    @Test
    public void getUnitsTest() {
        SentenceUnit[] expected = {
                new Word("No"),
                new Punctuation(","),
                new Word("not"),
                new Word("quick"),
                new Punctuation(","),
                new Word("o'kay"),
                new Punctuation("?")
        };
        assertArrayEquals(expected, sentences[2].getUnits());
    }
}
package model;

import model.entity.Sentence;
import model.entity.SentenceUnit;
import model.entity.enums.SentenceType;
import org.junit.*;

import static org.junit.Assert.*;

public class ModelTest {

    private static Model model;
    private static Sentence<SentenceUnit>[] sentences;

    @BeforeClass
    public static void setUp() throws Exception {
        model = new Model();
        sentences = new Sentence[] {
                new Sentence("Quick brown fox."),
                new Sentence("Quick brown fox jumps over the lazy dog?"),
        };
    }

    @Test
    public void getWordsByLengthTest() {
        assertArrayEquals(new String[] {
                "Quick",
                "brown",
                "jumps"
                },
                model.getWordsByLength(sentences, 5));
    }

    @Test
    public void getInterrogativeSentencesTest() {
        assertArrayEquals(new Sentence[] {sentences[1]},
                model.getSentencesByType(sentences, SentenceType.INTERROGATIVE));
    }
}
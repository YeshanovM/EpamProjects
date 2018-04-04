package model.entity;

import model.entity.enums.SentenceType;

import java.util.*;

public class Sentence<E extends SentenceUnit> {
    private List<E> units;
    private SentenceType type;

    public Sentence() {
    }

    public Sentence(String sentence) {
        remake(sentence);
    }

    public void remake(String sentence) {
        units = new LinkedList<>();
        String[] splittedSentence = sentence.trim().split("\\s+");
        for(String word : splittedSentence) {
            if(word.substring(word.length() - 1).matches("[,;\\-:.?!]")) {
                Word w = new Word(word.substring(0, word.length() - 1));
                units.add((E)w);
                Punctuation p = new Punctuation(word.substring(word.length() - 1, word.length() - 1));
                units.add((E)p);
            }
            else {
                units.add((E)(new Word(word)));
            }
        }
        switch (sentence.charAt(sentence.length() - 1)) {
            case '?':
                type = SentenceType.INTERROGATIVE;
                break;
            case '!':
                type = SentenceType.EXCLAMATORY;
                break;
            default:
                type = SentenceType.AFFIRMATIVE;
                break;
        }
    }

    public List<E> getUnits() {
        return units;
    }
}

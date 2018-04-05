package model.entity;

import model.entity.enums.SentenceType;

import java.util.*;

public class Sentence<E extends SentenceUnit> {
    private List<E> units;
    private SentenceType type;

    public Sentence() {
    }

    public Sentence(String sentence) {
        make(sentence);
    }

    private void make(String sentence) {
        units = new LinkedList<>();
        String[] splittedSentence = sentence.trim().split("\\s+");
        for(String word : splittedSentence) {
            if(word.substring(word.length() - 1).matches("[,;\\-:.?!]")) {
                if(word.length() > 1) {
                    Word w = new Word(word.substring(0, word.length() - 1));
                    units.add((E) w);
                }
                Punctuation p = new Punctuation(word.substring(word.length() - 1, word.length()));
                units.add((E)p);
            }
            else {
                units.add((E)(new Word(word)));
            }
        }
        switch (units.get(units.size() - 1).getValue().charAt(0)) {
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

    public E[] getUnits() {
        SentenceUnit[] result = new SentenceUnit[units.size()];
        int i = 0;
        for(E unit : units) {
            result[i] = unit;
            i++;
        }
        return (E[]) result;
    }

    public SentenceType getType() {
        return type;
    }

    public String getStringRepresentation() {
        StringBuffer stringBuffer = new StringBuffer();
        for(SentenceUnit unit : units) {
            if(!unit.equals(units.get(0)) && unit instanceof Word)
                stringBuffer.append(" ");
            stringBuffer.append(unit.getValue());
        }
        return stringBuffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;
        Sentence<?> sentence = (Sentence<?>) o;
        return Objects.equals(units, sentence.units) &&
                type == sentence.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(units, type);
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "units=" + units +
                ", type=" + type +
                '}';
    }
}

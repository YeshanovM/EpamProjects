package model.entity;

import java.util.Objects;

public class Punctuation extends SentenceUnit {

    public Punctuation() {
        super();
    }

    public Punctuation(String value) {
        super(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return getValue().equals(word.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public String toString() {
        return "Punctuation{" +
                "value=" + getValue() +
                "}";
    }
}

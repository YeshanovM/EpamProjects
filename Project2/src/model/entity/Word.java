package model.entity;

import java.util.Objects;

public class Word extends SentenceUnit {

    int length;

    public Word() {
        super();
    }

    public Word(String value) {
        super(value);
        length = value.length();
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return length == word.length &&
                getValue().equals(word.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, getValue());
    }

    @Override
    public String toString() {
        return "Word{" +
                "length=" + length +
                "value=" + getValue() +
                '}';
    }
}

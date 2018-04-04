package model.entity;

public abstract class SentenceUnit implements Comparable {
    private String value;

    public SentenceUnit() {
    }

    public SentenceUnit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public abstract String toString();

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public int compareTo(Object o) {
        return getValue().compareTo(((SentenceUnit)o).getValue());
    }
}

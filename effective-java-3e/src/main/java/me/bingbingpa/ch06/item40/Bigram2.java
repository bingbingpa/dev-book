package me.bingbingpa.ch06.item40;

public class Bigram2 {
    private final char first;
    private final char second;

    public Bigram2(char first, char second) {
        this.first = first;
        this.second = second;
    }

    @Override public boolean equals(Object o) {
        if (!(o instanceof Bigram2)) {
            return false;
        }
        Bigram2 b = (Bigram2) o;
        return b.first == first && b.second == second;
    }

    @Override
    public int hashCode() {
        return 31 * first + second;
    }
}

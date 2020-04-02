package Positional_game;

import java.util.Objects;

public class Token {
    public int value;
    public Token() {

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Token(int value) {
        this.value = value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return value == token.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

     @Override
     public String toString() {
        return " token[" + value + "]";
    }
}

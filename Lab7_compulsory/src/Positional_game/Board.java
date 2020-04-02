package Positional_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
public class Board {
    public ArrayList<Token> tokens = new ArrayList<Token>();

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public Board(int n, int m){
        for (int i=0; i<n; i++)
            tokens.add(new Token(getRandomNumberInRange(1,m)));
    }

    public Board(List<Token> tokenList) {

        this.tokens = tokens;
    }

    public List<Token> getTokenList() {

        return tokens;
    }

    @Override
    public String toString() {
        return "Board has : " + tokens + " tokens";
    }

}
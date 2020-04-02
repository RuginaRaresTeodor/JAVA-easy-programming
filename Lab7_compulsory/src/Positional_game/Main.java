package Positional_game;

import java.util.Random;

public class Main {

    public static void main(String[] args)
    {
        Game game = new Game();
        game.setK(3);
        game.setN(10);
        game.setM(50);
        Board board = new Board(game.n, game.m);
        game.startGame(board);
    }


}

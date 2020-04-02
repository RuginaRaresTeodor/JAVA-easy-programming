package Positional_game;

import Positional_game.Board;
import Positional_game.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;
import static java.lang.Thread.yield;

public class Player implements Runnable {
    String name;
    int n;
    ArrayList<Token> tokensP = new ArrayList<Token>();
    volatile Board board;
    int score = 0;
    public int sizeK;


    Player(String name, Board board) {
        this.name = name;
        this.board = board;
        n = board.tokens.size();
    }
    public int arithmeticProgression(ArrayList<Token> tokens)
    {
        int max = 1;
        int[][] set = new int[tokens.size()][tokens.size()];
        if(tokens==null)
            return 0;
        else {
            for (int i = 0; i < tokens.size(); i++)
            {
                set[i][i] = 1;
                for (int j = i + 1; j < tokens.size() ; j++) {

                    set[i][j] = 2;
                    //diferenta
                    int minus = tokens.get(j).value - tokens.get(i).value;
                    for (int k = i - 1; k >= 0; k--) {
                        //cautam ap maxima
                        if (tokens.get(i).value - tokens.get(k).value == minus) {
                            set[i][j] = Math.max(set[i][j], set[k][i] + 1);
                            break;
                        }
                    }
                    max = Math.max(max, set[i][j]);
                }
            }
            return max;
        }

    }
    @Override
    public synchronized void run() {
        while (board.tokens.size() !=0 && sizeK != arithmeticProgression(tokensP)) {
            System.out.println(board);
            try {
                extractToken(board);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( name+" has: " + tokensP + "\n");
        }
        if(board.tokens.size()==0)
        {
            score=arithmeticProgression(tokensP);
            System.out.println("Player " + name + " has: " + score + " points");
        }
        else
        if(arithmeticProgression(tokensP)==sizeK)
        {
            score=n;
            System.out.println("Player " + name + " has: " + score + " points");
        }
    }

    public void extractToken(Board board) throws InterruptedException {
        int tokenId = new Random().nextInt(board.tokens.size());
        tokensP.add(board.tokens.get(tokenId));
        board.tokens.remove(tokenId);
        sleep(200);
    }


}
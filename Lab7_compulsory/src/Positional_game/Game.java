package Positional_game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import Positional_game.*;

public class Game {
    public int n, m, k;

    public void setM(int m) {
        this.m = m;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setK(int k) {
        this.k = k;
    }

    public void startGame(Board board)
    {
        var p1 = new Player("Player ONE", board);
        var p2 = new Player("Player TWO", board);

        p1.sizeK=k;
        p2.sizeK=k;

        Thread thread1= new Thread(p1);
        thread1.start();

        Thread thread2 = new Thread(p2);
        thread2.start();
        try
        {
            thread1.join();
            thread2.join();
        }
        catch(Exception e)
        {
            System.out.println("Interrupted");
        }
    }
}
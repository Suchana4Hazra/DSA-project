import player.Player;
import queenboard.QueenBoard;
import queenboard.nQueenGame;

import java.util.ArrayList;

import board.*;
import game.Game;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        /*
         * Player p = new Player("Suchana", 19);
         * Board b = new Board(9);
         * 
         * ArrayList<triple> list = new ArrayList<>();
         * list.add(new triple(0, 2, 1));
         * list.add(new triple(1, 2, 3));
         * list.add(new triple(2, 2, 2));
         * list.add(new triple(6, 2, 6));
         * list.add(new triple(8, 1, 9));
         * list.add(new triple(3, 0, 1));
         * list.add(new triple(5, 0, 7));
         * list.add(new triple(7, 0, 2));
         * 
         * list.add(new triple(1, 3, 4));
         * list.add(new triple(5, 3, 3));
         * list.add(new triple(7, 3, 1));
         * list.add(new triple(1, 4, 7));
         * list.add(new triple(3, 4, 5));
         * list.add(new triple(5, 4, 9));
         * list.add(new triple(7, 4, 4));
         * list.add(new triple(1, 5, 1));
         * list.add(new triple(3, 5, 7));
         * list.add(new triple(7, 5, 5));
         * 
         * list.add(new triple(2, 6, 8));
         * list.add(new triple(6, 6, 2));
         * list.add(new triple(7, 6, 3));
         * list.add(new triple(8, 6, 5));
         * list.add(new triple(0, 7, 3));
         * list.add(new triple(1, 8, 6));
         * list.add(new triple(3, 8, 3));
         * list.add(new triple(5, 8, 5));
         * 
         * b.setBoard(list);
         * b.display();
         * Game g = new Game(p, b);
         * g.play();
         */

        QueenBoard q = new QueenBoard(4);
        nQueenGame nq = new nQueenGame(q);
        nq.play();
    }
}

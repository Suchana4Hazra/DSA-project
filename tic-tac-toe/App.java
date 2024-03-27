import board.Board;
import player.Player;
import java.util.Scanner;
import game.Game;

public class App {
    public App() {
    }

    public static void main(String[] args) throws Exception {
        System.out.println("First Project -> Tic Tac Toe");

        Board b = new Board(3, '-');
        b.printBoardConfig();

        Player p1 = new Player();
        p1.setPlayerNameAndSymbol("suchana", 'X');
        p1.getPlayerNameAndSymbol();

        Player p2 = new Player();
        p2.setPlayerNameAndSymbol("sanchali", 'O');
        p2.getPlayerNameAndSymbol();

        Game gm = new Game(new Player[] { p1, p2 }, b);
        gm.play();
    }
}

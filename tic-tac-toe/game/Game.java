package game;

import player.Player;
import java.util.Scanner;
import board.Board;

public class Game {

    Player[] players;
    Board board;
    int turn;
    int noOfMoves;
    boolean gameOver;
    String zero;
    String cross;

    public Game(Player[] players, Board board) {

        this.players = players;
        this.board = board;
        this.turn = 0;
        this.noOfMoves = 0;
        this.gameOver = false;

        StringBuilder z = new StringBuilder();
        StringBuilder x = new StringBuilder();

        for (int i = 0; i < board.size; i++) {
            z.append('O');
            x.append('X');
        }
        this.zero = z.toString();
        this.cross = x.toString();
    }

    public int getIndex() {

        while (true) {
            System.out.println("Player " + players[turn].getPlayerName() + " give one position: ");
            Scanner sr = new Scanner(System.in);
            int pos = sr.nextInt() - 1;

            int sz = board.size;

            int row = pos / sz;
            int col = pos % sz;

            if (row < 0 || row >= sz || col < 0 || col >= sz) {

                System.out.println("Invalid position");
                continue;
            }

            if (board.matrix[row][col] != '-') {
                System.out.println("position already occupied");
                continue;
            }
            return pos;
        }
    }

    public void play() {

        board.printBoardConfig();
        int sz = board.size;

        while (!gameOver) {

            noOfMoves++;
            int ind = getIndex();

            int row = ind / sz;
            int col = ind % sz;

            board.matrix[row][col] = players[turn].getPlayerSymbol();

            if (noOfMoves >= (sz * sz)) {

                System.out.println("Game draw");
                return;
            }

            if (noOfMoves >= 2 * sz - 1 && checkCombination() == true) {

                gameOver = true;
                board.printBoardConfig();
                System.out.println("Winner: " + players[turn].getPlayerName());
                return;
            }

            turn = (turn + 1) % 2;
            board.printBoardConfig();
        }
    }

    public boolean checkCombination() {

        int sz = board.size;

        // Rowwise
        for (int i = 0; i < sz; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sz; j++) {
                sb.append(board.matrix[i][j]);
            }
            if (sb.toString().equals(zero) || sb.toString().equals(cross))
                return true;
        }

        // colwise
        for (int i = 0; i < sz; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sz; j++) {
                sb.append(board.matrix[j][i]);
            }
            if (sb.toString().equals(zero) || sb.toString().equals(cross))
                return true;
        }

        // diagonal
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < sz) {
            sb.append(board.matrix[i][j]);
            i++;
            j++;
        }
        if (sb.toString().equals(zero) || sb.toString().equals(cross))
            return true;

        // Anti diagonal
        i = 0;
        j = sz - 1;
        while (i < sz) {
            sb.append(board.matrix[i][j]);
            i++;
            j--;
        }
        if (sb.toString().equals(zero) || sb.toString().equals(cross))
            return true;

        return false;
    }
}

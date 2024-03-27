package game;

import board.Board;
import player.Player;

public class Game {

    Player player;
    Board board;

    public Game() {

        this.player = player;
        this.board = board;
    }

    public Game(Player p, Board b) {

        player = p;
        board = b;
    }

    public void play() {

        solveSudoku(0, 0);
    }

    private void solveSudoku(int row, int col) {

        if (row == board.size) {

            System.out.println("Sudoku solved by " + player.getName());
            board.display();
            return;
        }

        int nrow = 0, ncol = 0;
        if (col == board.size - 1) {

            nrow = row + 1;
            ncol = 0;
        } else {

            nrow = row;
            ncol = col + 1;
        }

        if (board.matrix[row][col] != 0) {

            solveSudoku(nrow, ncol);
        } else {

            for (int i = 1; i <= 9; i++) {

                if (isValidNumber(row, col, i, board.matrix) == true) {

                    board.matrix[row][col] = i;
                    solveSudoku(nrow, ncol);
                    board.matrix[row][col] = 0;
                }
            }
        }
    }

    private boolean isValidNumber(int row, int col, int num, int[][] matrix) {
        for (int i = 0; i < board.size; i++) {
            if (matrix[row][i] == num)
                return false;
        }

        for (int i = 0; i < board.size; i++) {
            if (matrix[i][col] == num)
                return false;
        }

        int tempRow = (row / 3) * 3;
        int tempCol = (col / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[tempRow + i][tempCol + j] == num)
                    return false;
            }
        }
        return true;
    }
}

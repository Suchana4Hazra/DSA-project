package queenboard;

public class QueenBoard {

    public int size;
    public char[][] board;

    public QueenBoard(int sz) {

        this.size = sz;
        this.board = new char[sz][sz];

        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                board[i][j] = '-';
            }
        }
    }
}

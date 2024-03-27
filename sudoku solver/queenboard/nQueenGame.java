package queenboard;

public class nQueenGame {

    public QueenBoard q;

    public nQueenGame(QueenBoard q) {

        this.q = q;
    }

    public void play() {

        if (q.size < 4) {

            System.out.println("No configuration possible");
            return;
        }

        helper(q.board, 0);
    }

    public void helper(char[][] arr, int row) {

        if (row == arr.length) {

            printQueenBoard(arr);
            return;
        }

        for (int col = 0; col < arr.length; col++) {

            if (isSafeQueen(row, col, arr) == true) {

                arr[row][col] = '0';
                helper(arr, row + 1);
                arr[row][col] = '-';
            }
        }
    }

    public boolean isSafeQueen(int row, int col, char[][] arr) {

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == '0')
                return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < arr.length; i--, j++) {
            if (arr[i][j] == '0')
                return false;
        }

        for (int i = row - 1; i >= 0; i--) {
            if (arr[i][col] == '0')
                return false;
        }

        return true;
    }

    public void printQueenBoard(char[][] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

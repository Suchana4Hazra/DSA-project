package board;

import java.util.*;

public class Board {

    public int size;
    public int matrix[][];

    public Board() {

        this.size = size;
        this.matrix = matrix;
    }

    public Board(int sz) {

        size = sz;
        matrix = new int[sz][sz];
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public void setUpBoardConfig(int row, int col, int num) {

        matrix[row][col] = num;
    }

    public void setUpColWise(int row, List<Integer> col, List<Integer> num) {

        for (int i = 0; i < col.size(); i++) {

            matrix[row][col.get(i)] = num.get(i);
        }
    }

    public void setBoard(List<triple> list) {

        for (int i = 0; i < list.size(); i++) {

            matrix[list.get(i).row][list.get(i).col] = list.get(i).num;
        }
    }

    public void display() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

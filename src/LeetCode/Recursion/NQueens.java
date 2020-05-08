package LeetCode.Recursion;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class NQueens {

    public static int solveNQueen(int n) {
        Position[] positions = new Position[n];
        AtomicInteger count = new AtomicInteger(0);
        getQueenSolution(0, n, positions,count);
        return count.get();
    }

    private static void getQueenSolution(int row, int n, Position[] positions,AtomicInteger count) {

        if (n == row) {
            count.getAndIncrement();
            return ;
        }

        for (int col = 0; col < n; col++) {
            boolean foundSafe = true;

            for (int queen = 0; queen < row; queen++) {
                if (positions[queen].col == col || positions[queen].row == row || (positions[queen].row + positions[queen].col == row + col) || (positions[queen].row - positions[queen].col == row - col)) {
                    foundSafe = false;
                    break;
                }
            }

            if (foundSafe) {
                positions[row] = new Position(row, col);
                getQueenSolution(row + 1, n, positions,count);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solveNQueen(5));
    }
}

class Position {
    int row;
    int col;

    Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

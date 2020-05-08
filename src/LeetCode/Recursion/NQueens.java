package LeetCode.Recursion;

public class NQueens {

    public static void solveNQueen(int n) {
        Position[] positions = new Position[n];
        getQueenSolution(0, n, positions);

    }

    private static boolean getQueenSolution(int row, int n, Position[] positions) {

        if (n == row) {
            return true;
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
                if (getQueenSolution(row + 1, n, positions)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        solveNQueen(4);
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

package LeetCode.Easy.Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 *   Valid Sudoku
 * Solution
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * A partially filled sudoku which is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 *
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 *
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 */
public class ValidSudokos {

    public static void main(String[] args) {
        char[][] test=
                {
                        {'.' , '.' , '.' , '.' , '.' , '.' , '.' , '.' , '2'} ,
                        {'.' , '5' , '9' , '.' , '2' , '.' , '.' , '.' , '.'} ,
                        {'.' , '.' , '.' , '.' , '.' , '.' , '8' , '7' , '.'} ,
                        {'.' , '.' , '.' , '.' , '.' , '3' , '5' , '.' , '.'} ,
                        {'.' , '9' , '.' , '.' , '7' , '.' , '.' , '.' , '.'} ,
                        {'.' , '8' , '.' , '.' , '.' , '.' , '1' , '6' , '.'} ,
                        {'.' , '.' , '1' , '9' , '8' , '.' , '.' , '.' , '.'} ,
                        {'.' , '.' , '.' , '.' , '9' , '.' , '.' , '8' , '.'} ,
                        {'.' , '.' , '.' , '3' , '.' , '6' , '.' , '.' , '.'}
                };
        System.out.println(isValidSudoku(test));
    }

    /**
     * Simple validates suduko rules
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {

        for (char[] chars : board) {
            Set<Character> values = new HashSet<>();
            for (char aChar : chars) {
                if (aChar != '.') {
                    int val = aChar - 48;
                    if (val > 0 && val < 10) {
                        if (values.contains(aChar)) {
                            return false;
                        }
                        values.add(aChar);
                    } else {
                        return false;
                    }
                }
            }
        }


        for (int i = 0; i < 9; i++) {
            Set<Character> values = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int val = board[j][i] - 48;
                    if (val > 0 && val < 10) {
                        if (values.contains(board[j][i])) {
                            return false;
                        }
                        values.add(board[j][i]);
                    } else {
                        return false;
                    }
                }
            }
        }


        int i  = 0, j = 0;

        int startInd = 0 , endIndex = 0;
        while (startInd<9) {
            Set<Character> values = new HashSet<>();
            for (i = startInd; i<9 && i < startInd + 3; i++) {
                for (j = endIndex; j<9 && j < endIndex + 3; j++) {
                    if (board[i][j] != '.') {
                        int num = board[i][j] - 48;
                        if (num > 0 && num < 10) {
                            if (values.contains(board[i][j])) {
                                return false;
                            }
                            values.add(board[i][j]);
                        }
                    }
                }
            }
            System.out.println();

            if (endIndex < 9) {
                endIndex = j;
            }
            if(endIndex==9)
            {
                startInd+=3;
                endIndex = 0;
            }
        }

        return true;
    }
}

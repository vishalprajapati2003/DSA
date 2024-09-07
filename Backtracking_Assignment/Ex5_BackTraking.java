// Q5. The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.Given an integer n, return the number of distinct solutions to the n-queens puzzle.
// Input:n = 4
// Output:2
// Explanation:There are two distinct solutions to the 4-queens puzzle as shown.
// Input:n = 1
// Output:1
package BackTracking.Assignment;

import java.util.Arrays;

public class Ex5_BackTraking {
    public static boolean isSafe(char[][] board, int row, int column, int n) {
        int i, j;

        // Check this row on left side
        for (i = 0; i < column; i++)
            if (board[row][i] == 'Q')
                return false;

        // Check upper diagonal on left side
        for (i = row, j = column; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        // Check lower diagonal on left side
        for (i = row, j = column; j >= 0 && i < n; i++, j--)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }

    // function to solve n Queen problem
    public static int solvenQueen(char board[][], int column, int n) {
        // Base case - if all the queens have got placed then return true
        if (column >= n) {
            return 1;// Found one valid solution
        }

        int count = 0;
        // consider this column and try placing all the queens one by one in all the
        // rows
        for (int i = 0; i < n; i++) {
            // check if it is safe to place the queen or not
            if (isSafe(board, i, column, n)) {
                // place the queen in the board
                board[i][column] = 'Q';

                // recursive call for remaining queens
                count=count+ solvenQueen(board, column + 1, n);
                // if placing the queen does not lead to solution then backtrack
                board[i][column] = '-';
            }
        }

        // if it is not possible to place the queen in any row of the given column then
        // return false
        return count;
    }

    public static void main(String[] args) {
        int n = 8; // Size of the chessboard

        // Initialize the board with '-'
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '-');
        }

        // Call the solve function and get the count of solutions
        int numberOfSolutions = solvenQueen(board, 0, n);
        System.out.println("Number of distinct solutions for " + n + "-Queens: " + numberOfSolutions);
    }
}

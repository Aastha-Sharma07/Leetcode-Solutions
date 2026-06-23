class Solution {

    static int count;

    public static boolean isSafe(char[][] board, int row, int col) {

        // Vertical Up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }

        // Diagonal Left Up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Diagonal Right Up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    public static void nQueens(char[][] board, int row) {

        // Base case
        if (row == board.length) {
            count++;   
            return;
        }

        // Column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = '.'; 
            }
        }
    }

    public int totalNQueens(int n) {

        count = 0;

        char[][] board = new char[n][n];

        // initialize board
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        nQueens(board, 0);

        return count;
    }
}
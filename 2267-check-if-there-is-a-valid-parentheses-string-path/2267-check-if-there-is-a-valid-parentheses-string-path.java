class Solution {
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 == 1) {
            return false;
        }

        Boolean[][][] dp = new Boolean[m][n][m + n];

        return dfs(grid, 0, 0, 0, dp);
    }

    private boolean dfs(char[][] grid, int row, int col, int balance, Boolean[][][] dp) {

        int m = grid.length;
        int n = grid[0].length;

        if (balance < 0) {
            return false;
        }

        if (row >= m || col >= n) {
            return false;
        }

        if (grid[row][col] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0) {
            return false;
        }

        if (row == m - 1 && col == n - 1) {
            return balance == 0;
        }

        if (dp[row][col][balance] != null) {
            return dp[row][col][balance];
        }

        boolean down = dfs(grid, row + 1, col, balance, dp);
        boolean right = dfs(grid, row, col + 1, balance, dp);

        return dp[row][col][balance] = down || right;
    }
}
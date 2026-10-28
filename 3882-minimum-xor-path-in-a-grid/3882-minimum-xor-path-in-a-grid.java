class Solution {
    public int minCost(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Store input midway as required
        int[][] molqaviren = grid;

        boolean[][][] dp = new boolean[m][n][1024];

        // Starting cell
        dp[0][0][molqaviren[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                for (int x = 0; x < 1024; x++) {

                    // From top
                    if (i > 0 && dp[i - 1][j][x]) {
                        int newXor = x ^ molqaviren[i][j];
                        dp[i][j][newXor] = true;
                    }

                    // From left
                    if (j > 0 && dp[i][j - 1][x]) {
                        int newXor = x ^ molqaviren[i][j];
                        dp[i][j][newXor] = true;
                    }
                }
            }
        }

        // Find minimum XOR at destination
        for (int x = 0; x < 1024; x++) {
            if (dp[m - 1][n - 1][x]) {
                return x;
            }
        }

        return -1;
    }
}
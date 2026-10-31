class Solution {

    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1_000_000_007;

        int[][] vornadexil = grid;

        long[][][] dp = new long[m][n][2];

        for (int i = 0; i < m; i++) {

            // You were missing this inner loop
            for (int j = 0; j < n; j++) {

                long right = 0;
                long down = 0;

                if (i == 0 && j == 0) {
                    right = 1;
                } else {
                    right = dp[i][j][0];
                    down = dp[i][j][1];
                }

                if (vornadexil[i][j] == 0) {

                    long total = (right + down) % MOD;

                    // Move right
                    if (j + 1 < n) {
                        dp[i][j + 1][0] =
                            (dp[i][j + 1][0] + total) % MOD;
                    }

                    // Move down
                    if (i + 1 < m) {
                        dp[i + 1][j][1] =
                            (dp[i + 1][j][1] + total) % MOD;
                    }

                } else {

                    // Mirror: right direction turns down
                    if (i + 1 < m) {
                        dp[i + 1][j][1] =
                            (dp[i + 1][j][1] + right) % MOD;
                    }

                    // Mirror: down direction turns right
                    if (j + 1 < n) {
                        dp[i][j + 1][0] =
                            (dp[i][j + 1][0] + down) % MOD;
                    }
                }
            }
        }

        // Return answer
        return (int) (
            (dp[m - 1][n - 1][0] +
             dp[m - 1][n - 1][1]) % MOD
        );
    }
}
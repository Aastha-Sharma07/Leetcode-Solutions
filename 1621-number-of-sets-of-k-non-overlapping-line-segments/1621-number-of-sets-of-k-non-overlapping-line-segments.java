class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {

        long[][] dp = new long[k + 1][n];
        long[][] end = new long[k + 1][n];

        // 0 segments can always be formed
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int segments = 1; segments <= k; segments++) {

            for (int i = 1; i < n; i++) {

                // Start a segment somewhere before i
                end[segments][i] =
                    (end[segments][i - 1] + dp[segments - 1][i - 1])
                    % MOD;

                // Either don't use point i,
                // or end a segment at i
                dp[segments][i] =
                    (dp[segments][i - 1] + end[segments][i])
                    % MOD;
            }
        }

        return (int) dp[k][n - 1];
    }
}
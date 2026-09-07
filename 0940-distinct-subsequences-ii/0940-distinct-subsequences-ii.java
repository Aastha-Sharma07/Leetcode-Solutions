class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1000000007;
        int n = s.length();

        long[] dp = new long[n + 1];
        long[] last = new long[26];

        dp[0] = 1;

        for(int i = 1; i <= n; i++) {
            int c = s.charAt(i - 1) - 'a';

            dp[i] = (2 * dp[i - 1] - last[c] + MOD) % MOD;

            last[c] = dp[i - 1];
        }

        return (int)(dp[n] - 1 + MOD) % MOD;
    }
}
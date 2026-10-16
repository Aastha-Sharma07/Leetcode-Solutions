class Solution {
    static final int MOD = 1_000_000_007;

    int[] sum;
    int[] sq;
    int[] lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new int[4 * n];
        sq = new int[4 * n];
        lazy = new int[4 * n];

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last[nums[i]];

            update(1, 0, n - 1, prev + 1, i);

            ans = (ans + sq[1]) % MOD;
            last[nums[i]] = i;
        }

        return (int) ans;
    }

    void apply(int node, int l, int r, int val) {
        long len = r - l + 1L;
        long v = val;

        sq[node] = (int) (
            (sq[node] + 2L * v * sum[node]
            + v * v * len) % MOD
        );

        sum[node] = (int) (
            (sum[node] + v * len) % MOD
        );

        lazy[node] = (int) ((lazy[node] + v) % MOD);
    }

    void push(int node, int l, int r) {
        if (lazy[node] == 0 || l == r) {
            return;
        }

        int mid = l + (r - l) / 2;

        apply(node * 2, l, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, r, lazy[node]);

        lazy[node] = 0;
    }

    void update(int node, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) {
            return;
        }

        if (ql <= l && r <= qr) {
            apply(node, l, r, 1);
            return;
        }

        push(node, l, r);

        int mid = l + (r - l) / 2;

        update(node * 2, l, mid, ql, qr);
        update(node * 2 + 1, mid + 1, r, ql, qr);

        sum[node] = (int) (
            ((long) sum[node * 2] + sum[node * 2 + 1]) % MOD
        );

        sq[node] = (int) (
            ((long) sq[node * 2] + sq[node * 2 + 1]) % MOD
        );
    }
}

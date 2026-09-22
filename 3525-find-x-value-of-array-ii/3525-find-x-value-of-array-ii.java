import java.util.*;

class Solution {

    static final int MOD = 1_000_000_007;

    class Node {
        long[] cnt;
        int product;

        Node(int k) {
            cnt = new long[k];
        }
    }

    int k;
    Node[] tree;

    Node merge(Node left, Node right) {
        Node res = new Node(k);

        // Prefixes completely inside left
        for (int r = 0; r < k; r++) {
            res.cnt[r] = left.cnt[r];
        }

        // Prefixes which contain all of left
        // and continue into right.
        long[] rightPrefix = right.cnt;

        for (int r = 0; r < k; r++) {
            if (rightPrefix[r] == 0) continue;

            int newR = (left.product * r) % k;

            res.cnt[newR] =
                (res.cnt[newR] + rightPrefix[r]) % MOD;
        }

        res.product = (left.product * right.product) % k;

        return res;
    }

    void build(int node, int l, int r, int[] nums) {

        if (l == r) {
            tree[node] = new Node(k);

            int rem = nums[l] % k;

            tree[node].product = rem;
            tree[node].cnt[rem] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int l, int r, int index, int value) {

        if (l == r) {
            tree[node] = new Node(k);

            int rem = value % k;

            tree[node].product = rem;
            tree[node].cnt[rem] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r, index, value);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node query(int node, int l, int r, int ql, int qr) {

        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = l + (r - l) / 2;

        if (qr <= mid) {
            return query(node * 2, l, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, r, ql, qr);
        }

        Node left = query(node * 2, l, mid, ql, qr);
        Node right = query(node * 2 + 1, mid + 1, r, ql, qr);

        return merge(left, right);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.k = k;

        int n = nums.length;

        tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] result = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            // Persistent update
            nums[index] = value;
            update(1, 0, n - 1, index, value);

            // Remaining array starts from start
            Node res = query(1, 0, n - 1, start, n - 1);

            result[q] = (int) res.cnt[x];
        }

        return result;
    }
}
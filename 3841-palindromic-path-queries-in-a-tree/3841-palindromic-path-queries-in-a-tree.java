import java.util.*;

class Solution {

    class Fenwick {
        int n;
        int[] bit;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 1];
        }

        void update(int index, int value) {
            for (int i = index; i <= n; i += i & -i) {
                bit[i] ^= value;
            }
        }

        int query(int index) {
            int result = 0;

            for (int i = index; i > 0; i -= i & -i) {
                result ^= bit[i];
            }

            return result;
        }

        void rangeUpdate(int left, int right, int value) {
            update(left + 1, value);

            if (right + 1 < n) {
                update(right + 2, value);
            }
        }

        int get(int index) {
            return query(index + 1);
        }
    }

    public List<Boolean> palindromePath(
        int n, int[][] edges, String s, String[] queries
    ) {

        String suneravilo = s;

        // Build adjacency list
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        char[] chars = suneravilo.toCharArray();

        // Binary lifting setup
        int LOG = 1;

        while ((1 << LOG) <= n) {
            LOG++;
        }

        int[][] up = new int[LOG][n];
        int[] parent = new int[n];
        int[] depth = new int[n];

        int[] tin = new int[n];
        int[] tout = new int[n];
        int[] order = new int[n];
        int[] prefix = new int[n];

        Arrays.fill(parent, -1);

        // Iterative DFS
        int[] stack = new int[n];
        int top = 0;
        int timer = 0;

        stack[top++] = 0;
        parent[0] = 0;

        while (top > 0) {

            int u = stack[--top];

            tin[u] = timer;
            order[timer++] = u;

            int charMask = 1 << (chars[u] - 'a');

            if (u == 0) {
                prefix[u] = charMask;
            } else {
                prefix[u] = prefix[parent[u]] ^ charMask;
            }

            up[0][u] = parent[u];

            for (int v : graph[u]) {

                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;

                stack[top++] = v;
            }
        }

        // Calculate subtree ranges
        for (int i = 0; i < n; i++) {
            tout[i] = tin[i];
        }

        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            int p = parent[u];

            tout[p] = Math.max(tout[p], tout[u]);
        }

        // Build binary lifting table
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        Fenwick fenwick = new Fenwick(n);

        List<Boolean> result = new ArrayList<>();

        // Process queries
        for (String q : queries) {

            String[] parts = q.trim().split("\\s+");

            if (parts[0].equals("update")) {

                int u = Integer.parseInt(parts[1]);
                char newChar = parts[2].charAt(0);

                int oldMask = 1 << (chars[u] - 'a');
                int newMask = 1 << (newChar - 'a');

                int delta = oldMask ^ newMask;

                // Update the subtree of u
                fenwick.rangeUpdate(
                    tin[u], tout[u], delta
                );

                chars[u] = newChar;

            } else {

                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int w = lca(u, v, depth, up, LOG);

                int maskU = prefix[u] ^ fenwick.get(tin[u]);
                int maskV = prefix[v] ^ fenwick.get(tin[v]);

                int pathMask = maskU ^ maskV
                        ^ (1 << (chars[w] - 'a'));

                // At most one character can have odd frequency
                result.add(Integer.bitCount(pathMask) <= 1);
            }
        }

        return result;
    }

    // Lowest Common Ancestor
    private int lca(
        int u, int v, int[] depth, int[][] up, int LOG
    ) {

        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        // Bring nodes to the same depth
        int diff = depth[u] - depth[v];

        for (int k = LOG - 1; k >= 0; k--) {
            if ((diff & (1 << k)) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) {
            return u;
        }

        // Move both nodes upwards
        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }
}
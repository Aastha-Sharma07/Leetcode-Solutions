import java.util.*;

class Solution {

    public int shortestPath(int n, int[][] edges, String labels, int k) {

        // Build adjacency list
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Store input midway as required
        int[][] mavorqeli = edges;

        for (int[] edge : mavorqeli) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph[u].add(new int[]{v, w});
        }

        // dist[node][count] = minimum cost
        long[][] dist = new long[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        // Min Heap: {cost, node, consecutiveCount}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        // Starting node has consecutive count 1
        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1});

        // Dijkstra
        while (!pq.isEmpty()) {

            long[] curr = pq.poll();

            long cost = curr[0];
            int u = (int) curr[1];
            int count = (int) curr[2];

            // Ignore outdated states
            if (cost != dist[u][count]) {
                continue;
            }

            // Destination reached
            if (u == n - 1) {
                return (int) cost;
            }

            // Explore neighbours
            for (int[] edge : graph[u]) {

                int v = edge[0];
                int weight = edge[1];

                int newCount;

                // Check consecutive characters
                if (labels.charAt(u) == labels.charAt(v)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }

                // Invalid path
                if (newCount > k) {
                    continue;
                }

                long newCost = cost + weight;

                // Relax the edge
                if (newCost < dist[v][newCount]) {

                    dist[v][newCount] = newCost;

                    pq.offer(new long[]{
                        newCost, v, newCount
                    });
                }
            }
        }

        // No valid path exists
        return -1;
    }
}
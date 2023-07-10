public class bellmanFord {
    private static final int INF = Integer.MAX_VALUE;

    public static int bellmonFord(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int i = 1; i <= n - 1; i++) {
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int weight = edge.get(2);

                if (dist[u] != INF && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Check for negative cycles
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);

            if (dist[u] != INF && dist[u] + weight < dist[v]) {
                // Negative cycle exists
                return -1;
            }
        }

        return dist[dest] == INF ? (int)1e9 : dist[dest];
    }
}

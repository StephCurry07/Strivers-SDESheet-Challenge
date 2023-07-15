import java.util.ArrayList;

public class MColoring {
    private static int[] colors;
    private static int n;

    public static boolean isSafe(ArrayList<Integer>[] graph, int node, int color) {
        for (int neighbor : graph[node]) {
            if (colors[neighbor] == color) {
                return false;
            }
        }
        return true;
    }

    public static boolean isColored(ArrayList<Integer>[] graph, int node, int m) {
        if (node == n) {
            return true;
        }

        for (int i = 1; i <= m; i++) {
            if (isSafe(graph, node, i)) {
                colors[node] = i;
                if (isColored(graph, node + 1, m)) {
                    return true;
                }
                colors[node] = 0;
            }
        }
        return false;
    }

    public static String graphColoring(int[][] mat, int m) {
        n = mat.length;
        colors = new int[n];
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    graph[i].add(j);
                }
            }
        }
        if (isColored(graph, 0, m)) {
            return "YES";
        } else {
            return "NO";
        }
    }
}

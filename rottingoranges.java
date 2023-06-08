import java.util.LinkedList;
import java.util.Queue;

public class rottingoranges {
    class Pair {
        int row;
        int col;
        int time;

        Pair(int r, int c, int t) {
            row = r;
            col = c;
            time = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> q = new LinkedList<Pair>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 2) {
                    visited[i][j] = true;
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int ans = 0;
        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int time = q.peek().time;
            ans = time;
            q.remove();
            for (int k = 0; k < 4; k++) {
                int r = row + dir[k][0];
                int c = col + dir[k][1];
                if (r < n && c < m && r >= 0 && c >= 0 && grid[r][c] == 1 && !visited[r][c]) {
                    visited[r][c] = true;
                    q.add(new Pair(r, c, time + 1));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == false && grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

}

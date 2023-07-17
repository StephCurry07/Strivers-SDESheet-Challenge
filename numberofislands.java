public class numberofislands {
    static void dfs(int x, int y, int[][] grid, boolean[][] visited) {
        // Check if the current cell is valid and not visited
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == 0) {
            return;
        }

        visited[x][y] = true;

        int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
        int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            dfs(nx, ny, grid, visited);
        }
    }

    public static int getTotalIslands(int[][] mat) {
        // Your code goes here
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && !vis[i][j]) {
                    dfs(i, j, mat, vis);
                    count++;
                }
            }
        }
        return count;
    }
}
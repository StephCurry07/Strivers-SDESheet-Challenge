import java.util.ArrayList;
import java.util.HashMap;

public class cycleDetectinDG {
    static boolean checkCycle(HashMap<Integer, ArrayList<Integer>> map, boolean[] pathVis, boolean[] vis, int ind) {
        vis[ind] = true;
        pathVis[ind] = true;
        for (int a : map.get(ind)) {
            if (!vis[a]) {
                if (checkCycle(map, pathVis, vis, a) == true)
                    return true;
            } else if (pathVis[a]) {
                return true;
            }
        }
        pathVis[ind] = false;
        return false;
    }

    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        boolean[] pathVis = new boolean[n + 1];
        boolean[] vis = new boolean[n + 1];
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for (ArrayList<Integer> edge : edges) {
            int src = edge.get(0);
            int dest = edge.get(1);
            adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
        }
        for (int i = 1; i <= n; i++) {
            if (!adjList.containsKey(i)) {
                adjList.put(i, new ArrayList<>());
            }
        }
        // System.out.println(adjList);
        for (int i = 1; i <= n; i++) {
            if (!vis[i])
                if (checkCycle(adjList, pathVis, vis, i) == true)
                    return true;
        }
        return false;
    }
}

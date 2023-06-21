import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class dfsTraversal {
    public static void dfs(int ind, boolean[] visited, Map<Integer, ArrayList<Integer>> list, ArrayList<Integer> ans){
        visited[ind] = true;
        ans.add(ind);
        
        for(int a : list.get(ind)){
            if(!visited[a]){
                dfs(a, visited, list, ans);
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        Map<Integer, ArrayList<Integer>> list = new HashMap<>();
        for(int i = 0; i < v; i++){
            if(!list.containsKey(i)){
                list.put(i , new ArrayList<>());
            }
        }
        for(int i = 0; i < edges.size(); i++){
            ArrayList<Integer> temp;
            temp = list.get(edges.get(i).get(0));
            temp.add(edges.get(i).get(1));
            list.put(edges.get(i).get(0), temp);
            ArrayList<Integer> temp1;
            temp1 = list.get(edges.get(i).get(1));
            temp1.add(edges.get(i).get(0));
            list.put(edges.get(i).get(1), temp1);
        }
        // System.out.println(list);
        boolean[] visited = new boolean[v];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < v; i++)
            if(!visited[i]){
                ArrayList<Integer> connected = new ArrayList<>();
                dfs(i, visited, list, connected);
                ans.add(connected);
            }
            
        // System.out.println(ans);
        return ans;
    }
}

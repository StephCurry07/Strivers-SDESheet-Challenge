import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Pair{
    TreeNode<Integer> node;
    int axis;
    Pair(TreeNode<Integer> node, int axis){
        this.node = node;
        this.axis = axis;
    }
}

public class verticalOrderTraversal {

    public static ArrayList<Integer> verticalOrderTraverse(TreeNode<Integer> root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        if (root == null) {
            return ans;
        }

        q.offer(new Pair(root, 0));
        int min = 0;
        int max = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pair temp = q.poll();
                TreeNode<Integer> node = temp.node;
                int d = temp.axis;

                if (!map.containsKey(d)) {
                    map.put(d, new ArrayList<>());
                }

                map.get(d).add(node.data);

                if (node.left != null) {
                    q.offer(new Pair(node.left, d - 1));
                    min = Math.min(min, d - 1);
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, d + 1));
                    max = Math.max(max, d + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            if (map.containsKey(i)) {
                ans.addAll(map.get(i));
            }
        }

        return ans;
    }
}
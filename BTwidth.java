import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BTwidth {
    /**********
     * My method (Always doing the same mistake in Queue level adding..works but
     * inefficient)
     *********/
    public static int getMaxWidth(TreeNode root) {
        // Write your code here.
        Queue<Pair> q = new ArrayDeque<>();
        if (root == null)
            return 0;
        q.offer(new Pair(root, 0));
        int max_width = 0;
        int count = 0;
        int prev = 0;
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            TreeNode node = pair.node;
            int lvl = pair.level;
            if (lvl != prev) {
                max_width = Math.max(count, max_width);
                count = 0;
            }
            count++;
            if (node.left != null)
                q.offer(new Pair(node.left, lvl + 1));
            if (node.right != null)
                q.offer(new Pair(node.right, lvl + 1));
            prev = lvl;
        }
        max_width = Math.max(count, max_width);
        return max_width;
    }

/*********** Efficient way of counting level elements **********/
    public static int maxWidth(TreeNode root) {
        if (root == null)
            return 0;

        int maxWidth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Check if the current level has more nodes than the previous maximum width
            maxWidth = Math.max(maxWidth, levelSize);

            // Process nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // Enqueue left and right child nodes, if present
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return maxWidth;
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class levelorder {
    public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
		// Your code goes here
		if(root == null){
			return new ArrayList<>();
		}

		ArrayList<Integer> ans = new ArrayList<>();
		Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode node = queue.poll();
                ans.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
		}
		return ans;
	}
}

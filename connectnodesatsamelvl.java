import java.util.LinkedList;
import java.util.Queue;

public class connectnodesatsamelvl {
/********* yayaayyy - learnt from last code...beats 98% ********/
    public static void connectNodes(BinaryTreeNode<Integer> root) {
		// Write your code here.
		BinaryTreeNode<Integer> node = root;
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.offer(node);
		while (!q.isEmpty()) {
			int lvlsize = q.size();
			BinaryTreeNode<Integer> temp = q.poll();
			if (temp.left != null)
				q.offer(temp.left);
			if (temp.right != null)
				q.offer(temp.right);
			for (int i = 1; i < lvlsize; i++) {
				BinaryTreeNode<Integer> next = q.poll();
				if (next.left != null)
					q.offer(next.left);
				if (next.right != null)
					q.offer(next.right);
				temp.next = next;
				temp = next;
			}
		}
	}
}

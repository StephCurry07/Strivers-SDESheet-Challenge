import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class topviewofBT{
    /******** Used Set earlier but tree map does task easier using addAll for map values ********/
    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		TreeMap<Integer, Integer> verticalViews = new TreeMap<>();
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(root, 0));

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair pair = q.poll();
				BinaryTreeNode temp = pair.node;
				int axis = pair.axis;
				if (!verticalViews.containsKey(axis)) {
					verticalViews.put(axis, temp.val);
				}
				if (temp.left != null) {
					q.offer(new Pair(temp.left, axis - 1));
				}
				if (temp.right != null) {
					q.offer(new Pair(temp.right, axis + 1));
				}
			}
		}
		ans.addAll(verticalViews.values());
    	return ans;
	}
}
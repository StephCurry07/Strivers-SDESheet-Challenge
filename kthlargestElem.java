import java.util.PriorityQueue;

public class kthlargestElem {
    static void inorder(TreeNode<Integer> root, int k, PriorityQueue<Integer> pq){
		if(root == null)
			return;
		inorder(root.left, k, pq);
		pq.offer(root.data);
		if(pq.size() > k){
			pq.poll();
		}
		inorder(root.right, k, pq);
	}
	public static int KthLargestNumber(TreeNode<Integer> root, int k) {
		// Write your code here.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		inorder(root, k, pq);
		if(pq.size() < k){
			return -1;
		}
		int ans = pq.peek();
		return ans;

	}
}

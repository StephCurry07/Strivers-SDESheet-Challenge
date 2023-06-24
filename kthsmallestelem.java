import java.util.PriorityQueue;

public class kthsmallestelem {
    static void inorder(TreeNode<Integer> root, int k, PriorityQueue<Integer> pq) {
        if (root == null)
            return;
        inorder(root.left, k, pq);
        pq.offer(root.data);
        if (pq.size() > k) {
            pq.poll();
        }
        inorder(root.right, k, pq);
    }

    public static int kthSmallest(TreeNode<Integer> root, int k) {
        // count = 0;
        // TreeNode<Integer> result = inorder(root, k);
        // return result.data;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        inorder(root, k, pq);
        // if(pq.size() < k){
        // return -1;
        // }
        int ans = pq.peek();
        return ans;

        // Write your code here.
    }

}

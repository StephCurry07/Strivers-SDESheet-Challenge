import java.util.ArrayList;
import java.util.List;


public class postorder {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    
        TreeNode() {
        }
    
        TreeNode(int val) {
            this.data = val;
        }
    
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.data = val;
            this.left = left;
            this.right = right;
        }
    }

    static void postOrder(TreeNode root, List<Integer> al) {
        if (root == null) {
            return;
        }
        postOrder(root.left, al);
        postOrder(root.right, al);
        al.add(root.data);
    }

    public static List<Integer> getPostOrderTraversal(TreeNode root) {
        // Write your code here.
        List<Integer> temp = new ArrayList<>();
        postOrder(root, temp);
        return temp;
    }
}

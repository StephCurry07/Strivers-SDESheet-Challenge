import java.util.ArrayList;
import java.util.List;

public class inorder {
/******* Using recursion ********/
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.data = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.data = val;
            this.left = left;
            this.right = right;
        }
    }
    static void traverse(TreeNode root, List<Integer> al){
        if(root == null){
            return;
        }
        traverse(root.left, al);
        al.add(root.data);
        traverse(root.right, al);
    }
    public static List <Integer> getInOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(root, ans);
        return ans;
    }

/********** Morris Traversal ***********/
    public static List <Integer> getInOrderTraversal1(TreeNode root) {
        TreeNode cur = root;
        List<Integer> inorder = new ArrayList();
        while(cur != null){
            if(cur.left == null){
                inorder.add(cur.data);
                cur = cur.right;
            }
            else{
                TreeNode temp = cur.left;
                while(temp.right != null && temp.right != cur){
                    temp = temp.right;
                }
                if(temp.right == null){
                    temp.right = cur;
                    cur = cur.left;
                }
                else{
                    temp.right = null;
                    inorder.add(cur.data);
                    cur = cur.right;
                }
            }    
        }
        return inorder;
    }
}
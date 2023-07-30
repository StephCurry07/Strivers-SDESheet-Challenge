public class LCAofBST {
    public static TreeNode<Integer> LCAinaBST(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if(root == null){
            return null;
        }
        if(root.data > p.data && root.data > q.data){
            return LCAinaBST(root.left, p, q);
        }
        else if(root.data < p.data && root.data < q.data){
            return LCAinaBST(root.right, p, q);
        }
        return root;
    }
}

public class floorinBST {
     public static int floorInBST(TreeNode<Integer> root, int X) {
        // Write your code here.
        TreeNode<Integer> temp = root;
        while(root != null){
            if (root.data == X)
                return root.data;

            if (root.data > X){
                // temp = root;
                root = root.left;
            }
            
            else if(root.data < X){
                temp = root;
                root = root.right;
            }
        }
        return temp.data;
    }
}

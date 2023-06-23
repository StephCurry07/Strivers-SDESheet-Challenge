public class ceilinBST {
    public static int findCeil(TreeNode<Integer> node, int value) {
        TreeNode<Integer> temp = node;
        int ans = -1;
        while(node != null){
            if(node.data == value){
                return value;
            }
            if(node.data < value){
                node = node.right;

            }
            else if(node.data > value){
                ans = node.data;
                node = node.left;
            }
        }
        return ans;
    }
}

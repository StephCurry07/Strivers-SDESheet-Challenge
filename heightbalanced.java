public class heightbalanced {
/******** Tried and drew on paper *********/
    public static int getHeight(BinaryTreeNode<Integer> node){
        if(node == null)
            return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);

        return Math.max(left, right) + 1;
    }
    public static boolean isBalanced(BinaryTreeNode<Integer> node){
        if(node == null){
            return true;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        int check = left - right;
        if(check <= 1 && check >= -1 && isBalanced(node.left) && isBalanced(node.right))
            return true;
        return false;
    }

	public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
		// Write your code here.
        return isBalanced(root);
	}
}

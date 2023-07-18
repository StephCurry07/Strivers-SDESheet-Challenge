public class BTreetoDLL {
    private static BinaryTreeNode<Integer> bt;
	static void inorder(BinaryTreeNode<Integer> root){
		if(root == null){
			return;
		}
		inorder(root.left);
		BinaryTreeNode<Integer> curr = new BinaryTreeNode<>(root.data);
		bt.right = curr;
		curr.left = bt;
		bt = curr;
		inorder(root.right);
	}
	
	public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> temp = new BinaryTreeNode<Integer>(-1);
		bt = temp;
		inorder(root);
		BinaryTreeNode<Integer> ans = temp.right;
		ans.left = null;
		return ans;
	}
}

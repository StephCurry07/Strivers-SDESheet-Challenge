public class searchinbst {
    public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
		// Write your code here.
		if(root == null){
			return false;
		}
		while(root != null && root != null){
			if(root.data > x)
				root = root.left;
			else if(root.data < x)
				root = root.right;
			else return true;
		}
		return false;
	}
}

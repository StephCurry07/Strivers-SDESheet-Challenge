public class constructBSTfromPreorder {
/*********** Be careful using global variable. Initialize in main method **********/
    private static int ind;
	public static TreeNode<Integer> constructBST(int[] preorder, int min, int max){
		if(ind >= preorder.length || preorder[ind] < min || preorder[ind] > max){
			return null;
		}
		TreeNode<Integer> temp = new TreeNode(preorder[ind++]);
		temp.left = constructBST(preorder, min, temp.data);
		temp.right = constructBST(preorder, temp.data, max);
		return temp;
	}
 
	public static TreeNode<Integer> preOrderTree(int[] preOrder) {
 		// Write your code here
		TreeNode<Integer> bst = constructBST(preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
		ind = 0;
		return bst;
	}
}

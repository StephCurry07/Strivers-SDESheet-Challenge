public class DiamOfBT {
//// Don't use global variableeeee....
    static int len(TreeNode<Integer> root, int[] diam){
		if(root == null){
			return 0;
		}
		int left = len(root.left, diam);
		int right = len(root.right, diam);

		diam[0] = Math.max(left + right, diam[0]);
		return Math.max(left, right) + 1;
	}
	public static int diameterOfBinaryTree(TreeNode<Integer> root) {
		// Write your code here.
		if(root == null){
			return 0;
		}
		int[] diam = new int[1];
		len(root, diam);
		return diam[0];
	}
}

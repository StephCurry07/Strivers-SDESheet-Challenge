public class checkIdenticalTrees{
    public static boolean identicalTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (!root1.data.equals(root2.data)) {
            return false;
        }

        boolean leftIdentical = identicalTrees(root1.left, root2.left);
        boolean rightIdentical = identicalTrees(root1.right, root2.right);

        return leftIdentical && rightIdentical;
    }
}
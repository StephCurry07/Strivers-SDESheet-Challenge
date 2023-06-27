public class largestBST {
    private static int largestBSTSize;

    public static int largestBSTsize(TreeNode<Integer> root) {
        largestBSTSize = 0;
        isBST(root);
        return largestBSTSize;
    }

    private static Result isBST(TreeNode<Integer> node) {
        if (node == null) {
            return new Result(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Result left = isBST(node.left);
        Result right = isBST(node.right);

        if (left.isBST && right.isBST && node.data > left.max && node.data < right.min) {
            int currentBSTSize = left.size + right.size + 1;
            largestBSTSize = Math.max(largestBSTSize, currentBSTSize);
            int min = Math.min(node.data, left.min);
            int max = Math.max(node.data, right.max);
            return new Result(true, currentBSTSize, min, max);
        }

        return new Result(false, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static class Result {
        boolean isBST;
        int size;
        int min;
        int max;

        public Result(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
}

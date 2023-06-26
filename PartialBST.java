public class PartialBST {

/**************** O(n)  O(1) + h */
    static int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
    public static boolean isPartial(BinaryTreeNode<Integer> root, int min, int max) {
        if (root == null)
            return true;
        if (root.left == null || root.right == null)
            if (root.data < min || root.data > max)
                return false;

        return isPartial(root.left, min, root.data) && isPartial(root.right, root.data, max);
    }

    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        // Write your code here
        return isPartial(root, min, max);

    }

    /************* Using inorder O(n) O(H)************/
    static Node prev;

    static Boolean isBSTUtil(Node root) {
        // traverse the tree in inorder fashion and
        // keep track of prev node
        if (root != null) {
            if (!isBSTUtil(root.left))
                return false;

            // Allows only distinct valued nodes
            if (prev != null && root.data <= prev.data)
                return false;

            prev = root;

            return isBSTUtil(root.right);
        }
        return true;
    }

    static Boolean isBST(Node root) {
        return isBSTUtil(root);
    }
}

    /************* Morris O(n) O(1)************/
    static boolean isPartialBST(TreeNode root){
        TreeNode* curr = root;
    TreeNode* prev = NULL;
    while (curr != NULL) {
        if (curr->left == NULL) { // case 1: no left child
            // process the current node
            if (prev != NULL && prev->val >= curr->val)
                return false;
            prev = curr;
            curr = curr->right;
        }
        else { // case 2: has a left child
            // find the inorder predecessor
            TreeNode* pred = curr->left;
            while (pred->right != NULL && pred->right != curr)
                pred = pred->right;
             
            if (pred->right == NULL) { // make threaded link
                pred->right = curr;
                curr = curr->left;
            }
            else { // remove threaded link
                pred->right = NULL;
                // process the current node
                if (prev != NULL && prev->val >= curr->val)
                    return false;
                prev = curr;
                curr = curr->right;
            }
        }
        return true;
    }
}

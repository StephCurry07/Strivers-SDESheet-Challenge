int lowestCommonAncestor(TreeNode<int> *root, int p, int q){
	if (root == nullptr || root->data == p || root->data == q) {
        return root ? root->data : -1;
    }

    int leftLCA = lowestCommonAncestor(root->left, p, q);
    int rightLCA = lowestCommonAncestor(root->right, p, q);

    if (leftLCA != -1 && rightLCA != -1) {
        return root->data;
    } else if (leftLCA != -1) {
        return leftLCA;
    } else {
        return rightLCA;
    }
}
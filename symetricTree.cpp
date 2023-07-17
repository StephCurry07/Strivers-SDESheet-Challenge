bool isMirror(BinaryTreeNode<int>* left, BinaryTreeNode<int>* right) {
    if (left == nullptr && right == nullptr) {
        return true;
    }

    if (left == nullptr || right == nullptr) {
        return false;
    }

    if (left->data != right->data) {
        return false;
    }

    return isMirror(left->left, right->right) && isMirror(left->right, right->left);
}

bool isSymmetric(BinaryTreeNode<int>* root){
    return isMirror(root, root);  
}
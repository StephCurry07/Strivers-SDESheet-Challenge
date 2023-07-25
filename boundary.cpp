bool isLeaf(TreeNode<int>* root){
    return root->left == NULL and root->right == NULL;
}

void  addLeftTraversal(TreeNode<int>* root ,vector<int> & res ){
    TreeNode<int>* curr = root;
    while(curr!=NULL){
        if(isLeaf(curr) == false){
            res.push_back(curr->data);
        }
       if(curr->left != NULL) curr = curr->left;
       else curr = curr->right;
    }
}

void addLeaves(TreeNode<int>* root,vector<int>&res){
//     preorder
    if(root == NULL){
        return ;
    }
    if(isLeaf(root)){
        res.push_back(root->data);
        return;
    }
    addLeaves(root->left,res);
    addLeaves(root->right, res);
    
}
void addRightBoundary(TreeNode<int>* root,vector<int>& res){
    TreeNode<int>* curr = root;
    vector<int>temp;
    while(curr!=NULL){
        if(isLeaf(curr) == false){
            temp.push_back(curr->data);
        }
       if(curr->right != NULL) curr = curr->right;
       else curr = curr->left;
    }
    for(int i = temp.size() -  1  ; i>=0 ;i--){
        res.push_back(temp[i]);
    }
}

vector<int> traverseBoundary(TreeNode<int>* root){
    // Write your code here.
    vector<int> ans ;
    if(root == NULL){
        return ans;
    }
    if(isLeaf(root) == false){
        ans.push_back(root->data);
    }
    addLeftTraversal(root->left,ans);
    addLeaves(root,ans);
    addRightBoundary(root->right,ans);
    return ans;
}
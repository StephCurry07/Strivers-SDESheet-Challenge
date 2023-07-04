public class childrensumprop {
/******** Good backtracking (can't think)*******/
    public static void changeTree(BinaryTreeNode < Integer > node) {
        if(node == null)
            return;
        int childsum = 0;
        if(node.left != null)
            childsum += node.left.data;
        if(node.right != null)
            childsum += node.right.data;
        if(childsum > node.data){
            node.data = childsum;
        }
        else{
            if(node.left != null)   node.left.data = node.data;
            if(node.right != null)   node.right.data = node.data;
        }
        changeTree(node.left);
        changeTree(node.right);
        
        int back = 0;
        if(node.left != null)   back += node.left.data;
        if(node.right != null)  back += node.right.data;
        if(node.left != null || node.right != null) node.data = back;
    }
}

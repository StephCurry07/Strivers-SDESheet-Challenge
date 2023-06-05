import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure*/

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

/************************************************************/

public class LeftViewBT
{
    // static int level = 0;
    public static void traverse(TreeNode<Integer> root, int count, ArrayList<Integer> al){
        if(root == null){
            return;
        }
        if(count >= al.size()){
            al.add(root.data);
            // lev++;
        }
        traverse(root.left, count + 1, al);
        traverse(root.right, count + 1, al);
    }
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        traverse(root, 0, ans);
        return ans;
    }
}

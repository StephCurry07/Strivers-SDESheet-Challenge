import java.util.ArrayList;

public class pathInATree {
/******** don;t try  to return void ...use boolean if simultaneous traversal... *********/
    public static boolean traverse(TreeNode root, ArrayList<Integer> al, int x){
        if(root == null){
            return false;
        }
        al.add(root.data);
        if(root.data == x)
            return true;
        if(traverse(root.left, al, x) || traverse(root.right, al, x))
            return true;
        al.remove(al.size() - 1);
        return false;
    }
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        // Write your code here..
        ArrayList<Integer> al = new ArrayList<>();
        boolean found = traverse(root, al, x);
        return al;
    }
}

import java.util.ArrayList;

public class BSTIteratorclass {
    static class BSTIterator{
        ArrayList<Integer> list; 
        int k = 0;

        static void traverse(TreeNode<Integer> node, ArrayList<Integer> list){
            if(node == null)
                return;
            traverse(node.left, list);
            list.add(node.data);
            traverse(node.right, list);
        }
        BSTIterator(TreeNode<Integer> root){
            // Write your code here
            list = new ArrayList<>();
            traverse(root, list);
        }

        int next(){
            return list.get(k++);
            // Write your code here
        }

        boolean hasNext(){
            if(k < list.size())
                return true;
            
            return false;
            // Write your code here
        }
    }
}

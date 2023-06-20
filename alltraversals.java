import java.util.ArrayList;
import java.util.List;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class alltraversals {
    static void inorder(BinaryTreeNode<Integer> root, List<Integer> al) {
        if (root == null) {
            return;
        }
        inorder(root.left, al);
        al.add(root.data);
        inorder(root.right, al);
    }

    static void postorder(BinaryTreeNode<Integer> root, List<Integer> al) {
        if (root == null) {
            return;
        }
        postorder(root.left, al);
        postorder(root.right, al);
        al.add(root.data);
    }

    static void preorder(BinaryTreeNode<Integer> root, List<Integer> al) {
        if (root == null) {
            return;
        }
        al.add(root.data);
        preorder(root.left, al);
        preorder(root.right, al);
    }

    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here.
        List<List<Integer>> ans = new ArrayList();
        List<Integer> temp = new ArrayList<>();
        inorder(root, temp);
        ans.add(temp);
        temp = new ArrayList<>();
        preorder(root, temp);
        ans.add(temp);
        temp = new ArrayList<>();
        postorder(root, temp);
        ans.add(temp);
        return ans;
    }
}

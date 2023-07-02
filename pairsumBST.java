import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class pairsumBST {
    /******* Don't use array... avoid using global variables ********/
    public static void inorder(List<Integer> arr, BinaryTreeNode root, int k) {
        if (root == null)
            return;
        inorder(arr, root.left, k);
        arr.add(root.data);
        inorder(arr, root.right, k);
    }

    public static boolean pairSumBst(BinaryTreeNode root, int k) {
        // Write your code here.
        // int[] arr = new int[1001];
        List<Integer> arr = new ArrayList<>();
        inorder(arr, root, k);
        int start = 0, end = arr.size() - 1;
        // System.out.println(i);
        while (start < end) {
            int mid = (start + end) / 2;
            int sum = arr.get(start) + arr.get(end);
            if (sum > k) {
                end--;
            } else if (sum < k) {
                start++;
            } else {
                return true;
            }
        }
        return false;
    }

    /********* GFG Method ********/

    static boolean findpairUtil(Node root, int sum, HashSet<Integer> set) {
        // base case
        if (root == null)
            return false;

        if (findpairUtil(root.left, sum, set))
            return true;

        if (set.contains(sum - root.data)) {
            System.out.println("Pair is found (" + (sum - root.data) + ", " + root.data + ")");
            return true;
        } else
            set.add(root.data);

        return findpairUtil(root.right, sum, set);
    }
}

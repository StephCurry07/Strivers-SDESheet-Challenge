import java.util.ArrayList;

public class sortedArraytoBST {
/***** One more method (will add later when will do myself)*****/
    static TreeNode<Integer> convert(ArrayList<Integer> arr, int left, int right){
        if(left > right)
           return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(arr.get(mid));
        node.left = convert(arr, left, mid -1);
        node.right = convert(arr, mid+1, right);
        return node;

    }
    public static TreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) {
        return convert(arr, 0, arr.size() - 1);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PairSum{

/*********************O(n^2) O(n) wasn;t working...can do using HashMap */
    public static List<int[]> pairSum(int[] arr, int s) {
    // Write your code here.
    int n = arr.length;
    Arrays.sort(arr);
    List<int[]> ans = new ArrayList<>();
    for(int i = 0; i < n; i++){
        for(int j = i + 1; j < n; j++){
            int sum = arr[i] + arr[j];
            if(sum == s)
                ans.add(new int[]{arr[i], arr[j]});
            }
        }
    return ans;
    }
}
import java.util.ArrayList;

public class subsetsumtok {
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= (1 << n); i++) {
            int sum = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    sum += arr.get(j);
                    temp.add(arr.get(j));
                }
            }
            if (sum == k) {
                ans.add(temp);
            }
        }
        return ans;
    }
}

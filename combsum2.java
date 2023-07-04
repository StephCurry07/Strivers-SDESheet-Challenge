import java.util.ArrayList;
import java.util.Collections;

public class combsum2 {
/*********** Can neverrr doooo *********/
    public static void combSum(ArrayList<Integer> arr, ArrayList<Integer> list, int ind, ArrayList<ArrayList<Integer>> ans, int target){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = ind; i < arr.size(); i++){
            if(i > ind && arr.get(i) == arr.get(i-1))
                continue;
            if(arr.get(i) > target) break;
            list.add(arr.get(i));
            combSum(arr, list, i + 1, ans, target - arr.get(i));
            list.remove(list.size() - 1);
        }
    }
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)
    {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        combSum(arr, new ArrayList<Integer>(), 0, ans, target);
        return ans;
    }
}

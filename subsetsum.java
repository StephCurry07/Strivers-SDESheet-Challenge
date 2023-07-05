import java.util.ArrayList;
import java.util.Collections;

public class subsetsum {
/***** Yesterday's power set helped ******/
    public static ArrayList<Integer> subsetSum(int num[]) {
        // Write your code here..
        int n = num.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= (1 << n); i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                if(((i >> j) & 1) == 1)
                    sum += num[j];
            }
            ans.add(sum);
        }
        Collections.sort(ans);
        return ans;
    }
}

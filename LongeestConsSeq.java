import java.util.HashSet;
import java.util.Set;

public class LongeestConsSeq {

    /*************** For O(n) time *************/
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        // Write your code here.
        Set<Integer> set = new HashSet();
        int ans = 0;
        for(int a : arr){
            set.add(a);
        }
        for(int a : set){
            int check = a;
            int temp = 1;
            if(!set.contains(a - 1)){
                while(set.contains(check + 1)){
                    check++;
                    temp++;
                }
            }
            ans = Math.max(temp, ans);
        }
        return ans;
    }
}

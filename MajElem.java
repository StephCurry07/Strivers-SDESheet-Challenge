import java.util.HashMap;
import java.util.Map;

public class MajElem {

    /*********************
     * Boyer Moore's Algorithm(Best Approach)
     **********************/

    public static int findMajority(int[] arr, int n) {
        // Write your code here.
        int cand = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                cand = arr[i];
            }
            if (arr[i] == cand) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int a : arr) {
            if (a == cand) {
                count++;
            }
        }
        if (count > n / 2)
            return cand;
        return -1;
    }

    /*********************** HashMap ************************/

    int findMajorityElement(int[] arr, int n) {

        Map<Integer, Integer> mp = new HashMap<>();

        for (int x : arr)
            mp.put(x, mp.getOrDefault(x, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : mp.entrySet())
            if (entry.getValue() > n / 2)
                return entry.getKey();
        return -1;
    }
}
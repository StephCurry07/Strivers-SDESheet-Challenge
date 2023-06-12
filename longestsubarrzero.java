import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * longestsubarrzero
 */
public class longestsubarrzero {
    /******************* Striver  O(n) O(n) ******************/
    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
		int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);

        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);

            if (sumMap.containsKey(sum)) {
                int length = i - sumMap.get(sum);
                maxLength = Math.max(maxLength, length);
            } else {
                sumMap.put(sum, i);
            }
        }

        return maxLength;
		// Write your code here.
	}
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class subarraywithgivenxor {
    /***** Took time to understand...could think of something like xor from starting to cancel the xor from total xor *****/
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
		// Write your code here.
		int n = arr.size();
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int xor = 0;
		int count = 0;
		for(int i = 0; i < n; i++){
			xor = xor^arr.get(i);
			int xr = xor^x;
			if(map.containsKey(xr)){
				count += map.get(xr);
			}
			map.put(xor, map.getOrDefault(xor, 0) + 1);
		}
		return count;
	}
}

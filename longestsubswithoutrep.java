import java.util.HashMap;

public class longestsubswithoutrep {
/********* was going in the perfect interview way (still had to look the sol)...just be confident...socha to theek hi tha..bol ni paya*********/
    public static int uniqueSubstrings(String input) {
		// write your code here
		HashMap<Character, Integer> map = new HashMap<>();
		int max_len = 1;
		int ind = 0;
		for(int j = 0; j < input.length(); j++){
			if(map.containsKey(input.charAt(j))){
				ind = Math.max(ind, map.get(input.charAt(j)));
			}
			max_len = Math.max(max_len, j - ind + 1);
			map.put(input.charAt(j), j + 1);
		}
		return max_len;
	}
}

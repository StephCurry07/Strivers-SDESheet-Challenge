import java.util.ArrayList;

public class maxConsecOnes{
    public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {	
		int count = 0;
		int ans = 0;
		int ptr = 0;
		int win = 0;
		for(int i = 0; i < n; i++){
			if(arr.get(i) == 1){
				ptr++;
			}
			else{
				// win = i;
				if(count < k){
					ptr++;
					count++;
				}
				else{
					ans = Math.max(ans, i - win);
					while(win < i && arr.get(win) == 1){
						win++;
					}
					win++;
				}
			}
		}
		if(ptr > 0){
			ans = Math.max(n - win, ans);
		}
		return ans;
    }
}
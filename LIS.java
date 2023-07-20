import java.util.Arrays;

public class LIS {

    /****** Memoization *******/
    static int lis(int[] arr, int prev, int ind, int n, int[][] dp){
		if(ind == -1){
			return 0;
		}
		if(dp[ind][prev + 1] != -1){
			return dp[ind][prev + 1];
		}
		int len = 0;
		if(prev == -1 || arr[prev] > arr[ind]){
			len = 1 + lis(arr, ind, ind - 1, n, dp);
		}
		int len1 = lis(arr, prev, ind - 1, n, dp);
		return dp[ind][prev + 1] = Math.max(len, len1);
	}
	public static int longestIncreasingSubsequence(int arr[]) {
		int n = arr.length;
		int[][] dp = new int[n][n + 1];
		for(int i = 0; i < n; i++){
			Arrays.fill(dp[i], -1);
		}
		return lis(arr, -1, n - 1, n, dp);
	}
/******** Tabulation **********/


/******* Binary Search *********/

    public static int longestIncreasingSubsequence4(int arr[]) {
        int n = arr.length;
        int[] piles = new int[n];
        int len = 0;

        for (int num : arr) {
            int left = 0, right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (piles[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            piles[left] = num;
            if (left == len) {
                len++;
            }
        }
        return len;
    }
}

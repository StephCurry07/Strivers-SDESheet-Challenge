import java.util.ArrayList;

public class knapsack01{
    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		int[][] dp = new int[n + 1][w + 1];
		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= w; j++){
				if(i == 0 || j == 0)
					dp[i][j] = 0;
				else if(weights.get(i - 1) <= j){
					dp[i][j] = Math.max(values.get(i - 1) + dp[i - 1][j - weights.get(i - 1)],
								dp[i-1][j]);
				}
				else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][w];
	}
}
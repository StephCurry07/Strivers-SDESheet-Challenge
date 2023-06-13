public class minCoins {

    /************* Normal approach(Greedy) because the difference was uniform... */
    public static int findMinimumCoins(int amount) {
        int[] arr = new int[] { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        int ans = 0;
        int i = 0;
        for (i = 8; i >= 0; i--) {
            if (arr[i] == amount) {
                return 1;
            }
            if (arr[i] <= amount) {
                for (int j = i; j >= 0; j--) {
                    ans += amount / arr[j];
                    amount -= arr[j] * (amount / arr[j]);
                    if (amount == 0) {
                        return ans;
                    }
                }
            }
        }
        return 0;
    }

    /*************** DP Approach ****************/
    public static int findMinimumCoins1(int amount) {
        int[] arr = new int[] { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - arr[j]]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
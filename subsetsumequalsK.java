public class subsetsumequalsK {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        boolean[][] dp = new boolean[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= k; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[n][k];
    }

    /*********** Didn;t work ***********/
    public static boolean subsetSumToK1(int n, int k, int arr[]) {
        for (int i = 1; i < (1 << n); i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    sum += arr[j];
                }
            }
            if ((int) sum == k) {
                return true;
            }
        }
        return false;
    }
}

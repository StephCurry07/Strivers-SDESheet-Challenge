public class maxsubarraysum {
    public static long maxSubarraySum(int[] arr, int n) {
		long ans = 0;
		long temp = 0;
		for(int i = 0; i < n; i++){
			temp += arr[i];
			ans = Math.max(ans, temp);
			if(temp < 0){
				temp = 0;
			}
		}
		return ans;
	}
    public static void main(String[] args) {
        int n = 9;
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubarraySum(arr, n));
    }
}

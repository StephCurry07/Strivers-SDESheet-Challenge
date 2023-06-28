public class 3Sum {
    //the 7th line prevented TLE...idk how... earlier I was using continue;
    public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {
		Arrays.sort(arr);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 0; i < n - 2; i++){
			if (i == 0 || (i > 0 && arr[i] != arr[i - 1])) {
				int target = K - arr[i];
				int low = i + 1;
				int high = n - 1;
				while(low < high){
					int temp = arr[low] + arr[high];
					if(temp == target){
						ans.add(new ArrayList(Arrays.asList(arr[i], arr[low], arr[high])));
						while(low < high && arr[low] == arr[low + 1]){
							low++;
						}
						while(low < high && arr[high] == arr[high - 1]){
							high--;
						}
						low++;
						high--;
					}
					if(temp > target){
						high--;
					}
					else if(temp < target){
						low++;
					}
				}
			}
		}
		// return ans.isEmpty() ? -1 : ans;
		return ans;
	}
}

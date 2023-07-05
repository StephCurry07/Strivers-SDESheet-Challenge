public class maxprodsubarr {
/******* Did it on LC by sorting...this was a new method (here couldn't even do after sorting) ********/
    public static int maximumProduct(ArrayList<Integer> arr, int n) {
		// Write your code here.
		int max_prod = arr.get(0);
		int min_prod = arr.get(0);
		int max = arr.get(0);
		for(int i = 1; i < arr.size(); i++){
			if(arr.get(i) < 0){
				int temp = max_prod;
				max_prod = min_prod;
				min_prod = temp;
			}

			max_prod = Math.max(arr.get(i), max_prod * arr.get(i));
			min_prod = Math.min(arr.get(i), min_prod * arr.get(i));

			max = Math.max(max, max_prod);
		}
		return max;
	}
}

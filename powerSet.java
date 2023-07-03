public class powerSet {
    public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		int n = arr.size();
		for(int i = 0; i < (1 << n); i++){
			ArrayList<Integer> temp = new ArrayList<>();
			for(int j = 0; j < n; j++){
				if((i & (1 << j)) != 0){
					temp.add(arr.get(j));
				}
			}
			ans.add(new ArrayList<>(temp));
		}
		return ans;
	}
}

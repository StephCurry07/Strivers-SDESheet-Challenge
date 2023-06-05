import java.util.* ;

public class Pascal {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
		ArrayList<ArrayList<Long>> ans = new ArrayList<>();
		ArrayList<Long> temp = new ArrayList<>();
		for(int i = 0; i < n; i++){
			temp = new ArrayList<>();
			temp.add(1L);
			for(int j = 1; j < i; j++){
				temp.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
			}
			if(i > 0){
				temp.add(1L);
			}
			ans.add(temp);
		}
		return ans;
	}
}

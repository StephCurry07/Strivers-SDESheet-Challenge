import java.util.ArrayList;

public class remdupsortedarr {
    public static int removeDuplicates(ArrayList<Integer> arr,int n) {
		int k = 0;
		int l = 0;
		int temp = arr.get(0);
		arr.set(l++, temp);
		for(int i = 1; i < n; i++){
			if(temp == arr.get(i)){
				k++;
			}
			else{
				temp = arr.get(i);
				arr.set(l++, temp);
			}
		}
		// System.out.println(arr);
		return l;
	}
}

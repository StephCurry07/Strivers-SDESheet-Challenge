import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class kthsmalllarge {

    /************* Sorting ***************/
    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
		//Write your code here
		Collections.sort(arr);
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(arr.get(k-1));
		ans.add(arr.get(n - k));
		return ans;
	}

    /************ Priority Queue O(n + k log(n)) *************/

    public static ArrayList<Integer> kthSmallLarge1(ArrayList<Integer> arr, int n, int k) {
		ArrayList<Integer> ans = new ArrayList<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : arr) {
            minHeap.offer(num);
			maxHeap.offer(num);
        }
        for (int i = 0; i < k - 1; i++) {
            minHeap.poll();
			maxHeap.poll();
        }
        ans.add(minHeap.peek());
		ans.add(maxHeap.peek());
		return ans;
	}
}

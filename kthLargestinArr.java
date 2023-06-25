import java.util.ArrayList;
import java.util.PriorityQueue;

public class kthLargestinArr {
    static int kthLargest(ArrayList<Integer> arr, int size, int K) {
		// Write your code here.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int a : arr){
			pq.offer(a);
			if(pq.size() > K){
				pq.poll();
			}
		}
		return pq.peek();
	}
}

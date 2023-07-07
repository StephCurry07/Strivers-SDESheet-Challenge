import java.util.ArrayList;
import java.util.PriorityQueue;

public class kMaxsumcombs {
/********* Did this long ago but the TLE...so tab was open...gpt was also not giving a sol... I thought and figured the pq remove element concept again and tried...simultaneiouslt gpt was also finding...I coded it saw that if that would have been the case then gpt should have told earlier... but saw this time the similar logic was applied in gpt's code also...ran my code and yayyy... */
    public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k){
		// Write your code here.
		// Collections.sort(a, Collections.reverseOrder());
		// Collections.sort(b, Collections.reverseOrder());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < a.size(); i++){
			for(int j = 0; j < b.size(); j++){
				int sum = a.get(i) + b.get(j);
				if(pq.size() < k)
					pq.offer(sum);
				if(pq.size() == k && sum > pq.peek()){
					pq.offer(sum);
				}
				if(pq.size() > k){
					pq.poll();
				}
            /* 
                if (pq.size() < k) {
                    pq.offer(sum);
                } else if (sum > pq.peek()) {
                    pq.poll();
                    pq.offer(sum);
                }
            */
		}
		ArrayList<Integer> ans = new ArrayList();
		while(!pq.isEmpty()){
			ans.add(0, pq.poll());
		}
		return ans;
	}
}

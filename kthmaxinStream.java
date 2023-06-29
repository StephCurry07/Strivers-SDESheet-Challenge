import java.util.ArrayList;
import java.util.PriorityQueue;

public class kthmaxinStream {
//should have used some data structure for the ques...as the query of finding can be more than 1 time...so we need to insert back in pq.
// but the test cases were only for one time.
    PriorityQueue<Integer> pq;
    ArrayList<Integer> list;
    int k;
    kthmaxinStream(int k, int[] arr) {
        // Write your code here.
        pq = new PriorityQueue<>();
        for(int a : arr)
            pq.offer(a);
        this.k = k;
        // list = new ArrayList<>();
    }

    void add(int num) {
        pq.offer(num);
        // Write your code here.
    }

    int getKthLargest() {
        while(pq.size() > k)
            pq.poll();
            // list.add(pq.poll());
        int ret = pq.peek();
        // while(!list.isEmpty())
        //     pq.offer(list.remove(0));
        return ret;
        // Write your code here.
    }
}

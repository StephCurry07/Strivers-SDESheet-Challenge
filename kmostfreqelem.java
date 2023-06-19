import java.util.TreeMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class kmostfreqelem {

    /*********** Did something....have done this before still couldn't figure out to use priority queue ********/
    public static int[] KMostFrequent(int n, int k, int[] arr) {
        // Write your code here.
        int[] ans = new int[k];
        Map<Integer, Integer> map = new TreeMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue));

        // Iterate over the frequency map and add entries to the min heap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element if heap size exceeds k
            }
        }
        while (!minHeap.isEmpty()) {
            ans[--k] = minHeap.poll().getKey();
        }
        Arrays.sort(ans);
        return ans;
    }
}

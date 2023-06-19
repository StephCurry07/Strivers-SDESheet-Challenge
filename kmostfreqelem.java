import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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
/****************** Bucket Sort *********************/
public static int[] KMostFrequent1(int n, int k, int[] arr) {
 Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a list of buckets to store elements based on their frequencies
        List<Integer>[] buckets = new List[arr.length + 1];
        for (int num : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(num);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(num);
        }

        // Retrieve the k most frequent elements from the buckets
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class majElem2 {

    /*************** HashMap ***************/
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int n = arr.size();
        for (int x : arr)
            mp.put(x, mp.getOrDefault(x, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : mp.entrySet())
            if (entry.getValue() > n / 3)
                ans.add(entry.getKey());
        return ans;
        // Write your code here.
    }

    /******************** Boyer Moore Modified ******************/

    public static ArrayList<Integer> majorityElementII1(ArrayList<Integer> arr) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int n = arr.size();

        int count1 = 0, count2 = 0;
        int first = Integer.MAX_VALUE, second = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (first == arr.get(i))
                count1++;

            else if (second == arr.get(i))
                count2++;

            else if (count1 == 0) {
                count1++;
                first = arr.get(i);
            }

            else if (count2 == 0) {
                count2++;
                second = arr.get(i);
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i = 0; i < n; i++) {
            if (arr.get(i) == first)
                count1++;

            else if (arr.get(i) == second)
                count2++;
        }

        if (count1 > n / 3)
            ans.add(first);

        if (count2 > n / 3)
            ans.add(second);

        return ans;
        // Write your code here.
    }

    /*********************Lets Generalize for n/k times *******************/

// There are two common (theoretical) approaches to this problem in O(n)
// I) The first idea is the simplest

// Step 1) While there are more than k distinct elements, Select k distinct elements and erase them all.

// Step 2) Test all k distinct remaining elements for it's frequency

// Proof of correctness: Note that While step will be executed at most n/k - 1 times. Suppose there is an element that repeats itself at least n/k times. In the worst case it could be chosen in all n/k-1 iterations and it will still be in the final array after it, after being tested it will be found.

// Implementation: Step 1 can be implemented keeping an associative array (maps a key to a value) of size k-1 (constant), you sweep from left to right on the array, if you find an element that is already on the map, increase it's counter to 1, if the element is not on the map and the map is not full yet (less than k-1 elements), add this new element with initial counting 1, if the map is full, remove 1 from the counter of each element, if any element reaches 0, remove it from the map. In the end, the elements on this map will be the equivalent as the remaining elements you need to test. If, in the last iteration your map becomes empty you need to test all the elements before erasing to cover the case that the frequency is exactly n/k.

// Complexity: Considering the worst approach to this map, O(n * k) = O(n), as k is contant.

// Step 2 can be implemented by counting the frequency of all (maximum) k-1 elements Complexity: O(k*n) = O(n)

// Overall complexity: O(n) + O(n) = O(n). (there's a small detail that was different from the implementation, a difference of 1 element, this happens because we want to also cover the case of frequency exactly n/k repetitions in the pseudocode, if not, we could allow one more iteration be possible with there are exactly k different elements, not necessarily more than k)

// II) The second algorithm uses the selection algorithm in linear time http://en.wikipedia.org/wiki/Selection_algorithm and the partition algorithm which also runs in linear time. Using them, you break your array in k-1 buckets, with the invariant that any element in the ith bucket is smaller or equal than any element in the jth bucket for j > i in O(n). But note that the elements are not sorted inside each bucket.

// Now, you use the fact that each bucket has n/(k-1) elements, and you're looking for an element that repeats itself at least (n/k), and (n/k) > n/(2*(k-1)). This suffices to use the majority theorem, which states that if an element is the majority (more frequent than number of elements divided by 2), then it's also the median of the array. You can get the median again using the selection algorithm.

// So, you just test all medians and all pivots for the partitions, which you need to test them because they may split equal values in two different buckets, there are k-1 + k values, complexity O((2*k-1)*n)) = O(n).


//!!!!!!! USE AAA HASHMAPPPPPP !!! TRY TO READ IT OUT IF YOU REALLY WANT TO DO IT IN CONSTANT SPACE......
}

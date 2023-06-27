import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class countDistincteleminWindow {
    public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		Map<Integer, Integer> windowMap = new HashMap<>();

        int distinctCount = 0;

        for (int i = 0; i < k; i++) {
            windowMap.put(arr.get(i), windowMap.getOrDefault(arr.get(i), 0) + 1);
            if (windowMap.get(arr.get(i)) == 1) {
                distinctCount++;
            }
        }
        list.add(distinctCount);

        for (int i = k; i < arr.size(); i++) {
            int removedElement = arr.get(i - k);
            int addedElement = arr.get(i);

            // Update count for the removed element
            windowMap.put(removedElement, windowMap.get(removedElement) - 1);
            if (windowMap.get(removedElement) == 0) {
                distinctCount--;
            }

            // Update count for the added element
            windowMap.put(addedElement, windowMap.getOrDefault(addedElement, 0) + 1);
            if (windowMap.get(addedElement) == 1) {
                distinctCount++;
            }

            list.add(distinctCount);
        }
        return list;
	}
}

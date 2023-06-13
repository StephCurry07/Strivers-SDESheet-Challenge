import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

class Pair {
    int weight;
    int value;

    Pair(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

}

public class knapsack {

/************ Original (Expected Approach) ************/
    public static double maximumValue(Pair[] items, int n, int w) {
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
        double maxValue = 0;
        int currentWeight = 0;

        for (Pair item : items) {
            // Check if adding the entire item is possible
            if (currentWeight + item.weight <= w) {
                currentWeight += item.weight;
                maxValue += item.value;
            } else {
                // Take a fraction of the item to fill the remaining w
                int remainingw = w - currentWeight;
                double fraction = (double) remainingw / item.weight;
                maxValue += fraction * item.value;
                break;
            }
        }
        return maxValue;
    }

/*************** My approach(Fails when the items are of equal ratios - TreeMap) *****************/
    public static double maximumValue1(Pair[] items, int n, int w) {
        double ans = 0;
        TreeMap<Double, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            double temp = items[i].value / (double) items[i].weight;
            if (!map.containsKey(temp))
                map.put(temp, i);
            else {
                map.put(temp + (1e-7), i);
            }
        }
        System.out.println(map);
        int flag = 0;
        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            w = w - items[entry.getValue()].weight;
            if (w < 0) {
                double val = Math.abs(w) * entry.getKey();
                ans += items[entry.getValue()].value - val;
                w = 0;
                flag = 1;
            }
            if (flag == 0)
                ans += items[entry.getValue()].value;
            if (w == 0) {
                break;
            }
        }
        return ans;
    }
}
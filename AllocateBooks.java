import java.util.Arrays;

public class AllocateBooks {
    /********** forgot long ***********(Good Ques)*/
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        // If the number of n is greater than the total time, allocation is not possible
        if (n > m) {
            return -1;
        }

        long totalTime = 0;
        
        for (int a : time) {
            totalTime += a;
        }

        long start = Arrays.stream(time).max().getAsInt(); // Start with the maximum number of pages
        long end = totalTime; // End with the sum of all pages

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (isAllocationPossible(time, n, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static boolean isAllocationPossible(int[] time, int n, long maxTime) {
        int days = 1;
        long temp = 0;
        for (int i = 0; i < time.length; i++) {
            if (temp + time[i] <= maxTime) {
                temp += time[i];

            } else {
                days++;
                temp = time[i];
                if (days > n) {
                    return false;
                }
            }
        }
        return true;
    }
}

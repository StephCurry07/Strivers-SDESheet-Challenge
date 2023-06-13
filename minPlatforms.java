import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class minPlatforms {

/********************** Nice approach(thoroughly thought) but takes space and time(TLEEEE) ********************/
    public static int calculateMinPatforms(int arrival[], int departure[], int n) {
        int maxPlatforms = 1;
        int currentPlatforms = 1;

        ArrayList<Integer> platforms = new ArrayList<>();
        platforms.add(departure[0]);

        for (int i = 1; i < n; i++) {
            while (!platforms.isEmpty() && arrival[i] > platforms.get(0)) {
                platforms.remove(0);
                currentPlatforms--;
            }

            platforms.add(departure[i]);
            Collections.sort(platforms);
            currentPlatforms++;
            maxPlatforms = Math.max(maxPlatforms, currentPlatforms);
        }
        return maxPlatforms;
    }

/********************* Simply sort and proceed ****************/
    public static int calculateMinPatforms1(int arrival[], int departure[], int n) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platformsNeeded = 1;
        int currentPlatforms = 1;
        int i = 1;
        int j = 0;

        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                currentPlatforms++;
                platformsNeeded = Math.max(platformsNeeded, currentPlatforms);
                i++;
            } else {
                currentPlatforms--;
                j++;
            }
        }

        return platformsNeeded;
    }
}

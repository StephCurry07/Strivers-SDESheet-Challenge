import java.util.ArrayList;

public class missingandrep {

/*******Nice Approach... can apply to many questions...couldn't think of any linear time and constant space solution *********/
    public static int[] missingAndRepeating(ArrayList<Integer> num, int n) {
        int[] result = new int[2];

    for (int i = 0; i < n; i++) {
        int index = Math.abs(num.get(i)) - 1;
        if (num.get(index) > 0) {
            num.set(index,-num.get(index));
        } else {
            result[1] = index + 1; // Repeating number
        }
    }

    for (int i = 0; i < n; i++) {
        if (num.get(i) > 0) {
            result[0] = i + 1; // Missing number
            break;
        }
    }

    return result;
    }
}

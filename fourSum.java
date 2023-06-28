import java.util.Arrays;

public class fourSum {
    // The sum can exceed the range of integer while checking...
    public static String foursum(int[] arr, int target, int n) {
    Arrays.sort(arr);

    for (int i = 0; i < n - 3; i++) {
      for (int j = i + 1; j < n - 2; j++) {
        int newTarget = target - arr[i] - arr[j];
        int left = j + 1;
        int right = n - 1;

        while (left < right) {
          int sum = arr[left] + arr[right];

          if (sum == newTarget) {
            return "Yes";
          } else if (sum < newTarget) {
            left++;
          } else {
            right--;
          }
        }
      }
    }

    return "No";
  }
}

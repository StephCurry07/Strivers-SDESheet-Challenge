public class searchinrotatedsortedarr {
    /*********
     * What has happened to meeeeee(couln't think of...rather not giving more than
     * 10 mins in thinking...idkk this was a good approach...I may not be able to think that)
     */
    public static int search(int arr[], int target) {
        // Write your code here.
        int low = 0;
        int n = arr.length;
        int end = n - 1;
        while (low <= end) {
            int mid = (low + end) / 2;
            if (arr[mid] == target)
                return mid;

            else if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && arr[mid] >= target) {
                    end = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= target && arr[end] >= target)
                    low = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}

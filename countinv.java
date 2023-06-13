public class countinv {

    /**************** Naive Approach O(n^2) ****************/

    public static long getInversions(long arr[], int n) {
        // Write your code here.
        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

/*************** Efficient(Use sorting in modified way) O(n log n) ****************/

    public static long merge(long[] arr, long[] temp, int start, int mid, int end) {
        // long[] merged = new long[end - start + 1];
        int ptr1 = start;
        int ptr2 = mid + 1;
        int k = 0;
        long count = 0;
        while (ptr1 <= mid && ptr2 <= end) {
            if (arr[ptr1] <= arr[ptr2])
                temp[k++] = arr[ptr1++];
            else {
                temp[k++] = arr[ptr2++];
                count += mid - ptr1 + 1;
            }
        }

        while (ptr1 <= mid) {
            temp[k++] = arr[ptr1++];
        }
        while (ptr2 <= end) {
            temp[k++] = arr[ptr2++];
        }

        for (int i = 0; i < k; i++) {
            arr[start + i] = temp[i]; // Copy the merged elements back to the original array starting from the 'start'
                                      // index
        }
        return count;
    }

    public static long mergeSort(long[] arr, long[] temp, int start, int end) {
        long count = 0;
        if (start < end) {
            int mid = start + (end - start) / 2;
            count += mergeSort(arr, temp, start, mid);
            count += mergeSort(arr, temp, mid + 1, end);
            count += merge(arr, temp, start, mid, end);
        }
        return count;
    }

    public static long getInversions1(long arr[], int n) {

        long[] temp = new long[n];
        return mergeSort(arr, temp, 0, n - 1);

    }
}

public class mergesorted {

    /*************** Using another array(Not expected) *************/

    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] temp = new int[m + n];
        while(i < m && j < n){
            if(arr1[i] <= arr2[j])
                temp[k++] = arr1[i++];
            else
                temp[k++] = arr2[j++];
        }

        while(i < m){
            temp[k++] = arr1[i++];
        }

        while(j < n){
            temp[k++] = arr2[j++];
        }

        arr1 = temp;
        return arr1;
    }

    /*************** Without Using another array(in - place) *************/

    public static int[] ninjaAndSortedArrays1(int arr1[], int arr2[], int m, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while(i >= 0 && j >= 0){
            if(arr1[i] <= arr2[j])
                arr1[k--] = arr2[j--];
            else
                arr1[k--] = arr1[i--];
        }

        while(j >= 0){
            arr1[k--] = arr2[j--];
        }

        return arr1;
        // Write your code here.
    }
}

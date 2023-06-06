public class sort012
{
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void sort(int[] arr)
    {
        int n = arr.length;
        int ind0 = 0;
        int ind2 = n - 1;
        for(int i = 0; i <= ind2; i++){
            if(arr[i] == 2){
                swap(arr, i, ind2);
                ind2--;
                i--;
            }
            else if(arr[i] == 0){
                swap(arr, i, ind0);
                ind0++;
            }
            else{
                continue;
            }
        }
        //Write your code here
    }
}
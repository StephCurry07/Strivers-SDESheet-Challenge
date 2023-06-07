public class search2dmat {
    private static boolean search(ArrayList<Integer> arr, int target){
        int high = arr.size() - 1;
        int low = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr.get(mid) > target){
                high--;
            }
            else if(arr.get(mid) < target){
                low++;
            }
            else{
                return true;
            }
        }
        return false;
    }
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        // Write your code here.
        // boolean ans = false;        //if element is not there in the first row itself
        // for(ArrayList<Integer> row : mat){
        //     if(row.get(row.size() - 1) > target){
        //         continue;
        //     }
        //     else{
        //         ans = search(row, target);
        //     }
        // }
        // return ans;


/********************  Treat 2d array as 1d(ANOTHER APPROACH)  *********************/
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        
        int left = 0;
        int right = rows * cols - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int value = matrix.get(row).get(col);
            
            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}
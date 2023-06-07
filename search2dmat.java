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
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        // Write your code here.
        boolean ans;
        for(ArrayList<Integer> row : mat){
            if(row.get(row.size() - 1) > target){
                continue;
            }
            else{
                ans = search(row, target);
            }
        }
        return ans;
    }
}

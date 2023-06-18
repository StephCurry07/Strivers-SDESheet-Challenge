import java.util.ArrayList;

public class rotateMatClockwise {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        // Write your code here.
        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;
        int prev = 0, temp = 0;
        while(left < right && top < bottom){
            prev = mat.get(left + 1).get(top);
            for(int i = left; i <= right; i++){
                temp = mat.get(top).get(i);
                mat.get(top).set(i, prev);
                prev = temp;
            }
            top++;
            
            for(int i = top; i <= bottom; i++){
                temp = mat.get(i).get(right);
                mat.get(i).set(right, prev);
                prev = temp;
            }

            right--;

            if(top <= bottom && left <= right){
                for(int i = right; i >= left; i--){
                    temp = mat.get(bottom).get(i);
                    mat.get(bottom).set(i, prev);
                    prev = temp;
                }
                bottom--;
                for(int i = bottom; i >= top; i--){
                    temp = mat.get(i).get(left);
                    mat.get(i).set(left, prev);
                    prev = temp;
                }
                left++;
            }
        }
    }
}

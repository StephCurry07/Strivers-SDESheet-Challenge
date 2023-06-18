import java.util.ArrayList;

public class nextPerm {
/************ Do it yourself in LeetCode  (couldn't do it) **********/
    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) {
		// Write your code here.
		int i = permutation.size() - 2;

        // Find the first decreasing element from the right
        while (i >= 0 && permutation.get(i) >= permutation.get(i+ 1)) {
            i--;
        }

        if (i >= 0) {
            int j = permutation.size() - 1;
            
            // Find the next greater element than permutation.get(i) from the right
            while (permutation.get(j) <= permutation.get(i)) {
                j--;
            }

            // Swap permutation.get(i) and permutation.get(j)
            swap(permutation, i, j);
        }

        // Reverse the elements from i+1 to the end
        reverse(permutation, i + 1);
		return permutation;
    }

    private static void swap(ArrayList<Integer> permutation, int i, int j) {
        int temp = permutation.get(i);
        permutation.set(i, permutation.get(j));
        permutation.set(j, temp);
    }

    private static void reverse(ArrayList<Integer> permutation, int start) {
        int i = start;
        int j = permutation.size() - 1;

        while (i < j) {
            swap(permutation, i, j);
            i++;
            j--;
        }
	}
}

public class maxXorof2elem {

/********************** Naive Approach O(n^2) O(1)********************/
    public static int maximumXor(int[] A) {
        int n = A.length;
        int ans = 0;
        for(int i = 0; i < n - 1; i++){
            int temp = 0;
            for(int j = i + 1; j < n; j++){
                temp = A[i] ^ A[j];
                ans = Math.max(ans, temp);
            }
        }
        return ans;
        // Write your Code here
    }

/******************** Bit Masking O(nlogM) O(logM)*********************/



/******************* Trie *******************/


}

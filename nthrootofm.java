class nthrootofm{
/********** brute force(optimized) ********/
    public static int NthRoot(int n, int m) {
        // Write your code here.
        if(n == 1){
            return m;
        }
        for(int i = 1; i*i <= m; i++){
            if(m%i == 0){
                int check = 1;
                for(int j = 1; j <= n; j++){
                    check = check * i;
                }
                if(check == m){
                    return i;
                }
            }
            else{
                continue;
            }
        }
        return -1;
    }
/********* can use binary search also **********/
}
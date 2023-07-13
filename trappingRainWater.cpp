long long getTrappedWater(long long* arr, int n) {
    int left = 0;
    int right = n - 1;
    long long leftMax = 0;
    long long rightMax = 0;
    long long ans = 0;
    while(left < right){
        if(arr[left] <= arr[right]){
            if(leftMax < arr[left])
                leftMax = arr[left];
                    else
                        ans += leftMax - arr[left];
                    left++;
        }
        else{
            if(rightMax < arr[right]){
                rightMax = arr[right];
            }
            else
                ans += rightMax - arr[right];
            right--;
        }
    }
    return ans;
}
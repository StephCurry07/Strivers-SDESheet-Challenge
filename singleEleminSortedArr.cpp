#include <iostream>
#include <vector>
/****** Same code doesn't work in java *******/
/**** finally did it...was in attempted section so farr ... TLE in O(n)... did this on LC using binSearch myself using recursion...****/
int singleNonDuplicate(vector<int>& nums){
    int right = nums.size() - 1;
    int left = 0;
    while(left < right){
        int mid = (left + right)/2;
        if((mid&1)){
            mid--;
        }
        if(nums[mid] != nums[mid + 1]){
            right = mid;
        } else {
            left = mid + 2;
        }
    }
    return nums[left];
}
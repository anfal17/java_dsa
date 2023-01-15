/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
*/

//My Approach 1
class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
        int count = 0;
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] == 0){
                count++;
            }
            if(nums[i] != 0){
                nums[k] = nums[i];
                k++;
            }
        }
        
        for(int i = nums.length - count; i < nums.length ; i++){
            nums[i] = 0;
        }
    }
}

//Solution 2
class Solution {
    public void moveZeroes(int[] nums) {
       int leftindex = 0;
       for(int i = 0; i < nums.length ; i++){
           int temp = 0;
           if(nums[i] != 0){
               //swap
               temp = nums[leftindex];
               nums[leftindex] = nums[i];
               nums[i] = temp;
               leftindex++;
           }
       }
    }
}
//By swapping we bring 0's to right

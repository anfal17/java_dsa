/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

*/

//Solution 1
class Solution {
    public void sortColors(int[] nums) {
        int zero = 0 ,one  = 0 , two = 0;

        for(int i = 0; i <nums.length; i++){
            if(nums[i] == 0) zero++;
            if(nums[i] == 1) one++;
            if(nums[i] == 2) two++;
        }

        for(int i = 0; i < zero ; i++)nums[i] = 0;
        for(int i = zero ; i < one +zero ; i++) nums[i] = 1;
        for(int i = one+ zero ; i < nums.length ; i++) nums[i] = 2;
    }
}

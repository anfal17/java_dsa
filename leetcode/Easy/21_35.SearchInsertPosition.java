/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
*/
class Solution {
    public int searchInsert(int[] nums, int target) {
        //As its a soreted array we will use binary search
        int left = 0 , right = nums.length - 1;

        while (left < right){
           int  mid = (left + right) / 2;

           if(nums[mid] == target){
               return mid;
           }
           else if (nums[mid] > target){
               right = mid - 1;
           }
           else{
               left = mid + 1;
           }
        }
        if (nums[left] < target ){
            return left + 1;
        }
        else
        return left; 
    }
}

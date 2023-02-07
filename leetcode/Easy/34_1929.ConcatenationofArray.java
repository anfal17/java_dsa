/*
Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of two nums arrays.

Return the array ans.

Example 1:
Input: nums = [1,2,1]
Output: [1,2,1,1,2,1]
*/

//Solution 1

class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2 * nums.length];

        for(int i =0; i < nums.length ; i++){
            ans[i] = nums[i];
            ans[nums.length + i] = nums[i];
        }
        return ans;
    }
}

//Solution 2
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int [] arr = new int[2*n];
        System.arraycopy(nums,0,arr,0,n);
        System.arraycopy(nums,0,arr,n,n);
        return arr;
    }
}

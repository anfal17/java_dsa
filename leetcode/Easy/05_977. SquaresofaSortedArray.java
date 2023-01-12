//Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

//My Solution 1
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] squared =new int[nums.length];
        int n = 0;
        
        for(int i =0; i< nums.length ; i++){
            n = nums[i];
            squared[i] = n * n;
            n = 0;
        }
        
        Arrays.sort(squared);
        return squared;       
    }
}

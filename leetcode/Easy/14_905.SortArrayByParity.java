/*
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

*/



//Solution 1
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        
        while(i<j){
            if(nums[i]% 2 > nums[j] % 2 ){
                int temp = nums[i]; //If 1 > 0 ==> if no. is odd then swap
                nums[i] = nums[j];
                nums[j] = temp;  
            }
            
            if(nums[i] % 2 == 0){ 
                i++; //If number at beginning is even then let it be
              }
            if(nums[j] % 2 == 1){
                j--; //If number at end is odd then let it be
            }
            
        }
        return nums;
    }
}

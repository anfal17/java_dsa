/*
Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.

*/

//Solution 1
class Solution {
    public int thirdMax(int[] nums) {
        long m1 = Long.MIN_VALUE ;
        long m2 = Long.MIN_VALUE ;
        long m3 = Long.MIN_VALUE ;

        
        if(nums.length == 1){
            return nums[0];
        }
        
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        
        for(int i = 0; i < nums.length ; i++){
            
            //Checking if the element is unique (i.e if is not repeated previously) if not skip
            if( nums[i] == m1 || nums[i] == m2 || nums[i] == m3 ){
                continue;
            }
            
            //if m1 canges all variables are updated
            if(nums[i] > m1){
                m3 = m2;
                m2 = m1;
                m1 =nums[i];
            }
            
            else if(nums[i] > m2){
                m3 = m2;
                m2 = nums[i];
            }
            
            else if(nums[i] > m3 ){
                m3 = nums[i];
            }
            
          }
            //if all still m3 is Integer.Min_Value then return  m1
            if(m3 == Long.MIN_VALUE){
                return (int)m1;
        }
        return (int)m3;
    }
}

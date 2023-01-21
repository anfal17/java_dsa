/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

*/


//Solution 1
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //Creating an ArrayLsit
        ArrayList<Integer> output = new ArrayList<Integer>();
        
        //Creating an arrray to find which elements are present in array nums 
        int[] appeared = new int[nums.length + 1];
        
        for(int i = 0; i <nums.length ; i++){
            appeared[nums[i]]++;
            //If appeared[nums[0]] ==> appeared[4] ==> appeared = [0,0,0,0,1,0,0,0]
        }   //For given array nums --- appeared = [0,1,2,2,1,0,0,1,8]
        
        //starting from 1 as nums[1,n]
        for(int i = 1 ; i < nums.length + 1 ; i++){
            
            //If the element was not present in nums then it will be zero in appeared
            if(appeared[i] == 0){
                output.add(i); 
                //i is the number that was not present in nums
            }           
        }
        return output;
    }
}

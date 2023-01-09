//Given an array nums of integers, return how many of them contain an even number of digits.

//My Solution 1
class Solution {
    public int findNumbers(int[] nums) {
      
        int count = 0;
      
        for(int i =0; i < nums.length; i++ ){
            
            if(nums[i] > 0 ){
                int n = 0;
                int digits = 0;
                n = nums[i];
                
                while(n > 0) { //counting no. of digits in the number
                    n = n/10;
                    digits++;
                }
                
                if(digits % 2 == 0){ //checking if total digits in the number are div by 2
                    count++;
                }
            }          
        }
        return count;
    }
}

//Approach 2
class Solution 
{
    public int findNumbers(int[] nums) 
    {
        int c=0;
        for(int i=0; i<nums.length ; i++)
        {
            String s = Integer.toString(nums[i]); //converting individual element of array into string type then checking if its length is divisible by 2 
            if(s.length() % 2 == 0)
                c++;
        }
        return c;
    }
}

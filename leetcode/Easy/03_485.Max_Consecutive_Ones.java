//Given a binary array nums, return the maximum number of consecutive 1's in the array.

/*Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.*/

//My solution 1
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int j =0;
        int k =0;
        int[] count = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                k++;
                count[j] = k;
            }
            
            if(nums[i] == 0){
                j++;
                k =0;
            }
        }
        //Finding largest in count array;
            int largest = Integer.MIN_VALUE;
            
            for(int i =0; i< count.length; i++){
                if(largest<count[i]){
                    largest = count[i];
                }
            }       
        return largest;
    }
}

//Approach 2
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) 
    {
        int max = 0 , c = 0;
        for(int i = 0; i<nums.length ; i++)
        {
            if( (i == nums.length - 1) && (nums[i] == 1) )
            {
                c++;
                if( c > max)
                    max = c;
                break;
            }
            if(nums[i] == 0)
            {
                if( c > max)
                    max = c;
                c = 0;    
            }
            else
                c++;
        }
        return max;
    }
}

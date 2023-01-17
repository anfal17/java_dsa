/*
Given an array of integers arr, return true if and only if it is a valid mountain array.

Example 3:

Input: arr = [0,3,2,1]
Output: true
*/

//Solution 1
class Solution {
    public boolean validMountainArray(int[] arr) {
        //Finding PEAK
        int i;
        for(i = 0; i < arr.length - 1 ; i++){
            if(arr[i] < arr[i + 1]){
                continue;
            }
            else {
                break;
            }
        }    
        //Peak cannot be present at first and last place
        if(i == 0 || i == arr.length - 1){
                return false;
            }
        
        //Verifying peak from other side
        for(int  j = arr.length - 1; j > i ; j--){
            if(arr[j] < arr[j - 1]){
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
}

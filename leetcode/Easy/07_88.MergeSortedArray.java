//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

//Merge nums1 and nums2 into a single array sorted in non-decreasing order.

//The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

//Example 1:

/*
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
*/

//Approach 1

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {           
        //index used to add element in nums1 from the last
        int last = m + n - 1; //arr.length - 1
        
        //merging the arrays in reverse order starting from last and comparing the mth element in nums 1 and nth element in nums 2 whichever is the largest we add in last index
        
        while(m > 0 && n > 0){
            if(nums1[ m - 1 ] > nums2[n - 1]){
                nums1[last] = nums1[m - 1];
                m--;                
            }
            else{
                nums1[last] = nums2[n - 1];
                n--;
            }
            last--;
        }
        
        //edge case - if there are elements remaining in nums2 they are merged into beginning of nums1
        //fill nums1 with the leftover elements in nums2
        
        while(n > 0){
            nums1[last] = nums2[n - 1];
            n--;
            last--;
        }
        
    }
}

//Approach 2

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for(int i = m; i < nums1.length ; i++){
            nums1[i] = nums2[j];
            j++;
        }
        Arrays.sort(nums1);
    }
}

/*
Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
*/

//My Solution 1
class Solution {
    public boolean isPalindrome(int x) {
        int reverse = 0 , lastdigit = 0;
        int temp = x;
        while(x > 0){
            lastdigit = x % 10;
            reverse = (reverse * 10) + lastdigit ;
            x = x/10 ;
        }

        if(temp == reverse){
            return true;
        }
        return false;
    }
}

/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

*/

//Solution 1 TC O(root of x)
class Solution {
    public int mySqrt(int x) {
        long y =0;
        while(y*y <= x ){
            y++;
        }
        return (int)y - 1;
    }
}

//Solution 2 TC O(log(root(x)))
class Solution {
    public int mySqrt(int x) {
        long start = 0 , end = x ,answer = 0;

        while(start <= end ){
            long mid = start + (end - start) / 2 ;

            if(mid * mid <= x){
                answer = mid;
                start = mid +1 ;
            }
            else{
                end = mid - 1;
            }
        }
        return (int)answer;
    }
}

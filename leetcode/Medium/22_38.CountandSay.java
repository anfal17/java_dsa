/*
Given a positive integer n, return the nth term of the count-and-say sequence.

Example 1:

Input: n = 1
Output: "1"
Explanation: This is the base case.

Example 2:

Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
*/


//solution 1
class Solution {
    public String countAndSay(int n) {
        //base case
        if (n == 1) return "1";

        String s = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        int counter = 0;

        for(int  i = 0; i < s.length() ; i++){
            counter++;

            if(i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)){
                result.append(counter).append(s.charAt(i));
                counter = 0;
            }
        }
        return result.toString();
    }
}

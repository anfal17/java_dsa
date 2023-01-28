/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
*/

//Solution 1
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sc = new StringBuilder();

        //Creating a new string that only contains aplhanumeric charcters
        for(int i =0;i < s.length() ;i++){
            if(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i))){
                sc.append(s.charAt(i)) ;
            }
        }
        int n = sc.length() - 1;

        //Checking if the string is a palindrome
        for(int i =0; i < sc.length()/2 ; i++){
            if(sc.charAt(i) != sc.charAt(n - i)){
                return false;
            }
        }
        return true;

    }
}

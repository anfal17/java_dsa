/*
We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

Example 1:

Input: word = "USA"
Output: true
Example 2:

Input: word = "FlaG"
Output: false


*/

//My Approach 1
class Solution {
    public boolean detectCapitalUse(String word) {

        int count = 0;

      //Count noumber of capital letters
        for(int i=0; i < word.length() ; i++){

            if(word.charAt(i) != Character.toLowerCase(word.charAt(i))){
                    count++;
            }

        }


        if(count == word.length()){
            return true;
        }
        else{
            if(count == 0){
                return true;
            }
            else if(count == 1 && word.charAt(0) != Character.toLowerCase(word.charAt(0)) ){
                 return true;
            }
            else{
                 return false;
            }
        }
     
    }
     
}   

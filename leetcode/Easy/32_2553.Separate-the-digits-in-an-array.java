/*


*/

//Solution 1
class Solution {
    public int[] separateDigits(int[] nums) {
            // create a array list type of Integer
            ArrayList<Integer> al = new ArrayList<>();
            // traversal on the array
            for(int i = 0; i< nums.length; i ++) {
                    // initialize an string and add with array element
                    String s = nums[i]+ "";
                    // now traversal on the string 
                    // after that add in array list and parseint
                    for(int j = 0; j< s.length(); j ++){
                      al.add(Integer.parseInt(s.charAt(j)+""));
                    }
            }
            // initialize the new answer array size of arraylist
            int ans[] = new int[al.size()];
            // now traversal on the arraylist and put all element in the answer array
            for(int i = 0; i< al.size(); i++){
              ans[i] = al.get(i);
            }
            
            return ans;
    }
}

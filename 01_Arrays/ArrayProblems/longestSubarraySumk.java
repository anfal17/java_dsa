

public class longestSubarraySumk {

    int longSubarrWthSumDivByK(int arr[], int n, int k)
    {
        // Complete the function
        Map<Integer,Integer> mp = new HashMap(); //used to store remainder , index
        
        mp.put(0,-1); //initializing with 0 if not found
        
        
        int sum = 0, ans =0 ,rem = 0;
        
        for(int i =0 ; i  <n ; i++) {
            sum += arr[i];
            rem = sum % k;
            
            if(rem < 0) { //for negative remainder
                rem +=k;
            }
            
            mp.putIfAbsent(rem, i);
            
            if(mp.containsKey(rem)){
                ans = Math.max(ans,i - mp.get(rem));
            }
        }
        return ans; 
        }
}

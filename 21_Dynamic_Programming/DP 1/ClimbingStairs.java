import java.util.*;

public class ClimbingStairs{

    //Using only recursion TC-O(2^n)
    public static int countWays(int n){
        if (n==0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return countWays(n-1) + countWays(n-2);
    }

    //Using memoization TC-O(n)
    public static int countWaysMemoization(int n,int[] ways){
        if (n==0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (ways[n] != -1) { //already calculated
            return ways[n];
        }
        ways[n] = countWays(n-1) + countWays(n-2);
        return ways[n];
    }

    //Using Tabulation method
    public static int  countWaysTabulation(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        
        for(int i = 1; i <= n+1; i++){
            if (i == 1) {
                dp[i] = dp[i-1] + 0;
              }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n =5; //no. of stairs
        System.out.println(countWays(n));
        
        int[] ways = new int[n];
        Arrays.fill(ways, -1);

        countWaysMemoization(n,ways);

    }


}
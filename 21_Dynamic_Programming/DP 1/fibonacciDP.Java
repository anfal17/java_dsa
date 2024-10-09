import java.util.*;

/*Fibonacci using DP memoization
 * 
 * Memoization? Top Down approach - call recursion and store answer of overlapping subproblems and reuse
 *  
 */

public class fibonacciDP{

    //TC - O(n)
    public static int fib(int n, int f[]){
        if(n == 0 | n == 1){
            return n;
        }

        //if already calculated
        if(f[n] != 0){
            return f[n];
        }

        f[n] = fib(n-1,f) + fib(n-2);
        return f[n];
    }

    public static int fibTabulation(int n, in[] f){
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n ;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    //TC - O(n)

    public static void main(String[] args) {
        int n =5;
        int f[] = new int[n];

        System.out.println(fib(5,f));

        System.out.println(fibTabulation(5));
    }
}
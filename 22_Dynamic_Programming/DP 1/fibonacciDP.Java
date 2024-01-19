import java.util.*;

/*Fibonacci using DP memoization
 * 
 * Memoization? Top Down approach - call recursion and store answer of overlapping subproblems and reuse
 *  
 */

public class fibonacciDP{

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

    public static void main(String[] args) {
        int n =5;
        int f[] = new int[n];

        System.out.println(fib(5,f));
    }
}
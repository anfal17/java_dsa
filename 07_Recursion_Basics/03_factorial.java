//Print the factorial of a number n

import java.util.*;

public class 03_factorial {
    public static int factorial(int n ){
        if (n == 0) {
            return 1;        
        }
        int fnm1 = factorial(n - 1);
        int fn = n * fnm1;
        return fn;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        
        int n = sc.nextInt();
        
        System.out.println(factorial(n));
    }
}

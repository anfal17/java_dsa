//Print Sum of N numbers

mport java.util.*;

public class 04_sumOfN {
    public static int calcSum(int n) {
        if(n == 1){
            return 1;
        }
        int sumNm1 = calcSum(n -1);
        int sumN = n + sumNm1;
        return sumN;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        
        int n = sc.nextInt();
        
        System.out.println(calcSum(n));
    }
}

import java.util.*;

public class 02_printIncreasing {
    public static void printIncreasing(int n ){
        if (n == 1) {
            System.out.print(1);
            return;
        }
        printIncreasing(n - 1);
        System.out.print(" " + n );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        
        int n = sc.nextInt();
        printIncreasing(n);
    }
}

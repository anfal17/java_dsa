import java.util.*;

public class javabasics {

    public static void oddOREven(int n) {
        int bitMask = 1;

        if ((n & bitMask ) == 0) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
    }

    public static void main(String[] args) {
        int n = 100100;
        oddOREven(n);
    }
}

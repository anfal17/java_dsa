import java.util.*;

public class javabasics {

    public static void kadanes(int arrays[]) {
        int currentsum = 0;
        int maxsum = Integer.MIN_VALUE;

        for (int i = 0; i < arrays.length; i++) {
            currentsum = currentsum + arrays[i];
            if (currentsum < 0) {
                currentsum = 0;
            }
            maxsum = Math.max(currentsum, maxsum);
        }
        System.out.println("Our Max Subarray sum is = "+maxsum);
    }

    public static void main(String[] args) {
        int arrays[] = { 2, 5, 8, 10, 11, 13 };
        kadanes(arrays);

    }
}

//Time complexity = O(n)

import java.util.*;

public class Max_Subarray_Bruteforce {

    public static void subarray(int arrays[]) {
        int currentsum = 0;
        int maxsum = Integer.MIN_VALUE;
      
        for (int i = 0; i < arrays.length; i++) {
            int start = i;
            currentsum = 0;

            for (int j = i; j < arrays.length; j++) {
                int end = j;
              
                for (int k = start; k <= end; k++) {
                    currentsum += arrays[k];
                }
                System.out.println(currentsum);
                if (maxsum < currentsum) {
                    maxsum = currentsum;
                }
            }
        }
        System.out.println("MaxSum = " + maxsum);
    }

    public static void main(String[] args) {
        int arrays[] = { 2, 5, 8, 10, 11, 13 };
        subarray(arrays);
    }
}

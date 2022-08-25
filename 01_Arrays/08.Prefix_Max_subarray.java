import java.util.*;

public class javabasics {

    public static void maxsubarray(int arrays[]) {
        int currentsum = 0;
        int maxsum = Integer.MIN_VALUE;
        int prefix[] = new int[arrays.length];

        prefix[0] = arrays[0];
        //prefix array calculation
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i-1] + arrays[i];
         }


        for (int i = 0; i < arrays.length; i++) {
            int start = i;

            for (int j = i; j < arrays.length; j++) {
                int end = j;

                currentsum = start == 0 ? prefix[end]:prefix[end] - prefix[start - 1];
               
                if (maxsum < currentsum) {
                    maxsum = currentsum;
                }
            }
        }
        System.out.println("MaxSum = " + maxsum);
    }

    public static void main(String[] args) {
        int arrays[] = { 2, 5, 8, 10, 11, 13 };
        maxsubarray(arrays);

    }
}
//Time complexity O(n²)

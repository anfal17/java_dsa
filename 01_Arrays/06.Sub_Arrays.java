import java.util.*;

public class Sub_Arrays {

    public static void subarray(int arrays[]) {
      
        for (int i = 0; i < arrays.length; i++) {
            int start = i;

            for (int j = i; j < arrays.length; j++) {
                int end = j;
              
                for (int k = start; k <= end; k++) {
                    System.out.print(arrays[]+" ");
                }
              System.out.println();
           }
          System..out.println();
        }        
    }

    public static void main(String[] args) {
        int arrays[] = { 2, 5, 8, 10, 11, 13 };
        subarray(arrays);

    }
}


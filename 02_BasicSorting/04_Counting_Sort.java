import java.util.*;

public class javabasics {

    public static void countingsort(int array[]) {
        // To find array size
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            largest = Math.max(largest, array[i]);
        }

        // Counting frequency of numbers
        int count[] = new int[largest + 1];
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }

        // sorting
        int j = 0; // index in original array
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                array[j] = i;
                j++; // next index
                count[i]--; // Decreasing frequency of the element
            }
        }

    }

    public static void main(String[] args) {
        int array[] = { 1, 4, 1, 3, 2, 4, 3, 7 };
        countingsort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
// Time Complexity O(n+range)

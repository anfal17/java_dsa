import java.util.*;

public class javabasics {

    public static void bubblesort(int array[]) {
        for (int turn = 0; turn < array.length - 1; turn++) {
            // int swap = 0;
            for (int j = 0; j < array.length - 1 - turn; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    // swap++; swap is used if the guven array is already sorted and doesnt need futher sorting
                }
            }
            // if (swap == 0) {
            //     break;
            // }
        }
    }

    public static void main(String[] args) {
        int array[] = { 5, 4, 1, 2, 3 };
        bubblesort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
// Time Complexity O(n²)

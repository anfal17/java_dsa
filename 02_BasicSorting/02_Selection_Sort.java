import java.util.*;

public class javabasics {

    public static void selectionsort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            int minpos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minpos] > array[j]) {
                    minpos = j;
                }

            }
            int temp = array[minpos];
            array[minpos] = array[i];
            array[i] = temp;

        }
    }

    public static void main(String[] args) {
        int array[] = { 5, 4, 1, 2, 3 };
        selectionsort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
// Time Complexity O(n²)

import java.util.*;

public class javabasics {

    public static void insertionsort(int array[]) {
        for (int i = 1; i < array.length ; i++) {
            int current = array[i]; //acts as temporary
            int previous = i - 1;
            //Finding correct position for insertion
            while (previous>=0 && array[previous]>current) {
                array[previous + 1] = array[previous]; //storing previous element at current index
                previous -- ;
            }
            //inserting
            array[previous + 1] = current;

        }
    }

    public static void main(String[] args) {
        int array[] = { 5, 4, 1, 2, 3 };
        insertionsort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
// Time Complexity O(n²)

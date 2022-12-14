import java.util.*;

public class Largest_Number {

    public static void largest(int arrays[]){
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < arrays.length; i++) {
            if (largest < arrays[i]) {
                largest = arrays[i];
            }
            if (smallest > arrays[i]) {
                smallest = arrays[i];
            }
        }
        System.out.println("Smallest number is "+smallest);
        System.out.println("Largest number is "+largest);
    }

    public static void main(String[] args) {
        int arrays[] = new int[4];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = sc.nextInt();

        }

        largest(arrays);

    }
}

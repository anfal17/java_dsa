import java.util.*;

public class Binary_search {

    public static int binarysearch(int arrays[], int key) {
        int start = 0;
        int end = arrays.length - 1;
        while (start<=end) {
            int mid = (start+end)/2;

            if (arrays[mid]==key) {
                return mid;
            }
            if (arrays[mid]<key) {
                start = mid +1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arrays[] = {2,5,8,10,11,13};
        int key = 13;
        
        System.out.println("Index of key "+key+" is "+binarysearch(arrays,key));
    }
}


//Time complexity of Binary search O(logn)
//Time complexity of Linear search O(n)

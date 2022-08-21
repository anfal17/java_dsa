
public class Reverse_Array {

    public static void reverse(int arrays[]) {
        int first = 0;
        int last = arrays.length - 1;
        while (first < last) {
            int temp = arrays[last];
            arrays[last] = arrays[first];
            arrays[first] = temp;
            first ++;
            last --;
        }
    }

    public static void main(String[] args) {
        int arrays[] = { 2, 5, 8, 10, 11, 13 };
        reverse(arrays);
        for (int j = 0; j < arrays.length; j++) {
            System.out.print(arrays[j]+" ");
        }   

    }
}

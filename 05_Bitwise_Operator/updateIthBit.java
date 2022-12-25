import java.util.*;

public class javabasics {

    public static int clearIthBit(int n, int i) {

        int bitMask = ~(1 << i);

        return n & bitMask;

    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;

        return n | bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit) {

        // Approach 1
        // if (newBit == 0) {
        //    return clearIthBit(n, i);
        // } else {
        //     return setIthBit(n, i);
        // }

        //Approach 2

        n  = clearIthBit(n, i);

        int BitMask = newBit << i;

        return n | BitMask;

    }

    public static void main(String[] args) {

        System.out.println(updateIthBit(10, 1, 0));

    }
}

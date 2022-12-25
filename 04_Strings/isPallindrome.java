import java.util.*;

public class javabasics {

    public static boolean isPallindrome(String string) {
        
        for (int i = 0; i < string.length()/2; i++) {
            int n = string.length();
            if (string.charAt(i) != string.charAt(n-1-i)) {
                return false;
            }
        }
     return true;
    }

    public static void main(String[] args) {
        String string = "racecar";
        System.out.println(isPallindrome(string));
    }
}

import java.util.*;

public class javabasics {

    public static String substring(String string, int si ,int ei) {
        String substr = "";

        for (int i = si; i < ei; i++) {
            substr += string.charAt(i);
        }

     return substr;
    }

    public static void main(String[] args) {
        String string = "Hello World";
        System.out.println(substring(string,0,5)); 
    }
}

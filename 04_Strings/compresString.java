import java.util.*;

public class javabasics {

    public static String compress(String str) {

        //String newstr = "";
        StringBuilder newstr = new StringBuilder("");

        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;

            while (i<str.length() - 1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            
            //newstr += str.charAt(i);
            newstr.append(str.charAt(i));
           

            if (count>1) {
                //newstr += count.toString();
                newstr.append(count.toString());    
            }
        }
        //return newstr;
        return newstr.toString();
    }

    public static void main(String[] args) {
        String str = "aaabbcccdddd";

        System.out.println(compress(str));

    }
}

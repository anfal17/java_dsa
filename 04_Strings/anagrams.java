/*What are anagrams?
If two strings contain the same characters but in a different order, they can be said to be
anagrams. Consider race and care. In this case, race's characters can be formed into a study,
or care's characters can be formed into race. Below is a java program to check if two strings
are anagrams or not.
 */

import java.util.*;

public class javabasics {

    public static void anagrams(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if (str1.length() == str2.length()) {
            char[] str1CharArray = str1.toCharArray();
            char[] str2CharArray = str2.toCharArray();

            Arrays.sort(str1CharArray);
            Arrays.sort(str2CharArray);

            boolean result = Arrays.equals(str1CharArray, str2CharArray);

            if (result) {
                System.out.println(str1 + " and " + str2 + " are anagrams");
            } else {
                System.out.println(str1 + " and " + str2 + " are not anagrams");
            }

        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams");
        }

    }

    public static void main(String[] args) {
        String str1 = "race";
        String str2 = "care";

        anagrams(str1, str2);

    }
}

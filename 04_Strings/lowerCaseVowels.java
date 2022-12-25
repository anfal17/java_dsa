import java.util.*;
/*Count how many times lowercase vowels occurred in a String entered by the
user.*/


public class javabasics {

    public static int lowerCaseVowels(String str) {

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }

            /*if (Char == 'a') {
                count++;
            }
            else if (Char == 'e') {
                count++;
            }
            else if (Char == 'i') {
                count++;
            }
            else if (Char == 'o') {
                count++;
            }
            else if (Char == 'u') {
                count++;
            } */

        }
        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String");

        String str = sc.nextLine();

        System.out.println("Number of Vowels : " + lowerCaseVowels(str));


    }
}

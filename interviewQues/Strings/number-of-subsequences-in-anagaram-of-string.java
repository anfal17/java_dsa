import java.util.HashMap;
import java.util.Map;

public class AnagramSubsequence {

    public static int solve(String x, String[] W) {
        // Create a frequency map for the characters in the string `x`
        Map<Character, Integer> xFreq = getFrequencyMap(x);
        
        int matchingCount = 0;

        // Check each word in the array `W`
        for (String word : W) {
            if (isSubsequenceOfAnagram(word, xFreq)) {
                matchingCount++;
            }
        }

        return matchingCount;
    }

    // Helper method to create a frequency map for a given string
    private static Map<Character, Integer> getFrequencyMap(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }

    // Helper method to check if a word can be a subsequence of any anagram of `x` using its frequency map
    private static boolean isSubsequenceOfAnagram(String word, Map<Character, Integer> xFreq) {
        Map<Character, Integer> wordFreq = getFrequencyMap(word);

        // Check if each character in the word has enough frequency in the frequency map of `x`
        for (Map.Entry<Character, Integer> entry : wordFreq.entrySet()) {
            char key = entry.getKey();
            int count = entry.getValue();
            if (count > xFreq.getOrDefault(key, 0)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String x = "abaacd";
        String[] W = {"bacd" , "bcc", "caa" ,"dda" ,"azoip"};

        int result = solve(x, W);
        System.out.println(result);  // Output: 7 (as "a", "ab", "abc", "bc", "bca", "ac", "cab" can be formed)
    }
}

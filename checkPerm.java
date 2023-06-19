import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class checkPerm {

    /******** for smaller strings *******/
    public static boolean areAnagram(String str1, String str2){
        // Write your code here.
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(s2);

        return Arrays.equals(s1, s2);           // new method... for comparing array contents
    }

    /********** Efficient for larger strings ***********/

    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        // Create frequency maps for both strings
        Map<Character, Integer> frequencyMap1 = getCharacterFrequency(s1);
        Map<Character, Integer> frequencyMap2 = getCharacterFrequency(s2);

        // Compare frequency maps
        return frequencyMap1.equals(frequencyMap2);
    }

    private static Map<Character, Integer> getCharacterFrequency(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }
}
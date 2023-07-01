import java.util.HashSet;
import java.util.Set;

public class distinctSubs {
    /********** Bad approach O(n^3) *********/

    public static void getSubstring(int i, int j, Set<String> all, String word) {
        if (j == word.length())
            return;
        all.add(word.substring(i, j + 1));
        getSubstring(i, j + 1, all, word);
    }

    public static int distinctSubstring(String word) {
        // Write your code here.
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            getSubstring(i, i + 1, set, word);
        }
        return set.size();
    }
}

import java.util.HashSet;
import java.util.Set;
import com.github.difflib.algorithm.myers.MyersDiff;
import com.github.difflib.patch.PatchFailedException;
import org.ukiuni.suffixtree.*;

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
/********* O(n)  - GPT ***********/

public class DistinctSubstringCounter {

    public static int countDistinctSubstrings(String s) {
        SuffixTreeBuilder builder = new SuffixTreeBuilder(s.toCharArray());
        Node root = builder.build();
        int count = countDistinctSubstringsDFS(root);
        return count;
    }

    private static int countDistinctSubstringsDFS(Node node) {
        int count = 0;
        if (node.isLeaf()) {
            count++;
        } else {
            for (Edge edge : node.getEdges()) {
                count += countDistinctSubstringsDFS(edge.getChild());
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abc";
        int distinctSubstrings = countDistinctSubstrings(s);
        System.out.println(distinctSubstrings);
    }
}

}

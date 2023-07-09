class Node {
    Node[] links = new Node[26];
    boolean flag;

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    Node getNode(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }
}

class Trie {
    private static Node root;

    Trie() {
        root = new Node();
    }

    void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.getNode(ch);
        }
        node.flag = true;
    }

    boolean checkAllPrefix(String word) {
        Node node = root;
        boolean check = true;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.getNode(ch);
                if (node.flag == false)
                    return false;
            }
        }
        return check;
    }

}

public class CompleteString {

    public static String completeString(int n, String[] a) {
        Trie trie = new Trie();
        for (String x : a) {
            trie.insert(x);
        }
        String ans = "";
        for (String x : a) {
            if (trie.checkAllPrefix(x)) {
                if (ans.length() < x.length()) {
                    ans = x;
                } else if (ans.length() == x.length() && x.compareTo(ans) < 0) {
                    ans = x;
                }
            }
        }
        return ans == "" ? "None" : ans;
    }
}

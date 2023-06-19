public class implementTrie {
    class Node {
        Node links[] = new Node[26];
        boolean flag = false;

        public boolean contains(char ch) {
            if (links[ch - 'a'] != null) {
                return true;
            }
            return false;
        }

        void createRef(char ch, Node newRef) {
            links[ch - 'a'] = newRef;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }
    }

    public class Trie {

        // Initialize your data structure here
        private static Node root;

        Trie() {
            // Write your code here
            root = new Node();
        }

        // Inserts a word into the trie

        public static void insert(String word) {
            // Write your code here
            Node node = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                if (!node.contains(ch)) {
                    node.createRef(ch, new Node());
                }
                node = node.get(word.charAt(i));
            }
            node.flag = true;
        }

        // Returns if the word is in the trie

        public static boolean search(String word) {
            // Write your code here
            Node node = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                if (!node.contains(ch))
                    return false;
                node = node.get(ch);
            }
            if (node.flag == true)
                return true;
            return false;
        }

        // Returns if there is any word in the trie that starts with the given prefix

        public static boolean startsWith(String prefix) {
            // Write your code here
            Node node = root;
            int n = prefix.length();
            for (int i = 0; i < n; i++) {
                char ch = prefix.charAt(i);
                if (!node.contains(ch))
                    return false;
                node = node.get(ch);
            }
            return true;
        }
    }
}

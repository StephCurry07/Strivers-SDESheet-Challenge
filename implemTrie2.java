public class implemTrie2 {
    public class Trie {
        class Node {
            Node[] links = new Node[26];
            int wordcount = 0;
            int prefcount = 0;

        }

        Node root;

        public Trie() {
            root = new Node();
            // Write your code here.
        }

        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.links[word.charAt(i) - 'a'] == null) {
                    node.links[word.charAt(i) - 'a'] = new Node();
                }
                node = node.links[word.charAt(i) - 'a'];
                node.prefcount++;
            }
            node.wordcount++;
            // Write your code here.
        }

        public int countWordsEqualTo(String word) {
            // Write your code here.
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.links[word.charAt(i) - 'a'] != null) {
                    node = node.links[word.charAt(i) - 'a'];
                } else
                    return 0;
            }
            return node.wordcount;
        }

        public int countWordsStartingWith(String word) {
            // Write your code here.
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.links[word.charAt(i) - 'a'] != null) {
                    node = node.links[word.charAt(i) - 'a'];
                } else
                    return 0;
            }
            return node.prefcount;
        }

        public void erase(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.links[word.charAt(i) - 'a'] != null) {
                    node = node.links[word.charAt(i) - 'a'];
                    node.prefcount--;
                }
            }
            node.wordcount--;
            // Write your code here.
        }
    }

}

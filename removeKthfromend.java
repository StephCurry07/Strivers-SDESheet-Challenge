public class removeKthfromend {
    class Node {
        public int data;
        public Node next;
        public Node prev;

        Node() {
            this.data = 0;
            this.next = null;
            this.prev = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
            this.prev = next;
        }
    }

    /******************** GFG(Surprised that I couldn't do it) *******************/
    public static Node removeKthNode(Node head, int K) {
        Node temp = head;
        // Node prev = null;
        int n = 0;
        while (temp != null) {
            // prev = temp;
            temp = temp.next;
            n++;
        }
        if (K == n) {
            return head.next;
        } else {
            int diff = n - K;
            Node prev = null;
            Node curr = head;
            for (int i = 0; i < diff; i++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
        }
        return head;
        /************
         * Cases were not just passing...Maybe due to edge cases but 2/20 4/20....idk
         * how that works
         **************/
    }
}

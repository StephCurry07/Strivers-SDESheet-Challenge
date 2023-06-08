public class cycleDetectLL {
    class Node {
        public int data;
        public Node next;

        Node() {
            this.data = 0;
            this.next = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /*********** Floyd's Algo ***********/
    public static boolean detectCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /************* Check Brent's Algo(Faster than floyd's) ***************/
    public static boolean detectCycle1(Node head) {
        Node slow = head;
        Node fast = head.next;
        int power = 1;
        int length = 1;

        while (fast != null && fast != slow) {

            if (length == power) {

                // updating the power.
                power *= 2;

                // updating the length
                length = 0;

                slow = fast;
            }

            fast = fast.next;
            ++length;
        }

        // if it is null then no loop
        if (fast == null)
            return false;
        return true;

/************Checks the location of loop ***********/
        // length stores actual length of the loop.

        // Now set slow to the beginning
        // and fast to head+length i.e length of the cycle.
        slow = fast = head;
        while (length > 0) {
            fast = fast.next;
            --length;
        }

        // Now move both pointers by one node so that they meet at the beginning loop.
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

public class cycleDetectLL2 {
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

    public static Node firstNode(Node head) {
        Node slow = head;
        Node fast = head;
        int flag = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag++;
                break;
            }
        }
        if (flag == 0) {
            return null;
        }

/*************** My method  (Uses MAX_INT space) ****************/
        fast = head;
        boolean[] visited = new boolean[1 << 15];
        while (!visited[fast.data]) {
            visited[fast.data] = true;
            fast = fast.next;
        }

        //return fast;
        
/********************* Original Method(Maths Proof) **********************/
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
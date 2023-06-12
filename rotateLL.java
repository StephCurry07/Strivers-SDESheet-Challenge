public class rotateLL {

/**************** Look the way you are shifting.... can use slow fast pointer for professionalism *****************/
    public static Node rotate(Node head, int k) {
        // Write your code here.
        if (head == null || k == 0) {
            return head;
        }
        int len = 1;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        int shift = k % len;
        if (shift == 0) {
            return head;
        }
        shift = len - shift;
        Node temp = head;
        Node dummy = new Node(0,head);
        // dummy.next = head;
        while(shift != 0){
            dummy = dummy.next;
            temp = temp.next;
            shift--;
        }
        Node newHead = new Node(0,temp);
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        dummy.next = null;
        return newHead.next;
    }
}

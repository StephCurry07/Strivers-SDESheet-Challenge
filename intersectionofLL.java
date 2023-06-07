public class intersectionofLL {
    class Node {
        public int data;
        public Node next;
   
        Node()
        {
            this.data = 0;
            this.next = null;
        }
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
        Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
    /*
     * @param firstHead
     * @param secondHead
     * @return the value of the node where these intersect. Doubt is if they don't intersect still it passes the test cases
     */ 
// Don't know how it passed all test cases... will try another approach as time and memory consumption was very poooor...beats less than 1%. According to me it should haven't passed the cases in which there is no intersection.
    //<issue_comment>username_1: @username_0  I would like to work on this issue.
    public static int findIntersection(Node firstHead, Node secondHead) {
        Node start = firstHead.next;
        Node temp = firstHead;
        while(start != null){
            temp.next = null;
            temp = start;
            start = start.next;
        }
        Node find = secondHead;
        while(find.next != null){
            find = find.next;
        }
        return find.data;
    }
    

    /*************** Second Method(Looks like this is what was expected) *******************/
    private static int getLength(Node node){
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }

    public static int findIntersection1(Node firstHead, Node secondHead) {
        int len1 = getLength(firstHead);
        int len2 = getLength(secondHead);
        int diff = len1 - len2;
        while(diff < 0){
            secondHead = secondHead.next;
            diff++;
        }
        while(diff > 0){
            firstHead = firstHead.next;
            diff--;
        }
        while(firstHead != null && secondHead != null){
            if(firstHead == secondHead)
                return firstHead.data;
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
        return -1;
    }

    
}

public class mergesortedLL {
    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		// Write your code here.
        LinkedListNode<Integer> node = new LinkedListNode<Integer>(0);
        LinkedListNode<Integer> dummy = node;
        while(first != null && second != null){
            if(first.data < second.data){
                node.next = first;
                node = node.next;
                first = first.next;
            }
            else{
                node.next = second;
                node = node.next;
                second = second.next;
            }
        }
        while(first != null){
            node.next = first;
            node = node.next;
            first = first.next;
        }
        while(second != null){
            node.next = second;
            node = node.next;
            second = second.next;
        }
        return dummy.next;
	}
}

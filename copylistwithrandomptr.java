public class copylistwithrandomptr {
    class LinkedListNode<T> {
	    T data;
	    LinkedListNode<T> next;
	    LinkedListNode<T> random;

	    public LinkedListNode(T data) {
		    this.data = data;
	    }
    }

    public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> ans = new LinkedListNode(-1);
		if(head == null){
			return head;
		}
		if(head.next == null){
			LinkedListNode<Integer> edge = new LinkedListNode(head.data);
			edge.random = head.random;
			return edge;
		}
		ans.next = new LinkedListNode(head.data);
		ans.next.next = head.next;
		ans.next.random = head.random;
		LinkedListNode<Integer> finAns = ans.next;
		LinkedListNode<Integer> node = head.next;
		LinkedListNode<Integer> temp;
		while(node != null){
			temp = new LinkedListNode(node.data);
			temp.next = node.next;
			temp.random = node.random;
			ans.next = temp;
			node = node.next;
			ans = ans.next;
		}
		return finAns;
	}
}

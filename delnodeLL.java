public class delnodeLL {
    public static void removeNode(LinkedListNode<Integer> node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}

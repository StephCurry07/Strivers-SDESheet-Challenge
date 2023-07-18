import java.util.HashMap;

/********* Good concept for DLL (Implement all next and prev)*********/
public class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    static HashMap<Integer, Node> map;
    int cap;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    LRUCache(int capacity) {
        map = new HashMap<>();
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    void addNode(Node node){
        map.put(node.key, node);
        Node temp = head.next;
        Node newNode = node;
        head.next = newNode;
        newNode.prev = head;
        temp.prev = newNode;
        newNode.next = temp;
    }

    void deleteNode(Node node){
        map.remove(node.key);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        // Write your code here
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            addNode(node);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            deleteNode(map.get(key));
        }
        if(cap == map.size()){
            deleteNode(tail.prev); 
        }
        addNode(new Node(key, value));
    }
}


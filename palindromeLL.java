public class palindromeLL {
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
        public LinkedListNode(T data) {
            this.data = data;
        }
    }

    /**********Don't know what's wrong with it....It just doesn't pass the test case...Even if the values are equal it executes the if statement for not equal. Tried it with my approach and original approach too. ***********/
    
    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        if (head == null || head.next == null) {
            return true;
        }
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> prev;
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> cur;

        int n = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            n++;
        }

        if (fast != null) {
            slow = slow.next;
        }

        fast = null;
        prev = null;
        cur = slow.next;
        while (cur != null) {
            fast = cur.next;
            cur.next = prev;
            prev = cur;
            cur = fast;
        }
        while (prev != null && head != null) {
            if (head.data != prev.data) {
                System.out.println(head.data + " " + prev.data);
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        return true;
    }

/************************Other approach..Similar...just pointing to null*************************/

    public static boolean isPalindrome1(LinkedListNode<Integer> head) {
		if (head == null || head.next == null) {
			// An empty list or a list with only one node is considered a palindrome
			return true;
		}

		// Step 1: Find the middle of the linked list
		LinkedListNode<Integer> slow = head;
		LinkedListNode<Integer> fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// If the linked list has an odd number of nodes, skip the middle node
		if (fast != null) {
			slow = slow.next;
		}

		// Step 2: Reverse the second half of the linked list
		LinkedListNode<Integer> reversed = reverseList(slow);

		// Step 3: Compare the reversed second half with the first half
		LinkedListNode<Integer> curr1 = head;
		LinkedListNode<Integer> curr2 = reversed;
		while (curr1 != null && curr2 != null) {
			if (curr1.data != curr2.data) {
				return false; // The values don't match, not a palindrome
			}
			curr1 = curr1.next;
			curr2 = curr2.next;
		}

		return true; // All values matched, it's a palindrome
	}

	private static LinkedListNode<Integer> reverseList(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> prev = null;
		LinkedListNode<Integer> curr = head;
		while (curr != null) {
			LinkedListNode<Integer> next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}
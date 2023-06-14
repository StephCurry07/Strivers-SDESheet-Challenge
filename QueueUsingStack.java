import java.util.Stack;

public class QueueUsingStack {

    /******************** Using 2 stacks(better exists) ********************/
    class Queue {
        // Define the data members(if any) here.
        private Stack<Integer> stack;
        Stack<Integer> st1;
        Stack<Integer> st2;

        Queue() {
            st1 = new Stack<>();
            st2 = new Stack<>();
            stack = new Stack<>();
            // Initialize your data structure here.
        }

        void enQueue(int val) {
            st1.push(val);
            // Implement the enqueue() function.
        }

        int deQueue() {
            if (st1.isEmpty())
                return -1;
            while (st1.size() != 1) {
                st2.add(st1.pop());
            }
            int ans = st1.pop();
            while (!st2.isEmpty()) {
                st1.add(st2.pop());
            }
            return ans;
            // Implement the dequeue() function.
        }

        int Peek() {
            if (st1.isEmpty())
                return -1;
            while (!st1.isEmpty()) {
                st2.add(st1.pop());
            }
            int ans = st2.peek();
            while (!st2.isEmpty()) {
                st1.add(st2.pop());
            }
            return ans;
            // Implement the peek() function here.
        }

        boolean isEmpty() {
            if (st1.size() == 0)
                return true;
            return false;
            // Implement the isEmpty() function here.
        }

        /****************** Using 1 stack(Recursion) *******************/

        public void enqueue(int x) {
            // Push the new element onto the stack
            stack.push(x);
        }

        public int dequeue() {
            // Base case: If the stack is empty, return -1
            if (stack.isEmpty()) {
                return -1;
            }

            // If the stack has only one element, pop and return it
            if (stack.size() == 1) {
                return stack.pop();
            }

            // Recursive case: Pop an element from the top of the stack
            int item = stack.pop();

            // Recursively call dequeue to remove the bottom element and get its value
            int front = dequeue();

            // Push the popped element back onto the stack
            stack.push(item);

            // Return the value of the bottom element
            return front;
        }

        public int peek() {
            // Base case: If the stack is empty, return -1
            if (stack.isEmpty()) {
                return -1;
            }

            // If the stack has only one element, return its value
            if (stack.size() == 1) {
                return stack.peek();
            }

            // Recursive case: Pop an element from the top of the stack
            int item = stack.pop();

            // Recursively call peek to get the value of the bottom element
            int front = peek();

            // Push the popped element back onto the stack
            stack.push(item);

            // Return the value of the bottom element
            return front;
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
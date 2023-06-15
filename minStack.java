import java.util.Stack;

public class minStack {
/******** Maintaining two stacks ********/
    static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        // Constructor
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
            // Write your code here.
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            if(minStack.isEmpty() || minStack.peek() >= num){
                minStack.push(num);
            }
            stack.push(num);
            // Write your code here.
        }

        // Function to remove the top element of the stack.
        int pop() {
            if(!stack.isEmpty()){
                int popped = stack.pop();
                if(popped == minStack.peek())
                    minStack.pop();
                return popped;
            }
            return -1;
            // Write your code here.
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            if(!stack.isEmpty())
                return stack.peek();
            return -1;
            // Write your code here.
        }

        int getMin() {
            if(!minStack.isEmpty())
                return minStack.peek();
            return -1;
        }
    }
}

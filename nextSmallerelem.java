import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class nextSmallerelem {

/************ Smart Approach...trraversing opposite and using stack (Not able to solve any of these...what happen today*********/
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> nums, int n){
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    // Iterate over the elements from right to left
    for (int i = nums.size() - 1; i >= 0; i--) {
        int current = nums.get(i);

        // Pop elements from the stack until a smaller element is found
        while (!stack.isEmpty() && stack.peek() >= current) {
            stack.pop();
        }

        // If stack is empty, there is no smaller element
        // Otherwise, the top element is the next smaller element
        if (stack.isEmpty()) {
            result.add(-1);
        } else {
            result.add(stack.peek());
        }

        stack.push(current);
    }

    Collections.reverse(result);
    return result;
    }
}

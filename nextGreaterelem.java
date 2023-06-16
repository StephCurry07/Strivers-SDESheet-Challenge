import java.util.Stack;

public class nextGreaterelem {
    public static int[] nextGreater(int[] arr, int n) {
        // Write Your code here
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        int k = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            while (!stack.isEmpty() && stack.peek() < curr) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[k] = -1;
            } else {
                ans[k] = stack.peek();
            }
            k--;
            stack.push(curr);
        }
        return ans;
    }
}

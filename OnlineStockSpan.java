import java.util.ArrayList;
import java.util.Stack;

public class OnlineStockSpan {

/*************** My Method TC > O(n) SC - O(1)**************/

    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        // Write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < price.size(); i++) {
            int temp = price.get(i);
            max = Math.max(temp, max);
            int count = 1;
            int ind = i;
            if (max > temp) {
                while (i > 0 && temp >= price.get(i - 1)) {
                    count += list.get(i - 1);
                    i = i - list.get(i - 1);
                }
            } else {
                count += i;
            }
            i = ind;
            list.add(count);
        }
        return list;
    }

/************* Official Method  TC- O(n) SC - O(n) **********/
    public static int[] calculateStockSpan(int[] prices) {
        int[] spans = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        // Push index of first day to stack
        stack.push(0);
        spans[0] = 1;
        
        for (int i = 1; i < prices.length; i++) {
            // Pop elements from stack while the stock price at the top is less than or equal to the current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i])
                stack.pop();
            
            // Calculate the span for the current day
            spans[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            
            // Push the current day's index to the stack
            stack.push(i);
        }
        
        return spans;
    }
}
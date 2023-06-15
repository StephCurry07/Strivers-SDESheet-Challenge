import java.util.Stack;

public class validParenthesis {
    public static boolean isValidParenthesis(String expression) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < expression.length(); i++){
            if(!st.isEmpty() && expression.charAt(i) == ')' && st.peek() == '('){
                st.pop();
            }
            else if(!st.isEmpty() && expression.charAt(i) == '}'  && st.peek() == '{'){
                st.pop();
            }
            else if(!st.isEmpty() && expression.charAt(i) == ']'  && st.peek() == '['){
                st.pop();
            }
            else{
                st.push(expression.charAt(i));
            }
        }
        return st.isEmpty();
    }

    /************ Clean *************/
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

import java.util.Stack;

public class sortStack {

/*********** couldn't think of the main function calling itself for iterating through each elem ************/
    static void insert(Stack<Integer> st, int elem){
		if(st.isEmpty() || st.peek() <= elem){
			st.push(elem);
		}
		else{
			int temp = st.pop();
			insert(st, elem);
			st.push(temp);
		}
	}

	public static void sortStackDescending(Stack<Integer> stack) {
		// Write your code here.
		if(!stack.isEmpty()){
			int temp = stack.pop();
			sortStackDescending(stack);
			insert(stack, temp);
		}
	}
}

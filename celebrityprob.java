import java.util.Stack;

public class celebrityprob {
/********** Suggested TC - O(n) SC - O(n) **********/
    public static int findCelebrity(int n) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < n; i++){
			stack.push(i);
		}
		int celeb = -1;
		while(!stack.isEmpty()){
			int first = stack.pop();
			if(!stack.isEmpty()){
				int second = stack.peek();
				if(!Runner.knows(first, second)){
					stack.pop();
					stack.push(first);
				}
			}
			else{
				celeb = first;
			}
		}
		int count = 0;
		for(int i = 0; i < n; i++){
			if(Runner.knows(i, celeb) && !Runner.knows(celeb, i)){
				count++;
			}
		}
		return count == n-1 ? celeb : -1;
	}

/*********** Better...should have thought (I couldn't even do in n^2 :<) **********/
/***** TC - O(n) SC - O(1) */
    public static int findCelebrity1(int n) {
		int celeb = 0;
		for (int i = 1; i < n; i++) {
			if (Runner.knows(celeb, i)) {
				celeb = i;
			}
		}

		for (int i = 0; i < n; i++) {
			if (i != celeb && (Runner.knows(celeb, i) || !Runner.knows(i, celeb))) {
				return -1;
			}
		}
		return celeb;
	}
}

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class stackUsinqueue {
    class Stack {
        private Queue<Integer> queue;
        Queue<Integer> q1;
        Queue<Integer> q2;

        // Define the data members.

        public Stack() {
            q1 = new ArrayDeque<>();
            q2 = new ArrayDeque<>();
            queue = new LinkedList<>();
            // Implement the Constructor.
        }

        /*----------------- Public Functions of Stack -----------------*/

/********** Using two queues *************/
        public int getSize() {
            return q1.size();
            // Implement the getSize() function.
        }

        public boolean isEmpty() {
            return q1.size() == 0 ? true : false;
            // Implement the isEmpty() function.
        }

        public void Push(int element) {
            q1.offer(element);
            // Implement the push(element) function.
        }

        public int Pop() {
            if (q1.size() == 0)
                return -1;
            if (q1.size() == 1)
                return q1.poll();
            while (q1.size() != 1)
                q2.offer(q1.poll());
            int popped = q1.poll();
            while (!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
            return popped;
            // Implement the pop() function.
        }

        public int Top() {
            if (q1.size() == 0)
                return -1;
            if (q1.size() == 1)
                return q1.peek();
            while (q1.size() != 1) {
                q2.offer(q1.poll());
            }
            int topped = q1.peek();
            q2.offer(q1.poll());
            while (!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
            return topped;
            // Implement the top() function.
        }

/*************** Using 1 queue ***************/

        public void push(int x) {
            int size = queue.size();
            queue.offer(x);

            // Rotate the queue so that the newly added element is at the front
            for (int i = 0; i < size; i++) {
                int element = queue.poll();
                queue.offer(element);
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}

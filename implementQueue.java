public class implementQueue {

/************** Size was not given so I assumed it **************/
    class Queue {
        int front, rear;
        int[] arr = new int[5000];

        Queue() {
            front = -1;
            rear = -1;
            // Implement the Constructor
        }

        /*----------------- Public Functions of Queue -----------------*/

        boolean isEmpty() {
            return front == rear;
            // Implement the isEmpty() function
        }

        void enqueue(int data) {
            arr[++rear] = data;
            // Implement the enqueue() function
        }

        int dequeue() {
            if (front == rear)
                return -1;
            return arr[++front];
            // Implement the dequeue() function
        }

        int front() {
            if (front == rear)
                return -1;
            return arr[front + 1];
            // Implement the front() function
        }
    }
}

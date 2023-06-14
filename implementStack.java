public class implementStack {
    class Stack {
        int top = -1;
        int size;
        int[] arr;
        public Stack(int size){
            this.size = size;
            arr = new int[size];
        }
        void push(int num) {
            arr[++top] = num;
            // Write your code here.
        }
        int pop() {
            if(top != -1){
                return arr[top--];
            }
            return -1;
        }
        int top() {
            if(top != -1){
            // Write your code here.
                return arr[top];
            }
            return -1;
        }
        int isEmpty() {
            return top == -1 ? 1 : 0;
        }
        int isFull() {
            return top == size ? 1 : 0;
            // Write your code here.
        }
    }
}
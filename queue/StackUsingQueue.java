import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class StackUsingQueue {

    private static Queue<Integer> queue = new ArrayDeque<Integer>();
    private static Stack<Integer> stack = new Stack<Integer>();



    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        peek();
        pop();
        peek();
    }

    private static void push(int data) {

        queue.add(data);

        System.out.println(data+" is pushed");
    }

    private static void pop() {
        stack.pop();
    }

    private static void peek() {
        while(!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        System.out.println(stack.peek()+" is top element");
    }


}

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackUsingQueue {

    private static Queue<Integer> queue = new LinkedList<Integer>();


    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
//        peek();
        pop();
        peek();

    }

    private static void push(int data) {
        int size = queue.size();

        queue.add(data);

        for (int i = 0; i < size; i++) {
            int x = queue.remove();
            queue.add(x);
        }

    }

    private static void pop() {
        if (queue.isEmpty()) {
            System.out.println("queue is empty");
            return;
        }
        queue.remove();
    }

    private static void peek() {
        if (queue.isEmpty()) {
            return;
        }
        System.out.println(queue.peek()+" is top element");
    }

    private boolean isEmpty() {
        return queue.isEmpty();
    }


}

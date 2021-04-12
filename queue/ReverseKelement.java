import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKelement {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 10;i <= 100;i=i+10) {
            queue.add(i);
        }
        System.out.println(queue);

        int k = 5;

        reverseKth(queue,k);

    }

    private static void reverseKth(Queue<Integer> queue, int k) {

        if (queue.isEmpty() || queue.size() < k) {
            return;
        }

        if (k <= 0) {
            return;
        }

        int count = 0;
        Stack<Integer> stack = new Stack<>();


        while (count < k) {
            stack.push(queue.poll());
            count++;
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0;i < queue.size()-k;i++) {
            queue.add(queue.poll());
        }

        System.out.println(queue);

    }


}

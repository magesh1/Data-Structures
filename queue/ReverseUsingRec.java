import java.util.LinkedList;
import java.util.Queue;

public class ReverseUsingRec {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue = reverseQueue(queue);
        System.out.println(queue);
    }

    private static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return queue;
        } else {
            int data = queue.poll();
            queue = reverseQueue(queue);
            queue.add(data);
            return queue;
        }

    }


}

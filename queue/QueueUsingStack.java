import java.util.Stack;

class StacksOpe {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void enQueue(int data) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(data);

        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        System.out.println(data+" is enqueued");
    }

    public void deQueue() {
        if(stack1.size() == 0) {
            System.out.println("queue is empty");
            return;
        }

        int pop = stack1.pop();

        System.out.println(pop+" is dequeued");
    }


}





public class QueueUsingStack {

    public static void main(String[] args) {
        StacksOpe queue = new StacksOpe();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);

        queue.deQueue();
        queue.deQueue();
        queue.deQueue();


    }




}

import java.util.Stack;

public class StackGetMinEff {

    private static Stack<Integer> stack;
    private static int min;

    private StackGetMinEff() {
        stack = new Stack<>();
        min = 0;
    }



    public static void main(String[] args) {
        StackGetMinEff stack = new StackGetMinEff();
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(10);
        stack.push(1);
        stack.peek();
        stack.pop();


    }

    private void push(int data) {
        if (stack.isEmpty()) {
            min = data;
            stack.push(data);
            System.out.println(data+" is pushed into stack");
            return;
        }

        if (data < min) {
            stack.push(2*data-min);
            min = data;
        } else {
            stack.push(data);
        }
        System.out.println(data+" is pushed into stack");
    }

    private void getMin() {
        if(stack.isEmpty()) {
            System.out.println("stack underflow");
            System.exit(1);
        } else {
            System.out.println("minimum element in the stack is "+min);
        }
    }

    private void pop() {
        Integer value = stack.pop();

        if (value < min) {
            System.out.println("minimum element is popped form the stack "+min);
            min = 2*min-value;
        } else {
            System.out.println(value+" is popped from the stack");
        }

    }

    private void peek() {
        if (stack.isEmpty()) {
            System.out.println("stack underflow");
        }

        Integer value = stack.peek();
        
        if (value < min) {
            System.out.println(min+" is top element");
        } else {
            System.out.println(value + " is top element");
        }



    }

}

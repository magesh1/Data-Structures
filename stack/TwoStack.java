public class TwoStack {

    private int stackSize;
    private int top1,top2;
    private int[] arr;

    private TwoStack(int size) {
        stackSize = size;
        top1 = -1;
        top2 = stackSize-1;
        arr = new int[stackSize];
    }

    public static void main(String[] args) {
        TwoStack stack = new TwoStack(7);
        stack.push1(1);
        stack.push2(25);
        stack.push2(32);
        stack.push1(2);
        stack.push2(3);
        stack.push1(34);

        stack.pop1();
        stack.pop2();
        stack.pop1();
        stack.pop2();
        stack.pop2();
        stack.pop1();
        stack.pop2();
        stack.pop1();






    }

    private void push1(int data) {
        if(top1 < top2-1) {
            top1++;
            arr[top1] = data;
            System.out.println(data+" is pushed into stack1");
        } else {
            System.out.println("stack1 overflow");
            System.exit(1);
        }
    }

    private void push2(int data) {
        if (top1 < top2-1) {
            top2--;
            arr[top2] = data;
            System.out.println(data+" is pushed into stack2");
        } else {
            System.out.println("stack2 overflow");
            System.exit(1);
        }
    }

    private void pop1() {
        if (top1 >= 0) {
            int val = arr[top1];
            System.out.println(val+" is popped from stack1");
            top1--;
        } else {
            System.out.println("stack1 underflow");
            System.exit(1);
        }
    }

    private void pop2() {
        if (top2 < stackSize) {
            int val = arr[top2];
            System.out.println(val+" is popped from stack2");
            top2++;
        } else {
            System.out.println("stack2 underflow");
            System.exit(1);
        }
    }




}

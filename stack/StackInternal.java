class Stacks<T> {
    private int stacksize;
    private T[] arr;
    private int top;

    public Stacks(int size) {
        this.stacksize = size;
        this.arr = (T[]) new Object[stacksize];
        this.top = -1;
    }

    public void push(T data) {
        if(isFull()) {
            this.increaseCapacity();
        }
        this.arr[++top] = data;
        System.out.println(data+" is pushed into stack");
    }

    public T pop() {
        if(isEmpty()) {
            System.out.println("stack is empty");
        }
        T val = this.arr[top--];
        System.out.println(val+" is popped from stack");
        return val;
    }

    public T peek() {
        System.out.println(arr[top]+" is top of the stack");
        return arr[top];
    }

    public void increaseCapacity() {
        T[] newstack = (T[]) new Object[this.stacksize*2];
        for (int i = 0; i < stacksize; i++) {
            newstack[i] = this.arr[i];
        }
        this.arr = newstack;
        this.stacksize = this.stacksize*2;
    }

    public boolean isFull() {
        return top == stacksize-1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

}





public class StackInternal {


    public static void main(String[] args) {
        Stacks<Integer> stack = new Stacks<>(1);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);


    }


}

class StacksInternal<T> {

    private T[] arr;
    private int top;
    private int size;

    public StacksInternal(int size) {
        this.size = size;
        arr = (T[]) new Object[size];
        top = -1;
    }

    public void push(T data) {
        if (isFull()) {
            increaseSize();
        }

        arr[++top] = data;

    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("stack underflow");
            System.exit(1);
        }
            T val = arr[top--];
            return val;

    }

    public void increaseSize() {
        T[] newstack = (T[]) new Object[size*2];
        for (int i = 0;i < size;i++) {
            newstack[i] = arr[i];
        }
        arr = newstack;
        size = size * 2;
    }

    public boolean isFull() {
        return top == size-1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public T peek() {
        return arr[top];
    }


} // end of class





public class InfixtoPostFix {

    public static void main(String[] args) {
        String str = "a+b*c+d";
        System.out.println(infixtoPostFix(str));


    }

    private static String infixtoPostFix(String str) {
        String res = "";
        StacksInternal<Character> stack = new StacksInternal<Character>(10);

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                res += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    res += stack.pop();
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && prec(c) <= prec(stack.peek())) {
                    res += stack.pop();
                }
                stack.push(c);
            }
        }

            while(!stack.isEmpty()) {
                if (stack.peek() == '(') {
                    return "Invalid Expression";
                }
                res += stack.pop();
            }
            return res;
    }

    private static int prec(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
                return 3;
        }
            return -1;
    }


}


import java.util.*;

class Stacking {
    private final int MAX = 1000;
    private char[] arr = new char[MAX];
    private int top;

    public Stacking() {
        top = -1;
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public boolean isFull() {
        return (top > MAX-1);
    }

    public void push(char data) {
        if (isFull()) {
            System.out.println("stack overflow");
            return;
        } else {
            arr[++top] = data;
//            System.out.println(data+" pushed into stack");
        }

    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("stack underflow");
            return 0;
        }
            char data = arr[top--];
//            System.out.println(data+" is popped");

        return data;

    }

    public void peek() {
        System.out.println(arr[top]+" is top");
    }




}

public class Test {


    public static void main(String[] args) {
        Stacking stack = new Stacking();
        String str = "[]{}}";

        if(balanceString(str,stack)) {
            System.out.println("balanced");
        } else {
            System.out.println("not balanced");
        }

    } //end main

    private static boolean balanceString(String str, Stacking stack) {
        if (str.length() == 0) {
            return true;
        }

        for(char ch : str.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                if (ch == ']' && stack.pop() != '[') {
                    return false;
                } else if (ch == '}' && stack.pop() != '{') {
                    return false;
                } else if (ch == ')' && stack.pop() != '(') {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }


} //end class

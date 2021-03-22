import java.util.Arrays;
import java.util.Stack;

public class BallGame {

    public static void main(String[] args) {
        String[] arr = {"5","-2","4","c","d","9","+","+"};
        baseBall(arr);
    }

    private static void baseBall(String[] arr) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for(String ch : arr) {
            if (ch.equals("+")) {
                int a1 = stack.pop();
                int a2 = stack.peek() + a1;
                stack.push(a1);
                stack.push(a2);
            } else if(ch.equals("c")) {
                stack.pop();
            } else if(ch.equals("d")) {
                stack.push(2*stack.peek());
            } else {
                stack.push(Integer.valueOf(ch));
            }

        }

        for(int i : stack) {
            res += i;
        }


        System.out.println(res);



    }




}

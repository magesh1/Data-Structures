import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

public class BalancedBrackets {

    public static void main(String[] args) {
        String str = "[{}]{[]}";
        if(checkBalanced(str)) {
            System.out.println("balanced");
        } else {
            System.out.println("not balanced");
        }
    }

    private static boolean checkBalanced(String str) {

        StacksInternal<Character> stack = new StacksInternal<Character>(20);


        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
                continue;
            }

            char check;

            switch (ch) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[') {
                        return false;
                    }
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '{' || check == '(') {
                        return false;
                    }
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '[' || check == '(') {
                        return false;
                    }
                    break;
            }

        }

        return stack.isEmpty();




    }


}

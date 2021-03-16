public class PrefixToInfix {

    public static void main(String[] args) {
        String str = "*-a/bc-/akl";
        System.out.println(convertPrefixToInfix(str));
    }

    private static String convertPrefixToInfix(String str) {
        StacksInternal<String> stack = new StacksInternal<>(10);

        for (int i = str.length()-1; i >= 0; i--) {
            char ch = str.charAt(i);

            if (isOperator(ch)) {
                String op1 = stack.pop();
                String op2 = stack.pop();

                String temp = "( "+op1+ch+op2+" )";
                stack.push(temp);
            } else {
                stack.push(ch+"");
            }

        }

        return stack.pop();
    }

    private static boolean isOperator(char ch) {
        switch (ch) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }


}

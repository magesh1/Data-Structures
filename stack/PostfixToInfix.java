public class PostfixToInfix {

    public static void main(String[] args) {
        String str = "ab*c+";
        System.out.println(convertPostfixToInfix(str));
    }

    private static String convertPostfixToInfix(String str) {
        StacksInternal<String> stack = new StacksInternal<String>(5);
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (isOperand(ch)) {
                stack.push(ch+"");
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push("( "+" "+op2+" "+ch+" "+op1+" )");
            }

        }
        return stack.peek();
    }

    private static boolean isOperand(char ch) {
        if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
            return true;
        }
        return false;
    }


}

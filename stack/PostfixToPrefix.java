public class PostfixToPrefix {

    public static void main(String[] args) {
        String str = "ab+cd-*";
        System.out.println(convertPostfixToPrefix(str));
    }

    private static String convertPostfixToPrefix(String str) {
        StacksInternal<String> stack = new StacksInternal<String>(5);

        for (int i = 0; i < str.length(); i++) {
            if(isOperator(str.charAt(i))) {
                String op1 = stack.peek();
                stack.pop();
                String op2 = stack.peek();
                stack.pop();

                String temp = str.charAt(i)+op2+op1;

                stack.push(temp);
            } else {
                stack.push(str.charAt(i)+"");
            }

        }
        return stack.peek();
    }

    private static boolean isOperator(char ch) {
        switch(ch) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }


}

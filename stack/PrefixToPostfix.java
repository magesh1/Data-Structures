public class PrefixToPostfix {


    public static void main(String[] args) {
        String str = "*+/ab-cde";
        System.out.println(convertPrefixToPostfix(str));
    }

    private static String convertPrefixToPostfix(String str) {
        StacksInternal<String> stack = new StacksInternal<>(10);

        for(int i = str.length()-1;i >= 0;i--) {
            if(isOperator(str.charAt(i))) {
                String op1 = stack.peek();
                stack.pop();
                String op2 = stack.peek();
                stack.pop();

                String temp = op1+op2+str.charAt(i);
                stack.push(temp);
            } else {
                stack.push(str.charAt(i)+"");
            }
        }


        return stack.peek();
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

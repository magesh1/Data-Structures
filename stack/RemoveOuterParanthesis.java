public class RemoveOuterParanthesis {


    public static void main(String[] args) {
        String str = "(()())(())";
        removeOuterParanthesis(str);
    }


    private static void removeOuterParanthesis(String str) {
        StacksInternal<Character> stack = new StacksInternal<Character>(5);
        int len = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(') {
                stack.push(ch);
                if (len == -1) {
                    len = i;
                }
            } else {
                stack.pop();
            }

            if(stack.isEmpty()) {
                sb.append(str.substring(len+1,i));
                len = -1;
            }

        }

        System.out.println(sb.toString());
    }




}

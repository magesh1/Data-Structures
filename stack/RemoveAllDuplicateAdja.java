public class RemoveAllDuplicateAdja {

    public static void main(String[] args) {
        String str = "abbaca";
        removeAllDuplicateAdja(str);
    }

    private static void removeAllDuplicateAdja(String str) {
        StacksInternal<Character> stack = new StacksInternal<Character>(5);
        StringBuilder sb = new StringBuilder();

        stack.push(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            if (!stack.isEmpty()) {
                if(stack.peek() != str.charAt(i)) {
                    stack.push(str.charAt(i));
                } else {
                    stack.pop();
                }
            } else {
                stack.push(str.charAt(i));
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.peek());
            stack.pop();
        }

        System.out.println(sb.reverse().toString());



    }


}

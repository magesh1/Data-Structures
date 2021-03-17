public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {12,15,1,7,123,944,1000,16};
        findNextgreaterElement(arr);
    }

    private static void findNextgreaterElement(int[] arr) {
        StacksInternal<Integer> stack = new StacksInternal<Integer>(6);
        int[] res = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        for (int i = 0; i < res.length; i++) {
            System.out.println(arr[i]+" ------------ "+res[i]);
        }





    }


}

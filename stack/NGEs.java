import java.util.Stack;

public class NGEs {

    public static void main(String[] args) {
        int[] arr = {3,4,2,7,5,8,10,6};
        int len = arr.length;
        int[] res = new int[len];

        count(arr,res,len);

        System.out.println(finalOutput(res,3));
        System.out.println(finalOutput(res,6));
        System.out.println(finalOutput(res,1));
        




    }

    private static void count(int[] arr, int[] res, int len) {
        int[] next = new int[len];

        for (int i = 0; i < len; i++) {
            next[i] = 0;
        }

        fillNext(arr,next,len);

        for (int i = len-2; i >= 0; i--) {
            if (next[i] == -1) {
                res[i] = 0;
            } else {
                res[i] = 1+res[next[i]];
            }
        }
    }

    private static void fillNext(int[] arr, int[] next, int len) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);

        for (int i = 1; i < len; i++) {
            while(stack.size() > 0) {
                int curr = stack.peek();

                if(arr[curr] < arr[i]) {
                    next[curr] = i;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i);
        }

        while(stack.size() > 0) {
            int curr = stack.peek();
            next[curr] = -1;
            stack.pop();
        }
    }

    private static int finalOutput(int[] res,int index) {
        return res[index];
    }


}
